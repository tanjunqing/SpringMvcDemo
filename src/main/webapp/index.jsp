<%--
  Created by IntelliJ IDEA.
  User: Tan
  Date: 15/5/26
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <h1>TEST</h1>
    <br/>
    <a href="/helloWorld.acs">HelloWorld</a>
    <br/>
    <br/>
    <a href="/SpringMvc/requestMappingTest.acs">requestMappingTest</a>
    <br/>
    <form action="/SpringMvc/testMethodPost.acs", method="post">
        <input type="submit" value="testMethodPost">
    </form>

    <br/>
    <a href="/SpringMvc/testParamsAndHeaders.acs?userName=tanjunqing&age=10">requestMappingTest</a>
    <br/>
    <br/>
    <a href="/SpringMvc/pathVariable111.acs">pathVariable</a>
    <br/>
    <br/>
    <form action="/SpringMvc/postVariable232123.acs", method="post">
        <input type="submit" value="postVariable">
    </form>
    <br/>
    <br/>
    <form action="/SpringMvc/postVariableStr3,4,5,6.acs", method="post">
        <input type="submit" value="postVariableStr">
    </form>

</body>
</html>
