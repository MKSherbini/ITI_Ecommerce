<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="pageCommon.jsp" %>

<c:choose>
    <c:when test="${empty sessionScope.user}">
        <%@include file="mainHeader.jsp"%>
    </c:when>
    <c:when test="${!empty sessionScope.user}">
        <%@include file="userHeader.jsp"%>
    </c:when>
</c:choose>
