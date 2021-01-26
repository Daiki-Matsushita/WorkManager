<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>manage</title>
<link href="${pageContext.request.contextPath}/resources/css/auth.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
</style>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.2.0.min.js"></script>

<script type="text/javascript">

function search(){
	if(window.location.hash){
		var tableName = window.location.hash.replace('#', '');
		var reqParam = {"tableValue" : tableName};
	$.ajax({
		type : "POST",
		data: JSON.stringify(reqParam),
		dataType : "json",
		contentType : "application/json;charset=utf-8",
		url : "/HappyBeautyManager/auth/selectTableProcess",
		success : function(result) {
			$("#conditionTable").html('');
			 var results = result.tableColumList;
			 var identificationNum = result.identificationNum;
			 $.each(results , function(i){
				 $("#conditionTable").append($('<tr>')
							  .append($('<td>',	{text : results[i].columnName}))
							  .append($('<td>',	{html : "<input type='text' name='searchWord' >"})));
			 });
			 $("#conditionTable").append($('<tr>')
			  		  .append($('<td>',	{html : "<input type='hidden' name='identificationNumber' id='identificationNum' value='"+identificationNum+"' >"}))
						 .append($('<td>',	{html : "<input type='submit'　id='searchButton' class='searchButton' onclick='goSearch()'  value='検索' >"})));
			
	    		},
	    		
		error : function(e) {
            alert('エラ-');
     }
		});
	}
}
function goSearch(){
	
	var tableName = window.location.hash.replace('#', '');
	 var searchResultList = [];
	 $("input[name='searchWord']").each(function(i) {
		 searchResultList.push($(this).val());
	    });

	 var  sendObject = {
             "searchResultList" : searchResultList,      
             "tableValue":tableName     
         };
	 $.ajax({
			type : "POST",
			data: JSON.stringify(sendObject),
			dataType : "json",
			contentType : "application/json;charset=utf-8",
			url : "/HappyBeautyManager/auth/searchProcess",
			success : function(result) {
				$("#searchResultTable").html('');
				$("#authButtonSection").html('');
				 var searchResults = result.searchResultList;
				 var identificationNum = result.identificationNum;
				 var tableColumList = result.tableColumList;
				 $("#searchResultTable")
				 .append($('<td>',	{html : "<input type='checkbox' id='allCheck' >"}));
					
				 $.each(tableColumList , function(i){
					 $("#searchResultTable")
							  .append($('<th>',	{text : tableColumList[i].columnName}));
							  
				 });
				 $.each(searchResults , function(i){
					 if(identificationNum=="B1"){
						 $("#searchResultTable").append($('<tr>')
								  .append($('<td>',	{html : "<input type='checkbox' class='check' >"}))
								  .append($('<td>',	{text : searchResults[i].reservationOwnerId}))
								  .append($('<td>',	{text : searchResults[i].managerId}))
								  .append($('<td>',	{text : searchResults[i].reservationDeleteFlg}))
								  .append($('<td>',	{text : searchResults[i].judgmentFlg}))
								  .append($('<td>',	{text : searchResults[i].resarvationCreateDate}))
								  .append($('<td>',	{text : searchResults[i].ownerId}))
								  .append($('<td>',	{text : searchResults[i].securityId}))
								  .append($('<td>',	{text : searchResults[i].shopName}))
								  .append($('<td>',	{text : searchResults[i].shopCity}))
								  .append($('<td>',	{text : searchResults[i].shopTown}))
								  .append($('<td>',	{text : searchResults[i].shopPhoneNumber}))
								  .append($('<td>',	{text : searchResults[i].ownerPhoneNumber}))
								  .append($('<td>',	{text : searchResults[i].ownerPassword}))
								  .append($('<td>',	{text : searchResults[i].auth}))
								  .append($('<td>',	{text : searchResults[i].deleteFlg}))
								  .append($('<td>',	{text : searchResults[i].shopImg}))
								  .append($('<td>',	{text : searchResults[i].ownerLoginId}))
								  .append($('<td>',	{text : searchResults[i].shopDetailAddress}))
								  .append($('<td>',	{text : searchResults[i].shopTypeId}))
								  .append($('<td>',	{text : searchResults[i].shopOpenTime}))
								  .append($('<td>',	{text : searchResults[i].shopCloseTime}))
								  .append($('<td>',	{text : searchResults[i].reservationIntervalTime}))
								  .append($('<td>',	{text : searchResults[i].createDate}))
								  );
								  
				 
						 }
					 if(identificationNum=="B5"){
						 $("#searchResultTable").append($('<tr>')
								  .append($('<td>',	{html : "<input type='checkbox' class='check' >"}))
								  .append($('<td>',	{text : searchResults[i].reservationChargehistoryId}))
								  .append($('<td>',	{text : searchResults[i].managerId}))
								  .append($('<td>',	{text : searchResults[i].reservationDeleteFlg}))
								  .append($('<td>',	{text : searchResults[i].judgmentFlg}))
								  .append($('<td>',	{text : searchResults[i].resarvationCreateDate}))
								  .append($('<td>',	{text : searchResults[i].chargeId}))
								  .append($('<td>',	{text : searchResults[i].chargeMoney}))
								  .append($('<td>',	{text : searchResults[i].customerId}))
								  .append($('<td>',	{text : searchResults[i].ownerId}))
								  .append($('<td>',	{text : searchResults[i].chargeDate}))
								  .append($('<td>',	{text : searchResults[i].deleteFlg})));
								  
				 
						 }
					 if(identificationNum=="B7"){
						 $("#searchResultTable").append($('<tr>')
								  .append($('<td>',	{html : "<input type='checkbox' class='check'  value='1' >"}))
								  .append($('<td>',	{text : searchResults[i].reservationStampeventId}))
								  .append($('<td>',	{text : searchResults[i].managerId}))
								  .append($('<td>',	{text : searchResults[i].reservationDeleteFlg}))
								  .append($('<td>',	{text : searchResults[i].judgmentFlg}))
								  .append($('<td>',	{text : searchResults[i].resarvationCreateDate}))
								  .append($('<td>',	{text : searchResults[i].stampEventId}))
								  .append($('<td>',	{text : searchResults[i].stampId}))
								  .append($('<td>',	{text : searchResults[i].eventSpace}))
								  .append($('<td>',	{text : searchResults[i].eventContents}))
								  .append($('<td>',	{text : searchResults[i].deleteFlg})));
						  
								  
				 
						 }
					});
				 $("#allCheck").click(function(){ 
					  //allCheckのチェックボックスがチェックされた場合
					  if($("#allCheck").prop("checked")) {
						 //全体のcheckboxチェックされる
						  $('.check').prop("checked",true);
						   //allCheckのチェックボックスがチェックがされてない場合
						} else {
							//全体のcheckboxチェックしない。
							$('.check').prop("checked",false);
						}
				 });
				  var checkedList = [];
				 $("input[class='check']").click(function(i) {
					  if($(this).is(":checked")){
						  var tr = $(this).parents('tr');
						  var td = tr.children();
							  checkedList.push(td.eq(1).text());
							   $("#checkedList").val(checkedList);
							   $("#identificationNumber").val(identificationNum);
								  
						  }else{
							  checkedList.push("");
							  }
				    });
				 
				 $("#authButtonSection")
					.append($('<li>',{html : "<input type='submit'　id='authButton' class='authButton' onclick='location.href="+"\"${pageContext.request.contextPath }/auth/authConfirmProcess\""+"'  value='承認' >"}))
					.append($('<li>',{html : "<input type='submit'　id='rejectButton' class='rejectButton' onclick='location.href="+"\"${pageContext.request.contextPath }/auth/authConfirmProcess\""+"'   value='却下' >"}));
				
		    		},
		    		
			error : function(e) {
	            alert('エラ-');
	     }
			});



	    
}

['hashchange', 'load'].forEach(event => window.addEventListener(event, search));

</script>
</head>
<body>
	<header>
		<form:form action="dataManageProcess" method="POST"
			modelAttribute="dataManageProcessForm">
			<div class="col-xs-offset-1 col-xs-3">
				<input type="button" path="manage" value="データ管理 "> <input
					type="button" path="auth" value="テータ承認管理">
			</div>
		</form:form>

		<div class="col-xs-offset-9 col-xs-3">
			<table border=1>
				<tr>
					<td>ID : 1 or 2 *セッション情報</td>
				<tr>
					<td>ユーザ名 : 文 or 韓 *セッション情報</td>
				</tr>
				<tr>
					<td>権限 : id=""担当者 or 管理者 *セッション情報</td>
				</tr>
			</table>
		</div>
	</header>
	
		<aside id="sidebar">
			<ul id="tableName">
				<c:forEach items="${tableName}" var="tn" varStatus="stat">
					
                    <a class="results__link" href="#${tn.identificationNum }">
                    <li>${tn.tableName}</li>
                    <input type="hidden" value="${tn.identificationNum}"/>
					</a>
				</c:forEach>
			</ul>
		</aside>

	
	
		<section>
			
			<table id="conditionTable">
			<tbody>
			
			</tbody>
			
			</table>
				
		</section>

	<section id="resultSection">
	
      
     
	<table id="searchResultTable">
	<tbody>
		<thead>
		
		<thead>
		
			
		</tbody>
		</table>
		<form:form action="authConfirmProcess" modelAttribute="reservationSearchForm">
		<input type="hidden" name="checkedList" id="checkedList" />
		<input type="hidden" name="identificationNumber" id="identificationNumber" />
			<ul id="authButtonSection">
			</ul>
		</form:form>
		

	</section>

</body>
</html>