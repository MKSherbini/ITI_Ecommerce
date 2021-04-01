<%@include file="commons/pageCommon.jsp" %>

<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
    <%@include file="commons/headCommon.jsp" %>

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
</head>
<body class="config">
<div class="preloader is-active">
    <div class="preloader__wrap">

        <img class="preloader__img" src="images/preloader.png" alt=""></div>
</div>

<!--====== Main App ======-->
<div id="app">

    <!--====== Main Header ======-->
    <%@ include file="commons/headerCommon.jsp" %>
    <!--====== End - Main Header ======-->

    <!--====== App Content ======-->
    <div class="app-content">

        <!--====== Section 1 ======-->
        <div class="u-s-p-y-60">

            <!--====== Section Content ======-->
            <div class="section__content">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 u-s-m-b-30">
                            <div class="empty">
                                <div class="empty__wrap">

                                    <span class="empty__big-text">404</span>

                                    <span class="empty__text-1">Looks like you're in wrong place.</span>

                                    <a class="empty__redirect-link btn--e-brand" href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.HOME_PAGE)}">GO TO HOME</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--====== End - Section Content ======-->
        </div>
        <!--====== End - Section 1 ======-->
    </div>
    <!--====== End - App Content ======-->


    <!--====== Footer ======-->
    <jsp:include page="commons/footerCommon.jsp"/>
    <!--====== End - Footer ======-->
</div>
<!--====== End - Main App ======-->


<!--====== Google Analytics: change UA-XXXXX-Y to be your site's ID ======-->
<script>
    window.ga = function() {
        ga.q.push(arguments)
    };
    ga.q = [];
    ga.l = +new Date;
    ga('create', 'UA-XXXXX-Y', 'auto');
    ga('send', 'pageview')
</script>
<script src="https://www.google-analytics.com/analytics.js" async defer></script>

<!--====== Vendor Js ======-->
<script src="scripts/js/vendor.js"></script>
<%--    <script src="<c:url value='scripts/js/vendor.js'/>"></script>--%>

<!--====== jQuery Shopnav plugin ======-->
<script src="scripts/js/jquery.shopnav.js"></script>
<%--    <script src="<c:url value='scripts/js/jquery.shopnav.js'/>"></script>--%>

<!--====== App ======-->
<script src="scripts/js/app.js"></script>
<%--    <script src="<c:url value='scripts/js/app.js'/>"></script>--%>

<!--====== Noscript ======-->
<noscript>
    <div class="app-setting">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="app-setting__wrap">
                        <h1 class="app-setting__h1">JavaScript is disabled in your browser.</h1>

                        <span class="app-setting__text">Please enable JavaScript in your browser or upgrade to a JavaScript-capable browser.</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</noscript>
</body>
</html>