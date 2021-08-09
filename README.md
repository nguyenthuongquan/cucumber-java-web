##1. Setup Selenium Grid and Nodes:


##2. Run tests
- Open testng.xml review devices which take care each TestRunner/TestSuite/TestClass
- Right click and Run

##3. View report:
- reports > pdf > Extend.pdf
- reports > spark > Index.html
- target > run cmd: allure serve allure-results -> to see report locally

##4. Public Allure report
- (Hey! Remember this way is not good for security)
- target > run cmd: npx allure generate --clean --> to generate allure-report
- Drop 'allure-report' to [https://app.netlify.com/teams/nguyenthuongquan/overview](https://app.netlify.com/teams/nguyenthuongquan/overview)
- Share the link to others

##5. Mvn command to run test
- mvn clean verify
- mvn clean test -Dcucumber.filter.tags="@Smoke"
- mvn clean test -Dtest=TestRunner
- mvn clean test -Dtest=TestFailedRunner