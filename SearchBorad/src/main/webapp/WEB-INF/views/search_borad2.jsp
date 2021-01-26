<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<title>SearchBorad</title>
</head>
<body>
<h1>
	検索掲示板
</h1>
	<f:form name="searchform" action="${pageContext.request.contextPath }/searchborad/search_result" method="post" modelAttribute="searchBoradForm">
		多重検索&emsp;&emsp;<f:input type="text" path="multiSearch" valule="${searchBoradForm.multiSearch}" /><br>
		部分検索&emsp;&emsp;<f:input type="text" path="partialSearch" valule="${searchBoradForm.partialSearch}" /><br>
		権限検索&emsp;&emsp;<f:input type="text" path="position" valule="${searchBoradForm.position}" /><br>
		日付検索&emsp;&emsp;<f:input type="date" path="startSearchDate" valule="${searchBoradForm.startSearchDate}" /> ～ <f:input type="date" path="endSearchDate" valule="${searchBoradForm.endSearchDate}" /><br>
		<input id="search-button" type="submit" value="検索">
	</f:form>
	<f:form name="resultform" action="${pageContext.request.contextPath }/searchborad/update_result" method="post" modelAttribute="searchBoradForm">
		<table id="table">
			<tr>
				<th><input type="checkbox" class="allCheck" onclick="allCheck()"></th>
				<th>title</th>
				<th>position</th>
				<th>check_flg</th>
				<th>creat_at</th>
			</tr>
			<c:forEach var="obj" items="${boradList}" varStatus="status">
				<tr>
					<f:input path="id" type="hidden" value="${obj.id}" />
					<f:input path="checkFlg" class="${obj.id}req" type="hidden" />
					<td><input type="checkbox" class="${obj.id}" name="checkbox"></td>
					<td>${obj.title}</td>
					<td>${obj.position}</td>
					<td>${obj.checkFlg}</td>
					<td>${obj.creatAt}</td>
				</tr>
			</c:forEach>
		</table>
		<f:input path="multiSearch" type="hidden" value="${searchBoradForm.multiSearch}" />
		<f:input path="partialSearch" type="hidden" value="${searchBoradForm.partialSearch}" />
		<f:input path="position" type="hidden" value="${searchBoradForm.position}" />
		<f:input path="startSearchDate" type="hidden" value="${searchBoradForm.startSearchDate}" />
		<f:input path="endSearchDate" type="hidden" value="${searchBoradForm.endSearchDate}" />
		<input id="update-button" type="button" onclick="updateCheckFlg()" value="更新">
	</f:form>
		<script>

			<c:forEach var="obj" items="${boradList}" varStatus="status">
				var checkFlgVal = "${obj.checkFlg}"
				if(checkFlgVal=="1"){
					$(".${obj.id}").prop("checked", true);
				} else {
					$(".${obj.id}").prop("checked", false);
				}
			</c:forEach>

			function updateCheckFlg(){

				<c:forEach var="obj" items="${boradList}" varStatus="status">
					var checkBox = $(".${obj.id}").prop("checked")
					if(checkBox==true){
						$(".${obj.id}req").val("1");
					} else {
						$(".${obj.id}req").val("0");
					}
				</c:forEach>

				document.resultform.action = "${pageContext.request.contextPath }/searchborad/update_result";
				document.resultform.submit();
			}

			function allCheck(){
				if($(".allCheck").prop("checked")==true){
					$('input[name="checkbox"]').prop("checked", true);
				} else {
					$('input[name="checkbox"]').prop("checked", false);
				}
			}

		</script>
</body>
</html>
