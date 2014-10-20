package ${package};

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ${package}.resources.${camunda-plugin-base-class-name}RootResource;
import org.camunda.bpm.cockpit.plugin.spi.impl.AbstractCockpitPlugin;

public class ${camunda-plugin-base-class-name} extends AbstractCockpitPlugin {

  public static final String ID = "${camunda-plugin-id}";

  public String getId() {
    return ID;
  }

  @Override
  public Set<Class<?>> getResourceClasses() {
    Set<Class<?>> classes = new HashSet<Class<?>>();

    classes.add(${camunda-plugin-base-class-name}RootResource.class);

    return classes;
  }

  @Override
  public List<String> getMappingFiles() {
    return Arrays.asList("${package}".replace(".", "/") + "/sample-query.xml");
  }
}
