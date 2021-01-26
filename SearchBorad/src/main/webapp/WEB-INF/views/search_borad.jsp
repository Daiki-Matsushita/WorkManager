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
		多重検索&emsp;&emsp;<input type="text" id="multiSearch" /><br>
		部分検索&emsp;&emsp;<input type="text" id="partialSearch" /><br>
		権限検索&emsp;&emsp;<input type="text" id="position" /><br>
		日付検索&emsp;&emsp;<input type="date" id="startSearchDate" /> ～ <input type="date" id="endSearchDate" /><br>
		<input id="search-button" type="button" onclick="makeTable()" value="検索">
	</f:form>
	<f:form name="resultform" action="${pageContext.request.contextPath }/searchborad/update_result" method="post" modelAttribute="searchBoradForm">

		<!--テーブル生成位置-->
		<table id="maintable">
			<thead>
				<tr>
					<th><input type="checkbox" class="allCheck" onclick="allCheck()"></th>
					<th>title</th>
					<th>position</th>
					<th>check_flg</th>
					<th>creat_at</th>
				</tr>
			</thead>
		</table>


		<f:input path="multiSearch" type="hidden" value="${searchBoradForm.multiSearch}" />
		<f:input path="partialSearch" type="hidden" value="${searchBoradForm.partialSearch}" />
		<f:input path="position" type="hidden" value="${searchBoradForm.position}" />
		<f:input path="startSearchDate" type="hidden" value="${searchBoradForm.startSearchDate}" />
		<f:input path="endSearchDate" type="hidden" value="${searchBoradForm.endSearchDate}" />
		<input id="update-button" type="button" onclick="updateCheckFlg()" value="更新">
	</f:form>
		<script>

			// 検索したidの配列
			var idArray = [];

			// 検索したcheckFlgの配列
			var checkFlgArray = [];

			var resultList = null;

			// ヘッダー行のチェックボックスをチェックした場合の制御
			function allCheck(){
				// チェックした場合、表のチェックボックスを全てチェックする
				if($(".allCheck").prop("checked")==true){
					$('input[name="checkbox"]').prop("checked", true);
				} // チェックをはずした場合、表のチェックボックスを全てチェック外す
				else {
					$('input[name="checkbox"]').prop("checked", false);
				}
			}

			// 更新ボタンを押下したときの制御
			function updateCheckFlg(){

				var len = $('.tbody').children().length;

				for(var i = 0; i < len ; i++){
					// 現状のIDとチェックボックスの状態を詰める＊＊＊＊＊＊＊＊＊＊＊
					idArray.push(resultList[i]["id"]);

					var checkBox = $("." + resultList[i]["id"]).prop("checked")
					if(checkBox==true){
						checkFlgArray.push("1");
					} else {
						checkFlgArray.push("0");
					}

					// ＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊
				}


				var reqParam = {
						"idArray" : idArray,
						"checkFlgArray" : checkFlgArray
				}

				$.ajax({
					// http通信方式をpostに設定
					type : "POST",
					// コンテキストタイプをjsonに設定
					contentType : "application/json",
					// submitしたときの移動するメソッドのURLを設定
					url : "${pageContext.request.contextPath }/searchborad/update_result",
					// 上記で作ったreqParamを、jsonの文字列の形式にpathingする
					data : JSON.stringify(reqParam),
					// データの形式をjsonに設定
					dataType: "json"
				}).then(function(resultBoradList){


					// テーブル本体を作成
					for (var i = 0; i < resultBoradList.length; i++) {

						if(resultBoradList[i]["checkFlg"]=="1"){
							$("." + resultBoradList[i]["id"]).prop("checked", true);
						} else {
							$("." + resultBoradList[i]["id"]).prop("checked", false);
						}

						$("." + resultBoradList[i]["id"] + "checkFlg").text(resultBoradList[i]["checkFlg"]);


					}

				});
			}

			// 検索ボタンを押したときの制御
			function makeTable(){

				// jQueryを使って、画面で入力されたものを全て取得
				var reqParam = {
						"multiSearch" : $("#multiSearch").val(),
						"partialSearch" : $("#partialSearch").val(),
						"position" : $("#position").val(),
						"startSearchDate" : $("#startSearchDate").val(),
						"endSearchDate" : $("#endSearchDate").val()
				};

				// ajaxを使って表を非同期で動的に作成する。
				$.ajax({
					// http通信方式をpostに設定
					type : "POST",
					// コンテキストタイプをjsonに設定
					contentType : "application/json",
					// submitしたときの移動するメソッドのURLを設定
					url : "${pageContext.request.contextPath }/searchborad/search_result",
					// 上記で作ったreqParamを、jsonの文字列の形式にpathingする
					data : JSON.stringify(reqParam),
					// データの形式をjsonに設定
					dataType: "json"
				// レスポンスを受けて（検索結果のリスト）によって、動的にhtmlタグを作って表を作る
				}).then(function(resultBoradList){

					// グローバルに定義して、後で（更新の時）使う
					resultList = resultBoradList;

					var tbody = document.createElement('tbody');
					tbody.setAttribute('class','tbody');

					var tr = null;

					// tr要素が存在する場合、一度tr要素をクリア
					if($('.tr') != null){
						$(".tbody").remove();
						$(".tr").remove();
					}

					// テーブル本体を作成
					for (var i = 0; i < resultBoradList.length; i++) {

						// tr要素を生成
						var tr = document.createElement('tr');
						tr.setAttribute('class','tr');

						// th・td部分のループ
						for (key in resultBoradList[0]) {
							// td要素を生成
							var td = document.createElement('td');

							// input要素を生成(checkbox)
							var inputCheckBox = document.createElement('input');

							// keyがidの場合チェックボックスを生成する
							if(key=="id"){

								// チェックボックスを生成する＊＊＊＊＊始め＊＊＊＊＊＊＊＊＊＊＊＊＊
								// input要素をチェックボックスにする
								inputCheckBox.setAttribute('type','checkbox');
								// name属性をつけて、「checkbox」という名前にする
								inputCheckBox.setAttribute('name','checkbox');
								// 更新処理のために、class属性の値をidの値をいれる（ユニークにする）
								// そのあと、更新ボタンを押下したときにこのIDで特定して値を取得して配列に詰める
								inputCheckBox.setAttribute('class',resultBoradList[i]["id"]);

								// 表のほうにもオンクリック要素をつける。
								// チェックしたら１、しなかったら０を設定するようにする
								inputCheckBox.onclick = function check(){
									if($('input[name="checkbox"]').prop("checked")==true){
										$('input[name="checkbox"]').val("1");
									} // チェックを外した場合、tdのほうのチェックボックスを全て外す
									else {
										$('input[name="checkbox"]').val("0");
									}
								}

								// レスポンスのjson配列のkey「checkFlg」のvalueが「１」だった場合、チェックする
								if(resultBoradList[i]["checkFlg"]=="1"){
									inputCheckBox.setAttribute('checked','checked');
								}
								// チェックボックスを生成する＊＊＊＊＊終わり＊＊＊＊＊＊＊＊＊＊＊＊＊

								// テーブルのDOMの一番最後の階層であるtdタグの後ろにinputCheckBox要素を追加する
								td.appendChild(inputCheckBox);

							} // checkFlgの場合
							else if(key=="checkFlg"){
								td.setAttribute('class',resultBoradList[i]["id"] + "checkFlg");

							// id・checkFlg以外の場合そのままテーブルに値を代入する
							} else {
								// td要素内にテキストを追加
								td.textContent = resultBoradList[i][key];
							}

							// td要素をtr要素の子要素に追加
							tr.appendChild(td);

						}
						// tr要素をtable要素の子要素に追加
						tbody.appendChild(tr);
					}
					// 生成したtable要素を追加する
					document.getElementById('maintable').appendChild(tbody);

					// 表を生成した後にもう一度for文を回して、checkFLgに値を詰めていく
					for (var i = 0; i < resultBoradList.length; i++) {
						for (key in resultBoradList[0]) {
							$("." + resultBoradList[i]["id"] + "checkFlg").text(resultBoradList[i]["checkFlg"]);
						}
					}
				});
			}
		</script>
</body>
</html>
