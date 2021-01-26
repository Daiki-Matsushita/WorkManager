<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>HappyBeautyManagerLogin</title>
<link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet" />
</head>
<body>

  <div class="login-box">
  
  <h2>ログイン画面</h2>
  <form:form action="loginProcess" method="POST" modelAttribute="loginForm">
    <div class="user-box">
      <form:input type="text" path="id"/>
      <form:errors path="id" cssClass="error" />
      <form:label path="id">ID</form:label>
    </div>
    <div class="user-box">
      <form:input type="password" path="password"/>
      <form:errors path="password" cssClass="error" />
      <form:label path="password">Password</form:label>
    </div>
    <a href="#">
      <span></span>
      <span></span>	
      <span></span>
      <span></span>
      <form:button type="submit">ログイン</form:button>
    </a>
  </form:form>
</div>
</body>
</html>