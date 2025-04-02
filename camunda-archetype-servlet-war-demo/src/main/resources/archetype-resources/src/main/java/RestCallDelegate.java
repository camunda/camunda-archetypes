package ${package};

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import org.apache.commons.io.IOUtils;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.spin.plugin.variable.SpinValues;
import org.camunda.spin.plugin.variable.value.JsonValue;

/**
 * JAX-RS REST Client
 */
public class RestCallDelegate implements JavaDelegate {

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    String IBAN = (String) execution.getVariable("IBAN");
    
    // invoke service: https://service.ddbac.de/demo/openAPI/ui/index#!/bankinfo/Bankinfo_get 
    Client client = ClientBuilder.newClient();
    Response response = client.target("https://service.ddbac.de:443/demo/api/bankinfo/get?bac_bankcode=" + IBAN)
        .request(MediaType.APPLICATION_JSON)
        .get();
    
    // check HTTP status code
    boolean isIBANCorrect = response.getStatusInfo().toEnum() == Status.OK;
//    boolean isIBANCorrect = Status.Family.familyOf(response.getStatus()) == Status.Family.SUCCESSFUL;
    execution.setVariable("isIBANCorrect", isIBANCorrect);
    
    // store received payload in JSON variable 
    String result = IOUtils.toString((InputStream) response.getEntity(), StandardCharsets.UTF_8);
    JsonValue bankinfo = SpinValues.jsonValue(result).create();
    execution.setVariable("bankinfo", bankinfo);
  }

}
