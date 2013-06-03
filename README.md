#camunda-archetypes - [![Build Status](https://buildhive.cloudbees.com/job/camunda/job/camunda-archetypes/badge/icon)](https://buildhive.cloudbees.com/job/camunda/job/camunda-archetypes/)

These are Maven Archetypes for camunda BPM platform, which enable a quickstart for developing process applications using the camunda-BPM-platform.

##Usage


###Eclipse:

* Open your Eclipse
* Go to Preferences -> Maven -> Archetypes -> Add Remote Catalog
* Enter for catalog-file the following url: https://app.camunda.com/nexus/content/repositories/camunda-bpm/archetype-catalog.xml

Now you should be able to use the archetypes when creating a new maven project in eclipse.

###Commandline:

```mvn archetype:generate -Dfilter=org.camunda.bpm.archetype: 
-DarchetypeCatalog=https://app.camunda.com/nexus/content/repositories/camunda-bpm```
