<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="commons/pageCommon.jsp" %>
<script src="scripts/js/user_dash.js" type="text/javascript"></script>
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
    <title>${applicationScope.urlMappingConstants.getTitle(PageNames.USER_DASH_PAGE)}</title>
    <%@include file="commons/headCommon.jsp" %>

<%--    <script>document.write('<script src="scripts/js/shop.js?dev=' + new Date().getTime() + '"\><\/script>');</script>--%>
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
        <div class="u-s-p-y-90">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 col-md-12 u-s-m-b-30">
                        <div class="empty">
                            <div class="empty__wrap">
                                <span class="empty__big-text">Users Data </span>
                                <span class="empty__text-2 review-o__text">this dash board displays all user data </span>
                                <form class="blog-search-form"  id="searchUsers">

                                    <label for="user-search"></label>

                                    <input class="input-text input-text--border-radius input-text--style-1"

                                           onkeyup="myFunction()" value="<c:if test="${!param.search}">${search}</c:if>"

                                           type="text" id="user-search" name="search" placeholder="Search">
                                    <button class="btn btn--icon fas fa-search main-search-button" type="submit"></button>
                                </form>
                                <span class="empty__text-2  review-o__text">you can search with first name , last name or user name . </span>

                            </div>
                        </div>

                    </div>

                    <div class="gl-scroll col-lg-12 col-md-9 u-s-m-b-30">
                        <table class="dash__table" id="users_table" style="border-radius: 5px;">
                            <thead style="background-color: orangered; border-radius: 5px ;">
                                <th style="color: white;"><b>id</b></th>
                                <th style="color: white"><b>First Name</b></th>
                                <th style="color: white"><b>Last Name</b></th>
                                <th style="color: white"><b>User Name</b></th>
                                <th style="color: white"><b>Email</b></th>
                                <th style="color: white"><b>Birth Date</b></th>
                                <th style="color: white"><b>Country</b></th>

                            <thead>

                            <tbody>

                                <c:if test="${!empty requestScope.users}">
                                    <c:forEach items="${requestScope.users}" var="user">
                                        <%@include file="custom/user.jsp" %>
                                    </c:forEach>
                                </c:if>

                            </tbody>
                        </table>
                    </div>


                </div>
            </div>
        </div>
        <!--====== End - Section 1 ======-->
    </div>
    <!--====== End - App Content ======-->


    <!--====== Main Footer ======-->
    <jsp:include page="commons/footerCommon.jsp" flush="true"/>
    <!--====== Modal Section ======-->


<%--    <!--====== Quick Look Modal ======-->--%>
<%--    <div class="modal fade" id="quick-look">--%>
<%--        <div class="modal-dialog modal-dialog-centered">--%>
<%--            <div class="modal-content modal--shadow">--%>

<%--                <button class="btn dismiss-button fas fa-times" type="button" data-dismiss="modal"></button>--%>
<%--                <div class="modal-body">--%>
<%--                    <div class="row">--%>
<%--                        <div class="col-lg-5">--%>

<%--                            <!--====== Product Breadcrumb ======-->--%>
<%--                            <div class="pd-breadcrumb u-s-m-b-30">--%>
<%--                                <ul class="pd-breadcrumb__list">--%>
<%--                                    <li class="has-separator">--%>

<%--                                        <a href="index.hml">Home</a></li>--%>
<%--                                    <li class="has-separator">--%>

<%--                                        <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.SHOP)}">Electronics</a>--%>
<%--                                    </li>--%>
<%--                                    <li class="has-separator">--%>

<%--                                        <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.SHOP)}">DSLR--%>
<%--                                            Cameras</a></li>--%>
<%--                                    <li class="is-marked">--%>

<%--                                        <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.SHOP)}">Nikon--%>
<%--                                            Cameras</a></li>--%>
<%--                                </ul>--%>
<%--                            </div>--%>
<%--                            <!--====== End - Product Breadcrumb ======-->--%>


<%--                            <!--====== Product Detail ======-->--%>
<%--                            <div class="pd u-s-m-b-30">--%>
<%--                                <div class="pd-wrap">--%>
<%--                                    <div id="js-product-detail-modal">--%>
<%--                                        <div>--%>

<%--                                            <img class="u-img-fluid" src="images/product/product-d-1.jpg" alt=""></div>--%>
<%--                                        <div>--%>

<%--                                            <img class="u-img-fluid" src="images/product/product-d-2.jpg" alt=""></div>--%>
<%--                                        <div>--%>

<%--                                            <img class="u-img-fluid" src="images/product/product-d-3.jpg" alt=""></div>--%>
<%--                                        <div>--%>

<%--                                            <img class="u-img-fluid" src="images/product/product-d-4.jpg" alt=""></div>--%>
<%--                                        <div>--%>

<%--                                            <img class="u-img-fluid" src="images/product/product-d-5.jpg" alt=""></div>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                                <div class="u-s-m-t-15">--%>
<%--                                    <div id="js-product-detail-modal-thumbnail">--%>
<%--                                        <div>--%>

<%--                                            <img class="u-img-fluid" src="images/product/product-d-1.jpg" alt=""></div>--%>
<%--                                        <div>--%>

<%--                                            <img class="u-img-fluid" src="images/product/product-d-2.jpg" alt=""></div>--%>
<%--                                        <div>--%>

<%--                                            <img class="u-img-fluid" src="images/product/product-d-3.jpg" alt=""></div>--%>
<%--                                        <div>--%>

<%--                                            <img class="u-img-fluid" src="images/product/product-d-4.jpg" alt=""></div>--%>
<%--                                        <div>--%>

<%--                                            <img class="u-img-fluid" src="images/product/product-d-5.jpg" alt=""></div>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <!--====== End - Product Detail ======-->--%>
<%--                        </div>--%>
<%--                        <div class="col-lg-7">--%>

<%--                            <!--====== Product Right Side Details ======-->--%>
<%--                            <div class="pd-detail">--%>
<%--                                <div>--%>

<%--                                    <span class="pd-detail__name">Nikon Camera 4k Lens Zoom Pro</span></div>--%>
<%--                                <div>--%>
<%--                                    <div class="pd-detail__inline">--%>

<%--                                        <span class="pd-detail__price">$6.99</span>--%>

<%--                                        <span class="pd-detail__discount">(76% OFF)</span>--%>
<%--                                        <del class="pd-detail__del">$28.97</del>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                                <div class="u-s-m-b-15">--%>
<%--                                    <div class="pd-detail__rating gl-rating-style"><i class="fas fa-star"></i><i--%>
<%--                                            class="fas fa-star"></i><i class="fas fa-star"></i><i--%>
<%--                                            class="fas fa-star"></i><i class="fas fa-star-half-alt"></i>--%>

<%--                                        <span class="pd-detail__review u-s-m-l-4">--%>

<%--                                                <a href="product-detail.jsp">23 Reviews</a></span></div>--%>
<%--                                </div>--%>
<%--                                <div class="u-s-m-b-15">--%>
<%--                                    <div class="pd-detail__inline">--%>

<%--                                        <span class="pd-detail__stock">200 in stock</span>--%>

<%--                                        <span class="pd-detail__left">Only 2 left</span></div>--%>
<%--                                </div>--%>
<%--                                <div class="u-s-m-b-15">--%>

<%--                                    <span class="pd-detail__preview-desc">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</span>--%>
<%--                                </div>--%>
<%--                                <div class="u-s-m-b-15">--%>
<%--                                    <div class="pd-detail__inline">--%>

<%--                                            <span class="pd-detail__click-wrap"><i class="far fa-heart u-s-m-r-6"></i>--%>

<%--                                                <a href="signin.jsp">Add to Wishlist</a>--%>

<%--                                                <span class="pd-detail__click-count">(222)</span></span></div>--%>
<%--                                </div>--%>
<%--                                <div class="u-s-m-b-15">--%>
<%--                                    <div class="pd-detail__inline">--%>

<%--                                            <span class="pd-detail__click-wrap"><i--%>
<%--                                                    class="far fa-envelope u-s-m-r-6"></i>--%>

<%--                                                <a href="signin.jsp">Email me When the price drops</a>--%>

<%--                                                <span class="pd-detail__click-count">(20)</span></span></div>--%>
<%--                                </div>--%>
<%--                                <div class="u-s-m-b-15">--%>
<%--                                    <ul class="pd-social-list">--%>
<%--                                        <li>--%>

<%--                                            <a class="s-fb--color-hover" href="#"><i class="fab fa-facebook-f"></i></a>--%>
<%--                                        </li>--%>
<%--                                        <li>--%>

<%--                                            <a class="s-tw--color-hover" href="#"><i class="fab fa-twitter"></i></a>--%>
<%--                                        </li>--%>
<%--                                        <li>--%>

<%--                                            <a class="s-insta--color-hover" href="#"><i--%>
<%--                                                    class="fab fa-instagram"></i></a></li>--%>
<%--                                        <li>--%>

<%--                                            <a class="s-wa--color-hover" href="#"><i class="fab fa-whatsapp"></i></a>--%>
<%--                                        </li>--%>
<%--                                        <li>--%>

<%--                                            <a class="s-gplus--color-hover" href="#"><i--%>
<%--                                                    class="fab fa-google-plus-g"></i></a></li>--%>
<%--                                    </ul>--%>
<%--                                </div>--%>
<%--                                <div class="u-s-m-b-15">--%>
<%--                                    <form class="pd-detail__form">--%>
<%--                                        <div class="pd-detail-inline-2">--%>
<%--                                            <div class="u-s-m-b-15">--%>

<%--                                                <!--====== Input Counter ======-->--%>
<%--                                                <div class="input-counter">--%>

<%--                                                    <span class="input-counter__minus fas fa-minus"></span>--%>

<%--                                                    <input class="input-counter__text input-counter--text-primary-style"--%>
<%--                                                           type="text" value="1" data-min="1" data-max="1000">--%>

<%--                                                    <span class="input-counter__plus fas fa-plus"></span></div>--%>
<%--                                                <!--====== End - Input Counter ======-->--%>
<%--                                            </div>--%>
<%--                                            <div class="u-s-m-b-15">--%>

<%--                                                <button class="btn btn--e-brand-b-2" type="submit">Add to Cart</button>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                    </form>--%>
<%--                                </div>--%>
<%--                                <div class="u-s-m-b-15">--%>

<%--                                    <span class="pd-detail__label u-s-m-b-8">Product Policy:</span>--%>
<%--                                    <ul class="pd-detail__policy-list">--%>
<%--                                        <li><i class="fas fa-check-circle u-s-m-r-8"></i>--%>

<%--                                            <span>Buyer Protection.</span></li>--%>
<%--                                        <li><i class="fas fa-check-circle u-s-m-r-8"></i>--%>

<%--                                            <span>Full Refund if you don't receive your order.</span></li>--%>
<%--                                        <li><i class="fas fa-check-circle u-s-m-r-8"></i>--%>

<%--                                            <span>Returns accepted if product not as described.</span></li>--%>
<%--                                    </ul>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <!--====== End - Product Right Side Details ======-->--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <!--====== End - Quick Look Modal ======-->--%>


    <!--====== Add to Cart Modal ======-->
    <div class="modal fade" id="add-to-cart">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content modal-radius modal-shadow">

                <button class="btn dismiss-button fas fa-times" type="button" data-dismiss="modal"></button>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-lg-6 col-md-12">
                            <div class="success u-s-m-b-30">
                                <div class="success__text-wrap"><i class="fas fa-check" id="modal-add-icon"></i>

                                    <span id="modal-add-msg">Item is added successfully!</span></div>
                                <div class="success__img-wrap">

                                    <img id="modal-add-img" class="u-img-fluid"
                                         src="images/product/electronic/product1.jpg" alt=""></div>
                                <div class="success__info-wrap">

                                    <span id="modal-add-name" class="success__name">Beats Bomb Wireless Headphone</span>

                                    <span class="success__quantity">Quantity: 1</span>

                                    <span id="modal-add-price" class="success__price">$170.00</span></div>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-12">
                            <div class="s-option">

                                <span id="modal-add-itemsCount" class="s-option__text">1 item (s) in your cart</span>
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

<%--<script>--%>
<%--    function addToCart(productId) {--%>
<%--        $.get("${applicationScope.urlMappingConstants.getServiceUrl(ServiceNames.PRODUCT_ADD_TO_CART)}?${WebsiteConstants.paramProductId}=" + productId, function (product, status) {--%>
<%--            // console.log("Data: " + data + "\nStatus: " + status);--%>
<%--            // console.log(data.name)--%>
<%--            // if (data.length <= 5) return;--%>
<%--            // let product = JSON.parse(data);--%>
<%--            // console.log(product);--%>
<%--            // if (status === 'success')--%>
<%--            // fkingSetModal(product);--%>
<%--            // setTimeout(fkingSetModal, 500, product);--%>
<%--        });--%>
<%--    }--%>
<%--</script>--%>
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