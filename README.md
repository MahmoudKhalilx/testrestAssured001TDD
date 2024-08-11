
# REST Assured BDD Java Project

## Project Overview
This project is a test automation framework built using **REST Assured** for API testing and **Cucumber** for Behavior-Driven Development (BDD). The framework enables validation of RESTful web services through BDD scenarios written in Gherkin language, fostering clear communication between technical and non-technical team members.

## Features
- **BDD with Cucumber:** Write API test scenarios in Gherkin language for better readability and collaboration.
- **Comprehensive API Testing:** Supports testing of various HTTP methods (GET, POST, PUT, DELETE, etc.).
- **E2E Scenarios:** Includes a complete end-to-end (E2E) scenario that demonstrates multiple methods interacting together to test a full API workflow.
- **Reusable Components:** Leverages POJO classes and reusable methods for constructing request payloads and validating responses.

## Project Structure
- **src/test/java:** Contains the step definitions, hooks, and test runners.
- **src/test/resources:** Contains the feature files written in Gherkin, and configuration properties files.
- **target:** Stores compiled test results, logs, and other artifacts generated during test execution.


## E2E Scenario
This project includes an end-to-end (E2E) test scenario that showcases the full API workflow by combining multiple methods such as GET, POST, PUT, and DELETE. This scenario serves as a comprehensive example of how the framework can be used to validate complex API interactions.
