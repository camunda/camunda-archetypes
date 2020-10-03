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
        + "activtyName='" + task.getExecution().getCurrentActivityName() + "'"
        + ", activtyId=" + task.getExecution().getCurrentActivityId()
        + ", processDefinitionId=" + task.getProcessDefinitionId()
        + ", processInstanceId=" + task.getProcessInstanceId()
        + ", businessKey=" + task.getExecution().getProcessBusinessKey()
        + ", executionId=" + task.getId()
        + ", variables=" + task.getVariables()
        + " \n\n");

  }

}
