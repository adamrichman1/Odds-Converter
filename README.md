# CS1699 Object-Oriented-Design
 
## Final Project

### Contributors
* [Adam Richman](http://github.com/adamrichman1)
* [Josh Gulden](http://github.com/jdg78)

### Requirements
* [Java 1.8.0+](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven 3.5.3+](https://maven.apache.org/install.html)

### Build
```
cd CS1699_OOD_FinalProject/
mvn package
```

### Run
```
cd CS1699_OOD_FinalProject/
java -jar target/FinalProject-1.0.jar 
```

#### Architectural Patterns
* Layered Architecture

#### Design Patterns
* Singleton Design Pattern (all OddsEngine.java sub-classes)
* Factory Design Pattern (OddsEngineFactory.java)
* Composite Design Pattern (Inside OddsEngineFactory.java)

#### Other Project Requirements
* Dependency Injection (IOController.java)
* Composition/Aggregation (OddsEngineFactory.java)
* Interface (VigorishEngine.java)
* Abstract Class (OddsEngine.java)
* Static Access Modifier (Inside Driver.java)
* JUnit Tests found in the src/test/java directory