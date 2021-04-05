<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="commons/pageCommon.jsp" %>

<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
    <title>${applicationScope.urlMappingConstants.getTitle(PageNames.Error)}</title>
    <%@include file="commons/headCommon.jsp" %>
</head>
<body class="config">
<div class="preloader is-active">
    <div class="preloader__wrap">

        <img class="preloader__img" src="images/preloader.png" alt=""></div>
</div>

<!--====== Main App ======-->
<div id="app">

    <!--====== Main Header ======-->
    <header class="header--style-1 header--box-shadow">
        <%@include file="commons/headerCommon.jsp" %>
    </header>
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

                                    <c:if test="${requestScope.statusCode=='208'}">
                                        <span class="empty__big-text">${requestScope.statusCode}</span>
                                        <span class="empty__big-text">${requestScope.errorMessage}</span>
                                        <span class="empty__text-1">Already Reported</span>
                                    </c:if>

                                    <c:if test="${requestScope.statusCode=='301'}">
                                        <span class="empty__big-text">${requestScope.statusCode}</span>
                                        <span class="empty__big-text">${requestScope.errorMessage}</span>
                                        <span class="empty__text-1">The URL of the requested resource has been changed permanently</span>
                                    </c:if>

                                    <c:if test="${requestScope.statusCode=='305'}">
                                        <span class="empty__big-text">${requestScope.statusCode}</span>
                                        <span class="empty__big-text">${requestScope.errorMessage}</span>
                                        <span class="empty__text-1">Please use proxy</span>
                                    </c:if>

                                    <c:if test="${requestScope.statusCode=='400'}">
                                        <span class="empty__big-text">${requestScope.statusCode}</span>
                                        <span class="empty__big-text">${requestScope.errorMessage}</span>
                                        <span class="empty__text-1">Bad request</span>
                                    </c:if>

                                    <c:if test="${requestScope.statusCode=='401'}">
                                        <span class="empty__big-text">${requestScope.statusCode}</span>
                                        <span class="empty__big-text">${requestScope.errorMessage}</span>
                                        <span class="empty__text-1">unauthorized</span>
                                    </c:if>

                                    <c:if test="${requestScope.statusCode=='402'}">
                                        <span class="empty__big-text">${requestScope.statusCode}</span>
                                        <span class="empty__big-text">${requestScope.errorMessage}</span>
                                        <span class="empty__text-1">Payment Required</span>
                                    </c:if>

                                    <c:if test="${requestScope.statusCode=='403'}">
                                        <span class="empty__big-text">${requestScope.statusCode}</span>
                                        <span class="empty__big-text">${requestScope.errorMessage}</span>
                                        <span class="empty__text-1">Forbidden</span>
                                    </c:if>

                                    <c:if test="${requestScope.statusCode=='404'}">
                                        <span class="empty__big-text">${requestScope.statusCode}</span>
                                        <span class="empty__big-text">${requestScope.errorMessage}</span>
                                        <span class="empty__text-1">Not Found</span>
                                    </c:if>

                                    <c:if test="${requestScope.statusCode=='404'}">
                                        <span class="empty__big-text">${requestScope.statusCode}</span>
                                        <span class="empty__big-text">${requestScope.errorMessage}</span>
                                        <span class="empty__text-1">Method not allowed</span>
                                    </c:if>

                                    <c:if test="${requestScope.statusCode=='408'}">
                                        <span class="empty__big-text">${requestScope.statusCode}</span>
                                        <span class="empty__big-text">${requestScope.errorMessage}</span>
                                        <span class="empty__text-1">TimeOut</span>
                                    </c:if>

                                    <c:if test="${requestScope.statusCode=='414'}">
                                        <span class="empty__big-text">${requestScope.statusCode}</span>
                                        <span class="empty__big-text">${requestScope.errorMessage}</span>
                                        <span class="empty__text-1">URI Too Long</span>
                                    </c:if>

                                    <c:if test="${requestScope.statusCode=='414'}">
                                        <span class="empty__big-text">${requestScope.statusCode}</span>
                                        <span class="empty__big-text">${requestScope.errorMessage}</span>
                                        <span class="empty__text-1">Unsupported Media Type</span>
                                    </c:if>

                                    <c:if test="${requestScope.statusCode=='429'}">
                                        <span class="empty__big-text">${requestScope.statusCode}</span>
                                        <span class="empty__big-text">${requestScope.errorMessage}</span>
                                        <span class="empty__text-1">Too many requests</span>
                                    </c:if>

                                    <c:if test="${requestScope.statusCode=='666'}">
                                        <span class="empty__big-text">${requestScope.statusCode}</span>
                                        <span class="empty__big-text">Site Error</span>
                                        <span class="empty__text-1">${requestScope.errorMessage}</span>
                                    </c:if>

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