<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="part/header.jsp"/>

<!-- Title Page -->
<section class="bg-title-page flex-c-m p-t-160 p-b-80 p-l-15 p-r-15"
         style="background-image: url(${pageContext.request.contextPath}/static/img/bg-title-page-01.jpg);">
    <h2 class="tit6 t-center">
        Menu
    </h2>
</section>
<section class="section-lunch bgwhite">
    <div class="container">

        <c:if test="${sessionScope.userRole == 'ADMIN'}">
            <div class="row p-t-108 p-b-70">
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
                                    Calorie content: ${dishes.calorieContent} <br/>
							    </span>

                                <span class="txt22 m-t-20">
                                    ${dishes.price} BYN
							    </span>

                                <span class="txt24">
                                    <c:if test="${dishes.available == false}">
                                        Isn't available
                                    </c:if>
                                </span>
                                <span>
                                    <button form="updateDish" class="btn btn-success show2" type="submit"
                                            value="${dishes.id}" name="dishId">Update</button>
                                    <c:if test="${dishes.available == true}">
                                        <button form="deleteDish" class="btn btn-danger delete2" type="submit"
                                        value="${dishes.id}" name="dishId">Delete</button>
                                    </c:if>
                                </span>
                            </div>

                        </div>

                    </c:forEach>
                </div>
            </div>
        </c:if>
        <c:if test="${sessionScope.userRole != 'ADMIN'}">
            <div class="row p-t-108 p-b-70">
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
                                    Calorie content: ${dishes.calorieContent}
							    </span>

                                    <span class="txt22 m-t-20">
                                    ${dishes.price} BYN
							    </span>
                                    <span>
                                    <c:if test="${sessionScope.userRole == 'USER'}">
                                        <button form="addToOrder" class="btn btn-success delete2" type="submit" value="${dishes.id}" name="dishId">To order</button>
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
