#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.community.process_test_coverage.spring_test.platform7.ProcessEngineCoverageConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.*;
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
  public void testHappyPath() {
    // Drive the process by API and assert correct behavior by camunda-bpm-assert

    ProcessInstance processInstance = processEngine().getRuntimeService()
        .startProcessInstanceByKey(ProcessConstants.PROCESS_DEFINITION_KEY);

    assertThat(processInstance).isEnded();

  }

}
