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
        <div class="u-s-p-y-90">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3 col-md-12">
                        <div class="shop-w-master">
                            <h1 class="shop-w-master__heading u-s-m-b-30"><i class="fas fa-filter u-s-m-r-8"></i>

                                <span>FILTERS</span></h1>
                            <div class="shop-w-master__sidebar sidebar--bg-snow">
                                <div class="u-s-m-b-30">
                                    <div class="shop-w">
                                        <div class="shop-w__intro-wrap">
                                            <h1 class="shop-w__h">CATEGORY</h1>

                                            <span class="fas fa-minus shop-w__toggle" data-target="#s-category"
                                                  data-toggle="collapse"></span>
                                        </div>
                                        <div class="shop-w__wrap collapse show" id="s-category">
                                            <ul class="shop-w__category-list gl-scroll">
                                                <c:forEach items="${requestScope.categoryList}" var="category">
                                                    <!--====== Check Box List Item ======-->
                                                    <li onclick="fkingRunMyHref(this)">
                                                        <a href="" data-href="category=${category.name}"
                                                           onmouseover="setDynamicHref(this)">
                                                            <div class="check-box">
                                                                <input type="checkbox" id="${category.name}"
                                                                <c:if test="${category.selected}">
                                                                       checked</c:if>>
                                                                <div class="check-box__state check-box__state--primary">
                                                                    <label class="check-box__label"
                                                                           for="${category.name}">${category.name}
                                                                    </label>
                                                                </div>
                                                            </div>
                                                            <span class="category-list__text u-s-m-l-6">(${category.numberOfProducts})</span>
                                                        </a>
                                                    </li>
                                                </c:forEach>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="u-s-m-b-30">
                                    <div class="shop-w">
                                        <div class="shop-w__intro-wrap">
                                            <h1 class="shop-w__h">RATING</h1>

                                            <span class="fas fa-minus shop-w__toggle" data-target="#s-rating"
                                                  data-toggle="collapse"></span>
                                        </div>
                                        <div class="shop-w__wrap collapse show" id="s-rating">
                                            <ul class="shop-w__list gl-scroll">
                                                <li>
                                                    <div class="rating__check">

                                                        <input type="checkbox">
                                                        <div class="rating__check-star-wrap"><i class="fas fa-star"></i><i
                                                                class="fas fa-star"></i><i class="fas fa-star"></i><i
                                                                class="fas fa-star"></i><i class="fas fa-star"></i>
                                                        </div>
                                                    </div>

                                                    <span class="shop-w__total-text">(2)</span>
                                                </li>
                                                <li>
                                                    <div class="rating__check">

                                                        <input type="checkbox">
                                                        <div class="rating__check-star-wrap"><i class="fas fa-star"></i><i
                                                                class="fas fa-star"></i><i class="fas fa-star"></i><i
                                                                class="fas fa-star"></i><i class="far fa-star"></i>

                                                            <span>& Up</span></div>
                                                    </div>

                                                    <span class="shop-w__total-text">(8)</span>
                                                </li>
                                                <li>
                                                    <div class="rating__check">

                                                        <input type="checkbox">
                                                        <div class="rating__check-star-wrap"><i class="fas fa-star"></i><i
                                                                class="fas fa-star"></i><i class="fas fa-star"></i><i
                                                                class="far fa-star"></i><i class="far fa-star"></i>

                                                            <span>& Up</span></div>
                                                    </div>

                                                    <span class="shop-w__total-text">(10)</span>
                                                </li>
                                                <li>
                                                    <div class="rating__check">

                                                        <input type="checkbox">
                                                        <div class="rating__check-star-wrap"><i class="fas fa-star"></i><i
                                                                class="fas fa-star"></i><i class="far fa-star"></i><i
                                                                class="far fa-star"></i><i class="far fa-star"></i>

                                                            <span>& Up</span></div>
                                                    </div>

                                                    <span class="shop-w__total-text">(12)</span>
                                                </li>
                                                <li>
                                                    <div class="rating__check">

                                                        <input type="checkbox">
                                                        <div class="rating__check-star-wrap"><i class="fas fa-star"></i><i
                                                                class="far fa-star"></i><i class="far fa-star"></i><i
                                                                class="far fa-star"></i><i class="far fa-star"></i>

                                                            <span>& Up</span></div>
                                                    </div>

                                                    <span class="shop-w__total-text">(1)</span>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="u-s-m-b-30">
                                    <div class="shop-w">
                                        <div class="shop-w__intro-wrap">
                                            <h1 class="shop-w__h">SHIPPING</h1>

                                            <span class="fas fa-minus shop-w__toggle" data-target="#s-shipping"
                                                  data-toggle="collapse"></span>
                                        </div>
                                        <div class="shop-w__wrap collapse show" id="s-shipping">
                                            <ul class="shop-w__list gl-scroll">
                                                <li>

                                                    <!--====== Check Box ======-->
                                                    <div class="check-box">

                                                        <input type="checkbox" id="free-shipping">
                                                        <div class="check-box__state check-box__state--primary">

                                                            <label class="check-box__label" for="free-shipping">Free
                                                                Shipping</label></div>
                                                    </div>
                                                    <!--====== End - Check Box ======-->
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="u-s-m-b-30">
                                    <div class="shop-w">
                                        <div class="shop-w__intro-wrap">
                                            <h1 class="shop-w__h">PRICE</h1>

                                            <span class="fas fa-minus shop-w__toggle" data-target="#s-price"
                                                  data-toggle="collapse"></span>
                                        </div>
                                        <div class="shop-w__wrap collapse show" id="s-price">
                                            <form class="shop-w__form-p">
                                                <div class="shop-w__form-p-wrap">
                                                    <div>

                                                        <label for="price-min"></label>

                                                        <input class="input-text input-text--primary-style"
                                                               type="number" name="minPrice"
                                                               value="${requestScope.paramMinPrice}"
                                                               required
                                                               id="price-min" placeholder="Min"></div>
                                                    <div>

                                                        <label for="price-max"></label>

                                                        <input class="input-text input-text--primary-style"
                                                               type="number" name="maxPrice"
                                                               value="${requestScope.paramMaxPrice}"
                                                               required
                                                               id="price-max" placeholder="Max"></div>
                                                    <c:forEach items="${requestScope.requestParams}" var="requestParam">
                                                        <c:forEach items="${requestParam.value}"
                                                                   var="paramValue">
                                                            <c:if test="${!requestParam.key.equals(WebsiteConstants.paramMaxPriceName)&&!requestParam.key.equals(WebsiteConstants.paramMinPriceName)}">
                                                                <input type='hidden' name='${requestParam.key}'
                                                                       value='${paramValue}'/>
                                                            </c:if>
                                                        </c:forEach>
                                                    </c:forEach>
                                                    <button class="btn btn--icon fas fa-angle-right btn--e-transparent-platinum-b-2"
                                                            type="submit"></button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-9 col-md-12">
                        <div class="shop-p">
                            <div class="shop-p__toolbar u-s-m-b-30">
                                <div class="shop-p__meta-wrap u-s-m-b-60">

                                    <span class="shop-p__meta-text-1">FOUND 18 RESULTS</span>
                                    <div class="shop-p__meta-text-2">

                                        <span>Related Searches:</span>

                                        <a class="gl-tag btn--e-brand-shadow" href="#">men's clothing</a>

                                        <a class="gl-tag btn--e-brand-shadow" href="#">mobiles & tablets</a>

                                        <a class="gl-tag btn--e-brand-shadow" href="#">books & audible</a></div>
                                </div>
                                <div class="shop-p__tool-style">
                                    <div class="tool-style__group u-s-m-b-8">

                                        <span class="js-shop-grid-target is-active">Grid</span>

                                        <span class="js-shop-list-target">List</span></div>
                                    <form>
                                        <div class="tool-style__form-wrap">
                                            <div class="u-s-m-b-8"><select
                                                    class="select-box select-box--transparent-b-2">
                                                <option>Show: 8</option>
                                                <option selected>Show: 12</option>
                                                <option>Show: 16</option>
                                                <option>Show: 28</option>
                                            </select></div>
                                            <div class="u-s-m-b-8"><select
                                                    class="select-box select-box--transparent-b-2">
                                                <option selected>Sort By: Newest Items</option>
                                                <option>Sort By: Latest Items</option>
                                                <option>Sort By: Best Selling</option>
                                                <option>Sort By: Best Rating</option>
                                                <option>Sort By: Lowest Price</option>
                                                <option>Sort By: Highest Price</option>
                                            </select></div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="shop-p__collection">
                                <div class="row is-grid-active">
                                    <c:forEach items="${requestScope.productList}" var="product">
                                        <%@include file="custom/product.jsp" %>
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="u-s-p-y-60">

                                <!--====== Pagination ======-->
                                <ul class="shop-p__pagination">
                                    <c:if test="${requestScope.pageHasPrev}">
                                        <li><a class="fas fa-angle-left" href=""
                                               data-href="page=${requestScope.paramPageNumber-1}"
                                               onmouseover="setDynamicHref(this,destroyPaginationParams());"></a>
                                        </li>
                                    </c:if>
                                    <c:forEach items="${requestScope.pageList}" var="page">
                                        <li
                                                <c:if test="${page.selected}">class="is-active"</c:if> >
                                            <a href="" data-href="page=${page.number}"
                                               onmouseover="setDynamicHref(this,destroyPaginationParams());">${page.number}</a>
                                        </li>
                                    </c:forEach>
                                    <c:if test="${requestScope.pageHasNext}">
                                        <li><a class="fas fa-angle-right" href=""
                                               data-href="page=${requestScope.paramPageNumber+1}"
                                               onmouseover="setDynamicHref(this,destroyPaginationParams());"></a>
                                        </li>
                                    </c:if>
                                </ul>
                                <!--====== End - Pagination ======-->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--====== End - Section 1 ======-->
    </div>
    <!--====== End - App Content ======-->


    <!--====== Main Footer ======-->
    <footer>
        <div class="outer-footer">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4 col-md-6">
                        <div class="outer-footer__content u-s-m-b-40">

                            <span class="outer-footer__content-title">Contact Us</span>
                            <div class="outer-footer__text-wrap"><i class="fas fa-home"></i>

                                <span>4247 Ashford Drive Virginia VA-20006 USA</span></div>
                            <div class="outer-footer__text-wrap"><i class="fas fa-phone-volume"></i>

                                <span>(+0) 900 901 904</span></div>
                            <div class="outer-footer__text-wrap"><i class="far fa-envelope"></i>

                                <span>contact@domain.com</span></div>
                            <div class="outer-footer__social">
                                <ul>
                                    <li>

                                        <a class="s-fb--color-hover" href="#"><i class="fab fa-facebook-f"></i></a></li>
                                    <li>

                                        <a class="s-tw--color-hover" href="#"><i class="fab fa-twitter"></i></a></li>
                                    <li>

                                        <a class="s-youtube--color-hover" href="#"><i class="fab fa-youtube"></i></a>
                                    </li>
                                    <li>

                                        <a class="s-insta--color-hover" href="#"><i class="fab fa-instagram"></i></a>
                                    </li>
                                    <li>

                                        <a class="s-gplus--color-hover" href="#"><i
                                                class="fab fa-google-plus-g"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6">
                        <div class="row">
                            <div class="col-lg-6 col-md-6">
                                <div class="outer-footer__content u-s-m-b-40">

                                    <span class="outer-footer__content-title">Information</span>
                                    <div class="outer-footer__list-wrap">
                                        <ul>
                                            <li>

                                                <a href="cart.jsp">Cart</a></li>
                                            <li>

                                                <a href="dashboard.jsp">Account</a></li>
                                            <li>

                                                <a href="shop-side-version-2.jsp">Manufacturer</a></li>
                                            <li>

                                                <a href="dash-payment-option.jsp">Finance</a></li>
                                            <li>

                                                <a href="shop-side-version-2.jsp">Shop</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6">
                                <div class="outer-footer__content u-s-m-b-40">
                                    <div class="outer-footer__list-wrap">

                                        <span class="outer-footer__content-title">Our Company</span>
                                        <ul>
                                            <li>

                                                <a href="about.jsp">About us</a></li>
                                            <li>

                                                <a href="contact.jsp">Contact Us</a></li>
                                            <li>

                                                <a href="index.jsp">Sitemap</a></li>
                                            <li>

                                                <a href="dash-my-order.jsp">Delivery</a></li>
                                            <li>

                                                <a href="shop-side-version-2.jsp">Store</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-12">
                        <div class="outer-footer__content">

                            <span class="outer-footer__content-title">Join our Newsletter</span>
                            <form class="newsletter">
                                <div class="u-s-m-b-15">
                                    <div class="radio-box newsletter__radio">

                                        <input type="radio" id="male" name="gender">
                                        <div class="radio-box__state radio-box__state--primary">

                                            <label class="radio-box__label" for="male">Male</label></div>
                                    </div>
                                    <div class="radio-box newsletter__radio">

                                        <input type="radio" id="female" name="gender">
                                        <div class="radio-box__state radio-box__state--primary">

                                            <label class="radio-box__label" for="female">Female</label></div>
                                    </div>
                                </div>
                                <div class="newsletter__group">

                                    <label for="newsletter"></label>

                                    <input class="input-text input-text--only-white" type="text" id="newsletter"
                                           placeholder="Enter your Email">

                                    <button class="btn btn--e-brand newsletter__btn" type="submit">SUBSCRIBE</button>
                                </div>

                                <span class="newsletter__text">Subscribe to the mailing list to receive updates on promotions, new arrivals, discount and coupons.</span>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="lower-footer">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="lower-footer__content">
                            <div class="lower-footer__copyright">

                                <span>Copyright © 2018</span>

                                <a href="index.jsp">Reshop</a>

                                <span>All Right Reserved</span></div>
                            <div class="lower-footer__payment">
                                <ul>
                                    <li><i class="fab fa-cc-stripe"></i></li>
                                    <li><i class="fab fa-cc-paypal"></i></li>
                                    <li><i class="fab fa-cc-mastercard"></i></li>
                                    <li><i class="fab fa-cc-visa"></i></li>
                                    <li><i class="fab fa-cc-discover"></i></li>
                                    <li><i class="fab fa-cc-amex"></i></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>

    <!--====== Modal Section ======-->


    <!--====== Quick Look Modal ======-->
    <div class="modal fade" id="quick-look">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content modal--shadow">

                <button class="btn dismiss-button fas fa-times" type="button" data-dismiss="modal"></button>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-lg-5">

                            <!--====== Product Breadcrumb ======-->
                            <div class="pd-breadcrumb u-s-m-b-30">
                                <ul class="pd-breadcrumb__list">
                                    <li class="has-separator">

                                        <a href="index.hml">Home</a></li>
                                    <li class="has-separator">

                                        <a href="shop-side-version-2.jsp">Electronics</a></li>
                                    <li class="has-separator">

                                        <a href="shop-side-version-2.jsp">DSLR Cameras</a></li>
                                    <li class="is-marked">

                                        <a href="shop-side-version-2.jsp">Nikon Cameras</a></li>
                                </ul>
                            </div>
                            <!--====== End - Product Breadcrumb ======-->


                            <!--====== Product Detail ======-->
                            <div class="pd u-s-m-b-30">
                                <div class="pd-wrap">
                                    <div id="js-product-detail-modal">
                                        <div>

                                            <img class="u-img-fluid" src="images/product/product-d-1.jpg" alt=""></div>
                                        <div>

                                            <img class="u-img-fluid" src="images/product/product-d-2.jpg" alt=""></div>
                                        <div>

                                            <img class="u-img-fluid" src="images/product/product-d-3.jpg" alt=""></div>
                                        <div>

                                            <img class="u-img-fluid" src="images/product/product-d-4.jpg" alt=""></div>
                                        <div>

                                            <img class="u-img-fluid" src="images/product/product-d-5.jpg" alt=""></div>
                                    </div>
                                </div>
                                <div class="u-s-m-t-15">
                                    <div id="js-product-detail-modal-thumbnail">
                                        <div>

                                            <img class="u-img-fluid" src="images/product/product-d-1.jpg" alt=""></div>
                                        <div>

                                            <img class="u-img-fluid" src="images/product/product-d-2.jpg" alt=""></div>
                                        <div>

                                            <img class="u-img-fluid" src="images/product/product-d-3.jpg" alt=""></div>
                                        <div>

                                            <img class="u-img-fluid" src="images/product/product-d-4.jpg" alt=""></div>
                                        <div>

                                            <img class="u-img-fluid" src="images/product/product-d-5.jpg" alt=""></div>
                                    </div>
                                </div>
                            </div>
                            <!--====== End - Product Detail ======-->
                        </div>
                        <div class="col-lg-7">

                            <!--====== Product Right Side Details ======-->
                            <div class="pd-detail">
                                <div>

                                    <span class="pd-detail__name">Nikon Camera 4k Lens Zoom Pro</span></div>
                                <div>
                                    <div class="pd-detail__inline">

                                        <span class="pd-detail__price">$6.99</span>

                                        <span class="pd-detail__discount">(76% OFF)</span>
                                        <del class="pd-detail__del">$28.97</del>
                                    </div>
                                </div>
                                <div class="u-s-m-b-15">
                                    <div class="pd-detail__rating gl-rating-style"><i class="fas fa-star"></i><i
                                            class="fas fa-star"></i><i class="fas fa-star"></i><i
                                            class="fas fa-star"></i><i class="fas fa-star-half-alt"></i>

                                        <span class="pd-detail__review u-s-m-l-4">

                                                <a href="product-detail.jsp">23 Reviews</a></span></div>
                                </div>
                                <div class="u-s-m-b-15">
                                    <div class="pd-detail__inline">

                                        <span class="pd-detail__stock">200 in stock</span>

                                        <span class="pd-detail__left">Only 2 left</span></div>
                                </div>
                                <div class="u-s-m-b-15">

                                    <span class="pd-detail__preview-desc">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</span>
                                </div>
                                <div class="u-s-m-b-15">
                                    <div class="pd-detail__inline">

                                            <span class="pd-detail__click-wrap"><i class="far fa-heart u-s-m-r-6"></i>

                                                <a href="signin.jsp">Add to Wishlist</a>

                                                <span class="pd-detail__click-count">(222)</span></span></div>
                                </div>
                                <div class="u-s-m-b-15">
                                    <div class="pd-detail__inline">

                                            <span class="pd-detail__click-wrap"><i
                                                    class="far fa-envelope u-s-m-r-6"></i>

                                                <a href="signin.jsp">Email me When the price drops</a>

                                                <span class="pd-detail__click-count">(20)</span></span></div>
                                </div>
                                <div class="u-s-m-b-15">
                                    <ul class="pd-social-list">
                                        <li>

                                            <a class="s-fb--color-hover" href="#"><i class="fab fa-facebook-f"></i></a>
                                        </li>
                                        <li>

                                            <a class="s-tw--color-hover" href="#"><i class="fab fa-twitter"></i></a>
                                        </li>
                                        <li>

                                            <a class="s-insta--color-hover" href="#"><i
                                                    class="fab fa-instagram"></i></a></li>
                                        <li>

                                            <a class="s-wa--color-hover" href="#"><i class="fab fa-whatsapp"></i></a>
                                        </li>
                                        <li>

                                            <a class="s-gplus--color-hover" href="#"><i
                                                    class="fab fa-google-plus-g"></i></a></li>
                                    </ul>
                                </div>
                                <div class="u-s-m-b-15">
                                    <form class="pd-detail__form">
                                        <div class="pd-detail-inline-2">
                                            <div class="u-s-m-b-15">

                                                <!--====== Input Counter ======-->
                                                <div class="input-counter">

                                                    <span class="input-counter__minus fas fa-minus"></span>

                                                    <input class="input-counter__text input-counter--text-primary-style"
                                                           type="text" value="1" data-min="1" data-max="1000">

                                                    <span class="input-counter__plus fas fa-plus"></span></div>
                                                <!--====== End - Input Counter ======-->
                                            </div>
                                            <div class="u-s-m-b-15">

                                                <button class="btn btn--e-brand-b-2" type="submit">Add to Cart</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="u-s-m-b-15">

                                    <span class="pd-detail__label u-s-m-b-8">Product Policy:</span>
                                    <ul class="pd-detail__policy-list">
                                        <li><i class="fas fa-check-circle u-s-m-r-8"></i>

                                            <span>Buyer Protection.</span></li>
                                        <li><i class="fas fa-check-circle u-s-m-r-8"></i>

                                            <span>Full Refund if you don't receive your order.</span></li>
                                        <li><i class="fas fa-check-circle u-s-m-r-8"></i>

                                            <span>Returns accepted if product not as described.</span></li>
                                    </ul>
                                </div>
                            </div>
                            <!--====== End - Product Right Side Details ======-->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--====== End - Quick Look Modal ======-->



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

                                    <img id="modal-add-img" class="u-img-fluid" src="images/product/electronic/product1.jpg" alt=""></div>
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

                                    <a class="s-option__link btn--e-white-brand-shadow" data-dismiss="modal">CONTINUE SHOPPING</a>

                                    <a class="s-option__link btn--e-white-brand-shadow" href="cart.html">VIEW CART</a>

                                    <a class="s-option__link btn--e-brand-shadow" href="checkout.html">PROCEED TO CHECKOUT</a></div>
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
    function addToCart(productId) {
        $.get("${applicationScope.urlMappingConstants.getServiceUrl(ServiceNames.PRODUCT_ADD_TO_CART)}?${WebsiteConstants.paramProductId}=" + productId, function (product, status) {
            // console.log("Data: " + data + "\nStatus: " + status);
            // console.log(data.name)
            // if (data.length <= 5) return;
            // let product = JSON.parse(data);
            // console.log(product);
            if (status === 'success')
                // fkingSetModal(product);
                setTimeout(fkingSetModal, 500, product);
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