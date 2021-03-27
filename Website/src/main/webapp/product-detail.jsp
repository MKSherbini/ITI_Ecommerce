<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="commons/pageCommon.jsp" %>

<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
    <title>${applicationScope.urlMappingConstants.getTitle(PageNames.PRODUCT)}</title>
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
        <div class="u-s-p-t-90">
            <div class="container">
                <div class="row">
                    <div class="col-lg-5">

                        <!--====== Product Breadcrumb ======-->
                        <div class="pd-breadcrumb u-s-m-b-30">
                            <ul class="pd-breadcrumb__list">
                                <li class="has-separator">
                                    <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.HOME_PAGE)}">Home</a>
                                </li>
                                <li class="is-marked">
                                    <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.SHOP)}?category=${requestScope.product.category.name}">${requestScope.product.category.name}</a>
                                </li>
                            </ul>
                        </div>
                        <!--====== End - Product Breadcrumb ======-->


                        <!--====== Product Detail Zoom ======-->
                        <div class="pd u-s-m-b-30">
                            <div class="slider-fouc pd-wrap">
                                <div id="pd-o-initiate">
                                    <div class="pd-o-img-wrap" data-src="images/product/product-d-1.jpg">

                                        <img class="u-img-fluid" src="images/product/product-d-1.jpg"
                                             data-zoom-image="images/product/product-d-1.jpg" alt=""></div>
                                    <div class="pd-o-img-wrap" data-src="images/product/product-d-2.jpg">

                                        <img class="u-img-fluid" src="images/product/product-d-2.jpg"
                                             data-zoom-image="images/product/product-d-2.jpg" alt=""></div>
                                    <div class="pd-o-img-wrap" data-src="images/product/product-d-3.jpg">

                                        <img class="u-img-fluid" src="images/product/product-d-3.jpg"
                                             data-zoom-image="images/product/product-d-3.jpg" alt=""></div>
                                    <div class="pd-o-img-wrap" data-src="images/product/product-d-4.jpg">

                                        <img class="u-img-fluid" src="images/product/product-d-4.jpg"
                                             data-zoom-image="images/product/product-d-4.jpg" alt=""></div>
                                    <div class="pd-o-img-wrap" data-src="images/product/product-d-5.jpg">

                                        <img class="u-img-fluid" src="images/product/product-d-5.jpg"
                                             data-zoom-image="images/product/product-d-5.jpg" alt=""></div>
                                </div>

                                <span class="pd-text">Click for larger zoom</span>
                            </div>
                            <div class="u-s-m-t-15">
                                <div class="slider-fouc">
                                    <div id="pd-o-thumbnail">
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
                        </div>
                        <!--====== End - Product Detail Zoom ======-->
                    </div>
                    <div class="col-lg-7">

                        <!--====== Product Right Side Details ======-->
                        <div class="pd-detail">
                            <div>
                                <span class="pd-detail__name">${requestScope.product.name}</span>
                            </div>
                            <c:choose>
                                <c:when test="${requestScope.product.discountPercent==0}">
                                    <%--product price--%>
                                    <div>
                                        <div class="pd-detail__inline">

                                            <span class="pd-detail__price">$${requestScope.product.price}</span>

                                        </div>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <%--product price--%>
                                    <div>
                                        <div class="pd-detail__inline">

                                            <span class="pd-detail__price">$${requestScope.product.price * (1-(requestScope.product.discountPercent/ 100))}</span>

                                            <span class="pd-detail__discount">(${requestScope.product.discountPercent/100}% OFF)</span>
                                            <del class="pd-detail__del">$${requestScope.product.price}</del>
                                        </div>
                                    </div>
                                </c:otherwise>
                            </c:choose>

                            <div class="u-s-m-b-15">
                                <div class="pd-detail__rating gl-rating-style"><i class="fas fa-star"></i><i
                                        class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i
                                        class="fas fa-star-half-alt"></i>

                                    <span class="pd-detail__review u-s-m-l-4">

                                            <a data-click-scroll="#view-review">23 Reviews</a></span></div>
                            </div>
                            <div class="u-s-m-b-15">
                                <div class="pd-detail__inline">

                                    <span class="pd-detail__stock">200 in stock</span>

                                    <span class="pd-detail__left">Only 2 left</span></div>
                            </div>
                            <div class="u-s-m-b-15">

                                <span class="pd-detail__preview-desc">${requestScope.product.description}</span>
                            </div>
                            <div class="u-s-m-b-15">
                                <div class="pd-detail__inline">

                                        <span class="pd-detail__click-wrap"><i class="far fa-heart u-s-m-r-6"></i>

                                            <a href="signin.jsp">Add to Wishlist</a>

                                            <span class="pd-detail__click-count">(222)</span></span></div>
                            </div>
                            <div class="u-s-m-b-15">
                                <div class="pd-detail__inline">

                                        <span class="pd-detail__click-wrap"><i class="far fa-envelope u-s-m-r-6"></i>

                                            <a href="signin.jsp">Email me When the price drops</a>

                                            <span class="pd-detail__click-count">(20)</span></span></div>
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

        <!--====== Product Detail Tab ======-->
        <div class="u-s-p-y-90">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="pd-tab">
                            <div class="u-s-m-b-30">
                                <ul class="nav pd-tab__list">
                                    <li class="nav-item">

                                        <a class="nav-link active" data-toggle="tab" href="#pd-desc">DESCRIPTION</a>
                                    </li>
                                    <li class="nav-item">

                                        <a class="nav-link" data-toggle="tab" href="#pd-tag">TAGS</a></li>
                                    <li class="nav-item">

                                        <a class="nav-link" id="view-review" data-toggle="tab" href="#pd-rev">REVIEWS

                                            <span>(23)</span></a></li>
                                </ul>
                            </div>
                            <div class="tab-content">

                                <!--====== Tab 1 ======-->
                                <div class="tab-pane fade show active" id="pd-desc">
                                    <div class="pd-tab__desc">
                                        <div class="u-s-m-b-15">
                                            <p>${requestScope.product.description}</p>
                                        </div>
                                        <div class="u-s-m-b-30">
                                            <iframe src="https://www.youtube.com/embed/qKqSBm07KZk"
                                                    allowfullscreen></iframe>
                                        </div>
                                        <div class="u-s-m-b-30">
                                            <ul>
                                                <li><i class="fas fa-check u-s-m-r-8"></i>

                                                    <span>Buyer Protection.</span></li>
                                                <li><i class="fas fa-check u-s-m-r-8"></i>

                                                    <span>Full Refund if you don't receive your order.</span></li>
                                                <li><i class="fas fa-check u-s-m-r-8"></i>

                                                    <span>Returns accepted if product not as described.</span></li>
                                            </ul>
                                        </div>
                                        <div class="u-s-m-b-15">
                                            <h4>PRODUCT INFORMATION</h4>
                                        </div>
                                        <div class="u-s-m-b-15">
                                            <div class="pd-table gl-scroll">
                                                <table>
                                                    <tbody>
                                                    <tr>
                                                        <td>Main Material</td>
                                                        <td>Cotton</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Color</td>
                                                        <td>Green, Blue, Red</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Sleeves</td>
                                                        <td>Long Sleeve</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Top Fit</td>
                                                        <td>Regular</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Print</td>
                                                        <td>Not Printed</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Neck</td>
                                                        <td>Round Neck</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Pieces Count</td>
                                                        <td>1 Piece</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Occasion</td>
                                                        <td>Casual</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Shipping Weight (kg)</td>
                                                        <td>0.5</td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--====== End - Tab 1 ======-->


                                <!--====== Tab 2 ======-->
                                <div class="tab-pane" id="pd-tag">
                                    <div class="pd-tab__tag">
                                        <h2 class="u-s-m-b-15">ADD YOUR TAGS</h2>
                                        <div class="u-s-m-b-15">
                                            <form>

                                                <input class="input-text input-text--primary-style" type="text">

                                                <button class="btn btn--e-brand-b-2" type="submit">ADD TAGS</button>
                                            </form>
                                        </div>

                                        <span class="gl-text">Use spaces to separate tags. Use single quotes (') for phrases.</span>
                                    </div>
                                </div>
                                <!--====== End - Tab 2 ======-->


                                <!--====== Tab 3 ======-->
                                <div class="tab-pane" id="pd-rev">
                                    <div class="pd-tab__rev">
                                        <div class="u-s-m-b-30">
                                            <div class="pd-tab__rev-score">
                                                <div class="u-s-m-b-8">
                                                    <h2>23 Reviews - 4.6 (Overall)</h2>
                                                </div>
                                                <div class="gl-rating-style-2 u-s-m-b-8"><i class="fas fa-star"></i><i
                                                        class="fas fa-star"></i><i class="fas fa-star"></i><i
                                                        class="fas fa-star"></i><i class="fas fa-star-half-alt"></i>
                                                </div>
                                                <div class="u-s-m-b-8">
                                                    <h4>We want to hear from you!</h4>
                                                </div>

                                                <span class="gl-text">Tell us what you think about this item</span>
                                            </div>
                                        </div>
                                        <div class="u-s-m-b-30">
                                            <form class="pd-tab__rev-f1">
                                                <div class="rev-f1__group">
                                                    <div class="u-s-m-b-15">
                                                        <h2>23 Review(s) for Man Ruched Floral Applique Tee</h2>
                                                    </div>
                                                    <div class="u-s-m-b-15">

                                                        <label for="sort-review"></label><select
                                                            class="select-box select-box--primary-style"
                                                            id="sort-review">
                                                        <option selected>Sort by: Best Rating</option>
                                                        <option>Sort by: Worst Rating</option>
                                                    </select></div>
                                                </div>
                                                <div class="rev-f1__review">
                                                    <div class="review-o u-s-m-b-15">
                                                        <div class="review-o__info u-s-m-b-8">

                                                            <span class="review-o__name">John Doe</span>

                                                            <span class="review-o__date">27 Feb 2018 10:57:43</span>
                                                        </div>
                                                        <div class="review-o__rating gl-rating-style u-s-m-b-8"><i
                                                                class="fas fa-star"></i><i class="fas fa-star"></i><i
                                                                class="fas fa-star"></i><i class="fas fa-star"></i><i
                                                                class="far fa-star"></i>

                                                            <span>(4)</span></div>
                                                        <p class="review-o__text">Lorem Ipsum is simply dummy text of
                                                            the printing and typesetting industry. Lorem Ipsum has been
                                                            the industry's standard dummy text ever since the 1500s,
                                                            when an unknown printer took a galley of type and scrambled
                                                            it to make a type specimen book.</p>
                                                    </div>
                                                    <div class="review-o u-s-m-b-15">
                                                        <div class="review-o__info u-s-m-b-8">

                                                            <span class="review-o__name">John Doe</span>

                                                            <span class="review-o__date">27 Feb 2018 10:57:43</span>
                                                        </div>
                                                        <div class="review-o__rating gl-rating-style u-s-m-b-8"><i
                                                                class="fas fa-star"></i><i class="fas fa-star"></i><i
                                                                class="fas fa-star"></i><i class="fas fa-star"></i><i
                                                                class="far fa-star"></i>

                                                            <span>(4)</span></div>
                                                        <p class="review-o__text">Lorem Ipsum is simply dummy text of
                                                            the printing and typesetting industry. Lorem Ipsum has been
                                                            the industry's standard dummy text ever since the 1500s,
                                                            when an unknown printer took a galley of type and scrambled
                                                            it to make a type specimen book.</p>
                                                    </div>
                                                    <div class="review-o u-s-m-b-15">
                                                        <div class="review-o__info u-s-m-b-8">

                                                            <span class="review-o__name">John Doe</span>

                                                            <span class="review-o__date">27 Feb 2018 10:57:43</span>
                                                        </div>
                                                        <div class="review-o__rating gl-rating-style u-s-m-b-8"><i
                                                                class="fas fa-star"></i><i class="fas fa-star"></i><i
                                                                class="fas fa-star"></i><i class="fas fa-star"></i><i
                                                                class="far fa-star"></i>

                                                            <span>(4)</span></div>
                                                        <p class="review-o__text">Lorem Ipsum is simply dummy text of
                                                            the printing and typesetting industry. Lorem Ipsum has been
                                                            the industry's standard dummy text ever since the 1500s,
                                                            when an unknown printer took a galley of type and scrambled
                                                            it to make a type specimen book.</p>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                        <div class="u-s-m-b-30">
                                            <form class="pd-tab__rev-f2">
                                                <h2 class="u-s-m-b-15">Add a Review</h2>

                                                <span class="gl-text u-s-m-b-15">Your email address will not be published. Required fields are marked *</span>
                                                <div class="u-s-m-b-30">
                                                    <div class="rev-f2__table-wrap gl-scroll">
                                                        <table class="rev-f2__table">
                                                            <thead>
                                                            <tr>
                                                                <th>
                                                                    <div class="gl-rating-style-2"><i
                                                                            class="fas fa-star"></i>

                                                                        <span>(1)</span></div>
                                                                </th>
                                                                <th>
                                                                    <div class="gl-rating-style-2"><i
                                                                            class="fas fa-star"></i><i
                                                                            class="fas fa-star-half-alt"></i>

                                                                        <span>(1.5)</span></div>
                                                                </th>
                                                                <th>
                                                                    <div class="gl-rating-style-2"><i
                                                                            class="fas fa-star"></i><i
                                                                            class="fas fa-star"></i>

                                                                        <span>(2)</span></div>
                                                                </th>
                                                                <th>
                                                                    <div class="gl-rating-style-2"><i
                                                                            class="fas fa-star"></i><i
                                                                            class="fas fa-star"></i><i
                                                                            class="fas fa-star-half-alt"></i>

                                                                        <span>(2.5)</span></div>
                                                                </th>
                                                                <th>
                                                                    <div class="gl-rating-style-2"><i
                                                                            class="fas fa-star"></i><i
                                                                            class="fas fa-star"></i><i
                                                                            class="fas fa-star"></i>

                                                                        <span>(3)</span></div>
                                                                </th>
                                                                <th>
                                                                    <div class="gl-rating-style-2"><i
                                                                            class="fas fa-star"></i><i
                                                                            class="fas fa-star"></i><i
                                                                            class="fas fa-star"></i><i
                                                                            class="fas fa-star-half-alt"></i>

                                                                        <span>(3.5)</span></div>
                                                                </th>
                                                                <th>
                                                                    <div class="gl-rating-style-2"><i
                                                                            class="fas fa-star"></i><i
                                                                            class="fas fa-star"></i><i
                                                                            class="fas fa-star"></i><i
                                                                            class="fas fa-star"></i>

                                                                        <span>(4)</span></div>
                                                                </th>
                                                                <th>
                                                                    <div class="gl-rating-style-2"><i
                                                                            class="fas fa-star"></i><i
                                                                            class="fas fa-star"></i><i
                                                                            class="fas fa-star"></i><i
                                                                            class="fas fa-star"></i><i
                                                                            class="fas fa-star-half-alt"></i>

                                                                        <span>(4.5)</span></div>
                                                                </th>
                                                                <th>
                                                                    <div class="gl-rating-style-2"><i
                                                                            class="fas fa-star"></i><i
                                                                            class="fas fa-star"></i><i
                                                                            class="fas fa-star"></i><i
                                                                            class="fas fa-star"></i><i
                                                                            class="fas fa-star"></i>

                                                                        <span>(5)</span></div>
                                                                </th>
                                                            </tr>
                                                            </thead>
                                                            <tbody>
                                                            <tr>
                                                                <td>

                                                                    <!--====== Radio Box ======-->
                                                                    <div class="radio-box">

                                                                        <input type="radio" id="star-1" name="rating">
                                                                        <div class="radio-box__state radio-box__state--primary">

                                                                            <label class="radio-box__label"
                                                                                   for="star-1"></label></div>
                                                                    </div>
                                                                    <!--====== End - Radio Box ======-->
                                                                </td>
                                                                <td>

                                                                    <!--====== Radio Box ======-->
                                                                    <div class="radio-box">

                                                                        <input type="radio" id="star-1.5" name="rating">
                                                                        <div class="radio-box__state radio-box__state--primary">

                                                                            <label class="radio-box__label"
                                                                                   for="star-1.5"></label></div>
                                                                    </div>
                                                                    <!--====== End - Radio Box ======-->
                                                                </td>
                                                                <td>

                                                                    <!--====== Radio Box ======-->
                                                                    <div class="radio-box">

                                                                        <input type="radio" id="star-2" name="rating">
                                                                        <div class="radio-box__state radio-box__state--primary">

                                                                            <label class="radio-box__label"
                                                                                   for="star-2"></label></div>
                                                                    </div>
                                                                    <!--====== End - Radio Box ======-->
                                                                </td>
                                                                <td>

                                                                    <!--====== Radio Box ======-->
                                                                    <div class="radio-box">

                                                                        <input type="radio" id="star-2.5" name="rating">
                                                                        <div class="radio-box__state radio-box__state--primary">

                                                                            <label class="radio-box__label"
                                                                                   for="star-2.5"></label></div>
                                                                    </div>
                                                                    <!--====== End - Radio Box ======-->
                                                                </td>
                                                                <td>

                                                                    <!--====== Radio Box ======-->
                                                                    <div class="radio-box">

                                                                        <input type="radio" id="star-3" name="rating">
                                                                        <div class="radio-box__state radio-box__state--primary">

                                                                            <label class="radio-box__label"
                                                                                   for="star-3"></label></div>
                                                                    </div>
                                                                    <!--====== End - Radio Box ======-->
                                                                </td>
                                                                <td>

                                                                    <!--====== Radio Box ======-->
                                                                    <div class="radio-box">

                                                                        <input type="radio" id="star-3.5" name="rating">
                                                                        <div class="radio-box__state radio-box__state--primary">

                                                                            <label class="radio-box__label"
                                                                                   for="star-3.5"></label></div>
                                                                    </div>
                                                                    <!--====== End - Radio Box ======-->
                                                                </td>
                                                                <td>

                                                                    <!--====== Radio Box ======-->
                                                                    <div class="radio-box">

                                                                        <input type="radio" id="star-4" name="rating">
                                                                        <div class="radio-box__state radio-box__state--primary">

                                                                            <label class="radio-box__label"
                                                                                   for="star-4"></label></div>
                                                                    </div>
                                                                    <!--====== End - Radio Box ======-->
                                                                </td>
                                                                <td>

                                                                    <!--====== Radio Box ======-->
                                                                    <div class="radio-box">

                                                                        <input type="radio" id="star-4.5" name="rating">
                                                                        <div class="radio-box__state radio-box__state--primary">

                                                                            <label class="radio-box__label"
                                                                                   for="star-4.5"></label></div>
                                                                    </div>
                                                                    <!--====== End - Radio Box ======-->
                                                                </td>
                                                                <td>

                                                                    <!--====== Radio Box ======-->
                                                                    <div class="radio-box">

                                                                        <input type="radio" id="star-5" name="rating">
                                                                        <div class="radio-box__state radio-box__state--primary">

                                                                            <label class="radio-box__label"
                                                                                   for="star-5"></label></div>
                                                                    </div>
                                                                    <!--====== End - Radio Box ======-->
                                                                </td>
                                                            </tr>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                                <div class="rev-f2__group">
                                                    <div class="u-s-m-b-15">

                                                        <label class="gl-label" for="reviewer-text">YOUR REVIEW
                                                            *</label><textarea
                                                            class="text-area text-area--primary-style"
                                                            id="reviewer-text"></textarea></div>
                                                    <div>
                                                        <p class="u-s-m-b-30">

                                                            <label class="gl-label" for="reviewer-name">NAME *</label>

                                                            <input class="input-text input-text--primary-style"
                                                                   type="text" id="reviewer-name"></p>
                                                        <p class="u-s-m-b-30">

                                                            <label class="gl-label" for="reviewer-email">EMAIL *</label>

                                                            <input class="input-text input-text--primary-style"
                                                                   type="text" id="reviewer-email"></p>
                                                    </div>
                                                </div>
                                                <div>

                                                    <button class="btn btn--e-brand-shadow" type="submit">SUBMIT
                                                    </button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <!--====== End - Tab 3 ======-->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--====== End - Product Detail Tab ======-->
        <div class="u-s-p-b-90">

            <!--====== Section Intro ======-->
            <div class="section__intro u-s-m-b-46">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="section__text-wrap">
                                <h1 class="section__heading u-c-secondary u-s-m-b-12">CUSTOMER ALSO VIEWED</h1>

                                <span class="section__span u-c-grey">PRODUCTS THAT CUSTOMER VIEWED</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--====== End - Section Intro ======-->


            <!--====== Section Content ======-->
            <div class="section__content">
                <div class="container">
                    <div class="slider-fouc">
                        <div class="owl-carousel product-slider" data-item="4">
                            <div class="u-s-m-b-30">
                                <div class="product-o product-o--hover-on">
                                    <div class="product-o__wrap">

                                        <a class="aspect aspect--bg-grey aspect--square u-d-block"
                                           href="product-detail.jsp">

                                            <img class="aspect__img" src="images/product/electronic/product1.jpg"
                                                 alt=""></a>
                                        <div class="product-o__action-wrap">
                                            <ul class="product-o__action-list">
                                                <li>

                                                    <a data-modal="modal" data-modal-id="#quick-look"
                                                       data-tooltip="tooltip" data-placement="top" title="Quick View"><i
                                                            class="fas fa-search-plus"></i></a></li>
                                                <li>

                                                    <a data-modal="modal" data-modal-id="#add-to-cart"
                                                       data-tooltip="tooltip" data-placement="top"
                                                       title="Add to Cart"><i class="fas fa-plus-circle"></i></a></li>
                                                <li>

                                                    <a href="signin.jsp" data-tooltip="tooltip" data-placement="top"
                                                       title="Add to Wishlist"><i class="fas fa-heart"></i></a></li>
                                                <li>

                                                    <a href="signin.jsp" data-tooltip="tooltip" data-placement="top"
                                                       title="Email me When the price drops"><i
                                                            class="fas fa-envelope"></i></a></li>
                                            </ul>
                                        </div>
                                    </div>

                                    <span class="product-o__category">

                                            <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.SHOP)}">Electronics</a></span>

                                    <span class="product-o__name">

                                            <a href="product-detail.jsp">Beats Bomb Wireless Headphone</a></span>
                                    <div class="product-o__rating gl-rating-style"><i class="fas fa-star"></i><i
                                            class="fas fa-star"></i><i class="fas fa-star"></i><i
                                            class="fas fa-star"></i><i class="fas fa-star"></i>

                                        <span class="product-o__review">(20)</span></div>

                                    <span class="product-o__price">$125.00

                                            <span class="product-o__discount">$160.00</span></span>
                                </div>
                            </div>
                            <div class="u-s-m-b-30">
                                <div class="product-o product-o--hover-on">
                                    <div class="product-o__wrap">

                                        <a class="aspect aspect--bg-grey aspect--square u-d-block"
                                           href="product-detail.jsp">

                                            <img class="aspect__img" src="images/product/electronic/product2.jpg"
                                                 alt=""></a>
                                        <div class="product-o__action-wrap">
                                            <ul class="product-o__action-list">
                                                <li>

                                                    <a data-modal="modal" data-modal-id="#quick-look"
                                                       data-tooltip="tooltip" data-placement="top" title="Quick View"><i
                                                            class="fas fa-search-plus"></i></a></li>
                                                <li>

                                                    <a data-modal="modal" data-modal-id="#add-to-cart"
                                                       data-tooltip="tooltip" data-placement="top"
                                                       title="Add to Cart"><i class="fas fa-plus-circle"></i></a></li>
                                                <li>

                                                    <a href="signin.jsp" data-tooltip="tooltip" data-placement="top"
                                                       title="Add to Wishlist"><i class="fas fa-heart"></i></a></li>
                                                <li>

                                                    <a href="signin.jsp" data-tooltip="tooltip" data-placement="top"
                                                       title="Email me When the price drops"><i
                                                            class="fas fa-envelope"></i></a></li>
                                            </ul>
                                        </div>
                                    </div>

                                    <span class="product-o__category">

                                            <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.SHOP)}">Electronics</a></span>

                                    <span class="product-o__name">

                                            <a href="product-detail.jsp">Red Wireless Headphone</a></span>
                                    <div class="product-o__rating gl-rating-style"><i class="fas fa-star"></i><i
                                            class="fas fa-star"></i><i class="fas fa-star"></i><i
                                            class="fas fa-star"></i><i class="fas fa-star"></i>

                                        <span class="product-o__review">(20)</span></div>

                                    <span class="product-o__price">$125.00

                                            <span class="product-o__discount">$160.00</span></span>
                                </div>
                            </div>
                            <div class="u-s-m-b-30">
                                <div class="product-o product-o--hover-on">
                                    <div class="product-o__wrap">

                                        <a class="aspect aspect--bg-grey aspect--square u-d-block"
                                           href="product-detail.jsp">

                                            <img class="aspect__img" src="images/product/electronic/product3.jpg"
                                                 alt=""></a>
                                        <div class="product-o__action-wrap">
                                            <ul class="product-o__action-list">
                                                <li>

                                                    <a data-modal="modal" data-modal-id="#quick-look"
                                                       data-tooltip="tooltip" data-placement="top" title="Quick View"><i
                                                            class="fas fa-search-plus"></i></a></li>
                                                <li>

                                                    <a data-modal="modal" data-modal-id="#add-to-cart"
                                                       data-tooltip="tooltip" data-placement="top"
                                                       title="Add to Cart"><i class="fas fa-plus-circle"></i></a></li>
                                                <li>

                                                    <a href="signin.jsp" data-tooltip="tooltip" data-placement="top"
                                                       title="Add to Wishlist"><i class="fas fa-heart"></i></a></li>
                                                <li>

                                                    <a href="signin.jsp" data-tooltip="tooltip" data-placement="top"
                                                       title="Email me When the price drops"><i
                                                            class="fas fa-envelope"></i></a></li>
                                            </ul>
                                        </div>
                                    </div>

                                    <span class="product-o__category">

                                            <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.SHOP)}">Electronics</a></span>

                                    <span class="product-o__name">

                                            <a href="product-detail.jsp">Yellow Wireless Headphone</a></span>
                                    <div class="product-o__rating gl-rating-style"><i class="fas fa-star"></i><i
                                            class="fas fa-star"></i><i class="fas fa-star"></i><i
                                            class="fas fa-star"></i><i class="fas fa-star"></i>

                                        <span class="product-o__review">(20)</span></div>

                                    <span class="product-o__price">$125.00

                                            <span class="product-o__discount">$160.00</span></span>
                                </div>
                            </div>
                            <div class="u-s-m-b-30">
                                <div class="product-o product-o--hover-on">
                                    <div class="product-o__wrap">

                                        <a class="aspect aspect--bg-grey aspect--square u-d-block"
                                           href="product-detail.jsp">

                                            <img class="aspect__img" src="images/product/electronic/product23.jpg"
                                                 alt=""></a>
                                        <div class="product-o__action-wrap">
                                            <ul class="product-o__action-list">
                                                <li>

                                                    <a data-modal="modal" data-modal-id="#quick-look"
                                                       data-tooltip="tooltip" data-placement="top" title="Quick View"><i
                                                            class="fas fa-search-plus"></i></a></li>
                                                <li>

                                                    <a data-modal="modal" data-modal-id="#add-to-cart"
                                                       data-tooltip="tooltip" data-placement="top"
                                                       title="Add to Cart"><i class="fas fa-plus-circle"></i></a></li>
                                                <li>

                                                    <a href="signin.jsp" data-tooltip="tooltip" data-placement="top"
                                                       title="Add to Wishlist"><i class="fas fa-heart"></i></a></li>
                                                <li>

                                                    <a href="signin.jsp" data-tooltip="tooltip" data-placement="top"
                                                       title="Email me When the price drops"><i
                                                            class="fas fa-envelope"></i></a></li>
                                            </ul>
                                        </div>
                                    </div>

                                    <span class="product-o__category">

                                            <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.SHOP)}">Electronics</a></span>

                                    <span class="product-o__name">

                                            <a href="product-detail.jsp">Razor Gear Ultra Slim 8GB Ram</a></span>
                                    <div class="product-o__rating gl-rating-style"><i class="fas fa-star"></i><i
                                            class="fas fa-star"></i><i class="fas fa-star"></i><i
                                            class="fas fa-star"></i><i class="fas fa-star"></i>

                                        <span class="product-o__review">(20)</span></div>

                                    <span class="product-o__price">$125.00

                                            <span class="product-o__discount">$160.00</span></span>
                                </div>
                            </div>
                            <div class="u-s-m-b-30">
                                <div class="product-o product-o--hover-on">
                                    <div class="product-o__wrap">

                                        <a class="aspect aspect--bg-grey aspect--square u-d-block"
                                           href="product-detail.jsp">

                                            <img class="aspect__img" src="images/product/electronic/product26.jpg"
                                                 alt=""></a>
                                        <div class="product-o__action-wrap">
                                            <ul class="product-o__action-list">
                                                <li>

                                                    <a data-modal="modal" data-modal-id="#quick-look"
                                                       data-tooltip="tooltip" data-placement="top" title="Quick View"><i
                                                            class="fas fa-search-plus"></i></a></li>
                                                <li>

                                                    <a data-modal="modal" data-modal-id="#add-to-cart"
                                                       data-tooltip="tooltip" data-placement="top"
                                                       title="Add to Cart"><i class="fas fa-plus-circle"></i></a></li>
                                                <li>

                                                    <a href="signin.jsp" data-tooltip="tooltip" data-placement="top"
                                                       title="Add to Wishlist"><i class="fas fa-heart"></i></a></li>
                                                <li>

                                                    <a href="signin.jsp" data-tooltip="tooltip" data-placement="top"
                                                       title="Email me When the price drops"><i
                                                            class="fas fa-envelope"></i></a></li>
                                            </ul>
                                        </div>
                                    </div>

                                    <span class="product-o__category">

                                            <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.SHOP)}">Electronics</a></span>

                                    <span class="product-o__name">

                                            <a href="product-detail.jsp">Razor Gear Ultra Slim 12GB Ram</a></span>
                                    <div class="product-o__rating gl-rating-style"><i class="fas fa-star"></i><i
                                            class="fas fa-star"></i><i class="fas fa-star"></i><i
                                            class="fas fa-star"></i><i class="fas fa-star"></i>

                                        <span class="product-o__review">(20)</span></div>

                                    <span class="product-o__price">$125.00

                                            <span class="product-o__discount">$160.00</span></span>
                                </div>
                            </div>
                            <div class="u-s-m-b-30">
                                <div class="product-o product-o--hover-on">
                                    <div class="product-o__wrap">

                                        <a class="aspect aspect--bg-grey aspect--square u-d-block"
                                           href="product-detail.jsp">

                                            <img class="aspect__img" src="images/product/electronic/product30.jpg"
                                                 alt=""></a>
                                        <div class="product-o__action-wrap">
                                            <ul class="product-o__action-list">
                                                <li>

                                                    <a data-modal="modal" data-modal-id="#quick-look"
                                                       data-tooltip="tooltip" data-placement="top" title="Quick View"><i
                                                            class="fas fa-search-plus"></i></a></li>
                                                <li>

                                                    <a data-modal="modal" data-modal-id="#add-to-cart"
                                                       data-tooltip="tooltip" data-placement="top"
                                                       title="Add to Cart"><i class="fas fa-plus-circle"></i></a></li>
                                                <li>

                                                    <a href="signin.jsp" data-tooltip="tooltip" data-placement="top"
                                                       title="Add to Wishlist"><i class="fas fa-heart"></i></a></li>
                                                <li>

                                                    <a href="signin.jsp" data-tooltip="tooltip" data-placement="top"
                                                       title="Email me When the price drops"><i
                                                            class="fas fa-envelope"></i></a></li>
                                            </ul>
                                        </div>
                                    </div>

                                    <span class="product-o__category">

                                            <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.SHOP)}">Electronics</a></span>

                                    <span class="product-o__name">

                                            <a href="product-detail.jsp">Razor Gear Ultra Slim 16GB Ram</a></span>
                                    <div class="product-o__rating gl-rating-style"><i class="fas fa-star"></i><i
                                            class="fas fa-star"></i><i class="fas fa-star"></i><i
                                            class="fas fa-star"></i><i class="fas fa-star"></i>

                                        <span class="product-o__review">(20)</span></div>

                                    <span class="product-o__price">$125.00

                                            <span class="product-o__discount">$160.00</span></span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--====== End - Section Content ======-->
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

                                                <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.SHOP)}">Manufacturer</a></li>
                                            <li>

                                                <a href="dash-payment-option.jsp">Finance</a></li>
                                            <li>

                                                <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.SHOP)}">Shop</a></li>
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

                                                <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.SHOP)}">Store</a></li>
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
                                        <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.HOME_PAGE)}">Home</a>
                                    </li>
                                    <li class="is-marked">
                                        <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.SHOP)}?category=${requestScope.product.category.name}">${requestScope.product.category.name}</a>
                                    </li>
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

                                    <span class="pd-detail__preview-desc">${requestScope.product.description}</span>
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

                                    <a class="s-option__link btn--e-white-brand-shadow" href="cart.jsp">VIEW CART</a>

                                    <a class="s-option__link btn--e-brand-shadow" href="checkout.jsp">PROCEED TO
                                        CHECKOUT</a></div>
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