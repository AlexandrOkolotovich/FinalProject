<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>About</title>

    <fmt:setLocale value="${sessionScope.locale}" />
    <fmt:setBundle basename="locale" var="loc" />
    <fmt:message bundle="${loc}" key="aboutus.lable" var="lable"/>
    <fmt:message bundle="${loc}" key="aboutus.namerestaurant" var="namerestaurant"/>
    <fmt:message bundle="${loc}" key="aboutus.ourstory" var="ourstory"/>
    <fmt:message bundle="${loc}" key="aboutus.discover" var="discover"/>
    <fmt:message bundle="${loc}" key="aboutus.ourvideo" var="ourvideo"/>
    <fmt:message bundle="${loc}" key="aboutus.delicious" var="delicious"/>
    <fmt:message bundle="${loc}" key="aboutus.recipes" var="recipes"/>
    <fmt:message bundle="${loc}" key="aboutus.romantic" var="romantic"/>
    <fmt:message bundle="${loc}" key="aboutus.restaurant" var="restaurant"/>
    <fmt:message bundle="${loc}" key="aboutus.meetour" var="meetour"/>
    <fmt:message bundle="${loc}" key="aboutus.chef" var="chef"/>
    <fmt:message bundle="${loc}" key="aboutus.ourlocation" var="ourlocation"/>

</head>
<body class="animsition">
<jsp:include page="part/header.jsp"/>

<!-- Title Page -->
<section class="bg-title-page flex-c-m p-t-160 p-b-80 p-l-15 p-r-15" style="background-image: url(${pageContext.request.contextPath}/static/img/bg-title-page-03.jpg);">
    <h2 class="tit6 t-center">
        ${lable}
    </h2>
</section>


<!-- Our Story -->
<section class="bg2-pattern p-t-116 p-b-110 t-center p-l-15 p-r-15">
		<span class="tit2 t-center">
			${namerestaurant}
		</span>

    <h3 class="tit3 t-center m-b-35 m-t-5">
        ${ourstory}
    </h3>

    <p class="t-center size32 m-l-r-auto">
        Fusce at risus eget mi auctor pulvinar. Suspendisse maximus venenatis pretium. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Aliquam purus purus, lacinia a scelerisque in, luctus vel felis. Donec odio diam, dignissim a efficitur at, efficitur et est. Pellentesque semper est ut pulvinar ullamcorper. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nulla et leo accumsan, egestas velit ac, fringilla tortor. Sed varius justo sed luctus mattis.
    </p>
</section>


<!-- Video -->
<section class="section-video parallax100" style="background-image: url(${pageContext.request.contextPath}/static/img/header-menu-01.jpg);">
    <div class="content-video t-center p-t-225 p-b-250">
			<span class="tit2 p-l-15 p-r-15">
				${discover}
			</span>

        <h3 class="tit4 t-center p-l-15 p-r-15 p-t-3">
            ${ourvideo}
        </h3>

        <div class="btn-play ab-center size16 hov-pointer m-l-r-auto m-t-43 m-b-33" data-toggle="modal" data-target="#modal-video-01">
            <div class="flex-c-m sizefull bo-cir bgwhite color1 hov1 trans-0-4">
                <i class="fa fa-play fs-18 m-l-2" aria-hidden="true"></i>
            </div>
        </div>
    </div>
</section>


<div class="modal fade" id="modal-video-01" tabindex="-1" role="dialog" aria-hidden="true">

    <div class="modal-dialog" role="document" data-dismiss="modal">
        <div class="close-mo-video-01 trans-0-4" data-dismiss="modal" aria-label="Close">×</div>

        <div class="wrap-video-mo-01">
            <div class="w-full wrap-pic-w op-0-0"><img src="${pageContext.request.contextPath}/static/img/icons/video-16-9.jpg" alt="IMG"></div>
            <div class="video-mo-01">
                <iframe src="https://www.youtube.com/embed/BTiJb9VLm1U?rel=0&amp;showinfo=0" allowfullscreen=""></iframe>
            </div>
        </div>
    </div>
</div>


<!-- Delicious & Romantic-->
<section class="bg1-pattern p-t-120 p-b-105">
    <div class="container">
        <!-- Delicious -->
        <div class="row">
            <div class="col-md-6 p-t-45 p-b-30">
                <div class="wrap-text-delicious t-center">
						<span class="tit2 t-center">
							${delicious}
						</span>

                    <h3 class="tit3 t-center m-b-35 m-t-5">
                        ${recipes}
                    </h3>

                    <p class="t-center m-b-22 size3 m-l-r-auto">
                        Donec quis lorem nulla. Nunc eu odio mi. Morbi nec lobortis est. Sed fringilla, nunc sed imperdiet lacinia, nisl ante egestas mi, ac facilisis ligula sem id neque.
                    </p>
                </div>
            </div>

            <div class="col-md-6 p-b-30">
                <div class="wrap-pic-delicious size2 bo-rad-10 hov-img-zoom m-l-r-auto">
                    <img src="${pageContext.request.contextPath}/static/img/our-story-01.jpg" alt="IMG-OUR">
                </div>
            </div>
        </div>


        <!-- Romantic -->
        <div class="row p-t-170">
            <div class="col-md-6 p-b-30">
                <div class="wrap-pic-romantic size2 bo-rad-10 hov-img-zoom m-l-r-auto">
                    <img src="${pageContext.request.contextPath}/static/img/our-story-02.jpg" alt="IMG-OUR">
                </div>
            </div>

            <div class="col-md-6 p-t-45 p-b-30">
                <div class="wrap-text-romantic t-center">
						<span class="tit2 t-center">
							${romantic}
						</span>

                    <h3 class="tit3 t-center m-b-35 m-t-5">
                        ${restaurant}
                    </h3>

                    <p class="t-center m-b-22 size3 m-l-r-auto">
                        Fusce iaculis, quam quis volutpat cursus, tellus quam varius eros, in euismod lorem nisl in ante. Maecenas imperdiet vulputate dui sit amet vestibulum. Nulla quis suscipit nisl.
                    </p>
                </div>
            </div>
        </div>
    </div>
</section>


<!-- Banner -->
<div class="parallax0 parallax100" style="background-image: url(${pageContext.request.contextPath}/static/img/bg-cover-video-02.jpg);">
    <div class="overlay0-parallax t-center size33"></div>
</div>


<!-- Chef -->
<section class="section-chef bgwhite p-t-115 p-b-95">
    <div class="container t-center">
			<span class="tit2 t-center">
				${meetour}
			</span>

        <h3 class="tit5 t-center m-b-50 m-t-5">
            ${chef}
        </h3>

        <div class="row">
            <div class="col-md-8 col-lg-4 m-l-r-auto p-b-30">
                <!-- -Block5 -->
                <div class="blo5 pos-relative p-t-60">
                    <div class="pic-blo5 size14 bo4 wrap-cir-pic hov-img-zoom ab-c-t">
                        <a href="#"><img src="${pageContext.request.contextPath}/static/img/avatar-02.jpg" alt="IGM-AVATAR"></a>
                    </div>

                    <div class="text-blo5 size34 t-center bo-rad-10 bo7 p-t-90 p-l-35 p-r-35 p-b-30">
                        <a href="#" class="txt34 dis-block p-b-6">
                            Peter Hart
                        </a>

                        <span class="dis-block t-center txt35 p-b-15">
								${chef}
							</span>
                        <div class="star-review fs-18 color0 flex-c-m p-b-15">
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star p-l-1" aria-hidden="true"></i>
                            <i class="fa fa-star p-l-1" aria-hidden="true"></i>
                            <i class="fa fa-star p-l-1" aria-hidden="true"></i>
                            <i class="fa fa-star p-l-1" aria-hidden="true"></i>
                        </div>

                        <p class="t-center">
                            Donec porta eleifend mauris ut effici-tur. Quisque non velit vestibulum, lob-ortis mi eget, rhoncus nunc
                        </p>
                    </div>
                </div>
            </div>

            <div class="col-md-8 col-lg-4 m-l-r-auto p-b-30">
                <!-- -Block5 -->
                <div class="blo5 pos-relative p-t-60">
                    <div class="pic-blo5 size14 bo4 wrap-cir-pic hov-img-zoom ab-c-t">
                        <a href="#"><img src="${pageContext.request.contextPath}/static/img/avatar-03.jpg" alt="IGM-AVATAR"></a>
                    </div>

                    <div class="text-blo5 size34 t-center bo-rad-10 bo7 p-t-90 p-l-35 p-r-35 p-b-30">
                        <a href="#" class="txt34 dis-block p-b-6">
                            Joyce Bowman
                        </a>

                        <span class="dis-block t-center txt35 p-b-15">
								${chef}
							</span>
                        <div class="star-review fs-18 color0 flex-c-m p-b-15">
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star p-l-1" aria-hidden="true"></i>
                            <i class="fa fa-star p-l-1" aria-hidden="true"></i>
                            <i class="fa fa-star p-l-1" aria-hidden="true"></i>
                            <i class="fa fa-star p-l-1" aria-hidden="true"></i>
                        </div>

                        <p class="t-center">
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ultricies felis a sem tempus tempus.
                        </p>
                    </div>
                </div>
            </div>

            <div class="col-md-8 col-lg-4 m-l-r-auto p-b-30">
                <!-- -Block5 -->
                <div class="blo5 pos-relative p-t-60">
                    <div class="pic-blo5 size14 bo4 wrap-cir-pic hov-img-zoom ab-c-t">
                        <a href="#"><img src="${pageContext.request.contextPath}/static/img/avatar-05.jpg" alt="IGM-AVATAR"></a>
                    </div>

                    <div class="text-blo5 size34 t-center bo-rad-10 bo7 p-t-90 p-l-35 p-r-35 p-b-30">
                        <a href="#" class="txt34 dis-block p-b-6">
                            Peter Hart
                        </a>

                        <span class="dis-block t-center txt35 p-b-15">
								${chef}
							</span>
                        <div class="star-review fs-18 color0 flex-c-m p-b-15">
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star p-l-1" aria-hidden="true"></i>
                            <i class="fa fa-star p-l-1" aria-hidden="true"></i>
                            <i class="fa fa-star p-l-1" aria-hidden="true"></i>
                            <i class="fa fa-star p-l-1" aria-hidden="true"></i>
                        </div>

                        <p class="t-center">
                            Phasellus aliquam libero a nisi varius, vitae placerat sem aliquet. Ut at velit nec ipsum iaculis posuere quis in sapien
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<section id="contact" >
    <h3 class="tit5 t-center m-b-20 m-t-15">
        ${ourlocation}
    </h3>
    <div class="map m-t-20 m-b-40" align="center">
        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2049.192790554709!2d-2.3569949652291142!3d57.33693101247719!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x0!2zNTfCsDIwJzEyLjgiTiAywrAyMScyMC42Ilc!5e1!3m2!1sru!2sby!4v1620339109566!5m2!1sru!2sby" width="80%" height="450" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
    </div>
</section>

<jsp:include page="part/footer.jsp"/>
</body>
</html>