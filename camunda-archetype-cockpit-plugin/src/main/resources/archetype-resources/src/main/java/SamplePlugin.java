package ${package};

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ${package}.resources.SamplePluginRootResource;
import org.camunda.bpm.cockpit.plugin.spi.impl.AbstractCockpitPlugin;

public class SamplePlugin extends AbstractCockpitPlugin {

  public static final String ID = "sample-plugin";

  public String getId() {
    return ID;
  }

  @Override
  public Set<Class<?>> getResourceClasses() {
    Set<Class<?>> classes = new HashSet<Class<?>>();

    classes.add(SamplePluginRootResource.class);

    return classes;
  }

  @Override
  public List<String> getMappingFiles() {
    return Arrays.asList("${package}".replace(".", "/") + "/sample-query.xml");
  }
}
