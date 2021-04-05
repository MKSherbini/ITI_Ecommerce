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
    let img = $("#modal-add-img");
    let msg = $("#modal-add-msg");
    let icon = $("#modal-add-icon");
    let name = $("#modal-add-name");
    let price = $("#modal-add-price");
    let itemsCount = $("#modal-add-itemsCount");

    img.attr("src", product.imageSrc);
    img.attr("alt", product.name);
    if (parseInt(product.addedQuantity) > 0) {
        msg.text("Item is added successfully!")
        icon.removeClass("fa-times-circle")
        icon.addClass("fa-check")
    } else {
        msg.text("Quantity not available")
        icon.removeClass("fa-check")
        icon.addClass("fa-times-circle")
    }
    name.text(product.name);
    price.text(`$${product.price}`);
    itemsCount.text(`${product.totalInCart} item (s) in your cart`);

}