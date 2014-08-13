package ${package}.resources;

import java.util.List;
import javax.ws.rs.GET;

import org.camunda.bpm.cockpit.db.QueryParameters;
import org.camunda.bpm.cockpit.plugin.resource.AbstractPluginResource;
import ${package}.db.ProcessInstanceCountDto;

public class ProcessInstanceResource extends AbstractPluginResource {

  public ProcessInstanceResource(String engineName) {
    super(engineName);
  }

  @GET
  public List<ProcessInstanceCountDto> getProcessInstanceCounts() {

    return getQueryService()
        .executeQuery(
          "cockpit.sample.selectProcessInstanceCountsByProcessDefinition",
          new QueryParameters<ProcessInstanceCountDto>());
  }
}
