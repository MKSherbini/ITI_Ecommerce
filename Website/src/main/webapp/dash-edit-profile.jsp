<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="commons/pageCommon.jsp" %>
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
    <title>${applicationScope.urlMappingConstants.getTitle(PageNames.EditProfile)}</title>
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

                                    <a href="editProfile">My Account</a></li>
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
                                <div class="dash__box dash__box--shadow dash__box--radius dash__box--bg-white">
                                    <div class="dash__pad-2">
                                        <h1 class="dash__h1 u-s-m-b-14">Edit Profile</h1>

                                        <span class="dash__text u-s-m-b-30">Looks like you haven't update your profile</span>
                                        <div class="dash__link dash__link--secondary u-s-m-b-30">

                                            <a data-modal="modal" data-modal-id="#dash-newsletter">Subscribe
                                                Newsletter</a></div>
                                        <div class="row">
                                            <div class="col-lg-12">
                                                <form class="dash-edit-p" action="editProfile" method="post">
                                                    <div class="gl-inline">
                                                        <div class="u-s-m-b-30">

                                                            <label class="gl-label" for="reg-fname">FIRST NAME *</label>

                                                            <input class="input-text input-text--primary-style"
                                                                   type="text" id="reg-fname" name="reg-fname" required
                                                                   value="${sessionScope.user.firstName}">
                                                        </div>
                                                        <div class="u-s-m-b-30">

                                                            <label class="gl-label" for="reg-lname">LAST NAME *</label>

                                                            <input class="input-text input-text--primary-style"
                                                                   type="text" id="reg-lname" name="reg-lname" required
                                                                   value="${sessionScope.user.lastName}"></div>
                                                    </div>
                                                    <div class="gl-inline">
                                                        <div class="u-s-m-b-30">

                                                            <!--====== Date of Birth Select-Box ======-->


                                                            <span class="gl-label">BIRTHDAY</span>
                                                            <div class="gl-dob">
                                                                <input class="select-box select-box--primary-style"
                                                                       type="date" name="birthDate"
                                                                       value="${sessionScope.user.birthdate}">
                                                                <!--====== End - Date of Birth Select-Box ======-->
                                                            </div>
                                                        </div>
                                                        <div class="u-s-m-b-30">

                                                            <label class="gl-label" for="gender">GENDER</label><select
                                                                class="select-box select-box--primary-style u-w-100"
                                                                id="gender" name="gender">
                                                            <option selected>Select</option>
                                                            <option value="male">Male</option>
                                                            <option value="male">Female</option>
                                                        </select></div>
                                                    </div>
                                                    <div class="gl-inline">
                                                        <div class="u-s-m-b-30">
                                                            <h2 class="dash__h2 u-s-m-b-8">E-mail *</h2>
                                                            <div class="dash__link dash__link--secondary">
                                                                <input class="input-text input-text--primary-style"
                                                                       type="email" id="email" name="email" required
                                                                       value="${sessionScope.user.email}">
                                                                <%--<a href="#">Change</a>--%>
                                                                <label style='color: red' ; id="error-email"></label>
                                                            </div>
                                                        </div>
                                                        <%--<div class="u-s-m-b-30">
                                                            <h2 class="dash__h2 u-s-m-b-8">Phone</h2>

                                                            <div class="dash__link dash__link--secondary">
                                                                <input class="input-text input-text--primary-style" id="mobile" name="mobile">
                                                                &lt;%&ndash;<a href="#">Add</a>&ndash;%&gt;
                                                            </div>
                                                        </div>--%>
                                                    </div>

                                                    <button class="btn btn--e-brand-b-2">SAVE</button>
                                                </form>
                                            </div>
                                        </div>
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

                            <a class="d_modal__link" href="editProfile">Ludus Privacy Policy</a>
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
<script src="scripts/js/signup.jsp.js"></script>

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