package ai.verta.modeldb.versioning.blob.diff;

import static ai.verta.modeldb.versioning.blob.diff.DiffComputer.toMap;

import ai.verta.modeldb.versioning.DiffStatusEnum;
import ai.verta.modeldb.versioning.autogenerated._public.modeldb.versioning.model.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

// TODO: handle collisions instead of just overwriting? It will be useful for mergingit
public class DiffMerger {
  public static <B, D, F, DF> F merge(
      B a, D d, Function<B, F> getterA, Function<D, DF> getterD, Function3<F, DF, F> merger) {
    if (d == null || Utils.getOrNull(d, getterD) == null) {
      return Utils.getOrNull(a, getterA);
    }
    return merger.apply(Utils.getOrNull(a, getterA), Utils.getOrNull(d, getterD));
  }

  public static <B, D, F extends ProtoType, DF> List<F> mergeList(
      B a,
      D d,
      Function<B, List<F>> getterA,
      Function<D, List<DF>> getterD,
      Function<F, String> hasherA,
      Function<DF, String> hasherD,
      Function<DF, AutogenDiffStatusEnumDiffStatus> status,
      Function<DF, F> getA,
      Function<DF, F> getB,
      Function3<Set<F>, DF, F> merger) {
    Map<String, HashSet<F>> mapA = a == null ? new HashMap<>() : toMap(getterA.apply(a), hasherA);
    Map<String, HashSet<DF>> mapD = d == null ? new HashMap<>() : toMap(getterD.apply(d), hasherD);

    HashSet<String> keys = new HashSet<>();
    keys.addAll(mapA.keySet());
    keys.addAll(mapD.keySet());

    List<F> ret =
        keys.stream()
            .flatMap(
                key -> {
                  HashSet<F> elA = mapA.getOrDefault(key, new HashSet<>());
                  HashSet<DF> elD = mapD.get(key);

                  if (elD != null) {
                    for (DF el : elD) {
                      AutogenDiffStatusEnumDiffStatus elStatus = status.apply(el);
                      F diffA = getA.apply(el);
                      F diffB = getB.apply(el);
                      if (elStatus == null
                          || elStatus.Status == DiffStatusEnum.DiffStatus.DELETED) {
                        if (diffA != null) {
                          elA.remove(diffA);
                        }
                      } else if (elStatus.Status == DiffStatusEnum.DiffStatus.ADDED) {
                        if (diffB != null) {
                          elA.add(diffB);
                        }
                      } else if (elStatus.Status == DiffStatusEnum.DiffStatus.MODIFIED) {
                        // TODO: error otherwise
                        if (diffA != null && diffB != null) {
                          elA.remove(diffA);
                          // Send the current set of keys colliding in case the merger wants to
                          // handle in a special way
                          // The default behavior should be just to replace A with B
                          if (merger != null) {
                            F merged = merger.apply(elA, el);
                            elA.add(merged);
                          } else {
                            elA.add(diffB);
                          }
                        }
                      }
                    }
                  }
                  if (elA == null || elA.isEmpty()) return null;
                  return elA.stream();
                })
            .map(Utils::removeEmpty)
            .filter(
                Objects::nonNull) // Remove elements that became null in the process of applying the
            // diff for some reason
            .collect(Collectors.toList());
    if (ret.isEmpty()) {
      return null;
    }
    return ret;
  }

  public static <T, T2> T mergeLast(
      T a, T2 d, Function<T2, T> getB, Function<T2, AutogenDiffStatusEnumDiffStatus> getStatus) {
    if (d == null) {
      return a;
    }

    AutogenDiffStatusEnumDiffStatus status = getStatus.apply(d);
    if (status.Status == DiffStatusEnum.DiffStatus.ADDED
        || status.Status == DiffStatusEnum.DiffStatus.MODIFIED) {
      return getB.apply(d);
    }
    if (status.Status == DiffStatusEnum.DiffStatus.DELETED) {
      return null;
    }
    return a;
  }

  public static AutogenBlob mergeBlob(AutogenBlob a, AutogenBlobDiff d) {
    return Utils.removeEmpty(
        new AutogenBlob()
            .setCode(
                merge(a, d, AutogenBlob::getCode, AutogenBlobDiff::getCode, DiffMerger::mergeCode))
            .setConfig(
                merge(
                    a,
                    d,
                    AutogenBlob::getConfig,
                    AutogenBlobDiff::getConfig,
                    DiffMerger::mergeConfig))
            .setDataset(
                merge(
                    a,
                    d,
                    AutogenBlob::getDataset,
                    AutogenBlobDiff::getDataset,
                    DiffMerger::mergeDataset))
            .setEnvironment(
                merge(
                    a,
                    d,
                    AutogenBlob::getEnvironment,
                    AutogenBlobDiff::getEnvironment,
                    DiffMerger::mergeEnvironment)));
  }

  public static AutogenCodeBlob mergeCode(AutogenCodeBlob a, AutogenCodeDiff d) {
    return Utils.removeEmpty(
        new AutogenCodeBlob()
            .setGit(
                merge(
                    a,
                    d,
                    AutogenCodeBlob::getGit,
                    AutogenCodeDiff::getGit,
                    DiffMerger::mergeGitCode))
            .setNotebook(
                merge(
                    a,
                    d,
                    AutogenCodeBlob::getNotebook,
                    AutogenCodeDiff::getNotebook,
                    DiffMerger::mergeNotebookCode)));
  }

  public static AutogenGitCodeBlob mergeGitCode(AutogenGitCodeBlob a, AutogenGitCodeDiff d) {
    if (a == null && d == null) return null;
    if (d == null) return a;
    if (d.getStatus().isDeleted()) return null;
    return Utils.removeEmpty(mergeLast(a, d, x -> d.getB(), AutogenGitCodeDiff::getStatus));
  }

  public static AutogenNotebookCodeBlob mergeNotebookCode(
      AutogenNotebookCodeBlob a, AutogenNotebookCodeDiff d) {
    return Utils.removeEmpty(
        new AutogenNotebookCodeBlob()
            .setGitRepo(
                merge(
                    a,
                    d,
                    AutogenNotebookCodeBlob::getGitRepo,
                    AutogenNotebookCodeDiff::getGitRepo,
                    DiffMerger::mergeGitCode))
            .setPath(
                merge(
                    a,
                    d,
                    AutogenNotebookCodeBlob::getPath,
                    AutogenNotebookCodeDiff::getPath,
                    DiffMerger::mergePathDatasetComponent)));
  }

  public static AutogenConfigBlob mergeConfig(AutogenConfigBlob a, AutogenConfigDiff d) {
    return Utils.removeEmpty(
        new AutogenConfigBlob()
            .setHyperparameters(
                mergeList(
                    a,
                    d,
                    AutogenConfigBlob::getHyperparameters,
                    AutogenConfigDiff::getHyperparameters,
                    AutogenHyperparameterConfigBlob::getName,
                    x -> Utils.either(x.getA(), x.getB(), AutogenHyperparameterConfigBlob::getName),
                    AutogenHyperparameterConfigDiff::getStatus,
                    AutogenHyperparameterConfigDiff::getA,
                    AutogenHyperparameterConfigDiff::getB,
                    null))
            .setHyperparameterSet(
                mergeList(
                    a,
                    d,
                    AutogenConfigBlob::getHyperparameterSet,
                    AutogenConfigDiff::getHyperparameterSet,
                    AutogenHyperparameterSetConfigBlob::getName,
                    x ->
                        Utils.either(
                            x.getA(), x.getB(), AutogenHyperparameterSetConfigBlob::getName),
                    AutogenHyperparameterSetConfigDiff::getStatus,
                    AutogenHyperparameterSetConfigDiff::getA,
                    AutogenHyperparameterSetConfigDiff::getB,
                    null)));
  }

  /*
  public static HyperparameterConfigBlob mergeHyperparameterConfig(
      Set<HyperparameterConfigBlob> a, HyperparameterConfigDiff d) {
    return new HyperparameterConfigBlob().setName(d.Name).setValue(d.B);
  }

  public static HyperparameterSetConfigBlob mergeHyperparameterSetConfig(
      Set<HyperparameterSetConfigBlob> a, HyperparameterSetConfigDiff d) {
    return new HyperparameterSetConfigBlob().setName(d.Name).setContinuous(d.ContinuousB).setDiscrete(d.DiscreteB);
  }
   */

  public static AutogenDatasetBlob mergeDataset(AutogenDatasetBlob a, AutogenDatasetDiff d) {
    return Utils.removeEmpty(
        new AutogenDatasetBlob()
            .setPath(
                merge(
                    a,
                    d,
                    AutogenDatasetBlob::getPath,
                    AutogenDatasetDiff::getPath,
                    DiffMerger::mergePathDataset))
            .setS3(
                merge(
                    a,
                    d,
                    AutogenDatasetBlob::getS3,
                    AutogenDatasetDiff::getS3,
                    DiffMerger::mergeS3Dataset)));
  }

  public static AutogenPathDatasetBlob mergePathDataset(
      AutogenPathDatasetBlob a, AutogenPathDatasetDiff d) {
    return Utils.removeEmpty(
        new AutogenPathDatasetBlob()
            .setComponents(
                mergeList(
                    a,
                    d,
                    AutogenPathDatasetBlob::getComponents,
                    AutogenPathDatasetDiff::getComponents,
                    AutogenPathDatasetComponentBlob::getPath,
                    x -> Utils.either(x.getA(), x.getB(), AutogenPathDatasetComponentBlob::getPath),
                    AutogenPathDatasetComponentDiff::getStatus,
                    AutogenPathDatasetComponentDiff::getA,
                    AutogenPathDatasetComponentDiff::getB,
                    null)));
  }

  public static AutogenPathDatasetComponentBlob mergePathDatasetComponent(
      AutogenPathDatasetComponentBlob a, AutogenPathDatasetComponentDiff d) {
    return d.getB();
  }

  public static AutogenS3DatasetBlob mergeS3Dataset(
      AutogenS3DatasetBlob a, AutogenS3DatasetDiff d) {
    return Utils.removeEmpty(
        new AutogenS3DatasetBlob()
            .setComponents(
                mergeList(
                    a,
                    d,
                    AutogenS3DatasetBlob::getComponents,
                    AutogenS3DatasetDiff::getComponents,
                    x ->
                        Utils.getOrNull(
                            Utils.getOrNull(x, AutogenS3DatasetComponentBlob::getPath),
                            AutogenPathDatasetComponentBlob::getPath),
                    x ->
                        Utils.either(
                            Utils.getOrNull(
                                Utils.getOrNull(x, AutogenS3DatasetComponentDiff::getPath),
                                AutogenPathDatasetComponentDiff::getA),
                            Utils.getOrNull(
                                Utils.getOrNull(x, AutogenS3DatasetComponentDiff::getPath),
                                AutogenPathDatasetComponentDiff::getB),
                            AutogenPathDatasetComponentBlob::getPath),
                    x ->
                        Utils.getOrNull(
                            Utils.getOrNull(x, AutogenS3DatasetComponentDiff::getPath),
                            AutogenPathDatasetComponentDiff::getStatus),
                    x ->
                        new AutogenS3DatasetComponentBlob()
                            .setPath(
                                Utils.getOrNull(
                                    Utils.getOrNull(x, AutogenS3DatasetComponentDiff::getPath),
                                    AutogenPathDatasetComponentDiff::getA)),
                    x ->
                        new AutogenS3DatasetComponentBlob()
                            .setPath(
                                Utils.getOrNull(
                                    Utils.getOrNull(x, AutogenS3DatasetComponentDiff::getPath),
                                    AutogenPathDatasetComponentDiff::getB)),
                    null)));
  }

  /*
  public static S3DatasetComponentBlob mergeS3DatasetComponent(
      Set<S3DatasetComponentBlob> a, S3DatasetComponentDiff d) {
    return new S3DatasetComponentBlob().setPath(d.Path.B);
  }
   */

  public static AutogenEnvironmentBlob mergeEnvironment(
      AutogenEnvironmentBlob a, AutogenEnvironmentDiff d) {
    return Utils.removeEmpty(
        new AutogenEnvironmentBlob()
            .setPython(
                merge(
                    a,
                    d,
                    AutogenEnvironmentBlob::getPython,
                    AutogenEnvironmentDiff::getPython,
                    DiffMerger::mergePythonEnvironment))
            .setDocker(
                merge(
                    a,
                    d,
                    AutogenEnvironmentBlob::getDocker,
                    AutogenEnvironmentDiff::getDocker,
                    DiffMerger::mergeDockerEnvironment))
            .setEnvironmentVariables(
                mergeList(
                    a,
                    d,
                    AutogenEnvironmentBlob::getEnvironmentVariables,
                    AutogenEnvironmentDiff::getEnvironmentVariables,
                    AutogenEnvironmentVariablesBlob::getName,
                    x -> Utils.either(x.getA(), x.getB(), AutogenEnvironmentVariablesBlob::getName),
                    AutogenEnvironmentVariablesDiff::getStatus,
                    AutogenEnvironmentVariablesDiff::getA,
                    AutogenEnvironmentVariablesDiff::getB,
                    null))
            .setCommandLine(
                merge(
                    a,
                    d,
                    AutogenEnvironmentBlob::getCommandLine,
                    AutogenEnvironmentDiff::getCommandLine,
                    DiffMerger::mergeCommandLine)));
  }

  public static List<String> mergeCommandLine(List<String> a, AutogenCommandLineEnvironmentDiff d) {
    if (a == null && d == null) return null;
    if (d == null) return a;
    if (d.getStatus().isDeleted()) return null;
    return Utils.removeEmpty(
        mergeLast(
            a,
            d,
            AutogenCommandLineEnvironmentDiff::getB,
            AutogenCommandLineEnvironmentDiff::getStatus));
  }

  public static AutogenPythonEnvironmentBlob mergePythonEnvironment(
      AutogenPythonEnvironmentBlob a, AutogenPythonEnvironmentDiff d) {
    return Utils.removeEmpty(
        new AutogenPythonEnvironmentBlob()
            .setVersion(
                merge(
                    a,
                    d,
                    AutogenPythonEnvironmentBlob::getVersion,
                    AutogenPythonEnvironmentDiff::getVersion,
                    DiffMerger::mergeVersionEnvironment))
            .setConstraints(
                mergeList(
                    a,
                    d,
                    AutogenPythonEnvironmentBlob::getConstraints,
                    AutogenPythonEnvironmentDiff::getConstraints,
                    AutogenPythonRequirementEnvironmentBlob::getLibrary,
                    x ->
                        Utils.either(
                            x.getA(),
                            x.getB(),
                            AutogenPythonRequirementEnvironmentBlob::getLibrary),
                    AutogenPythonRequirementEnvironmentDiff::getStatus,
                    AutogenPythonRequirementEnvironmentDiff::getA,
                    AutogenPythonRequirementEnvironmentDiff::getB,
                    null))
            .setRequirements(
                mergeList(
                    a,
                    d,
                    AutogenPythonEnvironmentBlob::getRequirements,
                    AutogenPythonEnvironmentDiff::getRequirements,
                    AutogenPythonRequirementEnvironmentBlob::getLibrary,
                    x ->
                        Utils.either(
                            x.getA(),
                            x.getB(),
                            AutogenPythonRequirementEnvironmentBlob::getLibrary),
                    AutogenPythonRequirementEnvironmentDiff::getStatus,
                    AutogenPythonRequirementEnvironmentDiff::getA,
                    AutogenPythonRequirementEnvironmentDiff::getB,
                    null)));
  }

  public static AutogenVersionEnvironmentBlob mergeVersionEnvironment(
      AutogenVersionEnvironmentBlob a, AutogenVersionEnvironmentDiff d) {
    if (a == null && d == null) return null;
    if (d == null) return a;
    if (d.getStatus().isDeleted()) return null;
    return Utils.removeEmpty(
        mergeLast(
            a, d, AutogenVersionEnvironmentDiff::getB, AutogenVersionEnvironmentDiff::getStatus));
  }

  /*
  public static PythonRequirementEnvironmentBlob mergePythonRequirementEnvironment(
      Set<PythonRequirementEnvironmentBlob> a, PythonRequirementEnvironmentDiff d) {
    return d.B;
  }
   */

  public static AutogenDockerEnvironmentBlob mergeDockerEnvironment(
      AutogenDockerEnvironmentBlob a, AutogenDockerEnvironmentDiff d) {
    if (a == null && d == null) return null;
    if (d == null) return a;
    if (d.getStatus().isDeleted()) return null;
    return Utils.removeEmpty(
        mergeLast(
            a, d, AutogenDockerEnvironmentDiff::getB, AutogenDockerEnvironmentDiff::getStatus));
  }

  /*
  public static EnvironmentVariablesBlob mergeEnvironmentVariables(
      Set<EnvironmentVariablesBlob> a, EnvironmentVariablesDiff d) {
    return new EnvironmentVariablesBlob().setValue(d.ValueB).setName(d.Name);
  }
  I/
   */
}
