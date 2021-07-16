Run test by cmd:

- mvn clean verify
- mvn clean test -Dcucumber.filter.tags="@Smoke"
- mvn clean test -Dtest=TestRunner
- mvn clean test -Dtest=TestFailedRunner

View report:

- reports > pdf > Extend.pdf
- reports > spark > Index.html
- reports > thread > index.html
- target > run cmd: allure serve allure-results