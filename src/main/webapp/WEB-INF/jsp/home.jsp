<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 29.03.2021
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
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

    <!-- Slide1 -->
    <section class="section-slide">
        <div class="wrap-slick1">
            <div class="slick1">
                <div class="item-slick1 item1-slick1" style="background-image: url(${pageContext.request.contextPath}/static/img/slide1-01.jpg);">
                    <div class="wrap-content-slide1 sizefull flex-col-c-m p-l-15 p-r-15 p-t-150 p-b-170">
						<span class="caption1-slide1 txt1 t-center animated visible-false m-b-15" data-appear="fadeInDown">
							Welcome to
						</span>

                        <h2 class="caption2-slide1 tit1 t-center animated visible-false m-b-37" data-appear="fadeInUp">
                            Pato Place
                        </h2>

                        <div class="wrap-btn-slide1 animated visible-false" data-appear="zoomIn">
                            <!-- Button1 -->
                            <a href="menu.html" class="btn1 flex-c-m size1 txt3 trans-0-4">
                                Look Menu
                            </a>
                        </div>
                    </div>
                </div>

                <div class="item-slick1 item2-slick1" style="background-image: url(${pageContext.request.contextPath}/static/img/master-slides-02.jpg);">
                    <div class="wrap-content-slide1 sizefull flex-col-c-m p-l-15 p-r-15 p-t-150 p-b-170">
						<span class="caption1-slide1 txt1 t-center animated visible-false m-b-15" data-appear="rollIn">
							Welcome to
						</span>

                        <h2 class="caption2-slide1 tit1 t-center animated visible-false m-b-37" data-appear="lightSpeedIn">
                            Pato Place
                        </h2>

                        <div class="wrap-btn-slide1 animated visible-false" data-appear="slideInUp">
                            <!-- Button1 -->
                            <a href="menu.html" class="btn1 flex-c-m size1 txt3 trans-0-4">
                                Look Menu
                            </a>
                        </div>
                    </div>
                </div>

                <div class="item-slick1 item3-slick1" style="background-image: url(${pageContext.request.contextPath}/static/img/master-slides-01.jpg);">
                    <div class="wrap-content-slide1 sizefull flex-col-c-m p-l-15 p-r-15 p-t-150 p-b-170">
						<span class="caption1-slide1 txt1 t-center animated visible-false m-b-15" data-appear="rotateInDownLeft">
							Welcome to
						</span>

                        <h2 class="caption2-slide1 tit1 t-center animated visible-false m-b-37" data-appear="rotateInUpRight">
                            Pato Place
                        </h2>

                        <div class="wrap-btn-slide1 animated visible-false" data-appear="rotateIn">
                            <!-- Button1 -->
                            <a href="menu.html" class="btn1 flex-c-m size1 txt3 trans-0-4">
                                Look Menu
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
							Italian Restaurant
						</span>

                        <h3 class="tit3 t-center m-b-35 m-t-5">
                            Welcome
                        </h3>

                        <p class="t-center m-b-22 size3 m-l-r-auto">
                            Donec quis lorem nulla. Nunc eu odio mi. Morbi nec lobortis est. Sed fringilla, nunc sed imperdiet lacinia, nisl ante egestas mi, ac facilisis ligula sem id neque.
                        </p>

                        <a href="about.html" class="txt4">
                            Our Story
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
				Discover
			</span>

            <h3 class="tit4 t-center p-l-15 p-r-15 p-t-3">
                Pato Place
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
                                    Romantic Restaurant
                                </h4></a>

                                <p class="m-b-20">
                                    Phasellus lorem enim, luctus ut velit eget, con-vallis egestas eros.
                                </p>

                                <a href="#" class="txt4">
                                    Learn More
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
                                    Delicious Food
                                </h4></a>

                                <p class="m-b-20">
                                    Aliquam eget aliquam magna, quis posuere risus ac justo ipsum nibh urna
                                </p>

                                <a href="#" class="txt4">
                                    Learn More
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
                                    Red Wines You Love
                                </h4></a>

                                <p class="m-b-20">
                                    Sed ornare ligula eget tortor tempor, quis porta tellus dictum.
                                </p>

                                <a href="#" class="txt4">
                                    Learn More
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
					Discover
				</span>

                <h3 class="tit5 t-center m-t-2">
                    Our Menu
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
                                    Lunch
                                </a>
                            </div>
                        </div>

                        <div class="col-sm-6">
                            <!-- Item our menu -->
                            <div class="item-ourmenu bo-rad-10 hov-img-zoom pos-relative m-t-30">
                                <img src="${pageContext.request.contextPath}/static/img/our-menu-05.jpg" alt="IMG-MENU">

                                <!-- Button2 -->
                                <a href="#" class="btn2 flex-c-m txt5 ab-c-m size5">
                                    Dinner
                                </a>
                            </div>
                        </div>

                        <div class="col-12">
                            <!-- Item our menu -->
                            <div class="item-ourmenu bo-rad-10 hov-img-zoom pos-relative m-t-30">
                                <img src="${pageContext.request.contextPath}/static/img/our-menu-13.jpg" alt="IMG-MENU">

                                <!-- Button2 -->
                                <a href="#" class="btn2 flex-c-m txt5 ab-c-m size6">
                                    Happy Hour
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
                                    Drink
                                </a>
                            </div>
                        </div>

                        <div class="col-12">
                            <!-- Item our menu -->
                            <div class="item-ourmenu bo-rad-10 hov-img-zoom pos-relative m-t-30">
                                <img src="${pageContext.request.contextPath}/static/img/our-menu-10.jpg" alt="IMG-MENU">

                                <!-- Button2 -->
                                <a href="#" class="btn2 flex-c-m txt5 ab-c-m size8">
                                    Starters
                                </a>
                            </div>
                        </div>

                        <div class="col-12">
                            <!-- Item our menu -->
                            <div class="item-ourmenu bo-rad-10 hov-img-zoom pos-relative m-t-30">
                                <img src="${pageContext.request.contextPath}/static/img/our-menu-16.jpg" alt="IMG-MENU">

                                <!-- Button2 -->
                                <a href="#" class="btn2 flex-c-m txt5 ab-c-m size9">
                                    Dessert
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </section>


    <!-- Event -->
    <section class="section-event">
        <div class="wrap-slick2">
            <div class="slick2">
                <div class="item-slick2 item1-slick2" style="background-image: url(${pageContext.request.contextPath}/static/img/bg-event-01.jpg);">
                    <div class="wrap-content-slide2 p-t-115 p-b-208">
                        <div class="container">
                            <!-- - -->
                            <div class="title-event t-center m-b-52">
								<span class="tit2 p-l-15 p-r-15">
									Upcomming
								</span>

                                <h3 class="tit6 t-center p-l-15 p-r-15 p-t-3">
                                    Events
                                </h3>
                            </div>

                            <!-- Block2 -->
                            <div class="blo2 flex-w flex-str flex-col-c-m-lg animated visible-false" data-appear="zoomIn">
                                <!-- Pic block2 -->
                                <a href="#" class="wrap-pic-blo2 bg1-blo2" style="background-image: url(${pageContext.request.contextPath}/static/img/event-02.jpg);">
                                    <div class="time-event size10 txt6 effect1">
										<span class="txt-effect1 flex-c-m t-center">
											08:00 PM Tuesday - 21 November 2018
										</span>
                                    </div>
                                </a>

                                <!-- Text block2 -->
                                <div class="wrap-text-blo2 flex-col-c-m p-l-40 p-r-40 p-t-45 p-b-30">
                                    <h4 class="tit7 t-center m-b-10">
                                        Wines during specific nights
                                    </h4>

                                    <p class="t-center">
                                        Donec quis lorem nulla. Nunc eu odio mi. Morbi nec lobortis est. Sed fringilla, nunc sed imperdiet lacinia
                                    </p>

                                    <div class="flex-sa-m flex-w w-full m-t-40">
                                        <div class="size11 flex-col-c-m">
											<span class="dis-block t-center txt7 m-b-2 days">
												25
											</span>

                                            <span class="dis-block t-center txt8">
												Days
											</span>
                                        </div>

                                        <div class="size11 flex-col-c-m">
											<span class="dis-block t-center txt7 m-b-2 hours">
												12
											</span>

                                            <span class="dis-block t-center txt8">
												Hours
											</span>
                                        </div>

                                        <div class="size11 flex-col-c-m">
											<span class="dis-block t-center txt7 m-b-2 minutes">
												59
											</span>

                                            <span class="dis-block t-center txt8">
												Minutes
											</span>
                                        </div>

                                        <div class="size11 flex-col-c-m">
											<span class="dis-block t-center txt7 m-b-2 seconds">
												56
											</span>

                                            <span class="dis-block t-center txt8">
												Seconds
											</span>
                                        </div>
                                    </div>

                                    <a href="#" class="txt4 m-t-40">
                                        View Details
                                        <i class="fa fa-long-arrow-right m-l-10" aria-hidden="true"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="item-slick2 item2-slick2" style="background-image: url(${pageContext.request.contextPath}/static/img/bg-event-02.jpg);">
                    <div class="wrap-content-slide2 p-t-115 p-b-208">
                        <div class="container">
                            <!-- - -->
                            <div class="title-event t-center m-b-52">
								<span class="tit2 p-l-15 p-r-15">
									Upcomming
								</span>

                                <h3 class="tit6 t-center p-l-15 p-r-15 p-t-3">
                                    Events
                                </h3>
                            </div>

                            <!-- Block2 -->
                            <div class="blo2 flex-w flex-str flex-col-c-m-lg animated visible-false" data-appear="fadeInDown">
                                <!-- Pic block2 -->
                                <a href="#" class="wrap-pic-blo2 bg2-blo2" style="background-image: url(${pageContext.request.contextPath}/static/img/event-06.jpg);">
                                    <div class="time-event size10 txt6 effect1">
										<span class="txt-effect1 flex-c-m">
											08:00 PM Tuesday - 21 November 2021
										</span>
                                    </div>
                                </a>

                                <!-- Text block2 -->
                                <div class="wrap-text-blo2 flex-col-c-m p-l-40 p-r-40 p-t-45 p-b-30">
                                    <h4 class="tit7 t-center m-b-10">
                                        Wines during specific nights
                                    </h4>

                                    <p class="t-center">
                                        Donec quis lorem nulla. Nunc eu odio mi. Morbi nec lobortis est. Sed fringilla, nunc sed imperdiet lacinia
                                    </p>

                                    <div class="flex-sa-m flex-w w-full m-t-40">
                                        <div class="size11 flex-col-c-m">
											<span class="dis-block t-center txt7 m-b-2 days">
												25
											</span>

                                            <span class="dis-block t-center txt8">
												Days
											</span>
                                        </div>

                                        <div class="size11 flex-col-c-m">
											<span class="dis-block t-center txt7 m-b-2 hours">
												12
											</span>

                                            <span class="dis-block t-center txt8">
												Hours
											</span>
                                        </div>

                                        <div class="size11 flex-col-c-m">
											<span class="dis-block t-center txt7 m-b-2 minutes">
												59
											</span>

                                            <span class="dis-block t-center txt8">
												Minutes
											</span>
                                        </div>

                                        <div class="size11 flex-col-c-m">
											<span class="dis-block t-center txt7 m-b-2 seconds">
												56
											</span>

                                            <span class="dis-block t-center txt8">
												Seconds
											</span>
                                        </div>
                                    </div>

                                    <a href="#" class="txt4 m-t-40">
                                        View Details
                                        <i class="fa fa-long-arrow-right m-l-10" aria-hidden="true"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="item-slick2 item3-slick2" style="background-image: url(${pageContext.request.contextPath}/static/img/bg-event-04.jpg);">
                    <div class="wrap-content-slide2 p-t-115 p-b-208">
                        <div class="container">
                            <!-- - -->
                            <div class="title-event t-center m-b-52">
								<span class="tit2 p-l-15 p-r-15">
									Upcomming
								</span>

                                <h3 class="tit6 t-center p-l-15 p-r-15 p-t-3">
                                    Events
                                </h3>
                            </div>

                            <!-- Block2 -->
                            <div class="blo2 flex-w flex-str flex-col-c-m-lg animated visible-false" data-appear="rotateInUpLeft">
                                <!-- Pic block2 -->
                                <a href="#" class="wrap-pic-blo2 bg3-blo2" style="background-image: url(${pageContext.request.contextPath}/static/img/event-01.jpg);">
                                    <div class="time-event size10 txt6 effect1">
										<span class="txt-effect1 flex-c-m">
											08:00 PM Tuesday - 21 November 2021
										</span>
                                    </div>
                                </a>

                                <!-- Text block2 -->
                                <div class="wrap-text-blo2 flex-col-c-m p-l-40 p-r-40 p-t-45 p-b-30">
                                    <h4 class="tit7 t-center m-b-10">
                                        Wines during specific nights
                                    </h4>

                                    <p class="t-center">
                                        Donec quis lorem nulla. Nunc eu odio mi. Morbi nec lobortis est. Sed fringilla, nunc sed imperdiet lacinia
                                    </p>

                                    <div class="flex-sa-m flex-w w-full m-t-40">
                                        <div class="size11 flex-col-c-m">
											<span class="dis-block t-center txt7 m-b-2 days">
												25
											</span>

                                            <span class="dis-block t-center txt8">
												Days
											</span>
                                        </div>

                                        <div class="size11 flex-col-c-m">
											<span class="dis-block t-center txt7 m-b-2 hours">
												12
											</span>

                                            <span class="dis-block t-center txt8">
												Hours
											</span>
                                        </div>

                                        <div class="size11 flex-col-c-m">
											<span class="dis-block t-center txt7 m-b-2 minutes">
												59
											</span>

                                            <span class="dis-block t-center txt8">
												Minutes
											</span>
                                        </div>

                                        <div class="size11 flex-col-c-m">
											<span class="dis-block t-center txt7 m-b-2 seconds">
												56
											</span>

                                            <span class="dis-block t-center txt8">
												Seconds
											</span>
                                        </div>
                                    </div>

                                    <a href="#" class="txt4 m-t-40">
                                        View Details
                                        <i class="fa fa-long-arrow-right m-l-10" aria-hidden="true"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

            <div class="wrap-slick2-dots"></div>
        </div>
    </section>

</body>
</html>
