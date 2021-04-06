
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>LogIn</title>

    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="locale" var="loc" />
    <fmt:message bundle="${loc}" key="signin.lable" var="signin"/>
    <fmt:message bundle="${loc}" key="signin.lable.email" var="email"/>
    <fmt:message bundle="${loc}" key="signin.lable.password" var="password"/>
    <fmt:message bundle="${loc}" key="signin.button" var="login"/>
    <fmt:message bundle="${loc}" key="signin.path.signup" var="signup"/>
</head>
<body>
<jsp:include page="part/header.jsp"/>

<!-- Title Page -->
<section class="bg-title-page flex-c-m p-t-160 p-b-80 p-l-15 p-r-15" style="background-image: url(${pageContext.request.contextPath}/static/img/bg-title-page-02.jpg);">
    <h2 class="tit6 t-center">
        ${signin}
    </h2>
</section>
<br /><br />

<center>
<setction class="section-signup bg1-pattern p-t-85 p-b-85">
<div class="container" id="catalog">

    <form action="Controller" method="post" >
       <input type="hidden" name="command" value="logIn" />
        ${email}:
        <br /> <input type="email" class="bo-rad-10 txt36 p-l-20 size17" name="email" value="" /><br />
       ${password}:
        <br /> <input type="password" class="bo-rad-10 txt36 p-l-20 size17" name="password" value="" /><br />
        <br />
        <button type="submit" class="btn3 flex-c-m size13 txt11 trans-0-4">${login} </button><br />
        <br />
        <a href="Controller?command=registration" class="txt4">${signup}</a><br/><br/>
    </form>
</div>
</setction>
</center>

<jsp:include page="part/footer.jsp"/>
</body>
</html>
