<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="part/header.jsp"/>

<!-- Title Page -->
<section class="bg-title-page flex-c-m p-t-160 p-b-80 p-l-15 p-r-15" style="background-image: url(${pageContext.request.contextPath}/static/img/bg-title-page-01.jpg);">
    <h2 class="tit6 t-center">
        Menu
    </h2>
</section>

<div class="container" id="catalog">
    <c:forEach items="${requestScope.drinks}" var="dish">
    <c:choose>
    <c:when test="${dish.available eq false}">
        <div id="product2">
            </c:when>
        <c:otherwise>
        <div id="product">
            </c:otherwise>
            </c:choose>
            <div id="product_wrapper">
                <div>
                    <img src="${dish.picturePath}" class="css-adaptive" alt="" id="dish_pic">
                </div>

                <div id="product_title"><local:Localization message="dish.name.${dish.name}"/></div>
                <div id="product_description"><local:Localization message="dish.description.${dish.description}"/></div>
                <div id="product_modification">
                    <div id="product_info">
                        <div id="test-line">
                            <div id="product_price">${dish.price} BYN</div>
                            <div id="product_weight">${dish.weight} <local:Localization message="dish.gr"/></div>
                        </div>
                        <div id="product_action">
                            <button class="btn btn-success" type="button" id="${dish.id}" onClick="getdetails(this)"><local:Localization message="dish.add.to.cart"/></button>
                            <c:if test="${applicationScope.cache.getUser(sessionScope.userId).role eq 'ADMIN'}">
                                <c:if test="${dish.available eq true}">
                                    <button class="btn btn-success hide2" type="submit" data-id="${dish.id}" id="${dish.id}"><local:Localization message="dish.hide"/></button>
                                </c:if>
                                <c:if test="${dish.available eq false}">
                                    <button class="btn btn-success show2" type="submit" data-id="${dish.id}" id="${dish.id}"><local:Localization message="dish.show"/></button>
                                </c:if>
                                <button class="btn btn-success delete2" type="submit" data-id="${dish.id}"><local:Localization message="dish.delete"/></button>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </c:forEach>
</div>

<jsp:include page="part/footer.jsp"/>
</body>
</html>
