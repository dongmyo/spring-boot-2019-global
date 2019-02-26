<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<!DOCTYPE html>
<html>
<head lang="ko">
    <meta charset="UTF-8">
    <title>Main</title>
</head>
<body>
<h1>Main</h1>

<@security.authorize access="isAuthenticated()">
    <@security.authentication property="principal.name" />님,&nbsp;
    <a href="/logout">Logout</a>
</@security.authorize>
<@security.authorize access="!isAuthenticated()">
    <a href="/redirect-index">Login</a>
</@security.authorize>
<br />
<a href="/">Go to Main</a>
<br />
<br />
<br />

</body>
</html>
