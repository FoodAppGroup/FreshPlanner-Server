[![CI](https://github.com/FoodAppGroup/FoodApp-Server/actions/workflows/ci.yml/badge.svg)](https://github.com/FoodAppGroup/FoodApp-Server/actions/workflows/ci.yml)
[![Deploy Image](https://github.com/FoodAppGroup/FoodApp-Server/actions/workflows/deploy-image.yml/badge.svg)](https://github.com/FoodAppGroup/FoodApp-Server/actions/workflows/deploy-image.yml)

# Fresh Planner

This Backend depends on a MySQL-Database and provides a backend for it. Read the `Database Information` for more details
and open http://localhost:8080/swagger-ui/ to see the provided endpoints.

![System Modelling](.documentation/files/Modelling_System.png)

## Database Information

All details can be found in this file: [Database Information](.documentation/database.md)

## JPA Class Information

All details can be found in this file: [Classes Information](.documentation/java_classes.md)

## Application Properties

__File:__ [application.properties](src/main/resources/application.properties)

### Endpoints

* `server.port` = Port for the application

### Database

* `spring.datasource.url` = MySQL Database, on URL:Port, with database fresh
    * with timezone errors add
      this: `?createDatabaseIfNotExist=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC`
* `spring.datasource.username` = user with permissions to create and manage the database
* `spring.datasource.password` = password for the user

### JPA + Hibernate

* `spring.jpa.show-sql` = show sql log
* `spring.jpa.hibernate.ddl-auto` = hibernate will automatically update the tables
    * [extended ddl-auto documentation](https://docs.jboss.org/hibernate/orm/5.4/userguide/html_single/Hibernate_User_Guide.html#configurations-hbmddl)
* `spring.jpa.properties.hibernate.dialect` = depends on the database, can be removed for maybe correct default

## Useful Links

* [Swagger Tutorial](https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api)
* [Http Codes](https://en.wikipedia.org/wiki/List_of_HTTP_status_codes)
* [Lombok Documentation](https://projectlombok.org/features/Data)
* [Lombok IntelliJ Plugin](https://plugins.jetbrains.com/plugin/6317-lombok)
* [CodeCoverageRepo](https://about.codecov.io/)
* [Docker Image](https://hub.docker.com/r/felixsteinke/private/tags)
* http://localhost:8080/swagger-ui/
