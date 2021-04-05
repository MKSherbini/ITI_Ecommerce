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

