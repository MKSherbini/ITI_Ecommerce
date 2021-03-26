function setDynamicHref(elem, customParams) {
    let myHref = elem.dataset.href;
    let params;
    console.log(customParams);
    if (customParams !== void 0)
        params = customParams;
    else
        params = window.location.search;
    console.log(params);
    let exists = params.indexOf(myHref) !== -1;
    let base = window.location.pathname;
    if (exists) {
        let paramTokens = params.split(/[?&]/);
        params = base;
        if (paramTokens.length > 2) {
            let inserted = false;
            for (let i = 1; i < paramTokens.length; i++) {
                if (paramTokens[i] !== myHref) {
                    if (!inserted) {
                        params += "?" + paramTokens[i];
                        inserted = true;
                    } else {
                        params += "&" + paramTokens[i];
                    }
                }
            }
        }
    } else {
        if (params === "")
            params += "?" + myHref;
        else
            params += "&" + myHref;
    }

    elem.href = params;
}

function destroyPaginationParams() {
    let params = window.location.search;
    let exists = params.indexOf("page") !== -1;
    let base = window.location.pathname;
    console.log("exists " + exists);
    if (exists) {
        let paramTokens = params.split(/[?&]/);
        console.log("paramTokens " + paramTokens);
        params = base;
        if (paramTokens.length > 2) {
            let inserted = false;
            for (let i = 1; i < paramTokens.length; i++) {
                if (!paramTokens[i].startsWith("page")) {
                    console.log("paramTokens[i] " + paramTokens[i]);
                    if (!inserted) {
                        params += "?" + paramTokens[i];
                        inserted = true;
                    } else {
                        params += "&" + paramTokens[i];
                    }
                }
            }
        }
    }
    return params;
}

function fkingRunMyHref(elem) {
    window.location = elem.getElementsByTagName('a')[0].href
}

function fkingSetModal(product) {
    console.log(product);
    $("#add-to-cart").html(`<div class="modal-dialog modal-dialog-centered">
            <div class="modal-content modal-radius modal-shadow">
  
                <button class="btn dismiss-button fas fa-times close" type="button" data-dismiss="modal"></button>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-lg-6 col-md-12">
                            <div class="success u-s-m-b-30">
                                <div class="success__text-wrap"><i class="fas fa-check"></i>

                                    <span>Item is added successfully!</span></div>
                                <div class="success__img-wrap">

                                    <img class="u-img-fluid" src="${product.imageSrc}" alt="${product.name}"></div>
                                <div class="success__info-wrap">

                                    <span class="success__name">${product.name}</span>

                                    <span class="success__quantity">Quantity: 1</span>

                                    <span class="success__price">$${product.price}</span></div>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-12">
                            <div class="s-option">

                                <span class="s-option__text">1 item (s) in your cart</span>
                                <div class="s-option__link-box">

                                    <a class="s-option__link btn--e-white-brand-shadow close" data-dismiss="modal">CONTINUE
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
`)

}