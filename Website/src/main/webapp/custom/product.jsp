<div class="col-lg-4 col-md-6 col-sm-6">
    <div class="product-m">
        <div class="product-m__thumb">
            <%--product image--%>
            <a class="aspect aspect--bg-grey aspect--square u-d-block" href="product-detail.jsp">
                <img class="aspect__img" src="${product.imageSrc}" alt=""></a>

            <div class="product-m__quick-look">
                <a class="fas fa-search" data-modal="modal" data-modal-id="#quick-look" data-tooltip="tooltip"
                   data-placement="top" title="Quick Look"></a></div>

            <div class="product-m__add-cart">
                <a class="btn--e-brand" data-modal="modal" data-modal-id="#add-to-cart">Add to Cart</a></div>
        </div>
        <%--product category--%>
        <div class="product-m__content">
            <div class="product-m__category">
                <a href="shop-side-version-2.jsp">${product.category.name}</a></div>
            <%--product name--%>
            <div class="product-m__name">
                <a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.PRODUCT)}?ref=${product.productId}">${product.name}</a></div>
            <c:choose>
                <c:when test="${product.discountPercent==0}">
                    <%--product price--%>
                    <div class="product-m__price">${product.price}</div>
                </c:when>
                <c:otherwise>
                    <%--product price--%>
                    <div class="product-m__price">${product.price * (1-(product.discountPercent/ 100))}
                        <span class="product-m__discount">${product.price}</span></div>
                </c:otherwise>
            </c:choose>
            <%--product description--%>
            <div class="product-m__hover">
                <div class="product-m__preview-description">
                    <span>${product.description}</span></div>

                <div class="product-m__wishlist">
                    <a class="far fa-heart" href="#" data-tooltip="tooltip" data-placement="top"
                       title="Add to Wishlist"></a></div>
            </div>
        </div>
    </div>
</div>

