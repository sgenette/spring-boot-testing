This is a demo project for testing in Spring Boot.

Inspiration from:
* https://www.baeldung.com/spring-boot-testing
* https://www.baeldung.com/spring-tests
* https://spring.io/guides/gs/testing-web
* https://spring.io/guides/gs/accessing-data-jpa
* https://www.baeldung.com/java-mutation-testing-with-pitest
* https://jqno.nl/equalsverifier
* https://www.baeldung.com/jacoco

### JaCoCo Report
`$ mvn clean test jacoco:report`

### PIT Report
`$ mvn clean test org.pitest:pitest-maven:mutationCoverage`