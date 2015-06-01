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
    <a href="/helloWorld.acs">HelloWorld</a>
    <br/>
    <a href="/SpringMvc/requestMappingTest.acs">requestMappingTest</a>
    <br/>
    <form action="/SpringMvc/testMethodPost.acs", method="post">
        <input type="submit" value="testMethodPost">
    </form>
    <a href="/SpringMvc/testParamsAndHeaders.acs?userName=tanjunqing&age=10">requestMappingTest</a>
    <br/>
    <a href="/SpringMvc/pathVariable111.acs">pathVariable</a>
    <br/>
    <form action="/SpringMvc/postVariable232123.acs", method="post">
        <input type="submit" value="postVariable">
    </form>
    <form action="/SpringMvc/postVariableStr3,4,5,6.acs", method="post">
        <input type="submit" value="postVariableStr">
    </form>
    <H1>测试Rest格式的CRUD</H1>
    <a href="/SpringMvc/testGetRest1.acs">testGetRest</a>
    <br/>
    <form action="/SpringMvc/testRestPostDelete.acs" method="post">
        <input type="hidden" name="_method" value="delete">
        <input type="submit" value="testRestPostDelete">
    </form>
    <form action="/SpringMvc/testRestPostPut123.acs" method="post">
        <input type="hidden" name="_method" value="put">
        <input type="submit" value="testRestPostPut">
    </form>
    <form action="/SpringMvc/testRestPostPut456.acs" method="post">
        <input type="hidden" name="_method" value="put">
        <input type="submit" value="testRestPostPut">
    </form>
</body>
</html>
