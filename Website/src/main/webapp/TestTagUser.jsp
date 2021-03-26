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
    <link rel="stylesheet" href="styles/css/usersTable.css">
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
            <div class="container">
            <table>
                <thead>
                    <th>id</th>
                    <th>firstName</th>
                    <th>lastName</th>
                    <th>userName</th>
                    <th>password</th>
                    <th>email</th>
                <thead>
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
    </div>
    <%-- End of products grid --%>
</div>
</body>
</html>
