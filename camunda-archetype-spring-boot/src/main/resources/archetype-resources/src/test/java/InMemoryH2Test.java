#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.mock.Mocks;
import org.camunda.community.process_test_coverage.junit5.platform7.ProcessEngineCoverageExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Test case starting an in-memory database-backed Process Engine.
 */
@ExtendWith(ProcessEngineCoverageExtension.class)
public class InMemoryH2Test {

  @Test
  @Deployment(resources = "process.bpmn")
  public void testHappyPath() {
    // Drive the process by API and assert correct behavior by camunda-bpm-assert

    Mocks.register("logger", new LoggerDelegate());

    ProcessInstance processInstance = processEngine().getRuntimeService()
        .startProcessInstanceByKey(ProcessConstants.PROCESS_DEFINITION_KEY);

    assertThat(processInstance).isEnded();
  }

}
