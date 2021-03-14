<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<%@include file="Commons/pageCommon.jsp" %>
<html>

<head>
    <%@include file="commons/headCommon.jsp" %>
</head>

<header>
    <%@include file="commons/headerCommon.jsp" %>
    <%--    custom tags could help with this--%>
    <title>${applicationScope.urlMappingConstants.getTitle(PageNames.HOME_PAGE)}</title>
</header>
<body>
<a href="${applicationScope.urlMappingConstants.getControllerUrl(PageNames.SIGN_IN_PAGE)}"
   class="btn btn-primary">${applicationScope.urlMappingConstants.getTitle(PageNames.SIGN_IN_PAGE)}</a>
<a href="search.jsp" class="btn btn-primary">search</a>
<a href="search2.jsp" class="btn btn-primary">search2</a>

<footer>
    <%@include file="commons/footerCommon.jsp" %>
</footer>
</body>
</html>