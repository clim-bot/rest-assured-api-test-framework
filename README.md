
# Rest Assured API Test Framework

## Overview

This project is a Gradle-based framework for testing REST APIs using Rest Assured, TestNG, and Allure for reporting. It includes examples of common API operations such as GET, POST, PUT, and DELETE with detailed test execution reports generated using Allure. This project also supports environment-specific configurations for development and production.

## Features

- **REST Assured**: For API testing.
- **TestNG**: For structuring and running tests.
- **Hamcrest**: For assertions.
- **Allure**: For generating comprehensive and detailed test reports.
- **Environment Configurations**: Easily switch between `dev` and `prod` configurations.

## Prerequisites

- Java 11 or higher
- Gradle 7.x or higher
- Allure Command Line Tool

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/clim-bot/rest-assured-api-test-framework.git
   cd rest-assured-api-test-framework
   ```

2. Run tests with the specified environment (`dev` or `prod`):

   ```bash
   # For development
   ./gradlew clean test -Denv=dev

   # For production
   ./gradlew clean test -Denv=prod
   ```

3. Generate and serve the Allure report:

   ```bash
   ./gradlew allureServe
   ```

## Project Structure

```
rest-assured-api-test-framework/
├── .github/
│   └── workflows/
│       └── on-demand-tests.yml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── chris/
│   │           └── lim/
│   │               └── helpers/
│   │                   ├── Config.java
│   │                   ├── ConfigLoader.java
│   │                   ├── JsonHelper.java
│   │                   ├── JwtTokenHelper.java
│   │                   └── ResponseHelper.java
│   └── main/
│       └── resources/
│           ├── config-dev.properties
│           └── config-prod.properties
│   └── test/
│       └── java/
│           └── tests/
│               ├── ApiTestBase.java
│               ├── ExampleApiTest.java
│               └── AuthApiTest.java
│       └── resources/
│           └── testng.xml
├── .gitignore
├── README.md
├── build.gradle.kts
└── settings.gradle.kts
```

## Running Tests

To run the tests, execute:

```bash
# For development environment
./gradlew clean test -Denv=dev

# For production environment
./gradlew clean test -Denv=prod
```

## Generating Allure Reports

To generate and serve the Allure report:

```bash
./gradlew allureServe
```

## Environment Configuration

The project supports environment-specific configurations for `dev` and `prod`. Configuration properties for each environment are stored in separate properties files:

- `config-dev.properties`: Development environment settings.
- `config-prod.properties`: Production environment settings.

The environment can be specified using the `-Denv` property when running tests.

## Allure Annotations

You can enhance test reports using Allure annotations:

- `@Description`: Provides a detailed description of the test.
- `@Step`: Marks a specific step within the test.
- `@Attachment`: Attaches files or data (e.g., request/response bodies) to the report.
- `@Epic`, `@Feature`, `@Story`: Organize and structure test cases within the Allure report.

Example usage:

```java
import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class ExampleApiTest extends ApiTestBase {

   @Test
   @Description("Test retrieving users from the /users endpoint")
   public void testGetUsers() {
      Response response = sendGetRequest("/users?page=2");

      validateGetUsersResponse(response);
   }

   @Step("Send GET request to {endpoint}")
   private Response sendGetRequest(String endpoint) {
      return RestAssured.given()
              .when()
              .get(endpoint);
   }
}
```

## Dependencies

- Rest Assured
- TestNG
- Allure
- Hamcrest
- Jackson

## Contribution

Feel free to fork the project and submit pull requests. For major changes, please open an issue first to discuss what you would like to change.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
