package ${package};

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;


/**
 * This is an easy adapter implementation 
 * illustrating how a Java Delegate can be used 
 * from within a BPMN 2.0 Service Task.
 */
@Component("logger")
public class LoggerDelegate implements JavaDelegate {
 
  private final Logger LOGGER = Logger.getLogger(LoggerDelegate.class.getName());
  
  public void execute(DelegateExecution context) throws Exception {
    
    LOGGER.info("\n\n  ... LoggerDelegate invoked by "
            + "processDefinitionId=" + context.getProcessDefinitionId()
            + ", activtyId=" + context.getCurrentActivityId()
            + ", activtyName='" + context.getCurrentActivityName() + "'"
            + ", processInstanceId=" + context.getProcessInstanceId()
            + ", businessKey=" + context.getProcessBusinessKey()
            + ", executionId=" + context.getId()
            + " \n\n");
  }

}
