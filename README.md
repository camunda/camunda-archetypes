# Camunda Maven Archetypes

These are project templates for [Camunda Platform 7](https://camunda.com/platform-7/), which enable a quickstart for developing process applications.

## Template repositories
We provide a template repository for every Camunda Archetype. Every repository contains a project generated from one specific archetype. You can find the whole list on [GitHub](https://github.com/camunda?q=camunda-bpm-archetype-).

With every new release of the Archetypes, we will update those repositories with a new version as well. This allows to investigate possible update paths from one Camunda version to another and also enables you to simply update your existing project by pulling in the latest changes.

## Build from Source

A local build of all archetypes can be achieved with `mvn clean source:jar install` in the root directory. 
You can also build separate archetypes in their respective modules with the same command.

Besides, a couple of utility scripts that can aid in development can be found in the `utilities` directory.

## Contributing

Have a look at our [contribution guide](https://github.com/camunda/camunda-bpm-platform/blob/master/CONTRIBUTING.md) for how to contribute to this repository.
If you are creating issues in our issue tracker, you can add the `component` named `archetypes`.

## Full Documentation

The complete documentation of the Maven Archetypes is provided as part of the [Camunda Platform 7 User Guide](https://docs.camunda.org/manual/latest/user-guide/process-applications/maven-archetypes/).

## License

The source files in this repository are made available under the [Apache License Version 2.0](./LICENSE).
