package ${package}.resources;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.camunda.bpm.cockpit.db.QueryParameters;
import org.camunda.bpm.cockpit.plugin.resource.AbstractCockpitPluginResource;

import ${package}.db.ProcessInstanceCountDto;

public class ProcessInstanceResource extends AbstractCockpitPluginResource {

  public ProcessInstanceResource(String engineName) {
    super(engineName);
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<ProcessInstanceCountDto> getProcessInstanceCounts() {

    return getQueryService()
        .executeQuery(
          "${package}.selectProcessInstanceCountsByProcessDefinition",
          new QueryParameters());
  }
}
