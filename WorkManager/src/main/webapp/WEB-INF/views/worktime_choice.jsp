<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="true"%>
<html>
<head>
<title>worktime_choice</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
</head>
<body class="container">
	<br><br><br><br><br><br><br><br><br>
	<h1>勤務時間選択画面</h1>
	<span class="alert-success">【${member.name}】さん、お疲れ様です。勤務時間を入力してください。</span>
	<br><br><br>

	<f:form
		action="${pageContext.request.contextPath }/member/regist"
		method="get" modelAttribute="worktimeChoiceForm">


		<div class="form-group row">
			<div class="col-sm-10 btn-group" data-toggle="buttons">
				<label class="btn btn-outline-secondary active" style="width:50%">
					<input type="radio" name="month" value="0">先月
				</label>
				<label class="btn btn-outline-secondary" style="width:50%">
					<input type="radio" name="month" value="1" checked="checked">今月
				</label>
			</div>
		</div>

		<p>
			<label class="control-label col-xs-2">出社時間</label>
			<select class="form-control" name="startTime">
				<option value="${member.dfStartTime}">${member.dfStartTime}</option>
				<c:forEach var="obj" items="${worktimeList}" varStatus="status">
					<option value="${obj}">${obj}</option>
				</c:forEach>
			</select>
		</p>

		<p>
			<label class="control-label col-xs-2">退社時間</label>
			<select class="form-control" name="endTime">
				<option value="${member.dfEndTime}">${member.dfEndTime}</option>
				<c:forEach var="obj" items="${worktimeList}" varStatus="status">
					<option value="${obj}">${obj}</option>
				</c:forEach>
			</select>
		</p>

		<!-- ★　セッションの箱にログイン情報を詰めたので不要になった。<f:input path="memberId" type="hidden" value="${member.id}" /> -->
		<f:input path="memberId" type="hidden" value="${member.id}" />
		<input type="submit" value="設定" class="btn btn-danger btn-lg" >

	</f:form>

</body>
</html>
