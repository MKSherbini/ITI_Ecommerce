<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="jakarta.servlet.RequestDispatcher" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="commons/pageCommon.jsp" %>
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
    <title>${applicationScope.urlMappingConstants.getTitle(PageNames.CONTACT_US)}</title>
    <%@include file="commons/headCommon.jsp" %>
    <script src="scripts/js/validation_contact_form.js" type="text/javascript"></script>
</head>
<body class="config">
<div class="preloader is-active">
    <div class="preloader__wrap">

        <img class="preloader__img" src="images/preloader.png" alt=""></div>
</div>

<!--====== Main App ======-->
<div id="app">

    <!--====== Main Header ======-->
    <header class="header--style-1 header--box-shadow">
        <%@include file="commons/headerCommon.jsp" %>
    </header>
    <!--====== End - Main Header ======-->


    <!--====== App Content ======-->
    <div class="app-content">

        <!--====== Section 1 ======-->
        <div class="u-s-p-y-60">

            <!--====== Section Content ======-->
            <div class="section__content">
                <div class="container">
                    <div class="breadcrumb">
                        <div class="breadcrumb__wrap">
                            <ul class="breadcrumb__list">
                                <li class="has-separator">

                                    <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.HOME_PAGE)}">Home</a>
                                </li>
                                <li class="is-marked">

                                    <a href="contact.jsp">Contact</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--====== End - Section 1 ======-->


        <!--====== Section 2 ======-->
        <div class="u-s-p-b-60">

            <!--====== Section Content ======-->
            <div class="section__content">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="g-map">
                                <div id="map"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--====== End - Section Content ======-->
        </div>
        <!--====== End - Section 2 ======-->


        <!--====== Section 3 ======-->
        <div class="u-s-p-b-60">

            <!--====== Section Content ======-->
            <div class="section__content">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-4 col-md-6 u-s-m-b-30">
                            <div class="contact-o u-h-100">
                                <div class="contact-o__wrap">
                                    <div class="contact-o__icon"><i class="fas fa-phone-volume"></i></div>

                                    <span class="contact-o__info-text-1">LET'S HAVE A CALL</span>

                                    <span class="contact-o__info-text-2">(+20) 102 312 2579</span>
                                    <span class="contact-o__info-text-2">(+20) 112 312 2579</span>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6 u-s-m-b-30">
                            <div class="contact-o u-h-100">
                                <div class="contact-o__wrap">
                                    <div class="contact-o__icon"><i class="fas fa-map-marker-alt"></i></div>

                                    <span class="contact-o__info-text-1">OUR LOCATION</span>

                                    <span class="contact-o__info-text-2">28km Smart Village </span>

                                    <span class="contact-o__info-text-2">Giza Egypt</span>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6 u-s-m-b-30">
                            <div class="contact-o u-h-100">
                                <div class="contact-o__wrap">
                                    <div class="contact-o__icon"><i class="far fa-clock"></i></div>

                                    <span class="contact-o__info-text-1">WORK TIME</span>

                                    <span class="contact-o__info-text-2">5 Days a Week</span>

                                    <span class="contact-o__info-text-2">From 9 AM to 7 PM</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--====== End - Section Content ======-->
        </div>
        <!--====== End - Section 3 ======-->


        <!--====== Section 4 ======-->
        <div class="u-s-p-b-60">

            <!--====== Section Content ======-->
            <div class="section__content">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="contact-area u-h-100">
                                <div class="contact-area__heading">
                                    <h2>Get In Touch</h2>
                                </div>
                                <form class="contact-f" id="con_form" name="contact_form">
                                    <div class="row">
                                        <div class="col-lg-6 col-md-6 u-h-100">
                                            <div class="u-s-m-b-30">

                                                <label for="c-name"></label>

                                                <input class="input-text input-text--border-radius input-text--primary-style"
                                                       type="text" name="customerName" id="c-name"
                                                       placeholder="Name (Required)" required></div>
                                            <div class="u-s-m-b-30">

                                                <label for="c-email"></label>

                                                <input class="input-text input-text--border-radius input-text--primary-style"
                                                       type="text" id="c-email" name="email"
                                                       placeholder="Email (Required)" required></div>
                                            <div class="u-s-m-b-30">

                                                <label for="c-subject"></label>

                                                <input class="input-text input-text--border-radius input-text--primary-style"
                                                       type="text" id="c-subject" name="subject"
                                                       placeholder="Subject (Required)" required></div>
                                        </div>
                                        <div class="col-lg-6 col-md-6 u-h-100">
                                            <div class="u-s-m-b-30">

                                                <label for="c-message"></label><textarea
                                                    class="text-area text-area--border-radius text-area--primary-style"
                                                    id="c-message" name="message"
                                                    placeholder="Compose a Message (Required)" required></textarea>
                                            </div>
                                        </div>
                                        <div class="col-lg-12">

                                            <button class="btn btn--e-brand-b-2" type="submit">Send Message</button>
                                            <span class="mini-product__quantity" id="result"></span>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--====== End - Section Content ======-->
        </div>
        <!--====== End - Section 4 ======-->
    </div>
    <!--====== End - App Content ======-->


    <!--====== Main Footer ======-->
    <jsp:include page="commons/footerCommon.jsp" flush="true"/>
    <!--====== Main Footer ======-->
</div>
<!--====== End - Main App ======-->


<!--====== Google Analytics: change UA-XXXXX-Y to be your site's ID ======-->
<script>
    window.ga = function () {
        ga.q.push(arguments)
    };
    ga.q = [];
    ga.l = +new Date;
    ga('create', 'UA-XXXXX-Y', 'auto');
    ga('send', 'pageview')
</script>
<script src="https://www.google-analytics.com/analytics.js" async defer></script>

<!--====== Vendor Js ======-->
<script src="scripts/js/vendor.js"></script>

<!--====== Google Map ======-->
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB-MO9uPLS-ApTqYs0FpYdVG8cFwdq6apw"></script>

<!--====== Google Map Init ======-->
<script src="scripts/js/map-init.js"></script>

<!--====== jQuery Shopnav plugin ======-->
<script src="scripts/js/jquery.shopnav.js"></script>

<!--====== App ======-->
<script src="scripts/js/app.js"></script>

<!--====== Noscript ======-->
<noscript>
    <div class="app-setting">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="app-setting__wrap">
                        <h1 class="app-setting__h1">JavaScript is disabled in your browser.</h1>

                        <span class="app-setting__text">Please enable JavaScript in your browser or upgrade to a JavaScript-capable browser.</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</noscript>
</body>
</html>