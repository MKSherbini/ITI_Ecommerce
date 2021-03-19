<%-- cart item product--%>
<div class="card-mini-product">
    <div class="mini-product">
        <div class="mini-product__image-wrapper">
            <a class="mini-product__link" href="product-detail.html">
                <img class="u-img-fluid" src="${cartItem.product.imageSrc}" alt="">
            </a>
        </div>
        <div class="mini-product__info-wrapper">
             <span class="mini-product__category">
                 <a href="shop-side-version-2.html">${cartItem.product.category.name}</a>
             </span>
            <span class="mini-product__name">
                <a href="product-detail.html">${cartItem.product.name}</a>
            </span>
            <span class="mini-product__quantity">${cartItem.quantity}</span>
            <span class="mini-product__price">${cartItem.product.price}</span>
        </div>
    </div>
    <a class="mini-product__delete-link far fa-trash-alt"></a>
</div>
<!--====== End - Card for mini cart ======-->
</div>
<!--====== End - Mini Product Container ======-->
