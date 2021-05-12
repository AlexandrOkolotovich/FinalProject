<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>menu</title>

    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="locale" var="loc"/>
    <fmt:message bundle="${loc}" key="menu.lable" var="lable"/>
    <fmt:message bundle="${loc}" key="menu.search" var="search"/>
    <fmt:message bundle="${loc}" key="menu.sorting" var="sorting"/>
    <fmt:message bundle="${loc}" key="menu.alphabetically" var="alphabetically"/>
    <fmt:message bundle="${loc}" key="menu.price" var="price"/>
    <fmt:message bundle="${loc}" key="makeorder.lable.calorieContent" var="calorieContent"/>
    <fmt:message bundle="${loc}" key="currency.byn" var="byn"/>
    <fmt:message bundle="${loc}" key="menu.notavailable" var="notavailable"/>
    <fmt:message bundle="${loc}" key="menu.update" var="update"/>
    <fmt:message bundle="${loc}" key="menu.delete" var="delete"/>
    <fmt:message bundle="${loc}" key="menu.toorder" var="toorder"/>
</head>
<body>
<jsp:include page="part/header.jsp"/>

<!-- Title Page -->
<section class="bg-title-page flex-c-m p-t-160 p-b-80 p-l-15 p-r-15"
         style="background-image: url(${pageContext.request.contextPath}/static/img/bg-title-page-01.jpg);">
    <h2 class="tit6 t-center">
        ${lable}
    </h2>
</section>

<section class="section-lunch bgwhite">
    <div class="container">
        <div class="row p-t-108 p-b-20">
            <div class="col-md-8 col-lg-6 m-l-r-auto">
                <form action="Controller" method="post">
                    <input type="hidden" name="command" value="searchdish"/>
                    <form name="search">
                        <input placeholder="Search title" name="searchTitle" style="width: 400px"
                               class="bo-rad-10 txt36 p-l-20 size17">
                        <button type="submit" class="btn3 size1 txt11 trans-0-4">${search}</button>
                    </form>
                    <br/>
                    <form name="sort">

                        <div class="dropdown">
                            <button class="btn  dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown"
                                    aria-haspopup="true" aria-expanded="false">
                                ${sorting}
                            </button>
                            <div class="dropdown-menu" id="dropdown-menu3" aria-labelledby="dropdownMenu2">
                                <ul>
                                    <li>
                                        <form action="Controller" method="post">
                                            <input type="hidden" name="command" value="sortdishbytitle"/>
                                            <button class="dropdown-item" type="submit">${alphabetically}</button>
                                        </form>
                                    </li>
                                    <li>
                                        <form action="Controller" method="post">
                                            <input type="hidden" name="command" value="sortdishbypriceup"/>
                                            <button class="dropdown-item" type="submit">${price} ↑</button>
                                        </form>
                                    </li>
                                    <li>
                                        <form action="Controller" method="post">
                                            <input type="hidden" name="command" value="sortdishbypricedown"/>
                                            <button class="dropdown-item" type=submit">${price} ↓</button>
                                        </form>
                                    </li>
                                </ul>
                            </div>
                        </div>

                    </form>
                </form>
            </div>
        </div>

        <c:if test="${sessionScope.userRole == 'ADMIN'}">
            <div class="row p-t-60 p-b-70">
                <div class="col-md-8 col-lg-6 m-l-r-auto">
                    <c:forEach items="${requestScope.dishes}" var="dishes">

                        <form id="updateDish" action="Controller" method="post">
                            <input type="hidden" name="command" value="goToEditDishPage"/>
                        </form>
                        <form id="deleteDish" action="Controller" method="post">
                            <input type="hidden" name="command" value="deleteDish"/>
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
                                    ${calorieContent} ${dishes.calorieContent} <br/>
							    </span>

                                <span class="txt22 m-t-20">
                                    ${dishes.price} ${byn}
							    </span>

                                <span class="txt24">
                                    <c:if test="${dishes.available == false}">
                                        ${notavailable}
                                    </c:if>
                                </span>
                                <span>
                                    <button form="updateDish" class="btn btn-success show2" type="submit"
                                            value="${dishes.id}" name="dishId">${update}</button>
                                    <c:if test="${dishes.available == true}">
                                        <button form="deleteDish" class="btn btn-danger delete2" type="submit"
                                                value="${dishes.id}" name="dishId">${delete}</button>
                                    </c:if>
                                </span>
                            </div>

                        </div>

                    </c:forEach>
                </div>
            </div>
        </c:if>
        <c:if test="${sessionScope.userRole != 'ADMIN'}">
            <div class="row p-t-60 p-b-70">
                <div class="col-md-8 col-lg-6 m-l-r-auto">
                    <c:forEach items="${requestScope.dishes}" var="dishes">
                        <c:if test="${dishes.available == true}">
                            <form id="addToOrder" action="Controller" method="post">
                                <input type="hidden" name="command" value="addToOrder"/>
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
                                    <c:if test="${sessionScope.userRole == 'USER'}">
                                        <button form="addToOrder" class="btn btn-success delete2" type="submit"
                                                value="${dishes.id}" name="dishId">${toorder}</button>
                                    </c:if>
                                </span>
                                </div>

                            </div>
                        </c:if>
                    </c:forEach>
                </div>
            </div>
        </c:if>

    </div>
</section>

<jsp:include page="part/footer.jsp"/>
</body>
</html>
