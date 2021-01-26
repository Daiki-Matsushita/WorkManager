<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>SearchBorad</title>
</head>
<body>
<h1>
	検索掲示板
</h1>
	<f:form action="${pageContext.request.contextPath }/searchborad/search_result" method="post" modelAttribute="searchBoradForm">
		多重検索&emsp;&emsp;<f:input type="text" path="multiSearch" /><br>
		部分検索&emsp;&emsp;<f:input type="text" path="partialSearch" /><br>
		権限検索&emsp;&emsp;<f:input type="text" path="position" /><br>
		日付検索&emsp;&emsp;<f:input type="date" path="startSearchDate" /> ～ <f:input type="date" path="endSearchDate" /><br>
		<input type="submit" value="検索">
	</f:form>
</body>
</html>
