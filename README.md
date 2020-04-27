* [Kaizten Blue Task](#kaizten-blue-task)
  * [Executing algorithm](#executing-algorithm)
  * [Docker image](#docker-image)
  * [Executing algorithm as Docker container](#executing-algorithm-as-docker-container)
* [Kaizten Red Task](#kaizten-red-task)
  * [Executing algorithm](#executing-algorithm-1)
  * [Docker image](#docker-image1)
  * [Executing algorithm as Docker container](#executing-algorithm-as-docker-container1)
* [Kaizten Algorithm](#kaizten-algorithm)
  * [Deployment](#deployment)
  * [Stop](#stop)



# Kaizten Blue Task

## Executing algorithm

`mvn spring-boot:run`

The output is as follows:
```
...
2020-03-16 13:08:43.655  INFO 31025 --- [           main] c.k.a.KaiztenBlueTaskApplication         : Starting KaiztenBlueTaskApplication on christopher-laptop with PID 31025 (/home/christopher/Dropbox/KaizTen/source-code/kaizten-platform/kaizten-blue-task/target/classes started by christopher in /home/christopher/Dropbox/KaizTen/source-code/kaizten-platform/kaizten-blue-task)
2020-03-16 13:08:43.658  INFO 31025 --- [           main] c.k.a.KaiztenBlueTaskApplication         : No active profile set, falling back to default profiles: default
2020-03-16 13:08:44.478  INFO 31025 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2020-03-16 13:08:44.902  INFO 31025 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2020-03-16 13:08:44.921 DEBUG 31025 --- [           main] o.s.c.t.c.SimpleTaskConfiguration        : Using org.springframework.cloud.task.configuration.DefaultTaskConfigurer TaskConfigurer
2020-03-16 13:08:44.922 DEBUG 31025 --- [           main] o.s.c.t.c.DefaultTaskConfigurer          : No EntityManager was found, using DataSourceTransactionManager
2020-03-16 13:08:45.092 DEBUG 31025 --- [           main] o.s.c.t.r.s.TaskRepositoryInitializer    : Initializing task schema for h2 database
2020-03-16 13:08:45.459 DEBUG 31025 --- [           main] o.s.c.t.r.support.SimpleTaskRepository   : Creating: TaskExecution{executionId=0, parentExecutionId=null, exitCode=null, taskName='blueTask', startTime=Mon Mar 16 13:08:45 WET 2020, endTime=null, exitMessage='null', externalExecutionId='null', errorMessage='null', arguments=[]}
2020-03-16 13:08:45.470  INFO 31025 --- [           main] c.k.a.KaiztenBlueTaskApplication         : Started KaiztenBlueTaskApplication in 2.189 seconds (JVM running for 5.635)
EXECUTING BLUE TASK!
Blue parameter length: 0
2020-03-16 13:08:45.485 DEBUG 31025 --- [           main] o.s.c.t.r.support.SimpleTaskRepository   : Updating: TaskExecution with executionId=1 with the following {exitCode=0, endTime=Mon Mar 16 13:08:45 WET 2020, exitMessage='null', errorMessage='null'}
2020-03-16 13:08:45.504  INFO 31025 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2020-03-16 13:08:45.508  INFO 31025 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
...
```

## Docker image

Compiling and package:
```
mvn clean package
```
The JAR is available in `target/kaizten-blue-task-0.0.1-SNAPSHOT.jar`

> The JAR can be executed: `java -jar target/kaizten-blue-task-0.0.1-SNAPSHOT.jar`

Then, the Docker image can be obtained as follows:
```
docker build -t christophercei/kaizten-blue-task .
``` 
The resulting Docker image is available in the computer:
```
docker images
REPOSITORY                                     TAG                 IMAGE ID            CREATED             SIZE
christophercei/kaizten-blue-task                latest              53b71e601385        14 seconds ago      117MB
```

## Executing algorithm as Docker container

Once the image of the algorithm is created, we can create Docker containers from it:
```
docker run christophercei/kaizten-blue-task

2020-03-16 13:26:28.751  INFO 1 --- [           main] c.k.a.KaiztenBlueTaskApplication         : Starting KaiztenBlueTaskApplication v0.0.1-SNAPSHOT on 42b40ffe3407 with PID 1 (/app.jar started by root in /)
2020-03-16 13:26:28.754  INFO 1 --- [           main] c.k.a.KaiztenBlueTaskApplication         : No active profile set, falling back to default profiles: default
2020-03-16 13:26:29.674  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2020-03-16 13:26:30.035  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2020-03-16 13:26:30.049 DEBUG 1 --- [           main] o.s.c.t.c.SimpleTaskConfiguration        : Using org.springframework.cloud.task.configuration.DefaultTaskConfigurer TaskConfigurer
2020-03-16 13:26:30.051 DEBUG 1 --- [           main] o.s.c.t.c.DefaultTaskConfigurer          : No EntityManager was found, using DataSourceTransactionManager
2020-03-16 13:26:30.189 DEBUG 1 --- [           main] o.s.c.t.r.s.TaskRepositoryInitializer    : Initializing task schema for h2 database
2020-03-16 13:26:30.454 DEBUG 1 --- [           main] o.s.c.t.r.support.SimpleTaskRepository   : Creating: TaskExecution{executionId=0, parentExecutionId=null, exitCode=null, taskName='blueTask', startTime=Mon Mar 16 13:26:30 GMT 2020, endTime=null, exitMessage='null', externalExecutionId='null', errorMessage='null', arguments=[]}
2020-03-16 13:26:30.464  INFO 1 --- [           main] c.k.a.KaiztenBlueTaskApplication         : Started KaiztenBlueTaskApplication in 2.145 seconds (JVM running for 2.668)
EXECUTING BLUE TASK!
Blue parameter length: 0
2020-03-16 13:26:30.482 DEBUG 1 --- [           main] o.s.c.t.r.support.SimpleTaskRepository   : Updating: TaskExecution with executionId=1 with the following {exitCode=0, endTime=Mon Mar 16 13:26:30 GMT 2020, exitMessage='null', errorMessage='null'}
2020-03-16 13:26:30.490  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2020-03-16 13:26:30.494  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
```


# Kaizten Red Task

## Executing algorithm

`mvn spring-boot:run`

The output is as follows:
```
...
2020-03-16 13:11:14.780  INFO 31162 --- [           main] c.k.algorithm.KaiztenRedTaskApplication  : Starting KaiztenRedTaskApplication on christopher-laptop with PID 31162 (/home/christopher/Dropbox/KaizTen/source-code/kaizten-platform/kaizten-red-task/target/classes started by christopher in /home/christopher/Dropbox/KaizTen/source-code/kaizten-platform/kaizten-red-task)
2020-03-16 13:11:14.783  INFO 31162 --- [           main] c.k.algorithm.KaiztenRedTaskApplication  : No active profile set, falling back to default profiles: default
2020-03-16 13:11:15.561  INFO 31162 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2020-03-16 13:11:15.759  INFO 31162 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2020-03-16 13:11:15.780 DEBUG 31162 --- [           main] o.s.c.t.c.SimpleTaskConfiguration        : Using org.springframework.cloud.task.configuration.DefaultTaskConfigurer TaskConfigurer
2020-03-16 13:11:15.781 DEBUG 31162 --- [           main] o.s.c.t.c.DefaultTaskConfigurer          : No EntityManager was found, using DataSourceTransactionManager
2020-03-16 13:11:15.914 DEBUG 31162 --- [           main] o.s.c.t.r.s.TaskRepositoryInitializer    : Initializing task schema for h2 database
2020-03-16 13:11:16.200 DEBUG 31162 --- [           main] o.s.c.t.r.support.SimpleTaskRepository   : Creating: TaskExecution{executionId=0, parentExecutionId=null, exitCode=null, taskName='redTask', startTime=Mon Mar 16 13:11:16 WET 2020, endTime=null, exitMessage='null', externalExecutionId='null', errorMessage='null', arguments=[]}
2020-03-16 13:11:16.212  INFO 31162 --- [           main] c.k.algorithm.KaiztenRedTaskApplication  : Started KaiztenRedTaskApplication in 1.887 seconds (JVM running for 5.525)
EXECUTING RED TASK!
Red parameter length: 0
2020-03-16 13:11:16.224 DEBUG 31162 --- [           main] o.s.c.t.r.support.SimpleTaskRepository   : Updating: TaskExecution with executionId=1 with the following {exitCode=0, endTime=Mon Mar 16 13:11:16 WET 2020, exitMessage='null', errorMessage='null'}
2020-03-16 13:11:16.231  INFO 31162 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2020-03-16 13:11:16.244  INFO 31162 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
...
```

## Docker image

Compiling and package:
```
mvn clean package
```
The JAR is available in `target/kaizten-red-task-0.0.1-SNAPSHOT.jar`

> The JAR can be executed: `java -jar target/kaizten-red-task-0.0.1-SNAPSHOT.jar`

Then, the Docker image can be obtained as follows:
```
docker build -t christophercei/kaizten-red-task .
``` 
The resulting Docker image is available in the computer:
```
docker images
REPOSITORY                                      TAG                 IMAGE ID            CREATED             SIZE
christophercei/kaizten-red-task                 latest              711d6e0dddd1        19 seconds ago      117MB
```

## Executing algorithm as Docker container

Once the image of the algorithm is created, we can create Docker containers from it:
```
docker run christophercei/kaizten-red-task

2020-03-16 13:26:28.751  INFO 1 --- [           main] c.k.a.KaiztenRedTaskApplication          : Starting KaiztenRedTaskApplication v0.0.1-SNAPSHOT on 42b40ffe3407 with PID 1 (/app.jar started by root in /)
2020-03-16 13:26:28.754  INFO 1 --- [           main] c.k.a.KaiztenRedTaskApplication          : No active profile set, falling back to default profiles: default
2020-03-16 13:26:29.674  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2020-03-16 13:26:30.035  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2020-03-16 13:26:30.049 DEBUG 1 --- [           main] o.s.c.t.c.SimpleTaskConfiguration        : Using org.springframework.cloud.task.configuration.DefaultTaskConfigurer TaskConfigurer
2020-03-16 13:26:30.051 DEBUG 1 --- [           main] o.s.c.t.c.DefaultTaskConfigurer          : No EntityManager was found, using DataSourceTransactionManager
2020-03-16 13:26:30.189 DEBUG 1 --- [           main] o.s.c.t.r.s.TaskRepositoryInitializer    : Initializing task schema for h2 database
2020-03-16 13:26:30.454 DEBUG 1 --- [           main] o.s.c.t.r.support.SimpleTaskRepository   : Creating: TaskExecution{executionId=0, parentExecutionId=null, exitCode=null, taskName='redTask', startTime=Mon Mar 16 13:26:30 GMT 2020, endTime=null, exitMessage='null', externalExecutionId='null', errorMessage='null', arguments=[]}
2020-03-16 13:26:30.464  INFO 1 --- [           main] c.k.a.KaiztenRedTaskApplication          : Started KaiztenRedTaskApplication in 2.145 seconds (JVM running for 2.668)
EXECUTING RED TASK!
Red parameter length: 0
2020-03-16 13:26:30.482 DEBUG 1 --- [           main] o.s.c.t.r.support.SimpleTaskRepository   : Updating: TaskExecution with executionId=1 with the following {exitCode=0, endTime=Mon Mar 16 13:26:30 GMT 2020, exitMessage='null', errorMessage='null'}
2020-03-16 13:26:30.490  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2020-03-16 13:26:30.494  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
```

# Kaizten Auth

The users created by default and their corresponding API keys are:
* `kaizten-admin` &rarr; `oqduJ5ZjnzpUHggrtVzAbM0ExpKHmd1ulcxj6InYJSQeyHABFEGIqLhVgmJGfrVs`
* `kaizten-user-0` &rarr; `TWcus13P6JkjvqxEim298RRQq3rmJrzuzKiziRibrMlbAaMsGthcRY2RrG35uHK2`
* `kaizten-user-1` &rarr; `gfpdCJeuRbjedqk2M1HJVwRTJ5ACZ2mImssXYBUIxiuD3ogjSPiSJpktflNjLUVx`
* `kaizten-user-2` &rarr; `uHV348HPlkJPDK9bxSZZWih4k2vIX2msYta6TZ34CjG45QmW5VK0BEC2VMpnq0VA`
* `kaizten-user-3` &rarr; `mka74p3Jv6YaPfbkDaTXjak2L5VpXwdB3oQfEb78MVoV9M4VvlmX2eSCtnv9dcqF`
* `kaizten-user-4` &rarr; `RhGbV0114pljnEPD48gxczU5DbingxTwdTmKWVIo1izvsEL1Hps0OC5DLovWXOUZ`

# Kaizten Algorithm

## Deployment

```
wget https://raw.githubusercontent.com/kaizten/practicas-empresa-ull/master/script-deploy.sh
chmod 777 script-deploy.sh
./script-deploy.sh
```

Once the API is deployed it can be accessed as follows:

```
curl http://localhost:8080/v1/labels
```  

## Stop

`Ctrl + C`

