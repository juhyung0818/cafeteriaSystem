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
	<h1> DETAIL LIST </h1>
	
	<form action="/detail/register" method="post">
		<label for="detailName">detail name</label>
		<input type="hidden" name="cafeName" value="${cafeName}">
		<input type="text" name="detailName" placeholder="Detail name"/>
		<input type='hidden' name='keyword' value="${keyword}">
		<button type="submit" class="w3-btn w3-white w3-border "> 추가 </button>
		<button type="reset" class="w3-btn w3-white w3-border "> 취소 </button>
	</form>

	<form action="/detail/search" method="post">
		<label for="keyword">Search</label>
		<input type="text" name="keyword" placeholder="Write keyword" value="${keyword}"/>
		<input type="hidden" name="cafeName" value="${cafeName}">
		<button type="submit" class="w3-btn w3-white w3-border "> 검색 </button>
	</form>
	
	<table class="w3-table w3-bordered">
		<tr>
			<th>CAFE NAME</th>
			<th>삭제</th>
		</tr>
		<c:forEach items="${details}" var="detailVO">
		<tr>
			<td>
				${detailVO.detailName}
			</td>
			<td>
				<form action="/detail/delete?cafeName=${detailVO.cafeName}&detailName=${detailVO.detailName}" method="post">
					<input type='hidden' name='keyword' value="${keyword}">
					<button type="submit" class="w3-btn w3-white w3-border btn-danger" value="${keyword}">REMOVE</button>
				</form>
			</td>
		</tr>
		</c:forEach>
	</table>
	
	
</section>
</div>