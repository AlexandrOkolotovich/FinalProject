<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <fmt:setLocale value="${sessionScope.locale}" />
    <fmt:setBundle basename="locale" var="loc" />
    <fmt:message bundle="${loc}" key="home.lable.welcome" var="welcome"/>
    <fmt:message bundle="${loc}" key="home.lable.lookmenu" var="lookmenu"/>
    <fmt:message bundle="${loc}" key="aboutus.namerestaurant" var="namerestaurant"/>
    <fmt:message bundle="${loc}" key="home.ourmenu" var="ourmenu"/>
    <fmt:message bundle="${loc}" key="home.discover" var="discover"/>
    <fmt:message bundle="${loc}" key="home.romanticrestaurant" var="romanticrestaurant"/>
    <fmt:message bundle="${loc}" key="home.learnmore" var="learnmore"/>
    <fmt:message bundle="${loc}" key="home.deliciousfood" var="deliciousfood"/>
    <fmt:message bundle="${loc}" key="home.redwines" var="redwines"/>
    <fmt:message bundle="${loc}" key="home.lunch" var="lunch"/>
    <fmt:message bundle="${loc}" key="home.dinner" var="dinner"/>
    <fmt:message bundle="${loc}" key="home.happyhour" var="happyhour"/>
    <fmt:message bundle="${loc}" key="home.drink" var="drink"/>
    <fmt:message bundle="${loc}" key="home.starters" var="starters"/>
    <fmt:message bundle="${loc}" key="home.dessert" var="dessert"/>
</head>
<body>
    <jsp:include page="part/header.jsp"/>

    <!-- Slide1 -->
    <section class="section-slide">
        <div class="wrap-slick1">
            <div class="slick1">
                <div class="item-slick1 item1-slick1" style="background-image: url(${pageContext.request.contextPath}/static/img/slide1-01.jpg);">
                    <div class="wrap-content-slide1 sizefull flex-col-c-m p-l-15 p-r-15 p-t-150 p-b-170">
						<span class="caption1-slide1 txt1 t-center animated visible-false m-b-15" data-appear="fadeInDown">
							${welcome}
						</span>

                        <h2 class="caption2-slide1 tit1 t-center animated visible-false m-b-37" data-appear="fadeInUp">
                            Karpinka
                        </h2>

                        <div class="wrap-btn-slide1 animated visible-false" data-appear="zoomIn">
                            <!-- Button1 -->
                            <a href="Controller?command=gotomenupage" class="btn1 flex-c-m size1 txt3 trans-0-4">
                                ${lookmenu}
                            </a>
                        </div>
                    </div>
                </div>

                <div class="item-slick1 item2-slick1" style="background-image: url(${pageContext.request.contextPath}/static/img/master-slides-02.jpg);">
                    <div class="wrap-content-slide1 sizefull flex-col-c-m p-l-15 p-r-15 p-t-150 p-b-170">
						<span class="caption1-slide1 txt1 t-center animated visible-false m-b-15" data-appear="rollIn">
                            ${welcome}
						</span>

                        <h2 class="caption2-slide1 tit1 t-center animated visible-false m-b-37" data-appear="lightSpeedIn">
                            Karpinka
                        </h2>

                        <div class="wrap-btn-slide1 animated visible-false" data-appear="slideInUp">
                            <!-- Button1 -->
                            <a href="Controller?command=gotomenupage" class="btn1 flex-c-m size1 txt3 trans-0-4">
                                ${lookmenu}
                            </a>
                        </div>
                    </div>
                </div>

                <div class="item-slick1 item3-slick1" style="background-image: url(${pageContext.request.contextPath}/static/img/master-slides-01.jpg);">
                    <div class="wrap-content-slide1 sizefull flex-col-c-m p-l-15 p-r-15 p-t-150 p-b-170">
						<span class="caption1-slide1 txt1 t-center animated visible-false m-b-15" data-appear="rotateInDownLeft">
                            ${welcome}
						</span>

                        <h2 class="caption2-slide1 tit1 t-center animated visible-false m-b-37" data-appear="rotateInUpRight">
                            KARPINKA
                        </h2>

                        <div class="wrap-btn-slide1 animated visible-false" data-appear="rotateIn">
                            <!-- Button1 -->
                            <a href="Controller?command=gotomenupage" class="btn1 flex-c-m size1 txt3 trans-0-4">
                                ${lookmenu}
                            </a>
                        </div>
                    </div>
                </div>

            </div>

            <div class="wrap-slick1-dots"></div>
        </div>
    </section>

    <!-- Welcome -->
    <section class="section-welcome bg1-pattern p-t-120 p-b-105">
        <div class="container">
            <div class="row">
                <div class="col-md-6 p-t-45 p-b-30">
                    <div class="wrap-text-welcome t-center">
						<span class="tit2 t-center">
							${namerestaurant}
						</span>

                        <h3 class="tit3 t-center m-b-35 m-t-5">
                            ${welcome}
                        </h3>

                        <p class="t-center m-b-22 size3 m-l-r-auto">
                            Donec quis lorem nulla. Nunc eu odio mi. Morbi nec lobortis est. Sed fringilla, nunc sed imperdiet lacinia, nisl ante egestas mi, ac facilisis ligula sem id neque.
                        </p>

                        <a href="Controller?command=gotomenupage" class="txt4">
                            ${ourmenu}
                            <i class="fa fa-long-arrow-right m-l-10" aria-hidden="true"></i>
                        </a>
                    </div>
                </div>

                <div class="col-md-6 p-b-30">
                    <div class="wrap-pic-welcome size2 bo-rad-10 hov-img-zoom m-l-r-auto">
                        <img src="${pageContext.request.contextPath}/static/img/our-story-01.jpg" alt="IMG-OUR">
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- Intro -->
    <section class="section-intro">
        <div class="header-intro parallax100 t-center p-t-135 p-b-158" style="background-image: url(${pageContext.request.contextPath}/static/img/bg-intro-01.jpg);">
			<span class="tit2 p-l-15 p-r-15">
				${discover}
			</span>

            <h3 class="tit4 t-center p-l-15 p-r-15 p-t-3">
                Karpinka
            </h3>
        </div>

        <div class="content-intro bg-white p-t-77 p-b-133">
            <div class="container">
                <div class="row">
                    <div class="col-md-4 p-t-30">
                        <!-- Block1 -->
                        <div class="blo1">
                            <div class="wrap-pic-blo1 bo-rad-10 hov-img-zoom">
                                <a href="#"><img src="${pageContext.request.contextPath}/static/img/intro-01.jpg" alt="IMG-INTRO"></a>
                            </div>

                            <div class="wrap-text-blo1 p-t-35">
                                <a href="#"><h4 class="txt5 color0-hov trans-0-4 m-b-13">
                                    ${romanticrestaurant}
                                </h4></a>

                                <p class="m-b-20">
                                    Phasellus lorem enim, luctus ut velit eget, con-vallis egestas eros.
                                </p>

                                <a href="#" class="txt4">
                                    ${learnmore}
                                    <i class="fa fa-long-arrow-right m-l-10" aria-hidden="true"></i>
                                </a>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-4 p-t-30">
                        <!-- Block1 -->
                        <div class="blo1">
                            <div class="wrap-pic-blo1 bo-rad-10 hov-img-zoom">
                                <a href="#"><img src="${pageContext.request.contextPath}/static/img/intro-02.jpg" alt="IMG-INTRO"></a>
                            </div>

                            <div class="wrap-text-blo1 p-t-35">
                                <a href="#"><h4 class="txt5 color0-hov trans-0-4 m-b-13">
                                    ${deliciousfood}
                                </h4></a>

                                <p class="m-b-20">
                                    Aliquam eget aliquam magna, quis posuere risus ac justo ipsum nibh urna
                                </p>

                                <a href="#" class="txt4">
                                    ${learnmore}
                                    <i class="fa fa-long-arrow-right m-l-10" aria-hidden="true"></i>
                                </a>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-4 p-t-30">
                        <!-- Block1 -->
                        <div class="blo1">
                            <div class="wrap-pic-blo1 bo-rad-10 hov-img-zoom">
                                <a href="#"><img src="${pageContext.request.contextPath}/static/img/intro-04.jpg" alt="IMG-INTRO"></a>
                            </div>

                            <div class="wrap-text-blo1 p-t-35">
                                <a href="#"><h4 class="txt5 color0-hov trans-0-4 m-b-13">
                                    ${redwines}
                                </h4></a>

                                <p class="m-b-20">
                                    Sed ornare ligula eget tortor tempor, quis porta tellus dictum.
                                </p>

                                <a href="#" class="txt4">
                                    ${learnmore}
                                    <i class="fa fa-long-arrow-right m-l-10" aria-hidden="true"></i>
                                </a>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </section>

    <!-- Our menu -->
    <section class="section-ourmenu bg2-pattern p-t-115 p-b-120">
        <div class="container">
            <div class="title-section-ourmenu t-center m-b-22">
				<span class="tit2 t-center">
					${discover}
				</span>

                <h3 class="tit5 t-center m-t-2">
                    ${ourmenu}
                </h3>
            </div>

            <div class="row">
                <div class="col-md-8">
                    <div class="row">
                        <div class="col-sm-6">
                            <!-- Item our menu -->
                            <div class="item-ourmenu bo-rad-10 hov-img-zoom pos-relative m-t-30">
                                <img src="${pageContext.request.contextPath}/static/img/our-menu-01.jpg" alt="IMG-MENU">

                                <!-- Button2 -->
                                <a href="#" class="btn2 flex-c-m txt5 ab-c-m size4">
                                    ${lunch}
                                </a>
                            </div>
                        </div>

                        <div class="col-sm-6">
                            <!-- Item our menu -->
                            <div class="item-ourmenu bo-rad-10 hov-img-zoom pos-relative m-t-30">
                                <img src="${pageContext.request.contextPath}/static/img/our-menu-05.jpg" alt="IMG-MENU">

                                <!-- Button2 -->
                                <a href="#" class="btn2 flex-c-m txt5 ab-c-m size5">
                                    ${dinner}
                                </a>
                            </div>
                        </div>

                        <div class="col-12">
                            <!-- Item our menu -->
                            <div class="item-ourmenu bo-rad-10 hov-img-zoom pos-relative m-t-30">
                                <img src="${pageContext.request.contextPath}/static/img/our-menu-13.jpg" alt="IMG-MENU">

                                <!-- Button2 -->
                                <a href="#" class="btn2 flex-c-m txt5 ab-c-m size6">
                                    ${happyhour}
                                </a>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="row">
                        <div class="col-12">
                            <!-- Item our menu -->
                            <div class="item-ourmenu bo-rad-10 hov-img-zoom pos-relative m-t-30">
                                <img src="${pageContext.request.contextPath}/static/img/our-menu-08.jpg" alt="IMG-MENU">

                                <!-- Button2 -->
                                <a href="#" class="btn2 flex-c-m txt5 ab-c-m size7">
                                    ${drink}
                                </a>
                            </div>
                        </div>

                        <div class="col-12">
                            <!-- Item our menu -->
                            <div class="item-ourmenu bo-rad-10 hov-img-zoom pos-relative m-t-30">
                                <img src="${pageContext.request.contextPath}/static/img/our-menu-10.jpg" alt="IMG-MENU">

                                <!-- Button2 -->
                                <a href="#" class="btn2 flex-c-m txt5 ab-c-m size8">
                                    ${starters}
                                </a>
                            </div>
                        </div>

                        <div class="col-12">
                            <!-- Item our menu -->
                            <div class="item-ourmenu bo-rad-10 hov-img-zoom pos-relative m-t-30">
                                <img src="${pageContext.request.contextPath}/static/img/our-menu-16.jpg" alt="IMG-MENU">

                                <!-- Button2 -->
                                <a href="#" class="btn2 flex-c-m txt5 ab-c-m size9">
                                    ${dessert}
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </section>

    <jsp:include page="part/footer.jsp"/>
</body>
</html>
