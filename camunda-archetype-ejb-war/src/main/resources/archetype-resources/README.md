#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
Introduction
============

Environment Restrictions
========================

Remarks to run this application
===============================
There is no web interface to access the application. To get started refer to the
Arquillian test case, which by default connects to a camunda BPM Platform running
locally on JBoss AS 7.

You can also use `ant` to build and deploy the example.
For that to work you need to copy the file `build.properties.example` to `build.properties`
and configure the path to your application server inside it.
Alternatively, you can also copy it to `${symbol_dollar}{user.home}/.camunda/build.properties`
to have a central configuration that works with all camunda BPM projects.

Known Issues
============

Improvements Backlog
====================
