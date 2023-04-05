
# TestNG Automation Framework with JAVA Selenium

Problem Statement: Automating an eCommerce Website by following the standard TestNG Framework guidelines




## Documentation
* [Documentation](https://testng.org/doc/documentation-main.html)
* [Predefined Steps](https://www.lambdatest.com/learning-hub/testng)

## Features

- **Maven** structured Frameowrk with all necessary automation dependencies
- Implemented **Page Object Model** to drive locators from respective classes
- Drive object creation within page object classes **encapsulating** it from Tests 
- Created Base Test which sets browser configuration and **global properties**
- **Test Strategy,** decide how the tests must be clubbed and distributed with appropriate annotations
- Create **TestNG runner** file to trigger tests with single Point of execution control
- Introduce **Grouping in TestNG.xml** to categorise tests with different tags of execution
- Implemented **Data Driven Testing and Parameterization** using TestNG Data Provider HashMap and Json Files
- Implemented **TestNG Listeners** to capture screenshot on automatic test failure and logging
- Create Extent Report wrapper to generate **excellent HTML reports** for application
- Parallel execution with **Thread Safe** mechanism
- Implemented **TestNG retry mechanism** to rerun the failed flaky tests in the application





## Instructions

- **JDK 1.8+** (make sure Java class path is set)
- **Maven** (make sure .m2 class path is set)
- Plugins for **JUnit, Cucumber, Natural in Eclipse/intelliJ**
- Fork/Clone repository or **download** zip and set it up in your local workspace.
- You can run the test locally simply by pasting the feature tag in **TestRunner.java** file
- Go to your project directory from terminal and hit following commands
```bash
mvn test -P Regression 
mvn test -P errorValidation
mvn test -D browser=Chrome
```

## To Run on Jenkins
- Provide the project Git source URL or you can downlaod/fork the project directory and give the path while creating the job.
- Select Invoke Top level maven targets under Build section
```bash
test -P Regression
test -P errorValidation
test -D browser=Chrome
```
## Extent Reports

![This is an image](https://user-images.githubusercontent.com/46919369/228211780-fb289fbd-a2d0-4cf8-8d7f-9baa15a94f70.PNG)

![This is an image](https://user-images.githubusercontent.com/46919369/228211829-1fd89375-a318-4827-b639-653acf12c347.PNG)
## Support

* [LinkedIN](https://www.linkedin.com/in/sailesh-ramesh-96991b13a/)

