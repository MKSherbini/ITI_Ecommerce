<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="header--style-1 header--box-shadow">

    <!--====== Nav 1 ======-->

    <nav class="primary-nav primary-nav-wrapper--border">
        <div class="container">

            <!--====== Primary Nav ======-->
            <div class="primary-nav">

                <!--====== Main Logo ======-->

                <a class="main-logo"
                   href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.HOME_PAGE)}">

                    <img src="images/logo/logo-1.png" alt=""></a>
                <!--====== End - Main Logo ======-->
                <c:if test="${empty sessionScope.admin}">
                <form class="main-form"
                      action="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.SHOP)}">

                    <label for="main-search"></label>

                    <input class="input-text input-text--border-radius input-text--style-1"
                           value="${requestScope.paramSearch}"
                           type="text" id="main-search" name="search" placeholder="Search">
                    <button class="btn btn--icon fas fa-search main-search-button" type="submit"></button>
                </form>
                    </c:if>
                <!--====== Dropdown Main plugin ======-->
                <div class="menu-init" id="navigation">

                    <button class="btn btn--icon toggle-button fas fa-cogs" type="button"></button>

                    <!--====== Menu ======-->
                    <div class="ah-lg-mode">

                        <span class="ah-close">✕ Close</span>

                        <!--====== List ======-->
                        <ul class="ah-list ah-list--design1 ah-list--link-color-secondary">
                            <c:choose>
                            <c:when test="${!empty sessionScope.admin}">
                                <span>Hello, <label style="color: black; font-weight: bold">Admin</label></span>
                                <%--Logged In User--%>
                                <!--====== Dropdown ======-->

<%--ADMINISTRATOR Drop Down List --%>
                                    <li class="has-dropdown" data-tooltip="tooltip" data-placement="left" title="Signout">
                                        <a href="${applicationScope.urlMappingConstants.getServiceUrl(ServiceNames.SIGN_OUT)}"><i class="fas fa-lock-open u-s-m-r-6"></i></a></li>

                                    <li class="has-dropdown" data-tooltip="tooltip" data-placement="left" title="Show Users">
                                        <a href="userDash"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-table" viewBox="0 0 16 16">
                                            <path d="M0 2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2zm15 2h-4v3h4V4zm0 4h-4v3h4V8zm0 4h-4v3h3a1 1 0 0 0 1-1v-2zm-5 3v-3H6v3h4zm-5 0v-3H1v2a1 1 0 0 0 1 1h3zm-4-4h4V8H1v3zm0-4h4V4H1v3zm5-3v3h4V4H6zm4 4H6v3h4V8z"/>
                                        </svg></a>

                                    <li class="has-dropdown" data-tooltip="tooltip" data-placement="left" title="Add Product">
                                        <a href="addproduct"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-bag-plus-fill" viewBox="0 0 16 16">
                                            <path fill-rule="evenodd" d="M10.5 3.5a2.5 2.5 0 0 0-5 0V4h5v-.5zm1 0V4H15v10a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2V4h3.5v-.5a3.5 3.5 0 1 1 7 0zM8.5 8a.5.5 0 0 0-1 0v1.5H6a.5.5 0 0 0 0 1h1.5V12a.5.5 0 0 0 1 0v-1.5H10a.5.5 0 0 0 0-1H8.5V8z"/>
                                        </svg></a>


<%--USER Drop Down List--%>



<%--                                </ul>--%>
                                <!--====== End - Dropdown ======-->
                            </li>

                            <!--====== List ======-->

<%--USER HEART,BASKET--%>


                        </ul>
                        <!--====== End - List ======-->
                    </div>
                    </ul>
                    <!--====== End - List ======-->

                </div>
                <!--====== End - Menu ======-->
            </div>
            <!--====== End - Dropdown Main plugin ======-->
        </div>
        <!--====== End - Primary Nav ======-->
        </div>
    </nav>
        </c:when>
    </c:choose>
    <!--====== End - Nav 1 ======-->
<%--    Not Admin****************************************************************************--%>

<c:choose>
    <c:when test="${empty sessionScope.admin}">

                            <c:if test="${empty sessionScope.user}">
                                <span>Hello, <label style="color: black; font-weight: bold">User</label></span>
                            </c:if>
                            <c:if test="${!empty sessionScope.user}">
                                <span>Hello, <label
                                        style="color: black; font-weight: bold">${sessionScope.user.userName}</label></span>
                            </c:if>


                            <li class="has-dropdown" data-tooltip="tooltip" data-placement="left" title="Account">

                                <a><i class="far fa-user-circle"></i></a>

                                <!--====== Dropdown ======-->

                                <span class="js-menu-toggle"></span>
                                <ul style="width:120px">
                                    <c:if test="${empty sessionScope.user}">
                                        <li>

                                            <a href="signup"><i class="fas fa-user-plus u-s-m-r-6"></i>

                                                <span>Signup</span></a></li>
                                        <li>

                                            <a href="signin"><i class="fas fa-lock u-s-m-r-6"></i>

                                                <span>Signin</span></a></li>
                                    </c:if>
                                    <c:if test="${!empty sessionScope.user}">
                                        <li>

                                            <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.Account)}"><i class="fas fa-user-circle u-s-m-r-6"></i>

                                                <span>Account</span></a></li>
                                        <li>

                                            <a href="${applicationScope.urlMappingConstants.getServiceUrl(ServiceNames.SIGN_OUT)}"><i
                                                    class="fas fa-lock-open u-s-m-r-6"></i>

                                                <span>Signout</span></a></li>
                                    </c:if>
                                </ul>
                                <!--====== End - Dropdown ======-->
                            </li>

                            <!--====== List ======-->
                            <li>

                                <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.SHOP)}"><i
                                        class="fas fa-store-alt"></i></a></li>
                            <li>

                                <a href="wishlist.html"><i class="far fa-heart"></i></a></li>
                            <li class="has-dropdown">

                                <a class="mini-cart-shop-link"><i class="fas fa-shopping-bag"></i>

                                    <span class="total-item-round cart-total-itemsCount">${sessionScope.cart.totalItemsCount}</span></a>

                                <!--====== Dropdown ======-->

                                <span class="js-menu-toggle"></span>
                                <div id="mini-cart" class="mini-cart">

                                    <!--====== Mini Product Container ======-->
                                    <%@include file="../custom/mini-cart.jsp" %>
                                    <!--====== End - Mini Product Container ======-->


                                    <!--====== Mini Product Statistics ======-->
                                    <div class="mini-product-stat">
                                        <div class="mini-total">

                                            <span class="subtotal-text">SUBTOTAL</span>

                                            <span class="subtotal-value cart-total-price">$${sessionScope.cart.totalPrice}</span>
                                        </div>
                                        <div class="mini-action">

                                            <a class="mini-link btn--e-brand-b-2"
                                               href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.CHECKOUT)}">PROCEED
                                                TO
                                                CHECKOUT</a>

                                            <a class="mini-link btn--e-transparent-secondary-b-2"
                                               href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.CART)}">VIEW
                                                CART</a></div>
                                    </div>
                                    <!--====== End - Mini Product Statistics ======-->
                                </div>
                                <!--====== End - Dropdown ======-->
                            </li>
                        </ul>
                        <!--====== End - List ======-->
                    </div>
                    </ul>
                    <!--====== End - List ======-->

                </div>
                <!--====== End - Menu ======-->
            </div>
            <!--====== End - Dropdown Main plugin ======-->
        </div>
        <!--====== End - Primary Nav ======-->
        </div>
    </nav>
        </c:when>
        </c:choose>
</header>
