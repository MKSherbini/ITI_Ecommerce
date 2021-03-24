function setDynamicHref(elem) {
    let myHref = elem.dataset.href;
    let params = window.location.search;
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

var getUrlParameter = function getUrlParameter(sParam) {
    var sPageURL = window.location.search.substring(1),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return typeof sParameterName[1] === undefined ? true : decodeURIComponent(sParameterName[1]);
        }
    }
    return false;
};
