<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="true"%>
<html>
<head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
	<script src="http://code.jquery.com/jquery-latest.js?version=3"></script>
	<title>worktime_confirm</title>
</head>
<body class="container">
	<h1>勤務時間確認画面</h1>
	${year}年${month}月<br>
	【${name}】様の勤務時間<br><br>

	<f:form name="myForm" action="${pageContext.request.contextPath }/manager/downloead" method="post" modelAttribute="worktimeConfirmForm">

		<table id="table" class="table table-striped table-hover table-condensed table-responsive table-condensed">
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
					<td>${obj.workDate}<f:input path="worktimeConfirmForm[${status.index}].day" type="hidden" value="${obj.workDate}" /></td>
					<td class="week">${obj.week}</td><f:input path="worktimeConfirmForm[${status.index}].week" type="hidden" value="${obj.week}" />
					<td>${obj.startTime}<f:input path="worktimeConfirmForm[${status.index}].startTime" type="hidden" value="${obj.startTime}" /></td>
					<td>${obj.endTime}<f:input path="worktimeConfirmForm[${status.index}].endTime" type="hidden" value="${obj.endTime}" /></td>
					<td>${obj.restTime}<f:input path="worktimeConfirmForm[${status.index}].restTime" type="hidden" value="${obj.restTime}" /></td>
					<td>${obj.memo}<f:input path="worktimeConfirmForm[${status.index}].memo" type="hidden" value="${obj.memo}" /></td>
				</tr>
			</c:forEach>
		</table>

		<f:input path="year" type="hidden" value="${year}" />
		<f:input path="month" type="hidden" value="${month}" />
		<f:input path="name" type="hidden" value="${name}" />

		<input type="submit" value="CSVダウンロード" class="btn btn-danger btn-lg">

	</f:form>

	<script>
		$( '#table' ).find( 'td.week' ).each(function(index){
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

		// ダウンロードボタンを押下した場合の制御
		function downloadCsv(){

			// サーバーに送る値（日数別に２次元配列にする）: 例[[1,火,,,],[2,水,,,]]
			var data;

			// テーブルオブジェクトを取得
			var table = document.getElementById('table');
			// テーブル内のtdタグを全て取得
			var cells = table.querySelectorAll('td');


			// tdタグの数分ループ
			for(var i = 0; i < cells.length; i++){
				// tdタグがnullでではない場合、value値を
				if(cells.item(i).firstChild != null){
					data = data + cells.item(i).firstChild.nodeValue + ", ";
					//console.log(cells.item(i).firstChild.nodeValue);
				} // tdタグがnullの場合且つ、ループ回数がtdタグの数より小さい場合、
				else if(cells.item(i).firstChild == null && i < cells.length - 1) {
					data = data + null + ", ";
					//console.log(null);
				} else {
					data = data + null;
				}
			}
			document.getElementById( "tableValue" ).value = data;
			document.myForm.action = '${pageContext.request.contextPath }/manager/downloead';
			document.myForm.submit();
		}
	</script>
</body>
</html>
