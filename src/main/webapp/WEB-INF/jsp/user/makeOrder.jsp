<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add dish</title>

    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="locale" var="loc"/>
    <fmt:message bundle="${loc}" key="adddish.lable" var="adddish"/>
    <fmt:message bundle="${loc}" key="adddish.lable.title" var="title"/>
    <fmt:message bundle="${loc}" key="adddish.lable.description" var="description"/>
    <fmt:message bundle="${loc}" key="adddish.lable.price" var="price"/>
    <fmt:message bundle="${loc}" key="adddish.lable.calorieContent" var="calorieContent"/>
    <fmt:message bundle="${loc}" key="adddish.lable.isAvailable" var="isAvailable"/>
    <fmt:message bundle="${loc}" key="adddish.lable.picturePath" var="picturePath"/>
    <fmt:message bundle="${loc}" key="adddish.button" var="adddishButton"/>
</head>
<body>
<jsp:include page="../part/header.jsp"/>

<!-- Title Page -->
<section class="bg-title-page flex-c-m p-t-160 p-b-80 p-l-15 p-r-15"
         style="background-image: url(${pageContext.request.contextPath}/static/img/bg-title-page-02.jpg);">
    <h2 class="tit6 t-center">
        ${adddish}
    </h2>
</section>
<br/><br/>

<center>
    <form action="Controller" method="post">
        <input type="hidden" name="command" value="makeOrder"/>
        <c:forEach items="${requestScope.dishes}" var="dishes">
            <!-- Block3 -->
            <div class="blo3 flex-w flex-col-l-sm m-b-30">
                <div class="pic-blo3 size20 bo-rad-10 hov-img-zoom m-r-28">
                    <a href="#"><img src="${pageContext.request.contextPath}${dishes.picturePath}"
                                     alt="IMG-MENU"></a>
                </div>
                <div class="text-blo3 size21 flex-col-l-m">
                    <a href="#" class="txt21 m-b-3">
                            ${dishes.title}
                    </a>

                    <span class="txt23">
                            ${dishes.description}<br/>
                                Calorie content: ${dishes.calorieContent}
                    </span>

                    <span class="txt22 m-t-20">
                            ${dishes.price} BYN
                    </span>
                </div>
            </div>
        </c:forEach>

        ${title}:<br/>
        <input type="text" name="title" class="bo-rad-10 txt36 p-l-20 size17" value=""/><br/>
        ${description}:<br/>
        <textarea name="description" cols="50" rows="5" class="bo-rad-10 txt36 p-l-20"></textarea><br/>
        ${price}:<br/>
        <input type="text" name="price" class="bo-rad-10 txt36 p-l-20 size1" value=""/> BYN<br/>
        ${calorieContent}:<br/>
        <input type="text" name="calorieContent" class="bo-rad-10 txt36 p-l-20 size1" value=""/><br/>
        ${isAvailable}:<br/>
        <input type="checkbox" name="isAvailable" value=""/><br/>
        ${picturePath}:<br/>
        <input type="file" name="picturePath" multiple accept="image/*,image/jpeg" value=""/><br/>
        <br/>
        <button type="submit" class="btn3 flex-c-m size13 txt11 trans-0-4">${adddishButton}</button>
        <br/><br/>
    </form>
</center>

<jsp:include page="../part/footer.jsp"/>
</body>
</html>
