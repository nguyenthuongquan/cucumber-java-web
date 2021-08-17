##1. What can this framework do?
- User can select a browser of any (Chrome/Firefox/Edge/Safari/Opera) then run
- User can select it run in headless mode or not
- User can run parallel 10 different test methods in 10 threads at once but only on 1 type of browser 
- This framework is not designed for selenium Grid
- The reports of this framework (PDF, SparkExtend, Allure) are awesome.


##2. Run tests in IJ Configuration w/wo parallel
- Select TestNG options and run. E.g: "Regression", "Single", "RerunTestFailed"
- If in TestRunner > @DataProvider(parallel = true) > run parallel 10 threads as default
- If in TestRunner > @DataProvider(parallel = false) > run single 1 thread one by one

##3. Run tests by Maven cmd w/wo parallel
- mvn clean verify -> Run all test
- mvn clean test -Dcucumber.filter.tags="@Smoke" -> Run only tests with tag "Smoke"
- mvn clean test -Dtest=TestRunner -> Run all tests defined in test class TestRunner
- mvn clean test -Dtest=TestFailedRunner -> Rerun test failed
- If in pom.xml, maven-surefire-plugin has dataproviderthreadcount = 10 --> run parallel 10 threads

##4. View report:
- reports > pdf > Extend.pdf. 
- reports > spark > Index.html
- target > run cmd: allure serve allure-results -> to see report locally

##5. Public Allure report
- (Hey! Remember this way is not good for security)
- target > run cmd: npx allure generate --clean --> to generate allure-report
- Drop 'allure-report' to [https://app.netlify.com/teams/nguyenthuongquan/overview](https://app.netlify.com/teams/nguyenthuongquan/overview)
- Share the link to others