<%--
  Created by IntelliJ IDEA.
  User: TanTb
  Date: 2015-06-01
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<H1>PoJo测试</H1>

<form action="/SpringMvc/testPojo.acs" method="post">
    userName:<input type="text" value="" name="userName">
    <br/>
    passWord:<input type="text" value="" name="passWord">
    <br/>
    email:<input type="text" value="" name="email">
    <br/>
    age:<input type="text" value="" name="age">
    <br/>
    city:<input type="text" value="" name="address.city">
    <input type="submit" value="提交PoJO">
</form>

<H1>测试HttpServlet原生API</H1>

<form action="/SpringMvc/testHttpServletAPI.acs" method="post">
    userName:<input type="text" value="" name="userName">
    <br/>
    passWord:<input type="text" value="" name="passWord">
    <br/>
    email:<input type="text" value="" name="email">
    <br/>
    age:<input type="text" value="" name="age">
    <br/>
    city:<input type="text" value="" name="address.city">
    <input type="submit" value="提交PoJO">
</form>

<form action="/SpringMvc/testPersonPojo.acs" method="post">
    <input type="hidden" value="1" name="id"/>
    userName:<input type="text" value="tan" name="userName">
    <br/>
    age:<input type="text" value="30" name="age">
    <br/>
    <input type="submit" value="提交PersonPoJO">
</form>
</body>
</html>
