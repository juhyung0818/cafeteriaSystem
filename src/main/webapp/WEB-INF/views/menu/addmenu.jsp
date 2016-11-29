<%@include file="../include/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>add menu</title>
</head>
<style>
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

.tg .tg-yw4l {
	vertical-align: top
}
</style>
<body>
    <p>
	<div align="center">
		<table class="tg">
			<tr>
				<th class="tg-031e" colspan="4" rowspan="4">식당</th>
				<th class="tg-031e" colspan="4" rowspan="4">이름</th>
				<th class="tg-031e" colspan="4" rowspan="4">사진</th>
				<th class="tg-031e" colspan="4" rowspan="4">가격</th>
			</tr>
			<tr>
			</tr>
			<tr>
			</tr>
			<tr>
			</tr>
			<tr>
				<td class="tg-031e" colspan="4" rowspan="4"><input
					class="w3-input" name="cafeteria" rows="1"
					placeholder="Enter Cafeteria name"></td>
				<td class="tg-031e" colspan="4" rowspan="4"><input
					class="w3-input" name="menuname" rows="1"
					placeholder="Enter Menu name"></td>
				<td class="tg-031e" colspan="4" rowspan="4"><input
					class="w3-input" name="photo" rows="1" placeholder="Put photo"></td>
				<td class="tg-031e" colspan="4" rowspan="4"><input
					class="w3-input" name="price" rows="1" placeholder="Enter Price"></td>
			</tr>
			<tr>
			</tr>
			<tr>
			</tr>
			<tr>
			</tr>
		</table>
		<div>
			<br>
			<button id="complete"
				class="w3-btn w3-white w3-border w3-border-orange w3-round-xlarge">
				취소</button>
			<button type="reset"
				class="w3-btn w3-white w3-border w3-border-orange w3-round-xlarge">
				등록</button>
		</div>
	</div>
	</p>
</body>
</html>