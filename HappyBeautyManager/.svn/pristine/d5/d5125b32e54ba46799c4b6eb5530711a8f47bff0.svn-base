<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>manage</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
html {
	height: 100%;
}

body {
	margin: 0;
	padding: 0;
}

#sidebar {
	width: 300px;
	height: 100%;
	top: 0;
	left: 0px;
	bottom: position: fixed;
}

#sidebar>ul {
	margin: 0;
	padding: 0;
	top: 50px;
	left: 70px;
	position: absolute;
}

#sidebar li {
	margin: 0 0 20px;
	list-style: none;
}
</style>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.2.0.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#tableName").each(function() {
			var selectedTable = $(this).children();
			selectedTable.each(function() {
				$(this).click(function() {
					var result = $(this).children().val();
					$("#selectedTableResult").val(result);
					$('#tableForm').submit();
				});
			});

		});
	});
</script>
</head>
<body>
	<header>
		<form:form action="dataManageProcess" method="POST"
			modelAttribute="dataManageProcessForm">
			<div class="col-xs-offset-1 col-xs-3">
				<input type="button" path="manage" value="データ管理 "> <input
					type="button" path="auth" value="テータ承認管理">
			</div>
		</form:form>

		<div class="col-xs-offset-9 col-xs-3">
			<table border=1 width=180 height=80>
				
				<tr>				
					<td>ID :0</td>
				<tr>
					<td>ユーザ名 : ${userName}</td>
				</tr>
				<tr>				
					<td>権限 : 
						<c:if test="${auth==false}">担当者</c:if>
						<c:if test="${auth==true}">管理者</c:if>
					</td>
				</tr>
			</table>
		</div>
	</header>
	<form:form id="tableForm" action="selectTableProcess" method="post"
		modelAttribute="TableForm">
		<aside id="sidebar">
			<ul id="tableName">
				<c:forEach items="${tablesList}" var="tn" varStatus="stat">
					<li>${tn.value}<input type="hidden"
						value="${tn.identificationNum}" /></li>
				</c:forEach>
			</ul>
		</aside>
		<input type="hidden" id="selectedTableResult" name="selectedTable">

	</form:form>

	<section id="conditionSection"></section>
	<section id="resultSection"></section>

</body>
</html>