#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.util.Arrays;
import java.sql.SQLException;

import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.Variables.SerializationDataFormats;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.camunda.community.process_test_coverage.junit5.platform7.ProcessEngineCoverageExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.*;

/**
 * Test case starting an in-memory database-backed Process Engine.
 */
@ExtendWith(ProcessEngineCoverageExtension.class)
public class ProcessUnitTest {

  @Test
  @Deployment(resources = "process.bpmn")
  public void testHappyPath() throws SQLException {
    // Drive the process by API and assert correct behavior by camunda-bpm-assert

    ObjectValue documents = Variables
      .objectValue(Arrays.asList(new String[]{"one", "two", "three"}))
      .serializationDataFormat(SerializationDataFormats.JSON)
      .create();

    ProcessInstance processInstance = runtimeService()
        .createProcessInstanceByKey(ProcessConstants.PROCESS_DEFINITION_KEY)
        .businessKey("23")
        .setVariable("documents", documents)
        .execute();

    assertThat(processInstance).isWaitingAt("UserTask_Approve");

    // To inspect the DB, run the following line in the debugger
    // then connect your browser to: http://localhost:8082
    // and enter the JDBC URL: jdbc:h2:mem:camunda
//    org.h2.tools.Server.createWebServer("-web").start();

  }

}
