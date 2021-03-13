<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="Commons/pageCommon.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <%@include file="Commons/headCommon.jsp" %>
    <title>${applicationScope.urlMappingConstants.getTitle(PageNames.SIGN_IN_PAGE)}</title>


    <!-- Custom styles for this template -->
    <link href="<c:url value='Styles/signin.css'/>" rel="stylesheet">
</head>
<body class="text-center">

<main class="form-signin">
    <form method="post" action="signin">
        <img class="mb-4" src="Images/logo.png" alt="" width="72" height="57">
        <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
        <label for="inputEmail" class="visually-hidden">Email address</label>
        <input name="email" type="email" id="inputEmail" class="form-control" placeholder="Email address" required
               autofocus>
        <label for="inputPassword" class="visually-hidden">Password</label>
        <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <div class="checkbox mb-3">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <c:if test="${!empty requestScope.userError}">
            <span style='color:#f44336;'>Wrong user data</span>
        </c:if>
        <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
        <p class="mt-5 mb-3 text-muted">&copy; 2020</p>
    </form>
</main>


</body>
</html>
