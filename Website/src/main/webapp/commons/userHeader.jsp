<header class="header--style-1 header--box-shadow">

    <!--====== Nav 1 ======-->
    <nav class="primary-nav primary-nav-wrapper--border">
        <div class="container">

            <!--====== Primary Nav ======-->
            <div class="primary-nav">

                <!--====== Main Logo ======-->

                <a class="main-logo" href="index.html">

                    <img src="images/logo/logo-1.png" alt=""></a>
                <!--====== End - Main Logo ======-->


                <!--====== Search Form ======-->
                <form class="main-form">

                    <label for="main-search"></label>

                    <input class="input-text input-text--border-radius input-text--style-1" type="text" id="main-search" placeholder="Search">

                    <button class="btn btn--icon fas fa-search main-search-button" type="submit"></button></form>
                <!--====== End - Search Form ======-->


                <!--====== Dropdown Main plugin ======-->
                <div class="menu-init" id="navigation">

                    <button class="btn btn--icon toggle-button fas fa-cogs" type="button"></button>

                    <!--====== Menu ======-->
                    <div class="ah-lg-mode">

                        <span class="ah-close">✕ Close</span>
                        <!--====== List ======-->
                        <ul class="ah-list ah-list--design1 ah-list--link-color-secondary">
                            <span>Hello,<label style="color: black; font-weight: bold">${sessionScope.user.userName}</label></span>

                            <li class="has-dropdown" data-tooltip="tooltip" data-placement="left" title="Account">

                                <a><i class="far fa-user-circle"></i></a>

                                <!--====== Dropdown ======-->

                                <span class="js-menu-toggle"></span>
                                <ul style="width:120px">
                                    <li>

                                        <a href="account"><i class="fas fa-user-circle u-s-m-r-6"></i>

                                            <span>Account</span></a></li>
                                    <li>

                                        <a href="signout"><i class="fas fa-lock-open u-s-m-r-6"></i>

                                            <span>Signout</span></a></li>
                                </ul>
                                <!--====== End - Dropdown ======-->
                            </li>

                            <!--====== List ======-->
                            <li>

                                <a href="index.html"><i class="fas fa-home"></i></a></li>
                            <li>

                                <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.WISHLIST)}"><i class="far fa-heart"></i></a></li>
                            <li class="has-dropdown">

                                <a class="mini-cart-shop-link"><i class="fas fa-shopping-bag"></i>

                                    <span class="total-item-round">2</span></a>

                                <!--====== Dropdown ======-->

                                <span class="js-menu-toggle"></span>
                                <div class="mini-cart">

                                    <!--====== Mini Product Container ======-->
                                    <div class="mini-product-container gl-scroll u-s-m-b-15">

                                        <!--====== Card for mini cart ======-->
                                        <div class="card-mini-product">
                                            <div class="mini-product">
                                                <div class="mini-product__image-wrapper">

                                                    <a class="mini-product__link" href="product-detail.html">

                                                        <img class="u-img-fluid" src="images/product/electronic/product3.jpg" alt=""></a></div>
                                                <div class="mini-product__info-wrapper">

                                                                    <span class="mini-product__category">

                                                                        <a href="shop-side-version-2.html">Electronics</a></span>

                                                    <span class="mini-product__name">

                                                                        <a href="product-detail.html">Yellow Wireless Headphone</a></span>

                                                    <span class="mini-product__quantity">1 x</span>

                                                    <span class="mini-product__price">$8</span></div>
                                            </div>

                                            <a class="mini-product__delete-link far fa-trash-alt"></a>
                                        </div>
                                        <!--====== End - Card for mini cart ======-->


                                        <!--====== Card for mini cart ======-->
                                        <div class="card-mini-product">
                                            <div class="mini-product">
                                                <div class="mini-product__image-wrapper">

                                                    <a class="mini-product__link" href="product-detail.html">

                                                        <img class="u-img-fluid" src="images/product/electronic/product18.jpg" alt=""></a></div>
                                                <div class="mini-product__info-wrapper">

                                                                    <span class="mini-product__category">

                                                                        <a href="shop-side-version-2.html">Electronics</a></span>

                                                    <span class="mini-product__name">

                                                                        <a href="product-detail.html">Nikon DSLR Camera 4k</a></span>

                                                    <span class="mini-product__quantity">1 x</span>

                                                    <span class="mini-product__price">$8</span></div>
                                            </div>

                                            <a class="mini-product__delete-link far fa-trash-alt"></a>
                                        </div>
                                        <!--====== End - Card for mini cart ======-->


                                        <!--====== Card for mini cart ======-->
                                        <div class="card-mini-product">
                                            <div class="mini-product">
                                                <div class="mini-product__image-wrapper">

                                                    <a class="mini-product__link" href="product-detail.html">

                                                        <img class="u-img-fluid" src="images/product/women/product8.jpg" alt=""></a></div>
                                                <div class="mini-product__info-wrapper">

                                                                    <span class="mini-product__category">

                                                                        <a href="shop-side-version-2.html">Women Clothing</a></span>

                                                    <span class="mini-product__name">

                                                                        <a href="product-detail.html">New Dress D Nice Elegant</a></span>

                                                    <span class="mini-product__quantity">1 x</span>

                                                    <span class="mini-product__price">$8</span></div>
                                            </div>

                                            <a class="mini-product__delete-link far fa-trash-alt"></a>
                                        </div>
                                        <!--====== End - Card for mini cart ======-->


                                        <!--====== Card for mini cart ======-->
                                        <div class="card-mini-product">
                                            <div class="mini-product">
                                                <div class="mini-product__image-wrapper">

                                                    <a class="mini-product__link" href="product-detail.html">

                                                        <img class="u-img-fluid" src="images/product/men/product8.jpg" alt=""></a></div>
                                                <div class="mini-product__info-wrapper">

                                                                    <span class="mini-product__category">

                                                                        <a href="shop-side-version-2.html">Men Clothing</a></span>

                                                    <span class="mini-product__name">

                                                                        <a href="product-detail.html">New Fashion D Nice Elegant</a></span>

                                                    <span class="mini-product__quantity">1 x</span>

                                                    <span class="mini-product__price">$8</span></div>
                                            </div>

                                            <a class="mini-product__delete-link far fa-trash-alt"></a>
                                        </div>
                                        <!--====== End - Card for mini cart ======-->
                                    </div>
                                    <!--====== End - Mini Product Container ======-->


                                    <!--====== Mini Product Statistics ======-->
                                    <div class="mini-product-stat">
                                        <div class="mini-total">

                                            <span class="subtotal-text">SUBTOTAL</span>

                                            <span class="subtotal-value">$16</span></div>
                                        <div class="mini-action">

                                            <a class="mini-link btn--e-brand-b-2" href="checkout.html">PROCEED TO CHECKOUT</a>

                                            <a class="mini-link btn--e-transparent-secondary-b-2" href="cart.html">VIEW CART</a></div>
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