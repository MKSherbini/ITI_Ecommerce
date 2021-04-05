<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="commons/pageCommon.jsp" %>

<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
    <title>${applicationScope.urlMappingConstants.getTitle(PageNames.SHOP)}</title>
    <%@include file="commons/headCommon.jsp" %>
    <script>document.write('<script src="scripts/js/shop.js?dev=' + new Date().getTime() + '"\><\/script>');</script>
    <%--    <script  src="scripts/js/shop.js?time="></script>--%>
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

                                    <a href="dash-address-add.jsp">My Account</a></li>
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

                                        <span class="dash__text u-s-m-b-16">Hello, John Doe</span>
                                        <ul class="dash__f-list">
                                            <li>

                                                <a href="dashboard.jsp">Manage My Account</a></li>
                                            <li>

                                                <a href="dash-my-profile.jsp">My Profile</a></li>
                                            <li>

                                                <a href="dash-address-book.jsp">Address Book</a>
                                            <li>

                                                <a class="dash-active"
                                                   href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.CARD_BOOK)}">Card
                                                    Book</a>
                                            </li>
                                            <li>

                                                <a href="dash-track-order.jsp">Track Order</a></li>
                                            <li>

                                                <a href="dash-my-order.jsp">My Orders</a></li>
                                            <li>

                                                <a href="dash-payment-option.jsp">My Payment Options</a></li>
                                            <li>

                                                <a href="dash-cancellation.jsp">My Returns & Cancellations</a></li>
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
                                <div class="dash__box dash__box--shadow dash__box--radius dash__box--bg-white">
                                    <div class="dash__pad-2">
                                        <h1 class="dash__h1 u-s-m-b-14">Add new Card</h1>

                                        <span class="dash__text u-s-m-b-30">We need a card to charge.</span>
                                        <form class="dash-address-manipulation" method="post">
                                            <div class="gl-inline">
                                                <div class="u-s-m-b-30">

                                                    <label class="gl-label" for="card-number">Card Number *</label>

                                                    <input class="input-text input-text--primary-style" type="tel"
                                                           id="card-number" placeholder="Card Number" name="number"
                                                           required></div>
                                            </div>
                                            <div class="gl-inline">
                                                <div class="u-s-m-b-30">

                                                    <label class="gl-label" for="card-cvv">CVV *</label>

                                                    <input class="input-text input-text--primary-style" type="tel"
                                                           id="card-cvv" placeholder="Card CVV" name="cvv" required>
                                                </div>
                                                <div class="u-s-m-b-30">

                                                    <label class="gl-label" for="card-date">Expire date *</label>

                                                    <input class="input-text input-text--primary-style" type="date"
                                                           id="card-date" placeholder="Expire Date" name="date"
                                                           required>
                                                </div>
                                            </div>
                                            <button class="btn btn--e-brand-b-2" type="submit">SAVE</button>
                                        </form>
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

<!--====== jQuery Shopnav plugin ======-->
<script src="scripts/js/jquery.shopnav.js"></script>

<!--====== App ======-->
<script src="scripts/js/app.js"></script>
<script>
    $(".checkThis").attr("checked", true);
</script>
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