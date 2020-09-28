package ${package};

import java.util.logging.Logger;

import org.camunda.bpm.engine.authorization.Authorization;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.springframework.stereotype.Component;


/**
 * This is an easy listener implementation
 * illustrating how a Task Listener can be used
 * from within a BPMN 2.0 User Task.
 */
@Component("loggerTaskListener")
public class LoggerTaskListener implements TaskListener {

  private final Logger LOGGER = Logger.getLogger(LoggerTaskListener.class.getName());

  @Override
  public void notify(DelegateTask task) {

    LOGGER.info("\n\n  ... LoggerDelegate invoked by "
        + "activtyName='" + execution.getCurrentActivityName() + "'"
        + ", activtyId=" + execution.getCurrentActivityId()
        + ", processDefinitionId=" + execution.getProcessDefinitionId()
        + ", processInstanceId=" + execution.getProcessInstanceId()
        + ", businessKey=" + execution.getProcessBusinessKey()
        + ", executionId=" + execution.getId()
        + ", variables=" + execution.getVariables()
        + " \n\n");

  }

}
