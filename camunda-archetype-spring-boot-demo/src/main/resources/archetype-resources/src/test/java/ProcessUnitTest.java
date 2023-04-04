#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.util.Arrays;
import java.sql.SQLException;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.Variables.SerializationDataFormats;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.camunda.community.process_test_coverage.spring_test.platform7.ProcessEngineCoverageConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.*;
import static org.assertj.core.api.Assertions.*;


/**
 * Test case starting an in-memory database-backed Process Engine.
 */
@SpringBootTest
@Import(ProcessEngineCoverageConfiguration.class)
public class ProcessUnitTest {

  @Autowired
  private ProcessEngine processEngine;

  @BeforeEach
  public void setup() {
    init(processEngine);
  }

  @Test
  @Deployment(resources = "process.bpmn") // only required for process test coverage
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

    // To inspect the DB connect your browser to: http://localhost:8080/h2-console/

  }

}
