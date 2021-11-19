# PetStore Application

## Introduction

MicroProfile Starter has generated this MicroProfile application for you.

This project uses Quarkus Microprofile runtime, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Step 1 : Build and deploy the API

## Build the Jar File
At First, you need to fork this repository from the github & clone to a local machine or you can directly clone to your local machine from the following command.

    git clone https://github.com/ThiwankaSD/petstore

After cloning you can build the petstore app as a _??uber-jar_, by execute the following command:

    ./gradlew build -Dquarkus.package.type=uber-jar

To run the application:

    java -jar build/petstore-runner.jar

The application can be also packaged using simple:

    ./gradlew build

It produces the `quarkus-run.jar` file in the `build/quarkus-app/` directory.
Be aware that it is not an _??ber-jar_ as the dependencies are copied into the `build/quarkus-app/lib/` directory.

To launch the test page, open your browser at the following URL. 
It will lanuch the server stub as a HTML page with the supported microprofile specifications

    http://localhost:8080/index.html

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

    ./gradlew quarkusDev

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Creating a native executable using GraalVM

Native Image combine your jar code(classes), libraries, dependencies, runtime libraries compact together which provide platform independence to the application.
So it a standalone executable file.

Mind having GRAALVM_HOME set to your Mandrel or GraalVM installation.

You can create a native executable using the following code snippet:

    ./gradlew build -Dquarkus.package.type=native

Or, if you don't have [Mandrel](https://github.com/graalvm/mandrel/releases/) or
[GraalVM](https://github.com/graalvm/graalvm-ce-builds/releases) installed locally, you can run the native executable
build in a container using:

    ./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true

Or to use Mandrel distribution:

    ./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true -Dquarkus.native.builder-image=quay.io/quarkus/ubi-quarkus-mandrel:20.3-java11

You can then execute your native executable with:

    ./build/petstore-runner

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.

## Containerize the native Image using docker

Upto now we have a native executable file. Using docker we can containerize the the native image and export it to the production level.For that use,

    ./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true -Dquarkus.container-image.build=true

## Deploy on the Docker Compose

Docker compose will give visulize our container stats. But nowadays ochestration platforms like kubernetes can facilitate many services over docker compose.
navigate to deploy directory[./deploy](https://github.com/ThiwankaSD/petstore/tree/master/deploy), then input the following commands,

    cd ./deploy
    docker -compose up -d
    
Now go the browser and open up http://localhost:3000/dashboards
use the default credentials to the grafana dashboard using username and password as admin

It will open up the Microprofile Metrics dashboard

## Step 02: How to run the test suite

Run the test suite can run by two ways,

1. In the Step 1 process automatically run the default test cases in the file 

    /petstore/src/test/java/org/acme/PetResourceTest.java
    
2. Using eclipse you can execcute the test suite manually use right click at the PetResourceTest.java and Run as JUnit Test.
   It will seperately build the testcases.
   
## Step 03: How to run a CURL commands once deployed

### Run the GET commands
    curl -i -X GET http://localhost:8080/
   
    curl -i -X GET http://localhost:8080/v1/pets to see all the pets
   
    curl -i -X GET http://localhost:8080/v1/petType to see all the pet types
   
    curl -i -X GET http://localhost:8080/v1/pets/1 to get a particular pet
   
    curl -i -X GET http://localhost:8080/v1/pets/Boola to search a pet called Boola
   
### Run the POST commands
    curl -i -X POST -H 'Content-Type: application/json' -d '{"petAge": 3,"petId": 1,"petName": "Boola","petType": "Dog"}' http://localhost:8080/v1/pets will add a new pet
    
    curl -i -X POST -H 'Content-Type: application/json' -d '{"id": 3,"name": "Dog"}' http://localhost:8080/v1/petType will add a new pet Type

### Run the DELETE commands
    curl -i -X DELETE http://localhost:8080/v1/pets/1 will delete id = 1 pet
    
    curl -i -X DELETE http://localhost:8080/v1/petType/1 will delete id = 1 pet type

    Run the following command twice if a commands outputs a error message
    
### Run the PUT commands
    curl -i -X PUT -H 'Content-Type: application/json' -d '{"petAge": 3,"petId": 1,"petName": "Balus","petType": "Dog"}' http://localhost:8080/v1/pets/1
   

## Quarkus 3.2 Microprofile Specifications

By default, there is always the creation of a JAX-RS application class to define the path on which the JAX-RS endpoints are available.

Also, a simple Hello world endpoint is created, have a look at the class **HelloController**.

More information on MicroProfile can be found [here](https://microprofile.io/)

### Config

Configuration of your application parameters. Specification [here](https://microprofile.io/project/eclipse/microprofile-config)

The example class **ConfigTestController** shows you how to inject a configuration parameter and how you can retrieve it programmatically.

### Fault tolerance

Add resilient features to your applications like TimeOut, RetryPolicy, Fallback, bulkhead and circuit breaker. Specification [here](https://microprofile.io/project/eclipse/microprofile-fault-tolerance)

The example class **ResilienceController** has an example of a FallBack mechanism where an fallback result is returned when the execution takes too long.

### Health

The health status can be used to determine if the 'computing node' needs to be discarded/restarted or not. Specification [here](https://microprofile.io/project/eclipse/microprofile-health)

The class **ServiceHealthCheck** contains an example of a custom check which can be integrated to health status checks of the instance.  The index page contains a link to the status data.

### Metrics

The Metrics exports _Telemetric_ data in a uniform way of system and custom resources. Specification [here](https://microprofile.io/project/eclipse/microprofile-metrics)

The example class **MetricController** contains an example how you can measure the execution time of a request.  The index page also contains a link to the metric page (with all metric info)

### JWT Auth

Using the OpenId Connect JWT token to pass authentication and authorization information to the JAX-RS endpoint. Specification [here](https://microprofile.io/project/eclipse/microprofile-rest-client)

Have a look at the **TestSecureController** class which calls the protected endpoint on the secondary application.
The **ProtectedController** (secondary application) contains the protected endpoint since it contains the _@RolesAllowed_ annotation on the JAX-RS endpoint method.

The _TestSecureController_ code creates a JWT based on the private key found within the resource directory.
However, any method to send a REST request with an appropriate header will work of course. Please feel free to change this code to your needs.

### Open API

Exposes the information about your endpoints in the format of the OpenAPI v3 specification. Specification [here](https://microprofile.io/project/eclipse/microprofile-open-api)

The index page contains a link to the OpenAPI information of your endpoints.

### Open Tracing

Allow the participation in distributed tracing of your requests through various micro services. Specification [here](https://microprofile.io/project/eclipse/microprofile-opentracing)

To show this capability download [Jaeger](https://www.jaegertracing.io/download/#binaries) and run ```./jaeger-all-in-one```.
Open [http://localhost:16686/](http://localhost:16686/) to see the traces. Mind that you have to access your demo app endpoint for any traces to show on Jaeger UI.

