
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">

<!doctype html>
<html lang='ko'>
<head>
<meta charset="utf-8" />
<title>학교식당 관리 시스템 </title>
<style>
body {
	font-family: "Lucida Sans Typewriter", "Lucida Console", Monaco,
		"Bitstream Vera Sans Mono", monospace;
	margin: 0px;
	padding: 50px;
	background: #e1e1e1;
}

.menu {
	position: relative;
	height: 44px;
	background: #EF6C00;
	width: auto;
}

.menu ul {
	list-style: none;
	padding: 0;
	margin: 0;
	line-height: 1;
}

.menu>ul {
	position: relative;
	display: block;
	background: #EF6C00;
	width: 100%;
	z-index: 500;
}

.menu:after, .menu>ul:after {
	content: ".";
	display: block;
	clear: both;
	visibility: hidden;
	line-height: 0;
	height: 0;
}

.menu.align-right>ul>li {
	float: right;
}

.menu.align-center ul {
	text-align: center;
}

.menu.align-center ul ul {
	text-align: left;
}

.menu>ul>li {
	display: inline-block;
	position: relative;
	margin: 0;
	padding: 0;
}

.menu>ul>#menu-button {
	display: none;
}

.menu ul li a {
	display: block;
	font-family: Helvetica, sans-serif;
	text-decoration: none;
}

.menu>ul>li>a {
	font-size: 14px;
	font-weight: bold;
	padding: 15px 20px;
	color: #fff;
	text-transform: uppercase;
	-webkit-transition: color 0.25s ease-out;
	-moz-transition: color 0.25s ease-out;
	-ms-transition: color 0.25s ease-out;
	-o-transition: color 0.25s ease-out;
	transition: color 0.25s ease-out;
}

.menu>ul>li.sub>a {
	padding-right: 32px;
}

.menu>ul>li:hover>a {
	color: #ffffff;
}

.menu li.sub::after {
	display: block;
	content: "";
	position: absolute;
	width: 0;
	height: 0;
}

.menu>ul>li.sub::after {
	right: 10px;
	top: 20px;
	border: 5px solid transparent;
	border-top-color: #7a8189;
}

.menu>ul>li:hover::after {
	border-top-color: #ffffff;
}

.menu ul ul {
	position: absolute;
	left: -9999px;
	top: 70px;
	opacity: 0;
	-webkit-transition: opacity .3s ease, top .25s ease;
	-moz-transition: opacity .3s ease, top .25s ease;
	-ms-transition: opacity .3s ease, top .25s ease;
	-o-transition: opacity .3s ease, top .25s ease;
	transition: opacity .3s ease, top .25s ease;
	z-index: 1000;
}

.menu ul ul ul {
	top: 37px;
	padding-left: 5px;
}

.menu ul ul li {
	position: relative;
}

.menu>ul>li:hover>ul {
	left: auto;
	top: 44px;
	opacity: 1;
}

.menu.align-right>ul>li:hover>ul {
	left: auto;
	right: 0;
	opacity: 1;
}

.menu ul ul li:hover>ul {
	left: 170px;
	top: 0;
	opacity: 1;
}

.menu.align-right ul ul li:hover>ul {
	left: auto;
	right: 170px;
	top: 0;
	opacity: 1;
	padding-right: 5px;
}

.menu ul ul li a {
	width: 130px;
	border-bottom: 1px solid #eeeeee;
	padding: 10px 20px;
	font-size: 12px;
	color: #9ea2a5;
	background: #ffffff;
	-webkit-transition: all .35s ease;
	-moz-transition: all .35s ease;
	-ms-transition: all .35s ease;
	-o-transition: all .35s ease;
	transition: all .35s ease;
}

.menu.align-right ul ul li a {
	text-align: right;
}

.menu ul ul li:hover>a {
	background: #f2f2f2;
	color: #8c9195;
}

.menu ul ul li:last-child>a, .menu ul ul li.last>a {
	border-bottom: 0;
}

.menu>ul>li>ul::after {
	content: '';
	border: 6px solid transparent;
	width: 0;
	height: 0;
	border-bottom-color: #ffffff;
	position: absolute;
	top: -12px;
	left: 30px;
}

.menu.align-right>ul>li>ul::after {
	left: auto;
	right: 30px;
}

.menu ul ul li.sub::after {
	border: 4px solid transparent;
	border-left-color: #9ea2a5;
	right: 10px;
	top: 12px;
	-moz-transition: all .2s ease;
	-ms-transition: all .2s ease;
	-o-transition: all .2s ease;
	transition: all .2s ease;
	-webkit-transition: -webkit-transform 0.2s ease, right 0.2s ease;
}

.menu.align-right ul ul li.sub::after {
	border-left-color: transparent;
	border-right-color: #9ea2a5;
	right: auto;
	left: 10px;
}

.menu ul ul li.sub:hover::after {
	border-left-color: #ffffff;
	right: -5px;
	-webkit-transform: rotateY(180deg);
	-ms-transform: rotateY(180deg);
	-moz-transform: rotateY(180deg);
	-o-transform: rotateY(180deg);
	transform: rotateY(180deg);
}

.menu.align-right ul ul li.sub:hover::after {
	border-right-color: #ffffff;
	border-left-color: transparent;
	left: -5px;
	-webkit-transform: rotateY(180deg);
	-ms-transform: rotateY(180deg);
	-moz-transform: rotateY(180deg);
	-o-transform: rotateY(180deg);
	transform: rotateY(180deg);
}

h1 {
	color: #333;
	font-family: arial, sans-serif;
	width: 80%;
}
h1 {
    font-size: 2.5em; /* 40px/16=2.5em */
	font-family: Arial, Helvetica, sans-serif;
}

</style>
</head>
<body bgcolor="#EF6C00">
	<div align="center">
	<a href = "/notice/list">
      <img class='contentsimg' src="/resources/haksik.png" align="center">
	</a>
	</div>
	
	<div align ="right">
<!--
 	<script>
	if("${user}"){
		document.write(
			"<a class='w3-btn w3-white w3-border' href='/user/logout'>logout</a>"
		)
	} 
	</script>
	-->
	<a class='w3-btn w3-white w3-border' href='/user/logout'>logout</a>
	</div>
	
	<div class='menu'>
		<ul>


			<li class='active sub'><a>식단관리</a>

				<table class="w3-table w3-bordered">
					<ul>
						<c:forEach items="${list}" var="cafeVO">
							<li class='sub'><a
								href='/weekly/weeklyList?cafeName=${cafeVO.cafeName}&detailName=&keyword='>
									${cafeVO.cafeName}</a></li>
						</c:forEach>
					</ul>
				</table></li>

			<li class='active sub'><a>항시메뉴관리</a>

				<table class="w3-table w3-bordered">
					<ul>
						<c:forEach items="${list}" var="cafeVO">
							<li class='sub'><a
								href='/fixed/list?cafeName=${cafeVO.cafeName}&keyword='>
									${cafeVO.cafeName}</a></li>
						</c:forEach>
					</ul>
				</table></li>


			<li class='active sub'><a>메뉴관리</a>
				<table class="w3-table w3-bordered">
					<ul>
						<c:forEach items="${list}" var="cafeVO">
							<li class='sub'><a
								href='/menu/list?cafeName=${cafeVO.cafeName}&keyword='>
									${cafeVO.cafeName}</a></li>
						</c:forEach>
					</ul>

				</table>
			</li>
			<li class='last'><a href='/cafe/list?keyword='>식당관리</a></li>
			<li class='last'><a href='/complain/list'>소리함</a></li>
			<li class='last'><a href='/notice/list'>공지사항</a></li>
		</ul>
	</div>

</body>
</html>

