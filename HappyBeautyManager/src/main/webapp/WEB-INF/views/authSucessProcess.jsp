<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/auth.css" rel="stylesheet" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link
	href="https://fonts.googleapis.com/css?family=Nunito+Sans:400,600,700"
	rel="stylesheet">
	
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style type="text/css">
	* {
  margin: 0;
  padding: 0; }

*,
*::before,
*::after {
  box-sizing: inherit; }

html {
  box-sizing: border-box;
  font-size: 62.5%; }
  @media only screen and (max-width: 68.75em) {
    html {
      font-size: 50%; } }

body {
  font-family: 'Nunito Sans', sans-serif;
  font-weight: 400;
  line-height: 1.6;
  color: #655A56;
  background-image: linear-gradient(to right bottom, #FEF5E7, #FDEBD0 );
  background-size: cover;
  background-repeat: no-repeat;
  min-height: calc(100vh - 2 * 4vw); }

.container- {
  max-width: 140rem;
  margin: 4vw auto;
  background-color: #fff;
  border-radius: 6px;
  overflow: hidden;
  box-shadow: 0 2rem 6rem 0.5rem rgba(101, 90, 86, 0.2);
  display: grid;
  grid-template-rows: 10rem minmax(100rem, auto);
  grid-template-columns: 0.7fr 2.2fr 0.1fr;
  grid-template-areas: "head head head" "list recipe shopinglist"; }
  @media only screen and (max-width: 68.75em) {
    .container- {
      width: 100%;
      margin: 0;
      border-radius: 0; } }

.btn, .btn-small, .btn-small:link, .btn-small:visited {
  background-image: linear-gradient(to right bottom, #FBDB89, #F48982);
  border-radius: 10rem;
  border: none;
  text-transform: uppercase;
  color: #fff;
  cursor: pointer;
  display: flex;
  align-items: center;
  transition: all .2s; }
  .btn:hover, .btn-small:hover {
    transform: scale(1.05); }
  .btn:focus, .btn-small:focus {
    outline: none; }
  .btn > *:first-child, .btn-small > *:first-child {
    margin-right: 1rem; }

.btn {
  padding: 1.3rem 3rem;
  font-size: 1.4rem; }
  .btn svg {
    height: 2.25rem;
    width: 2.25rem;
    fill: currentColor; }

.btn-small, .btn-small:link, .btn-small:visited {
  font-size: 1.3rem;
  padding: 1rem 1.75rem;
  text-decoration: none; }
  .btn-small svg, .btn-small:link svg, .btn-small:visited svg {
    height: 1.5rem;
    width: 1.5rem;
    fill: currentColor; }

.btn-inline {
  color: #F59A83;
  font-size: 1.2rem;
  border: none;
  background-color: #F9F5F3;
  padding: .8rem 1.2rem;
  border-radius: 10rem;
  cursor: pointer;
  display: flex;
  align-items: center;
  transition: all .2s; }
  .btn-inline svg {
    height: 1.5rem;
    width: 1.5rem;
    fill: currentColor;
    margin: 0 .2rem; }
  .btn-inline span {
    margin: 0 .4rem; }
  .btn-inline:hover {
    color: #F48982;
    background-color: #F2EFEE; }
  .btn-inline:focus {
    outline: none; }

.btn-tiny {
  height: 1.75rem;
  width: 1.75rem;
  border: none;
  background: none;
  cursor: pointer; }
  .btn-tiny svg {
    height: 100%;
    width: 100%;
    fill: #F59A83;
    transition: all .3s; }
  .btn-tiny:focus {
    outline: none; }
  .btn-tiny:hover svg {
    fill: #F48982;
    transform: translateY(-1px); }
  .btn-tiny:active svg {
    fill: #F48982;
    transform: translateY(0); }
  .btn-tiny:not(:last-child) {
    margin-right: .3rem; }

.heading-2 {
  font-size: 1.8rem;
  font-weight: 600;
  color: #F59A83;
  text-transform: uppercase;
  margin-bottom: 2.5rem;
  text-align: center;
  transform: skewY(-3deg); }

.copyright {
  color: #968B87;
  font-size: 1.2rem;
  margin-top: auto; }

.link:link,
.link:visited {
  color: #968B87; }

.loader {
  margin: 5rem auto;
  text-align: center; }
  .loader svg {
    height: 5.5rem;
    width: 5.5rem;
    fill: #F59A83;
    transform-origin: 44% 50%;
    animation: rotate 1.5s infinite linear; }

@keyframes rotate {
  0% {
    transform: rotate(0); }
  100% {
    transform: rotate(360deg); } }

.header {
  grid-area: head;
  background-color: #F9F5F3;
  display: flex;
  align-items: center;
  justify-content: space-between; 
  }
  
  .header__logo {
    margin-left: 4rem;
    height: 4.5rem;
    display: block; }

.results,
.likes {
  padding: 3rem 0; }
  .results__list,
  .likes__list {
    list-style: none; }
  .results__link:link, .results__link:visited,
  .likes__link:link,
  .likes__link:visited {
    display: flex;
    align-items: center;
    padding: 1.5rem 3rem;
    transition: all .3s;
    border-right: 1px solid #fff;
    text-decoration: none; }
  .results__link:hover,
  .likes__link:hover {
    background-color: #F9F5F3;
    transform: translateY(-2px); }
  .results__link--active,
  .likes__link--active {
    background-color: #F9F5F3; }
  .results__fig,
  .likes__fig {
    flex: 0 0 5.5rem;
    border-radius: 50%;
    overflow: hidden;
    height: 5.5rem;
    margin-right: 2rem;
    position: relative;
    backface-visibility: hidden; }
    .results__fig::before,
    .likes__fig::before {
      content: '';
      display: block;
      height: 100%;
      width: 100%;
      position: absolute;
      top: 0;
      left: 0;
      background-image: linear-gradient(to right bottom, #FBDB89, #F48982);
      opacity: .4; }
    .results__fig img,
    .likes__fig img {
      display: block;
      width: 100%;
      height: 100%;
      object-fit: cover;
      transition: all .3s; }
  .results__name,
  .likes__name {
    font-size: 2.0rem;
    color: #F59A83;
    text-transform: uppercase;
    font-weight: 600;
    margin-bottom: .3rem; }
  .results__author,
  .likes__author {
    font-size: 1.1rem;
    color: #968B87;
    text-transform: uppercase;
    font-weight: 600; }
  .results__pages,
  .likes__pages {
    margin-top: 3rem;
    padding: 0 3rem; }
    .results__pages::after,
    .likes__pages::after {
      content: "";
      display: table;
      clear: both; }
  .results__btn--prev,
  .likes__btn--prev {
    float: left;
    flex-direction: row-reverse; }
  .results__btn--next,
  .likes__btn--next {
    float: right; }
    
    
.search {
  background-color: #fff;
  border-radius: 10rem;
  display: flex;
  align-items: center;
  padding-left: 3rem;
  transition: all .3s; }
  .search:focus-within {
    transform: translateY(-2px);
    box-shadow: 0 0.7rem 3rem rgba(101, 90, 86, 0.08); }
  .search__field {
    border: none;
    background: none;
    font-family: inherit;
    color: inherit;
    font-size: 1.7rem;
    width: 30rem; }
    .search__field:focus {
      outline: none; }
    .search__field::placeholder {
      color: #DAD0CC; }
.sumit_button{
	height : 50px;
	width : 100px;
	position : relative;
	top : 500px;
	left : 800px;
}


  
</style>



<title>更新画面</title>
</head>
<body>
	<div class="container-">	
        <header class="header">
        	<strong>更新画面</strong>
        	<strong>テーブル名</strong>
        			
        			
        			
        				<!--value値はidentificationNum
        				ここはモデルから選択されたテーブル名を貰う。get selected tableName from model.-->
 		       
        	
        	<div class="col-xs-offset-9 col-xs-3">
			
			<table border=1 width=180 height=80>
				
				<tr>				
					<td>ID :0</td>
				<tr>
					<td>ユーザ名 :</td>
				</tr>
				<tr>				
					<td>権限 : 
						
					</td>
				</tr>
			</table>
		</div>				     	
        </header>
        <label>承認しました。</label>
       
    	 
    	 <form action="selectTableProcess" >
    	 	<div class="clickButton">
 				<input type="submit" value="元のページへ" class="sumit_button" style="background-color:red;"/>
 			</div>
 			
    	 </form>
   		 
    </div>
    
  
    
   
</body>
</html>