package com.camunda.bpm.demo.report_process;

import org.camunda.bpm.engine.ProcessEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import static com.camunda.consulting.util.UserGenerator.*;
import static com.camunda.consulting.util.FilterGenerator.*;

@Component
public class CreateUsersAndGroupsApplicationRunner implements ApplicationRunner {

  @Autowired
  private ProcessEngine processEngine;
  
  @Override
  public void run(ApplicationArguments args) throws Exception {
    createDefaultUsers(processEngine);
    addGroup(processEngine, "Agent", "Agent", "demo");
    addGroup(processEngine, "Management", "Management", "demo");
    addFilterUserAuthorization(processEngine, "demo", FILTER_myTasks, FILTER_groupTasksFilter, FILTER_followUp, FILTER_overdue, FILTER_allTasksFilter);
//    addFilterUserAuthorization(processEngine, "demo", FILTER_MeineAufgaben, FILTER_GruppenAufgaben, FILTER_Wiedervorlage, FILTER_Ueberfaellig, FILTER_alleAufgaben);
  }

}
