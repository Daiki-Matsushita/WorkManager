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
<link
	href="https://fonts.googleapis.com/css?family=Nunito+Sans:400,600,700"
	rel="stylesheet">
	
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	
<link href="${pageContext.request.contextPath}/resources/css/manage.css" rel="stylesheet" />
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.18.0/jquery.validate.min.js"></script>

<script src="${pageContext.request.contextPath }/resources/js/main.js"></script>


<style type="text/css">

	#registrate, #delete { 
	 
	text-align:center;
	}

</style>

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
            <div id="search" style="float:right;"></div> <br> <br>
        </div>
        <br> <br>
        <div class="container">
				
				<table border="1" class="table table-striped table-bordered">
					<thead class="thead-dark" id="headTableInfo">
						
					</thead>
						<tbody id="bodyTableInfo">
							
						</tbody>
				</table>
				
				
				<form:form action="${pageContext.request.contextPath }/manage/delete" modelAttribute="searchForm">
					<input type="hidden" name="checkList" id="checkList" />
					<input type="hidden" name="identificationNumber" id="identificationNumber" />
					<div style="float:right;">
    					<div id="registrate" style="width:90px; display:inline-block;"></div>
    					<div id="delete" style="width:90px; display:inline-block;"></div>
					</div>
				</form:form>
            
        </div>
        
    </div>

		

</body>
</html>