<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/static/img/icons/favicon.png"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/fonts/themify/themify-icons.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/vendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/vendor/slick/slick.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/vendor/lightbox2/css/lightbox.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/util.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/main.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/catalog.css">

    <!--===============================================================================================-->

    <title>Title</title>

    <fmt:setLocale value="${sessionScope.locale}" />
    <fmt:setBundle basename="locale" var="loc" />
    <fmt:message bundle="${loc}" key="header.lable.home" var="home"/>
    <fmt:message bundle="${loc}" key="header.lable.signin" var="signin"/>
    <fmt:message bundle="${loc}" key="header.lable.menu" var="menu"/>
    <fmt:message bundle="${loc}" key="header.lable.reservation" var="reservation"/>
    <fmt:message bundle="${loc}" key="header.lable.gallery" var="gallery"/>
    <fmt:message bundle="${loc}" key="header.lable.about" var="about"/>
    <fmt:message bundle="${loc}" key="header.lable.blog" var="blog"/>
    <fmt:message bundle="${loc}" key="header.lable.contact" var="contact"/>
    <fmt:message bundle="${loc}" key="header.lable.logout" var="logout"/>
</head>
<body>

<!-- Header -->
<header class="animsition">
    <!-- Header desktop -->
    <div class="wrap-menu-header gradient1 trans-0-4">
        <div class="container h-full">
            <div class="wrap_header trans-0-3">
                <!-- Logo -->
                <div class="logo">
                    <a href="Controller?command=gotohomepage">
                        <img src="${pageContext.request.contextPath}/static/img/icons/logo5.png" alt="IMG-LOGO" data-logofixed="${pageContext.request.contextPath}/static/img/icons/logo2.png"/>
                    </a>
                </div>

                <!-- Menu -->
                <div class="wrap_menu p-l-45 p-l-0-xl">
                    <nav class="menu">
                        <ul class="main_menu">
                            <li>
                                <a href="Controller?command=gotohomepage">${home}</a>
                            </li>

                            <li>
                                <a href="Controller?command=gotomenupage">${menu}</a>
                            </li>

                            <li>
                                <a href="reservation.html">${reservation}</a>
                            </li>

                            <li>
                                <a href="gallery.html">${gallery}</a>
                            </li>

                            <li>
                                <a href="about.html">${about}</a>
                            </li>

                            <li>
                                <a href="blog.html">${blog}</a>
                            </li>

                            <li>
                                <a href="contact.html">${contact}</a>
                            </li>

                        </ul>
                    </nav>
                </div>

                <div class="login">
                    <ul class="main_menu">
                        <li>
                            <div class="dropdown choose-country">
                                <a type="submit"  data-toggle="dropdown" href="">
                                    <img src="${pageContext.request.contextPath}/static/img/flags/globus2.png" alt="language"/>
                                </a>
                                <ul class="dropdown-menu" role="menu">
                                    <li role="menuitem"><form action="Controller" class="locale" method="post">
                                        <input type="hidden" name="command" value="en" /><button type="submit" class="button-nav" id="locale_en" value="en"><img src="${pageContext.request.contextPath}/static/img/flags/gb.png" alt="English language"/> EN</button>
                                    </form></li>
                                    <li role="menuitem"><form action="Controller" method="post">
                                        <input type="hidden" name="command" value="ru" /><button type="submit" class="button-nav" id="locale_ru" value="ru"><img src="${pageContext.request.contextPath}/static/img/flags/ru.png" alt="Russian language"/> RU</button>
                                    </form></li>
                                </ul>
                            </div>
                        </li>
                        <c:set var="user" value="${sessionScope.userId}"/>
                        <c:if test="${user == null}">
                        <li>
                            <a href="Controller?command=gotologinpage">${signin}</a>
                        </li>
                        </c:if>
                        <c:if test="${user != null}">
                            <li>
                                <a href="Controller?command=logout">${logout}</a>
                            </li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</header>

</body>
</html>
