<%@ taglib prefix="ctg" uri="time" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <fmt:setLocale value="${sessionScope.locale}" />
    <fmt:setBundle basename="locale" var="loc" />
    <fmt:message bundle="${loc}" key="footer.contactus" var="contactus"/>
    <fmt:message bundle="${loc}" key="footer.latesttwitter" var="latesttwitter"/>
    <fmt:message bundle="${loc}" key="footer.may" var="may"/>
    <fmt:message bundle="${loc}" key="footer.openingtimes" var="openingtimes"/>
    <fmt:message bundle="${loc}" key="footer.worktime" var="worktime"/>

</head>
<body>
<!-- Footer -->
<footer class="bg1">
    <div class="container p-t-20 p-b-40">
        <div class="row" >
            <div class="col-sm-6 col-md-4 p-t-50">
                <!-- - -->
                <h4 class="txt13 m-b-33">
                    ${contactus}
                </h4>

                <ul class="m-b-70">
                    <li class="txt14 m-b-14">
                        <i class="fa fa-map-marker fs-16 dis-inline-block size19" aria-hidden="true"></i>
                        3rd floor, 379 Alesha St, Hrodno, Hr 230300
                    </li>

                    <li class="txt14 m-b-14">
                        <i class="fa fa-phone fs-16 dis-inline-block size19" aria-hidden="true"></i>
                        +375-(29)-666-33-69
                    </li>

                    <li class="txt14 m-b-14">
                        <i class="fa fa-envelope fs-13 dis-inline-block size19" aria-hidden="true"></i>
                        karpeychyk@mail.ru
                    </li>
                </ul>

            </div>

            <div class="col-sm-6 col-md-4 p-t-50">
                <!-- - -->
                <h4 class="txt13 m-b-33">
                    ${latesttwitter}
                </h4>

                <div class="m-b-25">
						    <span class="fs-13 color2 m-r-5">
							    <i class="fa fa-twitter" aria-hidden="true"></i>
                            </span>
                    <a href="#" class="txt15">
                        @colorlib
                    </a>

                    <p class="txt14 m-b-18">
                        Activello is a good option. It has a slider built into that displays the featured image in the slider.
                        <a href="#" class="txt15">
                            https://buff.ly/2zaSfAQ
                        </a>
                    </p>

                    <span class="txt16">
							    5 ${may} 2021
					</span>
                </div>
            </div>

            <div class="col-sm-6 col-md-4 p-t-50">
                <!-- - -->
                <h4 class="txt13 m-b-33">
                    ${openingtimes}
                </h4>

                <ul>
                    <li class="txt14">
                        09:30 AM – 11:00 PM
                    </li>

                    <li class="txt14">
                        ${worktime}
                    </li>
                    <li class="txt14">
                        <ctg:info-time/>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <div class="end-footer bg2">
        <div class="container">
            <div class="flex-sb-m flex-w p-t-22 p-b-22">

                <div class="p-t-5 p-b-5">
                    <a href="https://www.tripadvisor.ru/" class="fs-25 c-white"><i class="fa fa-tripadvisor m-l-18 " aria-hidden="true"></i></a>
                    <a href="https://www.instagram.com/day_dreame1r/" class="fs-25 c-white"><i class="fa fa-facebook m-l-18 " aria-hidden="true"></i></a>
                    <a href="https://www.instagram.com/s.h.e.p.e.l.e.v.i.c.h/" class="fs-25 c-white"><i class="fa fa-twitter m-l-18 " aria-hidden="true"></i></a>
                    <a href="https://vk.com/nonchromist" class="fs-25 c-white"><i class="fa fa-linkedin m-l-18 " aria-hidden="true"></i></a>
                    <a href="https://vk.com/idday_dreame1r" class="fs-25 c-white"><i class="fa fa-google-plus m-l-18 " aria-hidden="true"></i></a>
                    <a href="https://www.instagram.com/s.h.e.p.e.l.e.v.i.c.h/" class="fs-25 c-white"><i class="fa fa-instagram m-l-18 " aria-hidden="true"></i></a>

                </div>

                <div class="btn-back-to-top bg0-hov" id="myBtn" style="display: flex;">
		<span class="symbol-btn-back-to-top">
			<i class="fa fa-angle-double-up" aria-hidden="true"></i>
		</span>
                </div>


                <div class="txt17 p-r-20 p-t-5 p-b-5">
                    Copyright &copy; 2021 All rights reserved  |  This app is made with <i class="fa fa-heart"></i> by <a href="https://vk.com/idday_dreame1r" target="_blank">Alex</a> & <a href="https://vk.com/nonchromist" target="_blank">Maks</a>
                </div>
            </div>
        </div>
    </div>


    <a href="#" id="back-to-top" title="Back to top" style="display: none;">&uarr;</a>

</footer>


<!--===============================================================================================-->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/vendor/bootstrap/js/popper.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/vendor/daterangepicker/moment.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/vendor/slick/slick.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/slick-custom.js"></script>
<!--===============================================================================================-->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/vendor/parallax100/parallax100.js"></script>
<script type="text/javascript">
    $('.parallax100').parallax100();
</script>
<!--===============================================================================================-->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/vendor/lightbox2/js/lightbox.min.js"></script>
<!--===============================================================================================-->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/vendor/isotope/isotope.pkgd.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/main.js"></script>

</body>
</html>
