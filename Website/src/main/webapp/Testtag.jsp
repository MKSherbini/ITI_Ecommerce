<%--
  Created by IntelliJ IDEA.
  User: Hadeer
  Date: 15-Mar-21
  Time: 7:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  prefix="productTag" uri="/WEB-INF/CustomTags/taglib.tld" %>
<html>
<head>
    <title>Title</title>
    <%@include file="commons/headCommon.jsp" %>
</head>
<body>

<div id="app">
        <%@include file="commons/headerCommon.jsp" %>
    <div class="row">
        <productTag:product/>
    </div>
</div>
</body>
</html>
