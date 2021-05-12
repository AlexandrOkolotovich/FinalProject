<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>password recovery</title>

    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="locale" var="loc"/>
    <fmt:message bundle="${loc}" key="passwordrec.lable" var="lable"/>
    <fmt:message bundle="${loc}" key="passwordrec.button" var="button"/>
</head>
<body>
<jsp:include page="part/header.jsp"/>

<!-- Title Page -->
<section class="bg-title-page flex-c-m p-t-160 p-b-80 p-l-15 p-r-15"
         style="background-image: url(${pageContext.request.contextPath}/static/img/bg-title-page-02.jpg);">
    <h2 class="tit6 t-center">
        ${lable}
    </h2>
</section>

<section class="section-signup bg1-pattern p-t-85 p-b-85">
    <div class="container" id="catalog">
        <form action="Controller" method="post">
            <input type="hidden" name="command" value="passwordrecovery"/>
            <form name="passwordrecovery">
                <input type="email" class="bo-rad-10 txt36 p-l-20 size17" name="email"
                       pattern="^([a-zA-Z0-9_-]+\.)*[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)*\.[a-zA-Z]{2,6}$"
                       value=""/>
                <br/><br/>
                <button type="submit" class="btn3 size6 txt11 trans-0-4">${button}</button>
            </form>
            <br/>
        </form>
    </div>
</section>

<jsp:include page="part/footer.jsp"/>
</body>
</html>
