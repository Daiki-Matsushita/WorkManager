<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="true"%>
<html>
<head>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<title>worktime_regist</title>
</head>
<body>
	<h1>勤務時間登録画面</h1>
	${year}年${month}月

	<f:form
		action="${pageContext.request.contextPath }/member/registProcess"
		method="post" modelAttribute="worktimeRegistForm">

		<table id="table">
			<tr>
				<th>日</th>
				<th>曜日</th>
				<th>出社時間</th>
				<th>退社時間</th>
				<th>休み時間</th>
				<th>備考</th>
			</tr>
			<c:forEach var="obj" items="${wtList}" varStatus="status">
				<tr>
					<td>${obj.workDate}</td>
					<td class="week">${obj.week}</td>
					<td><f:select path="worktimeRegistFormList[${status.index}].startTime"><f:option value="${obj.startTime}" /><f:options items="${worktimeList}" /></f:select></td>
					<td><f:select path="worktimeRegistFormList[${status.index}].endTime"><f:option value="${obj.endTime}" /><f:options items="${worktimeList}" /></f:select></td>
					<td><f:select path="worktimeRegistFormList[${status.index}].restTime"><f:options items="${worktimeList}" /></f:select></td>
					<td><f:input type="text" path="worktimeRegistFormList[${status.index}].memo" value="${obj.memo}"/></td>
				</tr>
			</c:forEach>
		</table>

		<f:input path="year" type="hidden" value="${year}" />
		<f:input path="month" type="hidden" value="${month}" />
		<!--<f:input path="memberId" type="hidden" value="${memberId}" /> -->
		<input type="submit" value="設定">
	</f:form>

	<script>
		$( '#table' ).find( 'td.week' ).each(function(index){b
			var weekArry=["日","月","火","水","木","金","土"];

			var i = $(this).text();

			if (i==0) {
				$(this).text(weekArry[6]);
				$(this).css( 'color' , 'Blue' );
			} else if (i==1) {
				$(this).text(weekArry[i-1]);
				$(this).css( 'color' , 'Red' );
			} else {
				$(this).text(weekArry[i-1]);
			}
		});
	</script>
</body>
</html>
