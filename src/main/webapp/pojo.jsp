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
</body>
</html>
