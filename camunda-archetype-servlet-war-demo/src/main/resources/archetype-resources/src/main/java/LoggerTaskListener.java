package ${package};

import java.util.logging.Logger;

import org.camunda.bpm.engine.authorization.Authorization;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;


/**
 * This is an easy listener implementation
 * illustrating how a Task Listener can be used
 * from within a BPMN 2.0 User Task.
 */
public class LoggerTaskListener implements TaskListener {

  private final Logger LOGGER = Logger.getLogger(LoggerTaskListener.class.getName());

  @Override
  public void notify(DelegateTask task) {

    LOGGER.info("\n\n  ... LoggerDelegate invoked by "
        + "activityName='" + task.getExecution().getCurrentActivityName() + "'"
        + ", activityId=" + task.getExecution().getCurrentActivityId()
        + ", processDefinitionId=" + task.getProcessDefinitionId()
        + ", processInstanceId=" + task.getProcessInstanceId()
        + ", businessKey=" + task.getExecution().getProcessBusinessKey()
        + ", executionId=" + task.getId()
        + ", variables=" + task.getVariables()
        + " \n\n");

  }

}
