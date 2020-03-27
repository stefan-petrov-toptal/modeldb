// THIS FILE IS AUTO-GENERATED. DO NOT EDIT
package ai.verta.modeldb.versioning.autogenerated._public.modeldb.versioning.model;

import ai.verta.modeldb.ModelDBException;
import ai.verta.modeldb.versioning.*;
import ai.verta.modeldb.versioning.blob.diff.*;
import ai.verta.modeldb.versioning.blob.diff.Function3;
import ai.verta.modeldb.versioning.blob.visitors.Visitor;
import com.pholser.junit.quickcheck.generator.*;
import com.pholser.junit.quickcheck.random.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutogenPathDatasetDiff implements ProtoType {
  private List<AutogenPathDatasetComponentDiff> Components;

  public AutogenPathDatasetDiff() {
    this.Components = null;
  }

  public Boolean isEmpty() {
    if (this.Components != null && !this.Components.equals(null) && !this.Components.isEmpty()) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\"class\": \"AutogenPathDatasetDiff\", \"fields\": {");
    boolean first = true;
    if (this.Components != null && !this.Components.equals(null) && !this.Components.isEmpty()) {
      if (!first) sb.append(", ");
      sb.append("\"Components\": " + Components);
      first = false;
    }
    sb.append("}}");
    return sb.toString();
  }

  // TODO: actually hash
  public String getSHA() {
    StringBuilder sb = new StringBuilder();
    sb.append("AutogenPathDatasetDiff");
    if (this.Components != null && !this.Components.equals(null) && !this.Components.isEmpty()) {
      sb.append("::Components::").append(Components);
    }

    return sb.toString();
  }

  // TODO: not consider order on lists
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null) return false;
    if (!(o instanceof AutogenPathDatasetDiff)) return false;
    AutogenPathDatasetDiff other = (AutogenPathDatasetDiff) o;

    {
      Function3<
              List<AutogenPathDatasetComponentDiff>, List<AutogenPathDatasetComponentDiff>, Boolean>
          f =
              (x2, y2) ->
                  IntStream.range(0, Math.min(x2.size(), y2.size()))
                      .mapToObj(
                          i -> {
                            Function3<
                                    AutogenPathDatasetComponentDiff,
                                    AutogenPathDatasetComponentDiff,
                                    Boolean>
                                f2 = (x, y) -> x.equals(y);
                            return f2.apply(x2.get(i), y2.get(i));
                          })
                      .filter(x -> x.equals(false))
                      .collect(Collectors.toList())
                      .isEmpty();
      if (this.Components != null || other.Components != null) {
        if (this.Components == null && other.Components != null) return false;
        if (this.Components != null && other.Components == null) return false;
        if (!f.apply(this.Components, other.Components)) return false;
      }
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.Components);
  }

  public AutogenPathDatasetDiff setComponents(List<AutogenPathDatasetComponentDiff> value) {
    this.Components = Utils.removeEmpty(value);
    if (this.Components != null) {
      this.Components.sort(Comparator.comparingInt(AutogenPathDatasetComponentDiff::hashCode));
    }
    return this;
  }

  public List<AutogenPathDatasetComponentDiff> getComponents() {
    return this.Components;
  }

  public static AutogenPathDatasetDiff fromProto(ai.verta.modeldb.versioning.PathDatasetDiff blob) {
    if (blob == null) {
      return null;
    }

    AutogenPathDatasetDiff obj = new AutogenPathDatasetDiff();
    {
      Function<ai.verta.modeldb.versioning.PathDatasetDiff, List<AutogenPathDatasetComponentDiff>>
          f =
              x ->
                  blob.getComponentsList().stream()
                      .map(AutogenPathDatasetComponentDiff::fromProto)
                      .collect(Collectors.toList());
      obj.Components = Utils.removeEmpty(f.apply(blob));
    }
    return obj;
  }

  public ai.verta.modeldb.versioning.PathDatasetDiff.Builder toProto() {
    ai.verta.modeldb.versioning.PathDatasetDiff.Builder builder =
        ai.verta.modeldb.versioning.PathDatasetDiff.newBuilder();
    {
      if (this.Components != null && !this.Components.equals(null) && !this.Components.isEmpty()) {
        Function<ai.verta.modeldb.versioning.PathDatasetDiff.Builder, Void> f =
            x -> {
              builder.addAllComponents(
                  this.Components.stream()
                      .map(y -> y.toProto().build())
                      .collect(Collectors.toList()));
              return null;
            };
        f.apply(builder);
      }
    }
    return builder;
  }

  public void preVisitShallow(Visitor visitor) throws ModelDBException {
    visitor.preVisitAutogenPathDatasetDiff(this);
  }

  public void preVisitDeep(Visitor visitor) throws ModelDBException {
    this.preVisitShallow(visitor);
    visitor.preVisitDeepListOfAutogenPathDatasetComponentDiff(this.Components);
  }

  public AutogenPathDatasetDiff postVisitShallow(Visitor visitor) throws ModelDBException {
    return visitor.postVisitAutogenPathDatasetDiff(this);
  }

  public AutogenPathDatasetDiff postVisitDeep(Visitor visitor) throws ModelDBException {
    this.setComponents(visitor.postVisitDeepListOfAutogenPathDatasetComponentDiff(this.Components));

    return this.postVisitShallow(visitor);
  }
}
