<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="true"%>
<html>
<head>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
	<title>worktime_search</title>
</head>
<body class="container">
	<br><br><br><br><br><br><br><br><br>
	<h1>勤務時間検索画面</h1>
	<span class="alert-success">【${manager.name}】様、ようこそお越しくださいました！</span>
	<br><br>

	<f:form action="" method="post" modelAttribute="worktimeSearchForm">
		<p>
			年<f:select id="year" path="year" class="form-control" style="width:400px"><f:option value="" /><f:options items="${searchYearList}" /></f:select>
		</p>
		<p>
			月：<f:select id="month" path="month" class="form-control" style="width:400px"><f:option value="" /><f:options items="${searchMonthList}" /></f:select>
		</p>
		<p>
			氏名：<f:select id="name" path="name" class="form-control" style="width:400px"><f:option value="" /><f:options items="${memberNameList}" /></f:select>
		</p>

	</f:form>
	<input type="button" onclick="createSearchResultTable()" value="検索" class="btn btn-danger btn-lg" >

	<f:form name="resultTableForm"  modelAttribute="worktimeSearchForm">
		<br><br>

		<!--テーブル生成位置-->
		<table id="searchResultTable" class="table table-striped table-hover table-condensed table-responsive table-condensed">
			<thead>
				<tr>
					<th>メンバーID</th>
					<th>年</th>
					<th>月</th>
					<th>氏名</th>
					<th>合計勤務時間</th>
				</tr>
			</thead>
		</table>
	</f:form>

	<f:form id="inputForm" action="${pageContext.request.contextPath }/manager/confirm" modelAttribute="worktimeSearchForm">

		<f:input id="memberId" path="memberId" type="hidden"/>
		<f:input id="year" path="year" type="hidden"/>
		<f:input id="month" path="month" type="hidden"/>
		<f:input id="name" path="name" type="hidden"/>


	<!--// 行クリックをしたときに、その行のinputタグを動的に生成する
	// pathingする
	// サブミットする

	// この方法はformタグをサーバーへ値を送るための一時的な箱として扱い、画面表示はさせない方法

	// 他にもURLに例えばgetとかだと、http/workmanager/aaaa/aaa?個々のパラメータに値を＆で入れていく方法がある
	// postの場合もパラメータを代入して送る-->

	</f:form>


	<script>
		// 検索ボタンを押下したときに検索結果一覧を作る
		function createSearchResultTable(){
			// ｊQueryを使って、画面で入力された年/月/氏名の値を取得する
			var reqParam = {
				"year" : $("#year").val(),
				"month" : $("#month").val(),
				"name" : $("#name").val()
			};

			// ajaxを使って、表を非同期で動的に作成する。
			$.ajax({
				// http通信方式をpostに設定
				type : "POST",
				// コンテキストタイプをjsonに設定
				contentType : "application/json; charset=UTF-8",
				// submitしたときの移動するメソッドのURLを設定
				url : "${pageContext.request.contextPath }/manager/search",
				// 上記で作ったreqParamを、jsonの文字列の形式にpathingする
				data : JSON.stringify(reqParam),
				// データの形式をjsonに設定
				dataType: "json"
			}).then(function(worktimeSearchResultList){

				// tbody要素を生成する
				var tbody = document.createElement('tbody');
				tbody.setAttribute('class','tbody');

				// tr要素が存在する場合、一度tr要素をクリア
				if($('.tr') != null){
					$(".tbody").remove();
					$(".tr").remove();
				}

				// 検索結果テーブルを作成
				for(var i = 0; i < worktimeSearchResultList.length; i++) {	

					// tr要素を生成
					var tr = document.createElement('tr');
					tr.setAttribute('class','tr');

					// tr・td部分のループ
					for (key in worktimeSearchResultList[0]) {

						// td要素を生成
						var td = document.createElement('td');

						// input要素を生成
						var inputMemberId = document.createElement('input');
						var inputYear = document.createElement('input');
						var inputMonth = document.createElement('input');
						var inputName = document.createElement('input');


						if(key == "memberId"){
							td.textContent = worktimeSearchResultList[i][key];
							inputMemberId.setAttribute('type','hidden');
							inputMemberId.setAttribute('value',worktimeSearchResultList[i][key]);
							td.appendChild(inputMemberId);
						}
						// key名がyearだった場合、テーブルのカラムにテキストを追加する
						else if(key == "year"){
							// td要素内にテキストを追加
							td.textContent = worktimeSearchResultList[i][key];
							inputYear.setAttribute('type','hidden');
							inputYear.setAttribute('value',worktimeSearchResultList[i][key]);
							td.appendChild(inputYear);
						} else if(key == "month"){
							// td要素内にテキストを追加
							td.textContent = worktimeSearchResultList[i][key];
							inputMonth.setAttribute('type','hidden');
							inputMonth.setAttribute('value',worktimeSearchResultList[i][key]);
							td.appendChild(inputMonth);
						} else if(key == "name"){

							// ★ただ名前がラベルで表示されるだけ
							// td要素内にテキストを追加
							td.textContent = worktimeSearchResultList[i][key];
							inputName.setAttribute('type','hidden');
							inputName.setAttribute('value',worktimeSearchResultList[i][key]);
							td.appendChild(inputName);

							// ★文字リンクにしたい
							//ankerName.setAttribute('href', function(){
								//document.resultTableForm.submit();
							//});
							//ankerName.textContent = worktimeSearchResultList[i][key];

							// ★サブミットボタンができる
							//inputName.setAttribute('type','submit');
							//inputName.setAttribute('value',worktimeSearchResultList[i][key]);
							//td.appendChild(ankerName);

						} else if(key == "sumWorktime"){
							// td要素内にテキストを追加
							td.textContent = worktimeSearchResultList[i][key];
						}
						// td要素をtr要素の子要素に追加
						tr.appendChild(td);
					}
					// tr要素をtable要素の子要素に追加
					tbody.appendChild(tr);
				}
				// 生成したtable要素を追加する
				document.getElementById('searchResultTable').appendChild(tbody);
			});
		}

		// 行をクリックされたときに、その行の値をサーバーに送る
		$(document).on('click','.tr',function (){
			var memberId = $(this).children('td:eq(0)').children('input:eq(0)').val();
			var year = $(this).children('td:eq(1)').children('input:eq(0)').val();
			var month = $(this).children('td:eq(2)').children('input:eq(0)').val();
			var name = $(this).children('td:eq(3)').children('input:eq(0)').val();
			$('#inputForm #memberId').val(memberId);
			$('#inputForm #year').val(year);
			$('#inputForm #month').val(month);
			$('#inputForm #name').val(name);
			$('#inputForm').submit();
		});


	</script>
</body>
</html>
