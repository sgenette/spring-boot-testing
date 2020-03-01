This is a demo project illustrating testing in a Spring Boot application, following the test pyramid concept.

It features the following components:
- immutable core model using Lombok
- mapper using MapStruct, with Spring dependency injection
- in memory H2 test database
- test coverage with JaCoCo
- mutation testing with PIT

Inspiration from:
* https://martinfowler.com/articles/practical-test-pyramid.html
* https://www.baeldung.com/spring-boot-testing
* https://www.baeldung.com/spring-tests
* https://spring.io/guides/gs/testing-web
* https://spring.io/guides/gs/accessing-data-jpa
* https://www.baeldung.com/java-mutation-testing-with-pitest
* https://www.baeldung.com/jacoco

### Generate JaCoCo Report
`$ mvn clean test jacoco:report`

### Generate PIT Report
`$ mvn clean test org.pitest:pitest-maven:mutationCoverage`