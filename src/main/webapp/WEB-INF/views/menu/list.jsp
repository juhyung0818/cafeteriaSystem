<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/p_header.jsp"%>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.1.1.min.js">
	
</script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script><head>
	<title> 학 식 세 끼 </title>	
	
	<style>
	.dropdown {
    	position: relative;
    	display: inline-block;
	}	

	.dropdown-content {
    	display: none;
    	position: absolute;
    	background-color: #f9f9f9;
    	min-width: 160px;
    	box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    	padding: 12px 16px;
    	z-index: 1;
	}

	.dropdown:hover .dropdown-content {
    	display: block;
	}
	</style>
</head>

<body>

	<form action="/menu/register" method="post">
		<label for="menuName">menu name</label>
		<input type="hidden" name="cafeName" value="${cafeName}"/>
		<input type="text" name="menuName" placeholder="Menu name"/>
		<select name="detailName" size="${detailSize}">
			<c:forEach items="${details}" var="detailVO">
        		<option>${detailVO.detailName}</option>
        	</c:forEach>
		</select>
		<input type="number" name="price" placeholder="Menu price"/>
		<input type='hidden' name='keyword' value="${keyword}">
		<button type="submit" class="w3-btn w3-white w3-border "> 추가 </button>
		<button type="reset" class="w3-btn w3-white w3-border "> 취소 </button>
	</form>
	
	<form action="/menu/search?cafeName=${cafeName}" method="post">
		<label for="keyword">Search</label>
		<input type="text" name="keyword" placeholder="Write menu name"/>
		<button type="submit" class="w3-btn w3-white w3-border "> 검색 </button>
	</form>
	
		<h1> Menu list </h1>
		<table>
			<tr>
				<th> MENU NAME </th>
				<th> MENU PRICE </th>
				<th> MENU POINT </th>
				<th> MENU LIKE </th>
				<th> MODIFY </th>
				<th> DELETE </th>
			</tr>
			<c:forEach items="${menus}" var="menuVO">
			<tr>
				<td>${menuVO.menuName}(${menuVO.detailName}) </td>
				<td>${menuVO.price} </td>
				<td>${menuVO.point} </td>
				<td>${menuVO.likeNum} </td>
				<td>
					<form method="post">
						<input type='hidden' name='cafeName' value="${menuVO.cafeName}">
						<input type='hidden' name='menuName' value="${menuVO.menuName}">
						<button type="submit" class="w3-btn w3-white w3-border btn-warning">MODIFY</button>
					</form>
				</td>
				<td>
					<form action="/menu/delete?cafeName=${menuVO.cafeName}&menuName=${menuVO.menuName}&keyword=${keyword}" method="post">
						<button type="submit" class="w3-btn w3-white w3-border btn-danger" value="${keyword}">REMOVE</button>
					</form>
				</td>
			</tr>
			</c:forEach>
		</table>

</body>
<!-- <script>
$(document).ready(function() {
	var formObj = $("form[role='form']");

	console.log(formObj);

	$(".btn-danger").on("click", function() {
		formObj.attr("action", "/menu/search");
		formObj.submit();
	});

});
</script> -->
