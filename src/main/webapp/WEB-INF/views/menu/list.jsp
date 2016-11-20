<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
	
<head>
	<title> 학 식 세 끼 </title>	
</head>

<body>

	<form action="/menu/register?cafeName=${cafeName}&keyword=${keyword}" method="post">
		<label for="menuName">menu name</label>
		<input type="text" name="menuName" placeholder="Menu name"/>
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
				<th> MENU POINT </th>
				<th> MENU LIKE </th>
				<th> MODIFY </th>
				<th> DELETE </th>
			</tr>
			<c:forEach items="${list}" var="menuVO">
			<tr>
				<td>${menuVO.menuName} </td>
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
						<button type="submit" class="w3-btn w3-white w3-border btn-danger">REMOVE</button>
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