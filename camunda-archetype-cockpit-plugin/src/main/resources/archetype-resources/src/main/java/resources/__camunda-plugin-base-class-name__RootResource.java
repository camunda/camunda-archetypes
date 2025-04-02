package ${package}.resources;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import org.camunda.bpm.cockpit.plugin.resource.AbstractCockpitPluginRootResource;

import ${package}.${camunda-plugin-base-class-name};

@Path("plugin/" + ${camunda-plugin-base-class-name}.ID)
public class ${camunda-plugin-base-class-name}RootResource extends AbstractCockpitPluginRootResource {

  public ${camunda-plugin-base-class-name}RootResource() {
    super(${camunda-plugin-base-class-name}.ID);
  }

  @Path("{engineName}/process-instance")
  public ProcessInstanceResource getProcessInstanceResource(@PathParam("engineName") String engineName) {
    return subResource(new ProcessInstanceResource(engineName), engineName);
  }
}
