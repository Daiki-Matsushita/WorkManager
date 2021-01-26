
function searchForm() {
		if(window.location.hash){
			var identificationNumber = window.location.hash.replace('#', '');
			var reqParam = {"identificationNumber" : identificationNumber};
			$.ajax({
	    		type : "POST",
	    		contentType : "application/json;charset=utf-8",
	    		url : "search_result",
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
					searchInput.setAttribute('onclick', 'searchData()');
					searchInput.setAttribute('value', '検索');
					document.getElementById("search").appendChild(searchInput);
			    		},
	    		error : function() {
	                alert('error');
	         }
	   		});
			
		}
		
	}
	
	function searchData(){
		
		var searchResultList = [];
		var identificationNumber = window.location.hash.replace('#', '');
		
		$("input[name='tableValue']").each(function(i) {
			searchResultList.push($(this).val());
			});
		
		// jQueryを使って、画面で入力されたものを全て取得
		var reqParam = {
				"identificationNumber" : identificationNumber,
				"searchResultList" : searchResultList
		};
	 
		// ajaxを使って表を非同期で動的に作成する。
		$.ajax({
			// http通信方式をpostに設定
			type : "POST",
			// コンテキストタイプをjsonに設定
			contentType : "application/json",
			// submitしたときの移動するメソッドのURLを設定
			url : "search_data",
			// 上記で作ったreqParamを、jsonの文字列の形式にpathingする
			data : JSON.stringify(reqParam),
			// データの形式をjsonに設定
			dataType: "json"
		// レスポンスを受けて（検索結果のリスト）によって、動的にhtmlタグを作って表を作る
		}).then(function(resultList){
			$("#headTableInfo").html('');
			$("#bodyTableInfo").html('');
			var searchResults = resultList.searchResultList;
			var identificationNum = resultList.identificationNum;
			var tableColumList = resultList.tableColumList;
			
			//$.each(tableColumList , function(i){
				// $("#headTableInfo")
					//	  .append($('<th>',	{text : tableColumList[i].columnName}));		  
			 //});
			
			var tr = document.createElement('tr');
			var cell = document.createElement("th");
			var inputCheckBox = document.createElement('input');
			inputCheckBox.setAttribute('type','checkbox');
			inputCheckBox.setAttribute('id','allCheck');
			cell.appendChild(inputCheckBox);
			tr.appendChild(cell);
			 $.each(tableColumList , function(i){
				 cell = document.createElement("th");
				 var cellText = document.createTextNode(tableColumList[i].columnName);
				 cell.appendChild(cellText);
			     tr.appendChild(cell);
			 });
			document.getElementById('headTableInfo').appendChild(tr);
			
			$.each(searchResults , function(i){
				// stampevent table
				if(identificationNum=="A5"){
					 $("#bodyTableInfo").append($('<tr>')
							  .append($('<td>',	{html : "<input type='checkbox' class='check' value= '"+searchResults[i].stampEventId+"'>"}))
							  .append($('<td>',	{text : searchResults[i].stampEventId}))
							  .append($('<td>',	{text : searchResults[i].stampId }))
							  .append($('<td>',	{text : searchResults[i].eventSpace}))
							  .append($('<td>',	{text : searchResults[i].eventContents}))
							  .append($('<td>',	{text : searchResults[i].deleteFlg})));
				}
				// reservation history
				if(identificationNum=="A7"){
					 $("#bodyTableInfo").append($('<tr>')
							  .append($('<td>',	{html : "<input type='checkbox' class='check' value= '"+searchResults[i].stampEventId+"'>"}))
							  .append($('<td>',	{text : searchResults[i].reservationId}))
							  .append($('<td>',	{text : searchResults[i].reservationContents}))
							  .append($('<td>',	{text : searchResults[i].customerId }))
							  .append($('<td>',	{text : searchResults[i].ownerId}))
							  .append($('<td>',	{text : searchResults[i].reservationDate}))
							  .append($('<td>',	{text : searchResults[i].reservationTime}))
							  .append($('<td>',	{text : searchResults[i].serviceEstimatedTime}))
							  .append($('<td>',	{text : searchResults[i].deleteFlg}))
							  .append($('<td>',	{text : searchResults[i].customerPhoneNumber})));
				}
				// Service history table
				if(identificationNum=="A9"){
					 $("#bodyTableInfo").append($('<tr>')
							  .append($('<td>',	{html : "<input type='checkbox' class='check' value= '"+searchResults[i].stampEventId+"'>"}))
							  .append($('<td>',	{text : searchResults[i].serviceId}))
							  .append($('<td>',	{text : searchResults[i].serviceContents}))
							  .append($('<td>',	{text : searchResults[i].serviceMoney }))
							  .append($('<td>',	{text : searchResults[i].serviceImg}))
							  .append($('<td>',	{text : searchResults[i].customerId}))
							  .append($('<td>',	{text : searchResults[i].ownerId}))
							  .append($('<td>',	{text : searchResults[i].serviceDate})));
				}
			});
			
			var checkedList = [];
			 $("input[class='check']").click(function(i) {
				  if($(this).is(":checked")){
					  var tr = $(this).parents('tr');
					  var td = tr.children();
					  checkedList.push(td.eq(1).text());
					  $("#checkList").val(checkedList);
					  $("#identificationNumber").val(identificationNum);
							  
				   }else{
						checkedList.push("");
				   }
			  });
			
		});
		
		var registrateBtn = document.createElement("a");
		var linkText = document.createTextNode("登録");
		registrateBtn.appendChild(linkText);
		registrateBtn.title = '登録';
		registrateBtn.href = "/HappyBeautyManager/manage/registrate";
		registrateBtn.id = 'searchButton';
		registrateBtn.setAttribute('class', 'btn');
		document.getElementById("registrate").appendChild(registrateBtn);
		
		
		var deleteBtn = document.createElement("input");
		deleteBtn.setAttribute('type', 'submit');
		deleteBtn.setAttribute('class', 'btn btn-primary');
		deleteBtn.setAttribute('value', '削除');
		document.getElementById("delete").appendChild(deleteBtn);
		
		//var deleteBtn = document.createElement("a");
		//linkText = document.createTextNode("削除");
		//deleteBtn.appendChild(linkText);
		//deleteBtn.title = '削除';
		//deleteBtn.href = "/HappyBeautyManager/manage/delete";
		//deleteBtn.id = 'searchButton';
		//deleteBtn.setAttribute('class', 'btn');
		//document.getElementById("delete").appendChild(deleteBtn);
		
		
	}
	
	['hashchange', 'load'].forEach(event => window.addEventListener(event, searchForm));