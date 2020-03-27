// THIS FILE IS AUTO-GENERATED. DO NOT EDIT
package ai.verta.modeldb.versioning.autogenerated._public.modeldb.versioning.model;

import ai.verta.modeldb.versioning.*;
import ai.verta.modeldb.versioning.blob.diff.*;
import com.pholser.junit.quickcheck.generator.*;
import com.pholser.junit.quickcheck.generator.java.util.*;
import com.pholser.junit.quickcheck.random.*;
import java.util.*;

public class AutogenCommandLineEnvironmentDiffGen
    extends Generator<AutogenCommandLineEnvironmentDiff> {
  public AutogenCommandLineEnvironmentDiffGen() {
    super(AutogenCommandLineEnvironmentDiff.class);
  }

  @Override
  public AutogenCommandLineEnvironmentDiff generate(SourceOfRandomness r, GenerationStatus status) {
    // if (r.nextBoolean())
    //     return null;

    AutogenCommandLineEnvironmentDiff obj = new AutogenCommandLineEnvironmentDiff();
    if (r.nextBoolean()) {
      int size = r.nextInt(0, 10);
      List<String> ret = new ArrayList(size);
      for (int i = 0; i < size; i++) {
        ret.add(new StringGenerator().generate(r, status));
      }
      obj.setA(Utils.removeEmpty(ret));
    }
    if (r.nextBoolean()) {
      int size = r.nextInt(0, 10);
      List<String> ret = new ArrayList(size);
      for (int i = 0; i < size; i++) {
        ret.add(new StringGenerator().generate(r, status));
      }
      obj.setB(Utils.removeEmpty(ret));
    }
    if (r.nextBoolean()) {
      obj.setStatus(
          Utils.removeEmpty(gen().type(AutogenDiffStatusEnumDiffStatus.class).generate(r, status)));
    }
    return obj;
  }
}
