package ${package}.resources;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.camunda.bpm.cockpit.plugin.resource.AbstractPluginRootResource;
import ${package}.SamplePlugin;

@Path("plugin/" + SamplePlugin.ID)
public class SamplePluginRootResource extends AbstractPluginRootResource {

  public SamplePluginRootResource() {
    super(SamplePlugin.ID);
  }

  @Path("{engineName}/process-instance")
  public ProcessInstanceResource getProcessInstanceResource(@PathParam("engineName") String engineName) {
    return subResource(new ProcessInstanceResource(engineName), engineName);
  }
}
