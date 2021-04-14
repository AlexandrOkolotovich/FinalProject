<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>About</title>
</head>
<body class="animsition">
<jsp:include page="part/header.jsp"/>

<!-- Title Page -->
<section class="bg-title-page flex-c-m p-t-160 p-b-80 p-l-15 p-r-15" style="background-image: url(${pageContext.request.contextPath}/static/img/bg-title-page-03.jpg);">
    <h2 class="tit6 t-center">
        About Us
    </h2>
</section>


<!-- Our Story -->
<section class="bg2-pattern p-t-116 p-b-110 t-center p-l-15 p-r-15">
		<span class="tit2 t-center">
			Italian Restaurant
		</span>

    <h3 class="tit3 t-center m-b-35 m-t-5">
        Our Story
    </h3>

    <p class="t-center size32 m-l-r-auto">
        Fusce at risus eget mi auctor pulvinar. Suspendisse maximus venenatis pretium. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Aliquam purus purus, lacinia a scelerisque in, luctus vel felis. Donec odio diam, dignissim a efficitur at, efficitur et est. Pellentesque semper est ut pulvinar ullamcorper. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nulla et leo accumsan, egestas velit ac, fringilla tortor. Sed varius justo sed luctus mattis.
    </p>
</section>


<!-- Video -->
<section class="section-video parallax100" style="background-image: url(${pageContext.request.contextPath}/static/img/header-menu-01.jpg);">
    <div class="content-video t-center p-t-225 p-b-250">
			<span class="tit2 p-l-15 p-r-15">
				Discover
			</span>

        <h3 class="tit4 t-center p-l-15 p-r-15 p-t-3">
            Our Video
        </h3>

        <div class="btn-play ab-center size16 hov-pointer m-l-r-auto m-t-43 m-b-33" data-toggle="modal" data-target="#modal-video-01">
            <div class="flex-c-m sizefull bo-cir bgwhite color1 hov1 trans-0-4">
                <i class="fa fa-play fs-18 m-l-2" aria-hidden="true"></i>
            </div>
        </div>
    </div>
</section>


<!-- Delicious & Romantic-->
<section class="bg1-pattern p-t-120 p-b-105">
    <div class="container">
        <!-- Delicious -->
        <div class="row">
            <div class="col-md-6 p-t-45 p-b-30">
                <div class="wrap-text-delicious t-center">
						<span class="tit2 t-center">
							Delicious
						</span>

                    <h3 class="tit3 t-center m-b-35 m-t-5">
                        RECIPES
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
							Romantic
						</span>

                    <h3 class="tit3 t-center m-b-35 m-t-5">
                        Restaurant
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
				Meet Our
			</span>

        <h3 class="tit5 t-center m-b-50 m-t-5">
            Chef
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

                        <span class="dis-block t-center txt35 p-b-25">
								Chef
							</span>

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

                        <span class="dis-block t-center txt35 p-b-25">
								Chef
							</span>

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

                        <span class="dis-block t-center txt35 p-b-25">
								Chef
							</span>

                        <p class="t-center">
                            Phasellus aliquam libero a nisi varius, vitae placerat sem aliquet. Ut at velit nec ipsum iaculis posuere quis in sapien
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="part/footer.jsp"/>
</body>
</html>