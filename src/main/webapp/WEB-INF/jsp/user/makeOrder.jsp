<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add dish</title>

    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="locale" var="loc"/>
    <fmt:message bundle="${loc}" key="makeorder.lable" var="makeorder"/>
    <fmt:message bundle="${loc}" key="makeorder.button" var="makeorderButton"/>
    <fmt:message bundle="${loc}" key="makeorder.lable.calorieContent" var="calorieContent"/>
    <fmt:message bundle="${loc}" key="makeorder.deleteButton" var="deleteButton"/>
    <fmt:message bundle="${loc}" key="makeorder.lable.date" var="date"/>
    <fmt:message bundle="${loc}" key="makeorder.lable.totalPrice" var="totalPrice"/>
    <fmt:message bundle="${loc}" key="currency.byn" var="byn"/>
</head>
<body>
<jsp:include page="../part/header.jsp"/>

<!-- Title Page -->
<section class="bg-title-page flex-c-m p-t-160 p-b-80 p-l-15 p-r-15"
         style="background-image: url(${pageContext.request.contextPath}/static/img/bg-title-page-02.jpg);">
    <h2 class="tit6 t-center">
        ${makeorder}
    </h2>
</section>
<br/><br/>

<form action="Controller" method="post">
    <input type="hidden" name="command" value="makeOrder"/>
    <div class="row p-t-108 p-b-70">
        <div class="col-md-8 col-lg-6 m-l-r-auto">
            <c:forEach items="${requestScope.orderedDishes}" var="dishes">
                <form id="deleteDish" action="Controller" method="post">
                    <input type="hidden" name="command" value="deleteDishInOrder"/>
                </form>

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
                                ${calorieContent} ${dishes.calorieContent}
                        </span>

                        <span class="txt22 m-t-20">
                            ${dishes.price} ${byn}
                    </span>
                        <span>
                            <button form="deleteDish" class="btn btn-danger delete2" type="submit"
                                    value="${dishes.id}" name="dishId">${deleteButton}</button>
                        </span>
                    </div>
                </div>
            </c:forEach>

            <!-- Date -->
            <span class="txt9">
									${date}
								</span>

            <div class="wrap-inputdate pos-relative txt10 size12 bo2 bo-rad-10 m-t-3 m-b-23">
                <input class="bo-rad-10 sizefull txt10 p-l-20" type="datetime-local" name="date">

            </div>
            <span class="txt22 m-t-20">
        ${totalPrice}
                <c:out value="${sessionScope.totalPrice}" /> ${byn}

    </span>
            <br/>
            <button type="submit" class="btn3 flex-c-m size13 txt11 trans-0-4">${makeorderButton}</button>
            <br/><br/>

        </div>
    </div>
</form>


<jsp:include page="../part/footer.jsp"/>
</body>
</html>
