<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="true"%>
<html>
<head>
<title>worktime_choice</title>
</head>
<body>
	<h1>勤務時間選択画面</h1>
	${member.name}

	<f:form
		action="${pageContext.request.contextPath }/member/regist"
		method="get" modelAttribute="worktimeChoiceForm">

		<p>
			<f:radiobutton path="month" value="0" />先月
			<f:radiobutton path="month" value="1" checked="checked" />今月

		</p>

		<p>
			出社時間：<br>
			<!-- pathだけで、nameとid属性二つの役割を持つ -->
			<f:select path="startTime">
				<f:option value="${member.dfStartTime}" />
				<f:options items="${worktimeList}" />
			</f:select>
		</p>

		<p>
			退社時間：<br>
			<f:select path="endTime">
				<f:option value="${member.dfEndTime}" />
				<f:options items="${worktimeList}" />
			</f:select>
		</p>

		<!-- ★　セッションの箱にログイン情報を詰めたので不要になった。<f:input path="memberId" type="hidden" value="${member.id}" /> -->
		<f:input path="memberId" type="hidden" value="${member.id}" />
		<input type="submit" value="設定">

	</f:form>

</body>
</html>
