Run test: 
- mvn clean verify
- mvn clean test -Dcucumber.filter.tags="@Smoke"  
- mvn clean test -Dtest=TestRunner
- mvn clean test -Dtest=TestFailedRunner
