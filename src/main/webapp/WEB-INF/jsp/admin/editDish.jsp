<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit dish</title>

    <fmt:setLocale value="${sessionScope.locale}" />
    <fmt:setBundle basename="locale" var="loc" />
    <fmt:message bundle="${loc}" key="editdish.lable" var="editdish"/>
    <fmt:message bundle="${loc}" key="editdish.lable.title" var="title"/>
    <fmt:message bundle="${loc}" key="editdish.lable.description" var="description"/>
    <fmt:message bundle="${loc}" key="editdish.lable.price" var="price"/>
    <fmt:message bundle="${loc}" key="editdish.lable.calorieContent" var="calorieContent"/>
    <fmt:message bundle="${loc}" key="editdish.lable.isAvailable" var="isAvailable"/>
    <fmt:message bundle="${loc}" key="editdish.lable.picturePath" var="picturePath"/>
    <fmt:message bundle="${loc}" key="editdish.button" var="editdishButton"/>
</head>
<body>
<jsp:include page="../part/header.jsp"/>
<c:set var="dish" scope="request" value="${requestScope.dish}"/>

<!-- Title Page -->
<section class="bg-title-page flex-c-m p-t-160 p-b-80 p-l-15 p-r-15" style="background-image: url(${pageContext.request.contextPath}/static/img/bg-title-page-02.jpg);">
    <h2 class="tit6 t-center">
        ${editdish}
    </h2>
</section>
<br /><br />

<center>
    <form action="Controller" method="post">
        <input type="hidden" name="command" value="updatedish" />
        <input type="hidden" name="dishId" value="${dish.id}"/>
        ${title}:<br />
        <input type="text" name="title" class="bo-rad-10 txt36 p-l-20 size17" value="${dish.title}" /><br />
        ${description}:<br />
        <textarea name="description" cols="50" rows="5" class="bo-rad-10 txt36 p-l-20">${dish.description}</textarea><br/>
        ${price}:<br />
        <input type="text" name="price" class="bo-rad-10 txt36 p-l-20 size1" value="${dish.price}" /> BYN<br />
        ${calorieContent}:<br />
        <input type="text" name="calorieContent" class="bo-rad-10 txt36 p-l-20 size1" value="${dish.calorieContent}" /><br />
        ${isAvailable}:<br />
        <input type="checkbox" name="isAvailable" value="${dish.available}" /><br />
        ${picturePath}:<br />
        <input type="file" name="picturePath" multiple accept="image/*,image/jpeg" value="${dish.picturePath}" /><br />
        <br />
        <button type="submit"  class="btn3 flex-c-m size13 txt11 trans-0-4">${editdishButton}</button> <br /><br />
    </form>
</center>

<jsp:include page="../part/footer.jsp"/>
</body>
</html>