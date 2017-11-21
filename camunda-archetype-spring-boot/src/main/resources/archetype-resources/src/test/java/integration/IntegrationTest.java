#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.integration;

import org.apache.ibatis.logging.LogFactory;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.camunda.bpm.extension.process_test_coverage.junit.rules.TestCoverageProcessEngineRuleBuilder;
import org.camunda.bpm.engine.test.Deployment;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.camunda.bpm.scenario.ProcessScenario;
import org.camunda.bpm.scenario.Scenario;
import org.camunda.bpm.scenario.run.ProcessRunner.ExecutableRunner;
import org.camunda.bpm.scenario.run.ProcessRunner.ExecutableRunner.StartingByKey;

import org.mockito.Mock;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

import ${package}.integration.conf.TestApplication;

import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.*;
import static org.junit.Assert.*;

import javax.annotation.PostConstruct;

/**
 * Test case starting an in-memory database-backed Process Engine.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE, //
    classes = TestApplication.class)
@Deployment(resources = "process.bpmn")
public class IntegrationTest {

  private static final String PROCESS_DEFINITION_KEY = "${artifactId}";

  @Autowired
  private ProcessEngine processEngine;

  @Rule
  @ClassRule
  public static ProcessEngineRule rule;

  @PostConstruct
  void initRule() {
    rule =TestCoverageProcessEngineRuleBuilder.create(processEngine).build();
    // Without Coverage: new ProcessEngineRule(processEngine);
  }

  static {
    LogFactory.useSlf4jLogging(); // MyBatis
  }

  @Before
  public void setup() {
    init(rule.getProcessEngine());
    MockitoAnnotations.initMocks(this);
  }

  @Mock
  private ProcessScenario myProcess;

  @Test
  public void testHappyPath() {
    //ProcessInstance processInstance = processEngine().getRuntimeService().startProcessInstanceByKey(PROCESS_DEFINITION_KEY);
    
    // Now: Drive the process by API and assert correct behavior by camunda-bpm-assert

    // Or: Define scenarios by using camunda-bpm-assert-scenario

    //ExecutableRunner starter = Scenario.run(myProcess) //
    //    .startByKey(PROCESS_DEFINITION_KEY);

    // when(myProcess.waitsAtReceiveTask(anyString())).thenReturn((messageSubscription) -> {
    //  messageSubscription.receive();
    // });
    // when(myProcess.waitsAtUserTask(anyString())).thenReturn((task) -> {
    //  task.complete();
    // });

    // OK - everything prepared - let's go
    //Scenario scenario = starter.execute();

    // now you can do some assertions   
    //verify(myProcess).hasFinished("EndEvent");
  }

}
