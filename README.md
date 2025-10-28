## API Automation Dummy Project

This project provides automated tests for the https://dummyapi.io/sign-in API using Java, TestNG, RestAssured.

### Prerequisites

- Java 17 and above
- Maven
- Internet connection 

### Project Structure

```
src/
  main/
    java/
        org.example/
            base/
                basetest
            utils/
                configreader
                testdata 
  test/
     java/
        apiengine/
        payloads/
        tests/
    resources/
      applicationss.properties/
```

### How to Run

1. **Clone the repository:**
   ```sh
   git https://github.com/aldididi/API-AUTOMATION-TEST.git
   cd API-AUTOMATION-TEST
   ```

2. **install dependencies:**
      ```sh
      mvn clean install
      ```

3. **Run the tests:**
    - With Maven:
      ```sh
      mvn test
      ```
##

##
List of test cases:
https://docs.google.com/spreadsheets/d/1OhZOs9d93FmugPWdrQoYfBxvzRxzRDdfjkReI4q4J-g/edit?usp=sharing

###
also check my another project
https://github.com/aldididi/API-AUTOMATION-REQRES
