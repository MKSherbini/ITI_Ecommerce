<%--
  Created by IntelliJ IDEA.
  User: Hadeer
  Date: 15-Mar-21
  Time: 7:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="productTag" uri="/WEB-INF/CustomTags/taglib.tld" %>
<%@include file="commons/pageCommon.jsp" %>

<html>
<head>
    <title>Title</title>
    <%@include file="commons/headCommon.jsp" %>
</head>
<body>
<header class="header--style-1 header--box-shadow">
    <%@include file="commons/headerCommon.jsp" %>
</header>
<div id="app">
    <%--these are the divs for product grid--%>
    <div class="shop-p__collection">
        <div class="row is-grid-active">

        <c:forEach items="${requestScope.productList}" var="product">
            <%@include file="custom/product.jsp" %>
        </c:forEach>

        </div>
    </div>
    <%-- End of products grid --%>
</div>
</body>
</html>
