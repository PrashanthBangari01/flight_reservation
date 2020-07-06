$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login_FF.feature");
formatter.feature({
  "line": 1,
  "name": "Login Action",
  "description": "",
  "id": "login-action",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Successful Login with Valid Credentials",
  "description": "",
  "id": "login-action;successful-login-with-valid-credentials",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "User is on Home Page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "User Navigate to LogIn Page",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "User enters UserName and Password",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "User enters \"testuserFF\" and \"testpassword\"",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Message displayed Login Successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "Test_Steps.User_is_on_Home_Page()"
});
formatter.result({
  "duration": 102471850,
  "status": "passed"
});
formatter.match({
  "location": "Test_Steps.User_Navigate_to_LogIn_Page()"
});
formatter.result({
  "duration": 60649,
  "status": "passed"
});
formatter.match({
  "location": "Test_Steps.User_enters_UserName_and_Password()"
});
formatter.result({
  "duration": 77132,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "testuserFF",
      "offset": 13
    },
    {
      "val": "testpassword",
      "offset": 30
    }
  ],
  "location": "Test_Steps.User_enters_UserName_and_Password(String,String)"
});
formatter.result({
  "duration": 2490324,
  "status": "passed"
});
formatter.match({
  "location": "Test_Steps.Message_displayed_Login_Successfully()"
});
formatter.result({
  "duration": 68735,
  "status": "passed"
});
formatter.uri("Login_GC.feature");
formatter.feature({
  "line": 1,
  "name": "Login Action",
  "description": "",
  "id": "login-action",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Successful Login with Valid Credentials",
  "description": "",
  "id": "login-action;successful-login-with-valid-credentials",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "User is on Home Page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "User Navigate to LogIn Page",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "User enters UserName and Password",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "User enters \"testuserGC\" and \"testpassword\"",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Message displayed Login Successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "Test_Steps.User_is_on_Home_Page()"
});
formatter.result({
  "duration": 72778,
  "status": "passed"
});
formatter.match({
  "location": "Test_Steps.User_Navigate_to_LogIn_Page()"
});
formatter.result({
  "duration": 101081,
  "status": "passed"
});
formatter.match({
  "location": "Test_Steps.User_enters_UserName_and_Password()"
});
formatter.result({
  "duration": 63759,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "testuserGC",
      "offset": 13
    },
    {
      "val": "testpassword",
      "offset": 30
    }
  ],
  "location": "Test_Steps.User_enters_UserName_and_Password(String,String)"
});
formatter.result({
  "duration": 237618,
  "status": "passed"
});
formatter.match({
  "location": "Test_Steps.Message_displayed_Login_Successfully()"
});
formatter.result({
  "duration": 1523057,
  "status": "passed"
});
formatter.uri("Login_IE.feature");
formatter.feature({
  "line": 1,
  "name": "Login Action",
  "description": "",
  "id": "login-action",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Successful Login with Valid Credentials",
  "description": "",
  "id": "login-action;successful-login-with-valid-credentials",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "User is on Home Page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "User Navigate to LogIn Page",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "User enters UserName and Password",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "User enters \"testuserIE\" and \"testpassword\"",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Message displayed Login Successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "Test_Steps.User_is_on_Home_Page()"
});
formatter.result({
  "duration": 67180,
  "status": "passed"
});
formatter.match({
  "location": "Test_Steps.User_Navigate_to_LogIn_Page()"
});
formatter.result({
  "duration": 120676,
  "status": "passed"
});
formatter.match({
  "location": "Test_Steps.User_enters_UserName_and_Password()"
});
formatter.result({
  "duration": 99215,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "testuserIE",
      "offset": 13
    },
    {
      "val": "testpassword",
      "offset": 30
    }
  ],
  "location": "Test_Steps.User_enters_UserName_and_Password(String,String)"
});
formatter.result({
  "duration": 236996,
  "status": "passed"
});
formatter.match({
  "location": "Test_Steps.Message_displayed_Login_Successfully()"
});
formatter.result({
  "duration": 53184,
  "status": "passed"
});
});