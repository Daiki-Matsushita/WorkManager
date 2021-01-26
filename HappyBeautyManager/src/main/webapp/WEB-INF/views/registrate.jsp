<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link href="https://fonts.googleapis.com/css?family=Nunito+Sans:400,600,700" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="${pageContext.request.contextPath}/resources/css/manage.css" rel="stylesheet" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script type="text/javascript">

	function registrateForm() {
		if(window.location.hash){
			var tableName = window.location.hash.replace('#', '');
			var reqParam = {"value" : tableName};
			$.ajax({
	    		type : "POST",
	    		contentType : "application/json;charset=utf-8",
	    		url : "${pageContext.request.contextPath}/manage/search_result",
	    		data: JSON.stringify(reqParam),
	    		dataType : "json",
	    		success : function(result) {
	    			$("#headTable").html('');
	    			$("#bodyTable").html('');
	    			$("#search").html('');
	    			var results = result.tableColumList;
	    			var tr = document.createElement('tr');
	    			 $.each(results , function(i){
	    				 var cell = document.createElement("th");
	    				 var cellText = document.createTextNode(results[i].columnName);
	    				 cell.appendChild(cellText);
	    			     tr.appendChild(cell);
	    			 });
					document.getElementById('headTable').appendChild(tr);
					var row = document.createElement('tr');
					$.each(results , function(i){
	    				 var cell = document.createElement("td");
	    				 var input = document.createElement('input');
	    				 input.setAttribute('type', 'text');
	    				 input.setAttribute('name', 'tableValue');
	    				 cell.appendChild(input);
	    			     row.appendChild(cell);
	    			 });
					document.getElementById('bodyTable').appendChild(row);
					
					var searchInput = document.createElement("input");
					searchInput.setAttribute('type', 'submit');
					searchInput.setAttribute('id', 'searchButton');
					searchInput.setAttribute('class', 'btn btn-primary');
					searchInput.setAttribute('onclick', 'registrateData()');
					searchInput.setAttribute('value', '登録');
					document.getElementById("search").appendChild(searchInput);
			    		},
	    		error : function() {
	                alert('error');
	         }
	   		});
			
		}
		
	}
	
	function registrateData(){
		
		var searchResultList = [];
		var tableName = window.location.hash.replace('#', '');
		
		$("input[name='tableValue']").each(function(i) {
			searchResultList.push($(this).val());
			});
		
		// jQueryを使って、画面で入力されたものを全て取得
		var reqParam = {
				"tableName" : tableName,
				"searchResultList" : searchResultList
		};
	 
		// ajaxを使って表を非同期で動的に作成する。
		$.ajax({
			// http通信方式をpostに設定
			type : "POST",
			// コンテキストタイプをjsonに設定
			contentType : "application/json",
			// submitしたときの移動するメソッドのURLを設定
			url : "${pageContext.request.contextPath }/manage/registrate_processing",
			// 上記で作ったreqParamを、jsonの文字列の形式にpathingする
			data : JSON.stringify(reqParam),
			// データの形式をjsonに設定
			dataType: "json"
		// レスポンスを受けて（検索結果のリスト）によって、動的にhtmlタグを作って表を作る
		}).then(function(resultList){
			var test = resultList.insertResult;
			$("#headTable").html('');
			$("#bodyTable").html('');
			$("#search").html('');
			document.getElementById("result").appendChild(document.createTextNode(test));
		});
		
		
	}
	
	['hashchange', 'load'].forEach(event => window.addEventListener(event, registrateForm));
	
	
	

</script>

<title>Happy Beauty</title>
</head>
<body>

	<div class="container-">
        <header class="header">
        	<h1 class = "header__logo">HAPPY BEAUTY MANAGER</h1>
        	
        </header>


        <div class="results">
            <ul class="results__list">
                <c:forEach items="${tablesList}" var="e">
                <li>
                    <a class="results__link" href="#${e.identificationNum }">
                        <div class="results__data">
                            <h1 class="results__name">${e.tableName}</h1>
                        </div>
                    </a>
                </li>
                </c:forEach>
                
            </ul>

        </div>


		
        <div class="table">
        <br> <br>
    		<div class="container">
				
				<table border="1" class="table table-striped table-bordered">
					<thead class="thead-dark" id="headTable">
						
					</thead>
						<tbody id="bodyTable">
							
						</tbody>
				</table>
            	<div id="search"></div>
            	
            	<div style="font-size: 500%" class="alert alert-warning alert-dismissible fade show" role="alert">
  					<h1 id="result"></h1>
		        </div>
        	</div>
        	<br> <br> 
    	</div>

	</div>

</body>
</html>