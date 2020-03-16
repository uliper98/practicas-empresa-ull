# Kaizten Blue Task

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

# Kaizten Red Task

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

# Kaizten Algorithm

## Deploy

The REST API is deployed by means of the docker-compose.yml available in the repo:

`docker-compose up`

It takes a while!

Once the API is deployed it can be accessed as follows:

```
curl http://localhost:8080/v1/labels
```  

## Stop

`Ctrl + C`

