package ${package}.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.camunda.bpm.cockpit.db.QueryParameters;
import org.camunda.bpm.cockpit.plugin.resource.AbstractPluginResource;

import ${package}.db.ProcessInstanceCountDto;

public class ProcessInstanceResource extends AbstractPluginResource {

  public ProcessInstanceResource(String engineName) {
    super(engineName);
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<ProcessInstanceCountDto> getProcessInstanceCounts() {

    return getQueryService()
        .executeQuery(
          "cockpit.sample.selectProcessInstanceCountsByProcessDefinition",
          new QueryParameters<ProcessInstanceCountDto>());
  }
}
