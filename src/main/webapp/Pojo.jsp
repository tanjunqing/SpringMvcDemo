<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: TanTb
  Date: 2015-06-01
  Time: 15:46
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
  <input type="submit" value="提交PoJO">
</form>
</body>
</html>
