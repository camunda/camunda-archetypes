package ${package};

import static org.camunda.bpm.engine.authorization.Permissions.READ;
import static org.camunda.bpm.engine.authorization.Resources.FILTER;
import static com.camunda.consulting.util.FilterGenerator.*;
import static com.camunda.consulting.util.UserGenerator.*;

import java.util.Collection;
import java.util.List;

import org.camunda.bpm.application.PostDeploy;
import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.impl.JakartaServletProcessApplication;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.authorization.Authorization;
import org.camunda.bpm.model.bpmn.instance.UserTask;

import com.camunda.consulting.util.LicenseHelper;

import com.camunda.demo.environment.DemoDataGenerator;

/**
 * Process Application exposing this application's resources to the process engine.
 */
@ProcessApplication
public class CamundaBpmProcessApplication extends JakartaServletProcessApplication {

  /**
   * In a @PostDeploy Hook you can interact with the process engine and access 
   * the processes the application has deployed. 
   */
  @PostDeploy
  public void onDeploymentFinished(ProcessEngine processEngine) {
//    LicenseHelper.setLicense(processEngine);
    createDefaultUsers(processEngine);

//    addGroup(processEngine, "Agent", "Agent", "demo", "admin");
//    addGroup(processEngine, "Management", "Management", "demo", "admin");

    // create candidate groups from process model
    createGroupsAndFiltersForProcess(ProcessConstants.PROCESS_DEFINITION_KEY, processEngine);

    addFilterUserAuthorization(processEngine, "demo", FILTER_myTasks, FILTER_groupTasksFilter, FILTER_followUp, FILTER_overdue, FILTER_allTasksFilter);
//    addFilterUserAuthorization(processEngine, "demo", FILTER_MeineAufgaben, FILTER_GruppenAufgaben, FILTER_Wiedervorlage, FILTER_Ueberfaellig, FILTER_alleAufgaben);

//    DemoDataGenerator.autoGenerateFor(processEngine, ProcessConstants.PROCESS_DEFINITION_KEY, getReference());
  }

  private void createGroupsAndFiltersForProcess(String processDefinitionKey, ProcessEngine processEngine) {
    String processDefinitionId = processEngine.getRepositoryService()
      .createProcessDefinitionQuery()
      .processDefinitionKey(processDefinitionKey)
      .latestVersion()
      .singleResult()
      .getId();
    Collection<UserTask> userTasks = processEngine.getRepositoryService()
      .getBpmnModelInstance(processDefinitionId)
      .getModelElementsByType(UserTask.class);
    int priority = -9;
    for (UserTask userTask : userTasks) {
      List<String> candidateGroups = userTask.getCamundaCandidateGroupsList();
      for (String candidateGroup : candidateGroups) {
        if(!candidateGroup.contains("$") && !candidateGroup.contains("#") && !candidateGroup.contains("_")) {
          String groupId = candidateGroup;
          String groupName = groupId.replaceAll("([a-z])([A-Z])", "$1 $2"); // split camel case id into words
          groupName = String.valueOf(groupName.charAt(0)).toUpperCase() + groupName.substring(1); // upper case first character  
          addGroup(processEngine, groupId, groupName, "demo");
          String filterId = createFilter(processEngine, groupName, priority, "Tasks of group " + groupName, processEngine.getTaskService().createTaskQuery().taskCandidateGroup(groupId));
          long count = processEngine.getAuthorizationService().createAuthorizationQuery().resourceType(FILTER).resourceId(filterId).groupIdIn(groupId).count();
          if (count==0) {
            Authorization managementGroupFilterRead = processEngine.getAuthorizationService().createNewAuthorization(Authorization.AUTH_TYPE_GRANT);
            managementGroupFilterRead.setResource(FILTER);
            managementGroupFilterRead.setResourceId(filterId);
            managementGroupFilterRead.addPermission(READ);
            managementGroupFilterRead.setGroupId(groupId);
            processEngine.getAuthorizationService().saveAuthorization(managementGroupFilterRead);
          }
          priority++;
        }
      }
    }
  }

}
