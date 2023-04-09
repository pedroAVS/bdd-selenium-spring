# bdd-selenium-spring

### to execute the tests run the following command:

```mvn clean test -Dbrowser=chrome```

### to change the executing environment:

Run > Edit Configurations > Environment variables: ``spring.profiles.active=qa``

or

```mvn clean test -Dspring.profiles.active=qa```

### to start selenium grid and run the tests remotely:

``docker-compose up``

```mvn clean test -Dspring.profiles.active=remote,stg```

