<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 07.03.2021
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>LogIn</title>
</head>
<body>
    <h1>Sign In</h1>
    <form action="Controller" method="post">
        <input type="hidden" name="command" value="logIn" />
        Enter email:<br /> <input type="text" name="email" value="" /><br />
        Enter password:<br /> <input type="password" name="password" value="" /><br />
        <br />
        <input type="submit" value="Отправить" /><br />
        <br />
        <a href="Controller?command=registration">Create an account</a>
    </form>
</body>
</html>
