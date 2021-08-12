# api-testing-framework

This project is designed to test the Users API:  
https://gorest.co.in/public/v1/users

## Technologies

Language: Java

Testing framework: TestNG

Java library: REST Assured which provides a domain-specific language (DSL) for writing powerful, maintainable tests for RESTful APIs

## How to run
Before running tests please execute the following command to get the database up and running:

```
docker run --name postgres-db -e POSTGRES_PASSWORD=docker -p 5432:5432 -d postgres
```

For test run execute the command below or manually run testng.xml file:
```
mvn clean test -DsuiteXmlFile=testng.xml
```
