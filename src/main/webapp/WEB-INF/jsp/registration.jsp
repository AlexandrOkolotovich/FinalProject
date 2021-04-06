<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" language="java"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>registration</title>

    <fmt:setLocale value="${sessionScope.locale}" />
    <fmt:setBundle basename="locale" var="loc" />
    <fmt:message bundle="${loc}" key="signup.lable" var="signup"/>
    <fmt:message bundle="${loc}" key="signup.lable.name" var="name"/>
    <fmt:message bundle="${loc}" key="signup.lable.surname" var="surname"/>
    <fmt:message bundle="${loc}" key="signup.lable.phone" var="phone"/>
    <fmt:message bundle="${loc}" key="signup.lable.email" var="email"/>
    <fmt:message bundle="${loc}" key="signup.lable.password" var="password"/>
    <fmt:message bundle="${loc}" key="signup.button" var="signupButton"/>

</head>
<body>

<jsp:include page="part/header.jsp"/>

<!-- Title Page -->
<section class="bg-title-page flex-c-m p-t-160 p-b-80 p-l-15 p-r-15" style="background-image: url(${pageContext.request.contextPath}/static/img/bg-title-page-02.jpg);">
    <h2 class="tit6 t-center">
        ${signup}
    </h2>
</section>
<br /><br />

<center>
<form action="Controller" method="post">
    <input type="hidden" name="command" value="savenewuser" />
    ${name}:<br />
    <input type="text" name="name" class="bo-rad-10 txt36 p-l-20 size17" value="" /><br />
    ${surname}:<br />
    <input type="text" name="surname" class="bo-rad-10 txt36 p-l-20 size17" value="" /><br />
    ${phone}:<br />
    <input type="text" name="phone" class="bo-rad-10 txt36 p-l-20 size17" value="" /><br />
    ${email}:<br />
    <input type="text" name="email" class="bo-rad-10 txt36 p-l-20 size17" value="" /><br />
    ${password}:<br />
    <input type="password" name="password" cclass="bo-rad-10 txt36 p-l-20 size17" value="" /><br />
    <br />
    <button type="submit" class="btn3 flex-c-m size17 txt11 trans-0-4" >${signupButton}</button> <br /><br />
</form>
</center>

<jsp:include page="part/footer.jsp"/>
</body>
</html>
