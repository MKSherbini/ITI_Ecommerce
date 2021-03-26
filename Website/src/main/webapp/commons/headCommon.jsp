<meta charset="UTF-8">
<!--[if IE]><meta http-equiv="X-UA-Compatible" content="IE=edge"><![endif]-->
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link href="images/favicon.png" rel="shortcut icon">
<title>Ludus - Electronics, Apparel, Computers, Books, DVDs & more</title>

<!--====== Google Font ======-->
<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800" rel="stylesheet">

<!--====== Vendor Css ======-->
<link rel="stylesheet" href="styles/css/vendor.css">

<!--====== Utility-Spacing ======-->
<link rel="stylesheet" href="styles/css/utility.css">

<!--====== App ======-->
<link rel="stylesheet" href="styles/css/app.css">

<script>
    function removeFromCart(productId) {
        $.get("${applicationScope.urlMappingConstants.getServiceUrl(ServiceNames.PRODUCT_REMOVE_FROM_CART)}?${WebsiteConstants.paramProductId}=" + productId, function (data, status) {
            console.log(data);
            if (status === "success")
                window.location.reload(true);
        });
    }
</script>