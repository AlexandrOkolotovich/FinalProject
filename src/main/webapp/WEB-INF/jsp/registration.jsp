<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 28.02.2021
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
</head>
<body>
<h1>Registration</h1>
<form action="Controller" method="post">
    <input type="hidden" name="command" value="savenewuser" />
    Enter name:<br />
    <input type="text" name="name" value="" /><br />
    Enter surname:<br />
    <input type="text" name="surname" value="" /><br />
    Enter phone:<br />
    <input type="text" name="phone" value="" /><br />
    Enter email:<br />
    <input type="text" name="email" value="" /><br />
    Enter password:<br />
    <input type="password" name="password" value="" /><br />
    <br />
    <input type="submit" value="Отправить" /><br />
</form>
</body>
</html>
