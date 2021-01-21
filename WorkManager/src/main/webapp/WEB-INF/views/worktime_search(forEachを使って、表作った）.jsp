<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="true"%>
<html>
<head>
<title>worktime_search</title>
</head>
<body>
	<h1>勤務時間検索画面</h1>
	${manager.name}様、ようこそお越しくださいました！

	<f:form action="${pageContext.request.contextPath }/member/search" method="get" modelAttribute="worktimeSearchForm">
		<p>
			年：<f:select path="year"><f:option value="" /><f:options items="${searchYearList}" /></f:select>
		</p>
		<p>
			月：<f:select path="month"><f:option value="" /><f:options items="${searchMonthList}" /></f:select>
		</p>
		<p>
			氏名：<f:select path="name"><f:option value="" /><f:options items="${memberNameList}" /></f:select>
		</p>
		<input type="submit" value="検索">
	</f:form>

	<f:form action="${pageContext.request.contextPath }/member/search" method="get" modelAttribute="worktimeSearchForm">
		<table id="table">
			<tr>
				<th>年</th>
				<th>月</th>
				<th>氏名</th>
				<th>合計勤務時間</th>
			</tr>
			<c:forEach var="obj" items="${worktimeSearchResult}" varStatus="status">
				<tr>
					<f:input path="memberId" type="hidden" value="${obj.memberId}" />
					<td>${obj.year}</td>
					<td>${obj.month}</td>
					<td>${obj.name}</td>
					<td>${obj.sumWorktime}</td>
				</tr>
			</c:forEach>
		</table>
	</f:form>

</body>
</html>
