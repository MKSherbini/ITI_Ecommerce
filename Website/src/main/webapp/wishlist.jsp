<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="commons/pageCommon.jsp" %>

<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
    <title>${applicationScope.urlMappingConstants.getTitle(PageNames.WISHLIST)}</title>
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

                                    <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.WISHLIST)}">Wishlist</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--====== End - Section 1 ======-->


        <!--====== Section 2 ======-->
        <div class="u-s-p-b-60">

            <!--====== Section Intro ======-->
            <div class="section__intro u-s-m-b-60">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="section__text-wrap">
                                <h1 class="section__heading u-c-secondary">Wishlist</h1>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--====== End - Section Intro ======-->


            <!--====== Section Content ======-->
            <div class="section__content">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12">
                            <c:forEach items="${requestScope.wishlist}" var="item">

                                <!--====== Wishlist Product ======-->
                                <div class="w-r u-s-m-b-30">
                                    <div class="w-r__container">
                                        <div class="w-r__wrap-1">
                                            <div class="w-r__img-wrap">

                                                <img class="u-img-fluid" src="${item.imageSrc}"
                                                     alt="${item.name}"></div>
                                            <div class="w-r__info">

                                                <span class="w-r__name">

                                                    <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.PRODUCT)}?ref=${item.productId}">${item.name}</a></span>

                                                <span class="w-r__category">

                                                    <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.SHOP)}?category=${item.category.name}">${item.category.name}</a></span>

                                                <span class="w-r__price">$${WebsiteConstants.defaultDecimalFormat.format(item.price * (1-(item.discountPercent/ 100.0)))}
                                                <c:if test="${item.discountPercent>0}">
                                                    <span class="w-r__discount">$${WebsiteConstants.defaultDecimalFormat.format(item.price)}</span></span>
                                                </c:if>
                                            </div>
                                        </div>
                                        <div class="w-r__wrap-2">

                                            <a class="w-r__link btn--e-brand-b-2" data-modal="modal"
                                               data-modal-id="#add-to-cart"
                                               onclick="incrementFromCart(${item.productId});">ADD TO CART</a>

                                            <a class="w-r__link btn--e-transparent-platinum-b-2"
                                               href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.PRODUCT)}?ref=${item.productId}">VIEW</a>

                                            <a class="w-r__link btn--e-transparent-platinum-b-2"
                                               onclick="removeWishlistItem(${item.productId});">REMOVE</a>
                                        </div>
                                    </div>
                                </div>
                                <!--====== End - Wishlist Product ======-->

                            </c:forEach>


                        </div>
                        <div class="col-lg-12">
                            <div class="route-box">
                                <div class="route-box__g">

                                    <a class="route-box__link"
                                       href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.SHOP)}"><i
                                            class="fas fa-long-arrow-alt-left"></i>

                                        <span>CONTINUE SHOPPING</span></a></div>
                                <div class="route-box__g">

                                    <a class="route-box__link"
                                       href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.WISHLIST)}"><i
                                            class="fas fa-trash"></i>

                                        <span>CLEAR WISHLIST</span></a></div>
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


    <!--====== Footer ======-->
    <jsp:include page="commons/footerCommon.jsp"/>
    <!--====== End - Footer ======-->

    <!--====== Modal Section ======-->


    <!--====== Add to Cart Modal ======-->
    <div class="modal fade" id="add-to-cart">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content modal-radius modal-shadow">

                <button class="btn dismiss-button fas fa-times" type="button" data-dismiss="modal"></button>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-lg-6 col-md-12">
                            <div class="success u-s-m-b-30">
                                <div class="success__text-wrap"><i class="fas fa-check"></i>

                                    <span>Item is added successfully!</span></div>
                                <div class="success__img-wrap">

                                    <img class="u-img-fluid" src="images/product/electronic/product1.jpg" alt=""></div>
                                <div class="success__info-wrap">

                                    <span class="success__name">Beats Bomb Wireless Headphone</span>

                                    <span class="success__quantity">Quantity: 1</span>

                                    <span class="success__price">$170.00</span></div>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-12">
                            <div class="s-option">

                                <span class="s-option__text">1 item (s) in your cart</span>
                                <div class="s-option__link-box">

                                    <a class="s-option__link btn--e-white-brand-shadow" data-dismiss="modal">CONTINUE
                                        SHOPPING</a>

                                    <a class="s-option__link btn--e-white-brand-shadow"
                                       href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.CART)}">VIEW
                                        CART</a>

                                    <a class="s-option__link btn--e-brand-shadow"
                                       href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.CHECKOUT)}">PROCEED
                                        TO CHECKOUT</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--====== End - Add to Cart Modal ======-->
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

<script>
    function removeWishlistItem(id) {
        $.ajax({
            method: "POST",
            url: "${applicationScope.urlMappingConstants.getControllerUrl(PageNames.WISHLIST)}",
            data: {ref: id}
        }).done(function (msg) {
            console.log("deleted")
            window.location.reload(true);
        });
    }
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