# FRC 2020 Skeleton Code

## Dependencies
* Java Version: ``11``
* Gradle Version: ``5.0``

## Steps to recreate the project
**Some steps may be optional**
* ``gradle init`` java app -> groovy
* ``gradle wrapper`` set gradlew version
* ``gradlew`` using gradle wrapper to build
* ``mkdir .wpilib`` & ``touch wpilib_preferences.json``

## Todo List:
* Create motor controller common interface
    * Refactor SparkMax & SparkMaxGroup
    * Create basic drivetrain group
   
* Implement basic PID control on a sample system
    * Create sample system (i.e. arm)
    * Implement PID control
   
* Implement python decorator like wrapper for Shuffle
    * Java Annotations?
    * Use unique design pattern?

* Logging and Graphing
    * Logging object
    * GUI graph 