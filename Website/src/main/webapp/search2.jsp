<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<sql:setDataSource driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/chatapp" user="mks" password="jets"
	var="db" scope="session" />

<html>
<style>
table {
	border-collapse: collapse;
	width: 100%;
	border: 1px solid #ddd;
}

th, td {
	text-align: left;
	padding: 16px;
}
</style>

<div
	style="max-width: max-content; margin-top: 50px; margin-left: auto; margin-right: auto;">
	<div style="margin-left: 20px;">
		<h1>Registration form</h1>
	</div>
	<div style="margin-left: 10px;">please enter the first name or
		part of it</div>
	<FORM method="post">
		<BR> <b> FirstName:</b><INPUT
			style="margin-left: 12px; margin-top: 5px; margin-bottom: 5px;"
			TYPE=TEXT NAME=query> <INPUT TYPE="SUBMIT" VALUE="Submit">
	</FORM>
</div>
<c:if test="${!empty param.query}">
	<sql:query var="result" dataSource="${db}"
		sql="select * from user where firstName like '%${param.query}%' or lastName like '%${param.query}%'" />
</c:if>

<c:if test="${!empty result}">

	<table>
		<tr>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Username</th>
			<th>Password</th>
		</tr>
		<c:forEach items="${result.rows}" var="user">
			<tr>
				<th><c:out value="${user.firstName}" /></th>
				<th><c:out value="${user.lastName}" /></th>
				<th><c:out value="${user.userName}" /></th>
				<th><c:out value="${user.password}" /></th>
			</tr>
		</c:forEach>
	</table>
</c:if>

</body>
</html>
