<%@include file="../include/p_header.jsp"%>
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
<style type="text/css">
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

.panel {
	height: 34px;
	padding: 10px;
}

.panel a#add_pop {
	border: 2px solid #aaa;
	color: #fff;
	display: block;
	float: left;
	margin-left: 10px;
	padding: 5px 10px;
	text-decoration: none;
	text-shadow: 1px 1px #000;
	-webkit-border-radius: 10px;
	-moz-border-radius: 10px;
	-ms-border-radius: 10px;
	-o-border-radius: 10px;
	border-radius: 10px;
	font-family: 'dotum';
}

a#add_pop:hover {
	border-color: #eee;
}

.overlay {
	background-color: rgba(0, 0, 0, 0.6);
	bottom: 0;
	cursor: default;
	left: 0;
	opacity: 0;
	position: fixed;
	right: 0;
	top: 0;
	visibility: hidden;
	z-index: 1;
	-webkit-transition: opacity .5s;
	-moz-transition: opacity .5s;
	-ms-transition: opacity .5s;
	-o-transition: opacity .5s;
	transition: opacity .5s;
}

.overlay:target {
	visibility: visible;
	opacity: 1;
}

.popup {
	background-color: #fff;
	border: 3px solid #fff;
	display: inline-block;
	left: 50%;
	opacity: 0;
	padding: 15px;
	position: fixed;
	text-align: justify;
	top: 40%;
	visibility: hidden;
	z-index: 10;
	-webkit-transform: translate(-50%, -50%);
	-moz-transform: translate(-50%, -50%);
	-ms-transform: translate(-50%, -50%);
	-o-transform: translate(-50%, -50%);
	transform: translate(-50%, -50%);
	-webkit-border-radius: 10px;
	-moz-border-radius: 10px;
	-ms-border-radius: 10px;
	-o-border-radius: 10px;
	border-radius: 10px;
	-webkit-box-shadow: 0 1px 1px 2px rgba(0, 0, 0, 0.4) inset;
	-moz-box-shadow: 0 1px 1px 2px rgba(0, 0, 0, 0.4) inset;
	-ms-box-shadow: 0 1px 1px 2px rgba(0, 0, 0, 0.4) inset;
	-o-box-shadow: 0 1px 1px 2px rgba(0, 0, 0, 0.4) inset;
	box-shadow: 0 1px 1px 2px rgba(0, 0, 0, 0.4) inset;
	-webkit-transition: opacity .5s, top .5s;
	-moz-transition: opacity .5s, top .5s;
	-ms-transition: opacity .5s, top .5s;
	-o-transition: opacity .5s, top .5s;
	transition: opacity .5s, top .5s;
}

.overlay:target+.popup {
	top: 50%;
	opacity: 1;
	visibility: visible;
}

.close {
	background-color: rgba(0, 0, 0, 0.8);
	height: 30px;
	line-height: 30px;
	position: absolute;
	right: 0;
	text-align: center;
	text-decoration: none;
	top: -15px;
	width: 30px;
	-webkit-border-radius: 15px;
	-moz-border-radius: 15px;
	-ms-border-radius: 15px;
	-o-border-radius: 15px;
	border-radius: 15px;
}

.close:before {
	color: rgba(255, 255, 255, 0.9);
	content: "X";
	font-size: 24px;
	text-shadow: 0 -1px rgba(0, 0, 0, 0.9);
}

.close:hover {
	background-color: rgba(64, 128, 128, 0.8);
}

.popup p, .popup div {
	margin-bottom: 10px;
}

.popup label {
	display: inline-block;
	text-align: left;
	width: 120px;
}

.popup input[type="text"], .popup input[type="password"] {
	border: 1px solid;
	border-color: #999 #ccc #ccc;
	margin: 0;
	padding: 2px;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	-ms-border-radius: 2px;
	-o-border-radius: 2px;
	border-radius: 2px;
}

.popup input[type="text"]:hover, .popup input[type="password"]:hover {
	border-color: #555 #888 #888;
}
</style>
<body>
	<div align="center">
		<h5>월</h5>
		<table class="tg">
			<tr>
				<th class="tg-031e">조식</th>
				<th class="tg-031e">
					<div class="form-group">
						<input class="w3-input"  rows="1">
					</div>
				</th>
				<th class="tg-031e">
					<div class="panel">
						<a href="#menuadd" id="add_pop">추가</a>

					</div> <a href="#x" class="overlay" id="menuadd"></a>
					<div class="popup">
						<h2>메뉴추가하기</h2>
						<p>추가 할 음식을 검색하세요</p>
						<div>

							<input type="text" id="search" value="" /> <input type="button"
								value="검색" />
						</div>


						<a class="close" href="#close"></a>
					</div>


					</div>
				</th>
			</tr>
			<tr>
				<td class="tg-031e">중식</td>
				<td class="tg-031e"></td>
				<td class="tg-031e"></td>
			</tr>
			<tr>
				<td class="tg-yw4l">석식</td>
				<td class="tg-yw4l"></td>
				<td class="tg-yw4l"></td>
			</tr>

		</table>
	</div>
	<div align="center">
		<h5>화</h5>
		<table class="tg">
			<tr>
				<th class="tg-031e">조식</th>
				<th class="tg-031e"></th>
				<th class="tg-031e"></th>
			</tr>
			<tr>
				<td class="tg-031e">중식</td>
				<td class="tg-031e"></td>
				<td class="tg-031e"></td>
			</tr>
			<tr>
				<td class="tg-yw4l">석식</td>
				<td class="tg-yw4l"></td>
				<td class="tg-yw4l"></td>
			</tr>

		</table>
	</div>
	<div align="center">
		<h5>수</h5>
		<table class="tg">
			<tr>
				<th class="tg-031e">조식</th>
				<th class="tg-031e"></th>
				<th class="tg-031e"></th>
			</tr>
			<tr>
				<td class="tg-031e">중식</td>
				<td class="tg-031e"></td>
				<td class="tg-031e"></td>
			</tr>
			<tr>
				<td class="tg-yw4l">석식</td>
				<td class="tg-yw4l"></td>
				<td class="tg-yw4l"></td>
			</tr>

		</table>
	</div>
	<div align="center">
		<h5>목</h5>
		<table class="tg">
			<tr>
				<th class="tg-031e">조식</th>
				<th class="tg-031e"></th>
				<th class="tg-031e"></th>
			</tr>
			<tr>
				<td class="tg-031e">중식</td>
				<td class="tg-031e"></td>
				<td class="tg-031e"></td>
			</tr>
			<tr>
				<td class="tg-yw4l">석식</td>
				<td class="tg-yw4l"></td>
				<td class="tg-yw4l"></td>
			</tr>

		</table>
	</div>
	<div align="center">
		<h5>금</h5>
		<table class="tg">
			<tr>
				<th class="tg-031e">조식</th>
				<th class="tg-031e"></th>
				<th class="tg-031e"></th>
			</tr>
			<tr>
				<td class="tg-031e">중식</td>
				<td class="tg-031e"></td>
				<td class="tg-031e"></td>
			</tr>
			<tr>
				<td class="tg-yw4l">석식</td>
				<td class="tg-yw4l"></td>
				<td class="tg-yw4l"></td>
			</tr>

		</table>
	</div>
	<div align="center">
		<h5>토</h5>
		<table class="tg">
			<tr>
				<th class="tg-031e">조식</th>
				<th class="tg-031e"></th>
				<th class="tg-031e"></th>
			</tr>
			<tr>
				<td class="tg-031e">중식</td>
				<td class="tg-031e"></td>
				<td class="tg-031e"></td>
			</tr>
			<tr>
				<td class="tg-yw4l">석식</td>
				<td class="tg-yw4l"></td>
				<td class="tg-yw4l"></td>
			</tr>

		</table>
	</div>
	<div align="center">
		<h5>일</h5>
		<table class="tg">
			<tr>
				<th class="tg-031e">조식</th>
				<th class="tg-031e"></th>
				<th class="tg-031e"></th>
			</tr>
			<tr>
				<td class="tg-031e">중식</td>
				<td class="tg-031e"></td>
				<td class="tg-031e"></td>
			</tr>
			<tr>
				<td class="tg-yw4l">석식</td>
				<td class="tg-yw4l"></td>
				<td class="tg-yw4l"></td>
			</tr>

		</table>
		<div>
			<p>

				<div align="right"><br>
				<button id="complete"
					class="w3-btn w3-white w3-border w3-border-orange w3-round-xlarge">
					전체삭제</button>
				<button type="reset"
					class="w3-btn w3-white w3-border w3-border-orange w3-round-xlarge">
					등록</button></div>
			</p>
		</div>
	</div>
</body>
</html>