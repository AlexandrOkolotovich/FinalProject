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
        My orders
    </h2>
</section>

<section class="section-lunch bgwhite">
    <div class="container">

        <div class="row p-t-108 p-b-70">
            <div class="col-md-8 col-lg-6 m-l-r-auto">
                <c:forEach items="${requestScope.orders}" var="orders">

                    <!-- Block3 -->
                    <div class="blo3 flex-w flex-col-l-sm m-b-30">

                        <div class="text-blo3 size21 flex-col-l-m">
                            <a href="#" class="txt21 m-b-3">
                                    ${orders.time}
                            </a>

                            <span class="txt23">
                    <c:forEach items=" ${orders.dishList}" var="dishes">
                                        ${dishes.title}<br/>
                    </c:forEach>
							    </span>

                            <span class="txt22 m-t-20">
                                    ${orders.totalPrice} BYN
							    </span>

                        </div>

                    </div>

                </c:forEach>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../part/footer.jsp"/>
</body>
</html>
