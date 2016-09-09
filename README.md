Front-end Interview Pair Test
=============================

Hello Potential Front-end Developer.  This is the base project for the pair programming interview.  
Please have a look around the code, which is similar to the codebase we use at HMRC.
  
Ideally you should be able to load the project into an IDE like IntelliJ and run the web server using "sbt run" but don't worry if you can't, not many front-end developers have been exposed to Scala Play so on the day we will help load the project and run it.  Then, as a pair programming exercise, we'll ask you to do some changes to the main index page.

## SBT layout

```
build.sbt                  → Application build script
src                        → Application sources
 └ main                    → Compiled asset sources
    └ java                 → Java sources
       └ controllers       → Java controllers
       └ models            → Java business layer
    └ scala                → Scala sources
       └ controllers       → Scala controllers
       └ models            → Scala business layer
    └ resources            → Configurations files and other non-compiled resources (on classpath)
       └ application.conf  → Main configuration file
       └ routes            → Routes definition
    └ twirl                → Templates
       └ views             → Play views
          └ index.scala    → The index view
    └ assets               → Compiled asset sources
       └ css               → Typically LESS CSS sources
       └ js                → Typically CoffeeScript sources
    └ public               → Public assets
       └ css               → CSS files
       └ js                → Javascript files
       └ images            → Image files
 └ test                    → Unit or functional tests
    └ java                 → Java source folder for unit or functional tests
    └ scala                → Scala source folder for unit or functional tests
    └ resources            → Resource folder for unit or functional tests
 └ universal               → Arbitrary files to be included in your projects distribution
project                    → sbt configuration files
 └ build.properties        → Marker for sbt project
 └ plugins.sbt             → sbt plugins including the declaration for Play itself
lib                        → Unmanaged libraries dependencies
logs                       → Logs folder
 └ application.log         → Default log file
target                     → Generated stuff
 └ scala-2.11            
    └ cache              
    └ classes              → Compiled class files
    └ classes_managed      → Managed class files (templates, ...)
    └ resource_managed     → Managed resources (less, ...)
    └ src_managed          → Generated sources (templates, ...)
```