<%--
  Created by IntelliJ IDEA.
  User: osos
  Date: 15-Mar-21
  Time: 7:36 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="productTag" uri="/WEB-INF/CustomTags/taglib.tld" %>
<%@include file="commons/pageCommon.jsp" %>

<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800" rel="stylesheet">

    <!--====== Vendor Css ======-->
    <link rel="stylesheet" href="styles/css/vendor.css">

    <!--====== Utility-Spacing ======-->
    <link rel="stylesheet" href="styles/css/utility.css">

    <!--====== App ======-->
    <link rel="stylesheet" href="styles/css/app.css">
<%--    <link rel="stylesheet" href="styles/css/usersTable.css">--%>
    <title>Title</title>
    <%@include file="commons/headCommon.jsp" %>
</head>
<body>
<header class="header--style-1 header--box-shadow">
    <%@include file="commons/headerCommon.jsp" %>
</header>
<div class="dash__box dash__box--shadow dash__box--bg-white dash__box--radius">
    <h2 class="dash__h2 u-s-p-xy-20" style="text-align: center">USERS TABLE</h2>
    <div class="dash__table-wrap gl-scroll">
        <table class="dash__table">
            <thead>
            <thead style="background-color: orangered">
                <th style="color: white"><b>id</b></th>
                <th style="color: white"><b>firstName</b></th>
                <th style="color: white"><b>lastName</b></th>
                <th style="color: white"><b>userName</b></th>
                <th style="color: white"><b>password</b></th>
                <th style="color: white"><b>email</b></th>
            <thead>
            </thead>
            <tbody>
            <tr>
                <c:forEach items="${requestScope.userList}" var="user">
                    <%@include file="custom/user.jsp" %>
                </c:forEach>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<%@ include file="loginfooter.jsp" %>
</body>
</html>

