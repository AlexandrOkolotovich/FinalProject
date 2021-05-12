<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>personal account</title>

    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="locale" var="loc"/>
    <fmt:message bundle="${loc}" key="paccount.lable" var="lable"/>
    <fmt:message bundle="${loc}" key="paccount.name" var="name"/>
    <fmt:message bundle="${loc}" key="paccount.surname" var="surname"/>
    <fmt:message bundle="${loc}" key="paccount.phone" var="phone"/>
    <fmt:message bundle="${loc}" key="paccount.email" var="email"/>
    <fmt:message bundle="${loc}" key="paccount.role" var="role"/>
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

<div class="row p-t-60 p-b-70">
    <div class="col-md-8 col-lg-6 m-l-r-auto">

        <!-- Block3 -->
        <div class="blo3 flex-w flex-col-l-sm m-b-30">

            <div class="text-blo3 size22 flex-col-l-m">
                <span class="txt22 m-t-20">
                    ${name}: ${requestScope.user.name}<br/>
                </span>

                <span class="txt22 m-t-20">
                   ${surname}: ${requestScope.user.surname}<br/>
                </span>

                <span class="txt22 m-t-20">
                   ${phone}: ${requestScope.user.phone}<br/>
                </span>

                <span class="txt22 m-t-20">
                   ${email}: ${requestScope.user.email}<br/>
                </span>

                <span class="txt22 m-t-20">
                   ${role}: ${requestScope.user.role}<br/>
                </span>
            </div>
        </div>
    </div>
</div>

<jsp:include page="part/footer.jsp"/>
</body>
</html>
