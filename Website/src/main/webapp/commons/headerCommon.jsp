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


                <!--====== Search Form ======-->
                <form class="main-form"
                      action="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.SHOP)}">

                    <label for="main-search"></label>

                    <input class="input-text input-text--border-radius input-text--style-1"
                           value="${requestScope.paramSearch}"
                           type="text" id="main-search" name="search" placeholder="Search">

                    <%--                    <c:forEach items="${requestScope.requestParams}" var="requestParam">--%>
                    <%--                        <c:forEach items="${requestParam.value}"--%>
                    <%--                                   var="paramValue">--%>
                    <%--                            <c:if test="${!requestParam.key.equals(WebsiteConstants.paramSearchName)}">--%>
                    <%--                                <input type='hidden' name='${requestParam.key}'--%>
                    <%--                                       value='${paramValue}'/>--%>
                    <%--                            </c:if>--%>
                    <%--                        </c:forEach>--%>
                    <%--                    </c:forEach>--%>

                    <button class="btn btn--icon fas fa-search main-search-button" type="submit"></button>
                </form>
                <!--====== End - Search Form ======-->


                <!--====== Dropdown Main plugin ======-->
                <div class="menu-init" id="navigation">

                    <button class="btn btn--icon toggle-button fas fa-cogs" type="button"></button>

                    <!--====== Menu ======-->
                    <div class="ah-lg-mode">

                        <span class="ah-close">✕ Close</span>

                        <!--====== List ======-->
                        <ul class="ah-list ah-list--design1 ah-list--link-color-secondary">
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

                                            <a href="dashboard.html"><i class="fas fa-user-circle u-s-m-r-6"></i>

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
                                <div class="mini-cart">

                                    <!--====== Mini Product Container ======-->
                                    <div class="mini-product-container gl-scroll u-s-m-b-15">

                                        <c:forEach items="${sessionScope.cart.cartItems}" var="item">

                                            <!--====== Card for mini cart ======-->
                                            <div class="card-mini-product">
                                                <div class="mini-product">
                                                    <div class="mini-product__image-wrapper">

                                                        <a class="mini-product__link"
                                                           href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.PRODUCT)}?ref=${item.productId}">

                                                            <img class="u-img-fluid"
                                                                 src="${item.imageSrc}"
                                                                 alt="${item.name}"></a>
                                                    </div>
                                                    <div class="mini-product__info-wrapper">

                                                                    <span class="mini-product__category">

                                                                        <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.SHOP)}?category=${item.categoryName}">${item.categoryName}</a></span>

                                                        <span class="mini-product__name">

                                                                        <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.PRODUCT)}?ref=${item.productId}">${item.name}</a></span>

                                                        <span class="mini-product__quantity product-${item.productId}-productQuantity">${item.productQuantity} x</span>

                                                        <span class="mini-product__price">$${item.price}</span>
                                                    </div>
                                                </div>

                                                <a class="mini-product__delete-link far fa-trash-alt"
                                                   onclick="removeCartItem(${item.productId});"></a>
                                            </div>
                                            <!--====== End - Card for mini cart ======-->

                                        </c:forEach>

                                    </div>
                                    <!--====== End - Mini Product Container ======-->


                                    <!--====== Mini Product Statistics ======-->
                                    <div class="mini-product-stat">
                                        <div class="mini-total">

                                            <span class="subtotal-text">SUBTOTAL</span>

                                            <span class="subtotal-value cart-total-price">$${sessionScope.cart.totalPrice}</span></div>
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
    <!--====== End - Nav 1 ======-->
</header>
