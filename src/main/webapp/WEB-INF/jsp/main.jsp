<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html;
    charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>main</title>

    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="locale" var="loc" />
    <fmt:message bundle="${loc}" key="main.lable" var="lable"/>
</head>
<body>


<jsp:include page="part/header.jsp"/>

<!-- Title Page -->
<section class="bg-title-page flex-c-m p-t-160 p-b-80 p-l-15 p-r-15" style="background-image: url(${pageContext.request.contextPath}/static/img/bg-title-page-02.jpg);">
    <h2 class="tit6 t-center">
        ${lable}
    </h2>

</section>
<br /><br />

<section>
    <div class="container" id="catalog">
        <c:if test="${sessionScope.userRole == 'ADMIN'}">
        <form action="Controller" method="post" >
            <a href="Controller?command=gotomenupage" class="txt4">Просмотр блюд</a><br/>
            <a href="Controller?command=gotoadddishpage" class="txt4">Добавить блюдо</a><br /><br />
            <a href="" class="txt4">Просмотр меню</a><br/>
            <a href="" class="txt4">Составить меню</a><br/>
        </form>
        </c:if>
    </div>
</section>

<jsp:include page="part/footer.jsp"/>
</body>
</html>
