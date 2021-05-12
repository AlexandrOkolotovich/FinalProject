<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gallery</title>

    <fmt:setLocale value="${sessionScope.locale}" />
    <fmt:setBundle basename="locale" var="loc" />
    <fmt:message bundle="${loc}" key="gallery.lable" var="lable"/>
    <fmt:message bundle="${loc}" key="gallery.allphoto" var="allphoto"/>
    <fmt:message bundle="${loc}" key="gallery.interior" var="interior"/>
    <fmt:message bundle="${loc}" key="gallery.food" var="food"/>
    <fmt:message bundle="${loc}" key="gallery.events" var="events"/>
    <fmt:message bundle="${loc}" key="gallery.vipguests" var="vipguests"/>
</head>
<body class="animsition">
<jsp:include page="part/header.jsp"/>

<!-- Title Page -->
<section class="bg-title-page flex-c-m p-t-160 p-b-80 p-l-15 p-r-15" style="background-image: url(${pageContext.request.contextPath}/static/img/bg-title-page-02.jpg);">
    <h2 class="tit6 t-center">
        ${lable}
    </h2>
</section>

<!-- Gallery -->
<div class="section-gallery p-t-118 p-b-100">
    <div class="wrap-label-gallery filter-tope-group size27 flex-w flex-sb-m m-l-r-auto flex-col-c-sm p-l-15 p-r-15 m-b-60">
        <button class="label-gallery txt26 trans-0-4 is-actived" data-filter="*">
            ${allphoto}
        </button>

        <button class="label-gallery txt26 trans-0-4" data-filter=".interior">
            ${interior}
        </button>

        <button class="label-gallery txt26 trans-0-4" data-filter=".food">
            ${food}
        </button>

        <button class="label-gallery txt26 trans-0-4" data-filter=".events">
            ${events}
        </button>

        <button class="label-gallery txt26 trans-0-4" data-filter=".guests">
            ${vipguests}
        </button>
    </div>

    <div class="wrap-gallery isotope-grid flex-w p-l-25 p-r-25">
        <!-- - -->
        <div class="item-gallery isotope-item bo-rad-10 hov-img-zoom events guests">
            <img src="${pageContext.request.contextPath}/static/img/photo-gallery-13.jpg" alt="IMG-GALLERY">

            <div class="overlay-item-gallery trans-0-4 flex-c-m">
                <a class="btn-show-gallery flex-c-m fa fa-search" href="${pageContext.request.contextPath}/static/img/photo-gallery-13.jpg" data-lightbox="gallery"></a>
            </div>
        </div>

        <!-- - -->
        <div class="item-gallery isotope-item bo-rad-10 hov-img-zoom food">
            <img src="${pageContext.request.contextPath}/static/img/photo-gallery-14.jpg" alt="IMG-GALLERY">

            <div class="overlay-item-gallery trans-0-4 flex-c-m">
                <a class="btn-show-gallery flex-c-m fa fa-search" href="${pageContext.request.contextPath}/static/img/photo-gallery-14.jpg" data-lightbox="gallery"></a>
            </div>
        </div>

        <!-- - -->
        <div class="item-gallery isotope-item bo-rad-10 hov-img-zoom events">
            <img src="${pageContext.request.contextPath}/static/img/photo-gallery-15.jpg" alt="IMG-GALLERY">

            <div class="overlay-item-gallery trans-0-4 flex-c-m">
                <a class="btn-show-gallery flex-c-m fa fa-search" href="${pageContext.request.contextPath}/static/img/photo-gallery-15.jpg" data-lightbox="gallery"></a>
            </div>
        </div>

        <!-- - -->
        <div class="item-gallery isotope-item bo-rad-10 hov-img-zoom food">
            <img src="${pageContext.request.contextPath}/static/img/photo-gallery-16.jpg" alt="IMG-GALLERY">

            <div class="overlay-item-gallery trans-0-4 flex-c-m">
                <a class="btn-show-gallery flex-c-m fa fa-search" href="${pageContext.request.contextPath}/static/img/photo-gallery-16.jpg" data-lightbox="gallery"></a>
            </div>
        </div>

        <!-- - -->
        <div class="item-gallery isotope-item bo-rad-10 hov-img-zoom food">
            <img src="${pageContext.request.contextPath}/static/img/photo-gallery-17.jpg" alt="IMG-GALLERY">

            <div class="overlay-item-gallery trans-0-4 flex-c-m">
                <a class="btn-show-gallery flex-c-m fa fa-search" href="${pageContext.request.contextPath}/static/img/photo-gallery-17.jpg" data-lightbox="gallery"></a>
            </div>
        </div>

        <!-- - -->
        <div class="item-gallery isotope-item bo-rad-10 hov-img-zoom interior guests">
            <img src="${pageContext.request.contextPath}/static/img/photo-gallery-18.jpg" alt="IMG-GALLERY">

            <div class="overlay-item-gallery trans-0-4 flex-c-m">
                <a class="btn-show-gallery flex-c-m fa fa-search" href="${pageContext.request.contextPath}/static/img/photo-gallery-18.jpg" data-lightbox="gallery"></a>
            </div>
        </div>

        <!-- - -->
        <div class="item-gallery isotope-item bo-rad-10 hov-img-zoom interior">
            <img src="${pageContext.request.contextPath}/static/img/photo-gallery-19.jpg" alt="IMG-GALLERY">

            <div class="overlay-item-gallery trans-0-4 flex-c-m">
                <a class="btn-show-gallery flex-c-m fa fa-search" href="${pageContext.request.contextPath}/static/img/photo-gallery-19.jpg" data-lightbox="gallery"></a>
            </div>
        </div>

        <!-- - -->
        <div class="item-gallery isotope-item bo-rad-10 hov-img-zoom interior">
            <img src="${pageContext.request.contextPath}/static/img/photo-gallery-20.jpg" alt="IMG-GALLERY">

            <div class="overlay-item-gallery trans-0-4 flex-c-m">
                <a class="btn-show-gallery flex-c-m fa fa-search" href="${pageContext.request.contextPath}/static/img/photo-gallery-20.jpg" data-lightbox="gallery"></a>
            </div>
        </div>

        <!-- - -->
        <div class="item-gallery isotope-item bo-rad-10 hov-img-zoom events">
            <img src="${pageContext.request.contextPath}/static/img/photo-gallery-21.jpg" alt="IMG-GALLERY">

            <div class="overlay-item-gallery trans-0-4 flex-c-m">
                <a class="btn-show-gallery flex-c-m fa fa-search" href="${pageContext.request.contextPath}/static/img/photo-gallery-21.jpg" data-lightbox="gallery"></a>
            </div>
        </div>
    </div>

    <div class="pagination flex-c-m flex-w p-l-15 p-r-15 m-t-24 m-b-50">
        <a href="#" class="item-pagination flex-c-m trans-0-4 active-pagination">1</a>
        <a href="#" class="item-pagination flex-c-m trans-0-4">2</a>
        <a href="#" class="item-pagination flex-c-m trans-0-4">3</a>
    </div>
</div>

<jsp:include page="part/footer.jsp"/>
</body>
</html>