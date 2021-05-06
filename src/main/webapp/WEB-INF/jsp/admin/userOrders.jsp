<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../part/header.jsp"/>

<!-- Title Page -->
<section class="bg-title-page flex-c-m p-t-160 p-b-80 p-l-15 p-r-15"
         style="background-image: url(${pageContext.request.contextPath}/static/img/bg-title-page-02.jpg);">
    <h2 class="tit6 t-center">
        Users orders
    </h2>
</section>

<section class="section-lunch bgwhite">
    <div class="container">
        <div class="row p-t-108 p-b-70">



                <table style="width: 100%">
                    <tr>
                        <td>User id</td>
                        <td>Time</td>
                        <td>Dishes</td>
                        <td>Price</td>
                    </tr>

                    <c:forEach items="${requestScope.orders}" var="orders">
                        <c:if test="${orders.status eq 'PAID'}">
                                <tr>
                                    <td>${orders.userId}</td>
                            <td>${orders.time}</td>
                            <td>
                            <c:forEach items="${orders.dishes}" var="dish">
                                ${dish.title} - ${dish.price} BUN <br/>
                            </c:forEach>
                            </td>
                            <td>${orders.totalPrice} BYN</td>

                    </tr><br/>
                        </c:if>

                    </c:forEach>

                </table>

        </div>
    </div>

</section>

<jsp:include page="../part/footer.jsp"/>
</body>
</html>
