package ${package}.resources;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.camunda.bpm.cockpit.plugin.resource.AbstractPluginRootResource;
import ${package}.${camunda-plugin-base-class-name};

@Path("plugin/" + ${camunda-plugin-base-class-name}.ID)
public class ${camunda-plugin-base-class-name}RootResource extends AbstractPluginRootResource {

  public ${camunda-plugin-base-class-name}RootResource() {
    super(${camunda-plugin-base-class-name}.ID);
  }

  @Path("{engineName}/process-instance")
  public ProcessInstanceResource getProcessInstanceResource(@PathParam("engineName") String engineName) {
    return subResource(new ProcessInstanceResource(engineName), engineName);
  }
}
