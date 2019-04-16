# products_filter
This is spring project to list products based on category

## Table of contents
  * [Requirements](#requirements)
  * [Project Setup](#project-setup)
    * [IDE Setup](#ide-setup)
  * [Commands](#commands)
    * [Build Project](#build-project)
    * [Run the Application](#run-the-application)
    * [Run Integration Tests](#run-tests)

## Requirements
* Java 1.8

## Project Setup
### IDE Setup
IntelliJ is suggested: File -> New -> Module/Project from Existing Source -> (Select root `build.gradle`)

## Commands
### Build Project
Compiles the source, runs the unit tests, and creates executable jar file in `build` directory.
In the project directory run:
```
./gradlew clean build
```


### Run Tests
```
./gradlew test
```

### Run the Application
```
./gradlew bootRun
```

## Test Application
### Testing Application with REST client
Use any REST client like PostMan to send the request, and send GET request for the bellow URL's
```
http://localhost:8080/v1/categories/600001506
http://localhost:8080/v1/categories/600001506?labelType=ShowPercDscount
http://localhost:8080/v1/categories/600001506?labelType=ShowWasThenNow
http://localhost:8080/v1/categories/WRONGCODE
http://localhost:8080/v1/categories/600001506?labelType=unknown
```

