#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.nonarquillian;

import org.activiti.engine.test.ActivitiTestCase;
import org.activiti.engine.test.Deployment;

/**
 * Test case starting an in-memory database-backed Process Engine just to test
 * if the process definition is deployable.
 */
public class ProcessParsingTest extends ActivitiTestCase {

  @Deployment(resources = "process.bpmn")
  public void testParsingAndDeployment() {
    // nothing is done here, as we just want to check for exceptions during deployment
  }

}
