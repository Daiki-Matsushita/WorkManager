<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>login</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
</head>
<body class="container">
<br><br><br><br><br><br><br><br><br><br><br><br><br>
<h1>
	ログイン画面
</h1>
	<f:form action="${pageContext.request.contextPath }/member/loginProcess" method="post" modelAttribute="loginForm">
		<f:input type="password" path="password" class="form-control"/>
		<input type="submit" value="ログイン"  class="btn btn-danger btn-lg">
		<f:errors path="password" />
		<span class="alert-success">${message}</span>
	</f:form>
</body>
</html>
