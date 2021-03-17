<div class="col-lg-3 col-md-4 col-sm-6">
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
                <a href="shop-side-version-2.jsp">${product.category}</a></div>
            <%--product name--%>
            <div class="product-m__name">
                <a href="product-detail.jsp">${product.name}</a></div>
            <%--product price--%>
            <div class="product-m__price">${product.price}
                <span class="product-m__discount">${product.discount}</span></div>
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

