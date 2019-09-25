# Camunda Maven Archetypes

These are project templates for [camunda BPM platform](http://camunda.org/), which enable a quickstart for developing process applications.


## Usage in Eclipse

1. Add archetype catalog (**Preferences -> Maven -> Archetypes -> Add Remote Catalog**):
    **https://app.camunda.com/nexus/content/repositories/camunda-bpm/**
2. Create Maven project from archetype (**File -> New -> Project... -> Maven -> Maven Project**)

## Usage in IntelliJ IDEA

1.  While in any project, navigate to "**File > Settings... > Plugins**".  

Search for plugin in the Marketplace labeled "**Maven Archetype Catalogs**" and install, then restart IDEA to complete install.

2.  In an open project, navigate to: "**File > Settings... > Build,Execution,Deployment > Build Tools > Maven Archetype Catalogs**"

Click the plus sign (**+**) on the right side of the settings dialog to add an Archetype Catalog to the list.  NOTE:  you must add "archetype-catalog.xml", as the URL must be a direct file location.  Like so:

**https://app.camunda.com/nexus/content/repositories/camunda-bpm/archetype-catalog.xml**

Select OK.  Then when creating a Maven project, you should see the camunda archetypes listed.

## Full Documentation

The complete documentation of the Maven Archetypes is provided as part of the [Camunda BPM User Guide](https://docs.camunda.org/manual/latest/user-guide/process-applications/maven-archetypes/).
