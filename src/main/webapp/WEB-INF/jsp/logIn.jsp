<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 07.03.2021
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="local" uri="/tld/localization.tld" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>LogIn</title>

    <fmt:setLocale value="${sessionScope.locale}" />
    <fmt:setBundle basename="locale" var="loc" />
    <fmt:message bundle="${loc}" key="signin.lable" var="signin"/>
    <fmt:message bundle="${loc}" key="signin.lable.email" var="email"/>
    <fmt:message bundle="${loc}" key="signin.lable.password" var="password"/>
    <fmt:message bundle="${loc}" key="signin.button" var="login"/>
    <fmt:message bundle="${loc}" key="signin.path.signup" var="signup"/>
</head>
<body>
<jsp:include page="part/header.jsp"/>

<!-- Sidebar -->
<aside class="sidebar trans-0-4">
    <!-- Button Hide sidebar -->
    <button class="btn-hide-sidebar ti-close color0-hov trans-0-4"></button>

    <!-- - -->
    <ul class="menu-sidebar p-t-95 p-b-70">
        <li class="t-center m-b-13">
            <a href="index.html" class="txt19">Home</a>
        </li>

        <li class="t-center m-b-13">
            <a href="menu.html" class="txt19">Menu</a>
        </li>

        <li class="t-center m-b-13">
            <a href="gallery.html" class="txt19">Gallery</a>
        </li>

        <li class="t-center m-b-13">
            <a href="about.html" class="txt19">About</a>
        </li>

        <li class="t-center m-b-13">
            <a href="blog.html" class="txt19">Blog</a>
        </li>

        <li class="t-center m-b-33">
            <a href="contact.html" class="txt19">Contact</a>
        </li>

        <li class="t-center">
            <!-- Button3 -->
            <a href="reservation.html" class="btn3 flex-c-m size13 txt11 trans-0-4 m-l-r-auto">
                Reservation
            </a>
        </li>
    </ul>

    <!-- - -->
    <div class="gallery-sidebar t-center p-l-60 p-r-60 p-b-40">
        <!-- - -->
        <h4 class="txt20 m-b-33">
            Gallery
        </h4>

        <!-- Gallery -->
        <div class="wrap-gallery-sidebar flex-w">
            <a class="item-gallery-sidebar wrap-pic-w" href="${pageContext.request.contextPath}/static/img/photo-gallery-01.jpg" data-lightbox="gallery-footer">
                <img src="${pageContext.request.contextPath}/static/img/photo-gallery-thumb-01.jpg" alt="GALLERY">
            </a>

            <a class="item-gallery-sidebar wrap-pic-w" href="${pageContext.request.contextPath}/static/img/photo-gallery-02.jpg" data-lightbox="gallery-footer">
                <img src="${pageContext.request.contextPath}/static/img/photo-gallery-thumb-02.jpg" alt="GALLERY">
            </a>

            <a class="item-gallery-sidebar wrap-pic-w" href="${pageContext.request.contextPath}/static/img/photo-gallery-03.jpg" data-lightbox="gallery-footer">
                <img src="${pageContext.request.contextPath}/static/img/photo-gallery-thumb-03.jpg" alt="GALLERY">
            </a>

            <a class="item-gallery-sidebar wrap-pic-w" href="${pageContext.request.contextPath}/static/img/photo-gallery-05.jpg" data-lightbox="gallery-footer">
                <img src="${pageContext.request.contextPath}/static/img/photo-gallery-thumb-05.jpg" alt="GALLERY">
            </a>

            <a class="item-gallery-sidebar wrap-pic-w" href="${pageContext.request.contextPath}/static/img/photo-gallery-06.jpg" data-lightbox="gallery-footer">
                <img src="${pageContext.request.contextPath}/static/img/photo-gallery-thumb-06.jpg" alt="GALLERY">
            </a>

            <a class="item-gallery-sidebar wrap-pic-w" href="${pageContext.request.contextPath}/static/img/photo-gallery-07.jpg" data-lightbox="gallery-footer">
                <img src="${pageContext.request.contextPath}/static/img/photo-gallery-thumb-07.jpg" alt="GALLERY">
            </a>

            <a class="item-gallery-sidebar wrap-pic-w" href="${pageContext.request.contextPath}/static/img/photo-gallery-09.jpg" data-lightbox="gallery-footer">
                <img src="${pageContext.request.contextPath}/static/img/photo-gallery-thumb-09.jpg" alt="GALLERY">
            </a>

            <a class="item-gallery-sidebar wrap-pic-w" href="${pageContext.request.contextPath}/static/img/photo-gallery-10.jpg" data-lightbox="gallery-footer">
                <img src="${pageContext.request.contextPath}/static/img/photo-gallery-thumb-10.jpg" alt="GALLERY">
            </a>

            <a class="item-gallery-sidebar wrap-pic-w" href="${pageContext.request.contextPath}/static/img/photo-gallery-11.jpg" data-lightbox="gallery-footer">
                <img src="${pageContext.request.contextPath}/static/img/photo-gallery-thumb-11.jpg" alt="GALLERY">
            </a>
        </div>
    </div>
</aside>


<!-- Title Page -->
<section class="bg-title-page flex-c-m p-t-160 p-b-80 p-l-15 p-r-15" style="background-image: url(${pageContext.request.contextPath}/static/img/bg-title-page-02.jpg);">
    <h2 class="tit6 t-center">
        ${signin}
    </h2>
</section>
<br /><br />
<setction class="section-signup bg1-pattern p-t-85 p-b-85">
<div class="container" id="catalog">

    <form action="Controller" method="post">
       <input type="hidden" name="command" value="logIn" />
        ${email}:
        <br /> <input type="email" class="bo-rad-10 txt15 " name="email" value="" /><br />
       ${password}:
        <br /> <input type="password" class="bo-rad-10 txt15" name="password" value="" /><br />
        <br />
        <input type="submit" class="btn3 flex-c-m size13 txt11 trans-0-4" value=${login} /><br />
        <br />
        <a href="Controller?command=registration" class="txt4">${signup}</a>
    </form>
</div>
</setction>
</body>
</html>
