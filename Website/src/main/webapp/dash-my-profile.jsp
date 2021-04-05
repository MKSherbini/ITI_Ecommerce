<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="commons/pageCommon.jsp" %>
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
    <title>${applicationScope.urlMappingConstants.getTitle(PageNames.Profile)}</title>
    <%@include file="commons/headCommon.jsp" %>
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

                                    <a href="profile">My Account</a></li>
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
                <div class="dash">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-3 col-md-12">

                                <!--====== Dashboard Features ======-->
                                <div class="dash__box dash__box--bg-white dash__box--shadow u-s-m-b-30">
                                    <div class="dash__pad-1">

                                        <span class="dash__text u-s-m-b-16">Hello, ${sessionScope.user.userName}</span>
                                        <ul class="dash__f-list">
                                            <li>

                                                <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.Account)}">Manage
                                                    My Account</a></li>
                                            <li>

                                                <a class="dash-active"
                                                   href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.Profile)}">My
                                                    Profile</a></li>
                                            <li>

                                                <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.ADDRESS_BOOK)}">Address
                                                    Book</a>
                                            <li>

                                                <a
                                                        href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.CARD_BOOK)}">Card
                                                    Book</a>
                                            </li>
                                            <li>

                                                <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.TRACK_ORDER)}">Track
                                                    Order</a></li>
                                            <li>

                                                <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.MY_ORDERS)}">My
                                                    Orders</a></li>
                                            <li>

                                                <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.CANCELLATIONS)}">My
                                                    Returns & Cancellations</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="dash__box dash__box--bg-white dash__box--shadow dash__box--w">
                                    <div class="dash__pad-1">
                                        <ul class="dash__w-list">
                                            <li>
                                                <div class="dash__w-wrap">

                                                    <span class="dash__w-icon dash__w-icon-style-1"><i
                                                            class="fas fa-cart-arrow-down"></i></span>

                                                    <span class="dash__w-text">${requestScope.ordersCount}</span>

                                                    <span class="dash__w-name">Orders Placed</span></div>
                                            </li>
                                            <li>
                                                <div class="dash__w-wrap">

                                                    <span class="dash__w-icon dash__w-icon-style-2"><i
                                                            class="fas fa-times"></i></span>

                                                    <span class="dash__w-text">0</span>

                                                    <span class="dash__w-name">Cancel Orders</span></div>
                                            </li>
                                            <li>
                                                <div class="dash__w-wrap">

                                                    <span class="dash__w-icon dash__w-icon-style-3"><i
                                                            class="far fa-heart"></i></span>

                                                    <span class="dash__w-text">0</span>

                                                    <span class="dash__w-name">Wishlist</span></div>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                                <!--====== End - Dashboard Features ======-->
                            </div>
                            <div class="col-lg-9 col-md-12">
                                <div class="dash__box dash__box--shadow dash__box--radius dash__box--bg-white u-s-m-b-30">
                                    <div class="dash__pad-2">
                                        <c:if test="${empty sessionScope.user}">
                                            <h1 class="dash__h1 u-s-m-b-14">My Profile</h1>
                                            <span class="dash__text u-s-m-b-30">Look all your info, you could customize your profile.</span>
                                            <div class="row">
                                                <div class="col-lg-4 u-s-m-b-30">
                                                    <h2 class="dash__h2 u-s-m-b-8">Full Name</h2>

                                                    <span class="dash__text">User Name</span>
                                                </div>
                                                <div class="col-lg-4 u-s-m-b-30">
                                                    <h2 class="dash__h2 u-s-m-b-8">E-mail</h2>

                                                    <span class="dash__text">example@example.com</span>

                                                </div>
                                                <div class="col-lg-4 u-s-m-b-30">
                                                    <h2 class="dash__h2 u-s-m-b-8">Phone</h2>

                                                    <span class="dash__text">+2-011-11111111</span>

                                                </div>
                                                <div class="col-lg-4 u-s-m-b-30">
                                                    <h2 class="dash__h2 u-s-m-b-8">Birthday</h2>

                                                    <span class="dash__text">YYYY-MM-DD</span>
                                                </div>
                                                <div class="col-lg-4 u-s-m-b-30">
                                                    <h2 class="dash__h2 u-s-m-b-8">Gender</h2>

                                                    <span class="dash__text">F/M</span>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-lg-12">

                                                    <div class="u-s-m-b-16">

                                                        <a class="dash__custom-link btn--e-transparent-brand-b-2"
                                                           href="signin">Sign In</a></div>
                                                    <div>

                                                        <a class="dash__custom-link btn--e-brand-b-2" href="signup">Register</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:if>

                                        <c:if test="${!empty sessionScope.user}">
                                            <h1 class="dash__h1 u-s-m-b-14">My Profile</h1>
                                            <span class="dash__text u-s-m-b-30">Look all your info, Press Edit Profile for any changes.</span>
                                            <div class="row">
                                                <div class="col-lg-4 u-s-m-b-30">
                                                    <h2 class="dash__h2 u-s-m-b-8">Full Name</h2>

                                                    <span class="dash__text">${sessionScope.user.userName}</span>
                                                </div>
                                                <div class="col-lg-4 u-s-m-b-30">
                                                    <h2 class="dash__h2 u-s-m-b-8">E-mail</h2>

                                                    <span class="dash__text">${sessionScope.user.email}</span>

                                                </div>
                                                    <%--<div class="col-lg-4 u-s-m-b-30">
                                                        <h2 class="dash__h2 u-s-m-b-8">Phone</h2>

                                                        <span class="dash__text">+2-011-11111111</span>

                                                    </div>--%>
                                                <div class="col-lg-4 u-s-m-b-30">
                                                    <h2 class="dash__h2 u-s-m-b-8">Birthday</h2>

                                                    <span class="dash__text">${sessionScope.user.birthdate}</span>
                                                </div>
                                                <div class="col-lg-4 u-s-m-b-30">
                                                    <h2 class="dash__h2 u-s-m-b-8">Gender</h2>

                                                    <span class="dash__text">F/M</span>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-lg-12">

                                                    <div class="u-s-m-b-16">

                                                        <a class="dash__custom-link btn--e-transparent-brand-b-2"
                                                           href="editProfile">Edit Profile</a></div>
                                                </div>
                                            </div>
                                        </c:if>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--====== End - Section Content ======-->
        </div>
        <!--====== End - Section 2 ======-->
    </div>
    <!--====== End - App Content ======-->


    <!--====== Main Footer ======-->
    <jsp:include page="commons/footer.jsp" flush="true"/>
    <!--====== Main Footer ======-->

    <!--====== Modal Section ======-->


    <!--====== Unsubscribe or Subscribe Newsletter ======-->
    <div class="modal fade" id="dash-newsletter">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content modal--shadow">
                <div class="modal-body">
                    <form class="d-modal__form">
                        <div class="u-s-m-b-15">
                            <h1 class="gl-modal-h1">Newsletter Subscription</h1>

                            <span class="gl-modal-text">I have read and understood</span>

                            <a class="d_modal__link" href="profile">Ludus Privacy Policy</a>
                        </div>
                        <div class="gl-modal-btn-group">

                            <button class="btn btn--e-brand-b-2" type="submit">SUBSCRIBE</button>

                            <button class="btn btn--e-grey-b-2" type="button" data-dismiss="modal">CANCEL</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!--====== Unsubscribe or Subscribe Newsletter ======-->
    <!--====== End - Modal Section ======-->
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