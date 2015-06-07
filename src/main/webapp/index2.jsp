<%--
  Created by IntelliJ IDEA.
  User: TanTb
  Date: 2015-06-01
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>测试@RequestParam取参数值</h1>

<form action="/SpringMvc/testRestPostPut.acs" method="post">
    <input type="hidden" name="_method" value="put">
    <input type="text" value="789" name="Id">
    <input type="submit" value="testRestPostPut">
</form>
<h1>测试@RequestHeader头</h1>
<a href="/SpringMvc/getRequestHeader.acs">测试 @RequestHeader头</a>
</body>
<H1>测试 Cookie</H1>
<a href="/SpringMvc/getRequestCookie.acs">测试 @RequestCookie</a>

<H1>测试 Global</H1>
<a href="/SpringMvc/testGlobal.acs">测试 Global</a>

<H1>测试 testRedirect</H1>
<a href="/SpringMvc/testRedirect.acs">测试 testRedirect</a>
</html>
