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
</head>
<style type="text/css">
#box1 {
	width: 225px;
	height: 225px;
}

.tg {
	border-collapse: collapse;
	border-spacing: 0;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
}

.tg .tg-i46p {
	background-color: pink;
	color: pink
}

.tg .tg-yw4l {
	vertical-align: top
}
</style>

<div align="center">
<section class="content">
	<h1> CAFE NAME </h1>
	<table class="w3-table w3-bordered">
			<tr>
				<th>${cafeName}</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
			<c:forEach items="${cafes}" var="cafeVO">
			<tr>
				<td>
					<a href="/detail/list?cafeName=${cafeVO.cafeName}">
						${cafeVO.cafeName}
					</a>
				</td>
				<td>
					<form action="/cafe/modify?cafeName=${cafeVO.cafeName}" method="post">
						<input type='hidden' name='cafeName' value="${cafeVO.cafeName}">
						<button type="submit" class="w3-btn w3-white w3-border btn-warning">MODIFY</button>
					</form>
				</td>
				<td>
					<form action="/cafe/delete?cafeName=${cafeVO.cafeName}" method="post">
						<button type="submit" class="w3-btn w3-white w3-border btn-danger" value="${keyword}">REMOVE</button>
					</form>
				</td>
			</tr>
			</c:forEach>
			<tr>
				<td>
					<form action="/cafe/register?cafeName=${cafeVO.cafeName}" method="post">
						<input type='hidden' name='cafeName' value="${cafeVO.cafeName}">
						<input type='text' name='menuName' value="${cafeVO.menuName}">
						<button type="submit" class="w3-btn w3-white w3-border btn-warning">ADD</button>
					</form>
				</td>
			</tr>
	</table>
	
	
</section>
</div>