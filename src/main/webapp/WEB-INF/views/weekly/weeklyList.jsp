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
		/* The Modal (background) */
		.modal {
			display: none; /* Hidden by default */
			position: fixed; /* Stay in place */
			z-index: 1; /* Sit on top */
			padding-top: 20%; /* Location of the box */
			left: 0;
			top: 0;
			width: 100%; /* Full width */
			height: 100%; /* Full height */
			overflow: auto; /* Enable scroll if needed */
			background-color: rgb(0, 0, 0); /* Fallback color */
			background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
		}
		
		/* Modal Content */
		.modal-content {
			position: relative;
			background-color: #fefefe;
			margin: auto;
			padding: 0;
			border: 1px solid #888;
			width: 80%;
			box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
				rgba(0, 0, 0, 0.19);
			-webkit-animation-name: animatetop;
			-webkit-animation-duration: 0.4s;
			animation-name: animatetop;
			animation-duration: 0.4s
		}
		
		/* Add Animation */
		@
		-webkit-keyframes animatetop {
			from {
				top: -300px;
				opacity: 0
			}
		
			to {
				top: 0;
				opacity: 1
			}
		}
		@
		keyframes animatetop {
			from {
				top: -300px;
				opacity: 0
			}
			to {
				top: 0;
				opacity: 1
			}
		}
		
		/* The Close Button */
		.close {
			color: white;
			float: right;
			font-size: 28px;
			font-weight: bold;
		}
		
		.close:hover, .close:focus {
			color: #EF6C00;
			text-decoration: none;
			cursor: pointer;
		}
		
		.modal-header {
			padding: 2px 16px;
			background-color: #EF6C00;
			color: white;
		}
		
		.modal-body {
			padding: 2px 16px;
		}
		
		.modal-footer {
			padding: 2px 16px;
			background-color: #EF6C00;
			color: white;
		}
</style>
<script>
	var isExist = false;
	var menu;
	var empty = "등록된 메뉴가 없습니다.";
</script>
<body>

	<!-- 월요일 -->
	<div align="center">
		<h5>월</h5>
		<table class="tg">
			<tr>
			<td> 시간\코너 </td>
			<c:forEach items="${details}" var="detailVO">
				<td>
					${detailVO.detailName}
				</td>
			</c:forEach>
			</tr>
			<tr>
				<th class="tg-031e">조식</th>
				<c:forEach items="${details}" var="detailVO">
				<td>
					<c:forEach items="${weeklis}" var="weeklyVO">
						<script type="text/javascript">
							isExist = false;
							if(('${weeklyVO.detailName}' == '${detailVO.detailName}') 
									&& ('${weeklyVO.dateFlag.num}' == 0) 
									&& ('${weeklyVO.wFlag.num}' == 1)){
								isExist = true;
								menu = '${weeklyVO.menuName}';
							}
						</script>
						<a href="/weekly/list?cafeName=${detailVO.cafeName}&detailName=${detailVO.detailName}&keyword=
						&wFlag=${weeklyVO.wFlag.num}&dateFlag=${weeklyVO.dateFlag.num}"> 검색 </a>
					</c:forEach>
				</td>
				</c:forEach>
			</tr>
			<tr>
				<th class="tg-031e">중식</th>
				<c:forEach items="${details}" var="detailVO">
				<td>
					<c:forEach items="${weeklis}" var="weeklyVO">
						
						<script type="text/javascript">
							if(('${weeklyVO.detailName}' == '${detailVO.detailName}') 
									&& ('${weeklyVO.dateFlag.num}' == 1) 
									&& ('${weeklyVO.wFlag.num}' == 1)){
								document.write('${weeklyVO.menuName}');
							}
						</script>
						<a href="/weekly/list?cafeName=${detailVO.cafeName}&detailName=${detailVO.detailName}&keyword=
						&wFlag=${weeklyVO.wFlag.num}&dateFlag=${weeklyVO.dateFlag.num}"> 검색 </a>
							
					</c:forEach>
				</td>
				</c:forEach>
			</tr>
			<tr>
				<th class="tg-031e">석식</th>
				<c:forEach items="${details}" var="detailVO">
				<td>
					<c:forEach items="${weeklis}" var="weeklyVO">
						
						<script type="text/javascript">
							if(('${weeklyVO.detailName}' == '${detailVO.detailName}') 
									&& ('${weeklyVO.dateFlag.num}' == 2) 
									&& ('${weeklyVO.wFlag.num}' == 1)){
								document.write('${weeklyVO.menuName}');
							}
						</script>
						<a href="/weekly/list?cafeName=${detailVO.cafeName}&detailName=${detailVO.detailName}&keyword=
						&wFlag=${weeklyVO.wFlag.num}&dateFlag=${weeklyVO.dateFlag.num}"> 검색 </a>
							
					</c:forEach>
				</td>
				</c:forEach>
			</tr>
		</table>
	</div>
	
	<!-- 화요일 -->
	<div align="center">
		<h5>화</h5>
		<table class="tg">
			<tr>
			<td> 시간\코너 </td>
			<c:forEach items="${details}" var="detailVO">
				<td>
					${detailVO.detailName}
				</td>
			</c:forEach>
			</tr>
			<tr>
				<th class="tg-031e">조식</th>
				<c:forEach items="${details}" var="detailVO">
				<td>
					<c:forEach items="${weeklis}" var="weeklyVO">
						
						<script type="text/javascript">
							if(('${weeklyVO.detailName}' == '${detailVO.detailName}') 
									&& ('${weeklyVO.dateFlag.num}' == 0) 
									&& ('${weeklyVO.wFlag.num}' == 2)){
								document.write('${weeklyVO.menuName}');
							}
						</script>
					<a href="#menuadd" id="add_pop">추가</a>
					<a href="#x" class="overlay" id="menuadd"></a>
					</c:forEach>
				</td>
				</c:forEach>
			</tr>
			<tr>
				<th class="tg-031e">중식</th>
				<c:forEach items="${details}" var="detailVO">
				<td>
					<c:forEach items="${weeklis}" var="weeklyVO">
						
						<script type="text/javascript">
							if(('${weeklyVO.detailName}' == '${detailVO.detailName}') 
									&& ('${weeklyVO.dateFlag.num}' == 1) 
									&& ('${weeklyVO.wFlag.num}' == 2)){
								document.write('${weeklyVO.menuName}');
							}
						</script>
					<a href="#menuadd" id="add_pop">추가</a>
					<a href="#x" class="overlay" id="menuadd"></a>
					</c:forEach>
				</td>
				</c:forEach>
			</tr>
			<tr>
				<th class="tg-031e">석식</th>
				<c:forEach items="${details}" var="detailVO">
				<td>
					<c:forEach items="${weeklis}" var="weeklyVO">
						
						<script type="text/javascript">
							if(('${weeklyVO.detailName}' == '${detailVO.detailName}') 
									&& ('${weeklyVO.dateFlag.num}' == 2) 
									&& ('${weeklyVO.wFlag.num}' == 2)){
								document.write('${weeklyVO.menuName}');
							}
						</script>
					<a href="#menuadd" id="add_pop">추가</a>
					<a href="#x" class="overlay" id="menuadd"></a>
					</c:forEach>
				</td>
				</c:forEach>
			</tr>
		</table>
	</div>
	<!-- 수요일 -->
	<div align="center">
		<h5>월</h5>
		<table class="tg">
			<tr>
			<td> 시간\코너 </td>
			<c:forEach items="${details}" var="detailVO">
				<td>
					${detailVO.detailName}
				</td>
			</c:forEach>
			</tr>
			<tr>
				<th class="tg-031e">조식</th>
				<c:forEach items="${details}" var="detailVO">
				<td>
					<c:forEach items="${weeklis}" var="weeklyVO">
						
						<script type="text/javascript">
							if(('${weeklyVO.detailName}' == '${detailVO.detailName}') 
									&& ('${weeklyVO.dateFlag.num}' == 0) 
									&& ('${weeklyVO.wFlag.num}' == 3)){
								document.write('${weeklyVO.menuName}');
							}
						</script>
					<a href="#menuadd" id="add_pop">추가</a>
					<a href="#x" class="overlay" id="menuadd"></a>
					</c:forEach>
				</td>
				</c:forEach>
			</tr>
			<tr>
				<th class="tg-031e">중식</th>
				<c:forEach items="${details}" var="detailVO">
				<td>
					<c:forEach items="${weeklis}" var="weeklyVO">
						
						<script type="text/javascript">
							if(('${weeklyVO.detailName}' == '${detailVO.detailName}') 
									&& ('${weeklyVO.dateFlag.num}' == 1) 
									&& ('${weeklyVO.wFlag.num}' == 3)){
								document.write('${weeklyVO.menuName}');
							}
						</script>
					<a href="#menuadd" id="add_pop">추가</a>
					<a href="#x" class="overlay" id="menuadd"></a>
					</c:forEach>
				</td>
				</c:forEach>
			</tr>
			<tr>
				<th class="tg-031e">석식</th>
				<c:forEach items="${details}" var="detailVO">
				<td>
					<c:forEach items="${weeklis}" var="weeklyVO">
						
						<script type="text/javascript">
							if(('${weeklyVO.detailName}' == '${detailVO.detailName}') 
									&& ('${weeklyVO.dateFlag.num}' == 2) 
									&& ('${weeklyVO.wFlag.num}' == 3)){
								document.write('${weeklyVO.menuName}');
							}
						</script>
					<a href="#menuadd" id="add_pop">추가</a>
					<a href="#x" class="overlay" id="menuadd"></a>
					</c:forEach>
				</td>
				</c:forEach>
			</tr>
		</table>
	</div>
	<!-- 목요일 -->
	<div align="center">
		<h5>월</h5>
		<table class="tg">
			<tr>
			<td> 시간\코너 </td>
			<c:forEach items="${details}" var="detailVO">
				<td>
					${detailVO.detailName}
				</td>
			</c:forEach>
			</tr>
			<tr>
				<th class="tg-031e">조식</th>
				<c:forEach items="${details}" var="detailVO">
				<td>
					<c:forEach items="${weeklis}" var="weeklyVO">
						
						<script type="text/javascript">
							if(('${weeklyVO.detailName}' == '${detailVO.detailName}') 
									&& ('${weeklyVO.dateFlag.num}' == 0) 
									&& ('${weeklyVO.wFlag.num}' == 4)){
								document.write('${weeklyVO.menuName}');
							}
						</script>
					<a href="#menuadd" id="add_pop">추가</a>
					<a href="#x" class="overlay" id="menuadd"></a>
					</c:forEach>
				</td>
				</c:forEach>
			</tr>
			<tr>
				<th class="tg-031e">중식</th>
				<c:forEach items="${details}" var="detailVO">
				<td>
					<c:forEach items="${weeklis}" var="weeklyVO">
						
						<script type="text/javascript">
							if(('${weeklyVO.detailName}' == '${detailVO.detailName}') 
									&& ('${weeklyVO.dateFlag.num}' == 1) 
									&& ('${weeklyVO.wFlag.num}' == 4)){
								document.write('${weeklyVO.menuName}');
							}
						</script>
					<a href="#menuadd" id="add_pop">추가</a>
					<a href="#x" class="overlay" id="menuadd"></a>
					</c:forEach>
				</td>
				</c:forEach>
			</tr>
			<tr>
				<th class="tg-031e">석식</th>
				<c:forEach items="${details}" var="detailVO">
				<td>
					<c:forEach items="${weeklis}" var="weeklyVO">
						
						<script type="text/javascript">
							if(('${weeklyVO.detailName}' == '${detailVO.detailName}') 
									&& ('${weeklyVO.dateFlag.num}' == 2) 
									&& ('${weeklyVO.wFlag.num}' == 4)){
								document.write('${weeklyVO.menuName}');
							}
						</script>
					<a href="#menuadd" id="add_pop">추가</a>
					<a href="#x" class="overlay" id="menuadd"></a>
					</c:forEach>
				</td>
				</c:forEach>
			</tr>
		</table>
	</div>
	<!-- 금요일 -->
	<div align="center">
		<h5>금</h5>
		<table class="tg">
			<tr>
			<td> 시간\코너 </td>
			<c:forEach items="${details}" var="detailVO">
				<td>
					${detailVO.detailName}
				</td>
			</c:forEach>
			</tr>
			<tr>
				<th class="tg-031e">조식</th>
				<c:forEach items="${details}" var="detailVO">
				<td>
					<c:forEach items="${weeklis}" var="weeklyVO">
						
						<script type="text/javascript">
							if(('${weeklyVO.detailName}' == '${detailVO.detailName}') 
									&& ('${weeklyVO.dateFlag.num}' == 0) 
									&& ('${weeklyVO.wFlag.num}' == 5)){
								document.write('${weeklyVO.menuName}');
							}
						</script>
					<a href="#menuadd" id="add_pop">추가</a>
					<a href="#x" class="overlay" id="menuadd"></a>
					</c:forEach>
				</td>
				</c:forEach>
			</tr>
			<tr>
				<th class="tg-031e">중식</th>
				<c:forEach items="${details}" var="detailVO">
				<td>
					<c:forEach items="${weeklis}" var="weeklyVO">
						
						<script type="text/javascript">
							if(('${weeklyVO.detailName}' == '${detailVO.detailName}') 
									&& ('${weeklyVO.dateFlag.num}' == 1) 
									&& ('${weeklyVO.wFlag.num}' == 5)){
								document.write('${weeklyVO.menuName}');
							}
						</script>
					<a href="#menuadd" id="add_pop">추가</a>
					<a href="#x" class="overlay" id="menuadd"></a>
					</c:forEach>
				</td>
				</c:forEach>
			</tr>
			<tr>
				<th class="tg-031e">석식</th>
				<c:forEach items="${details}" var="detailVO">
				<td>
					<c:forEach items="${weeklis}" var="weeklyVO">
						
						<script type="text/javascript">
							if(('${weeklyVO.detailName}' == '${detailVO.detailName}') 
									&& ('${weeklyVO.dateFlag.num}' == 2) 
									&& ('${weeklyVO.wFlag.num}' == 5)){
								document.write('${weeklyVO.menuName}');
							}
						</script>
					<a href="#menuadd" id="add_pop">추가</a>
					<a href="#x" class="overlay" id="menuadd"></a>
					</c:forEach>
				</td>
				</c:forEach>
			</tr>
		</table>
	</div>
	<!-- 토요일 -->
	<div align="center">
		<h5>토</h5>
		<table class="tg">
			<tr>
			<td> 시간\코너 </td>
			<c:forEach items="${details}" var="detailVO">
				<td>
					${detailVO.detailName}
				</td>
			</c:forEach>
			</tr>
			<tr>
				<th class="tg-031e">조식</th>
				<c:forEach items="${details}" var="detailVO">
				<td>
					<c:forEach items="${weeklis}" var="weeklyVO">
						
						<script type="text/javascript">
							if(('${weeklyVO.detailName}' == '${detailVO.detailName}') 
									&& ('${weeklyVO.dateFlag.num}' == 0) 
									&& ('${weeklyVO.wFlag.num}' == 6)){
								document.write('${weeklyVO.menuName}');
							}
						</script>
					<a href="#menuadd" id="add_pop">추가</a>
					<a href="#x" class="overlay" id="menuadd"></a>
					</c:forEach>
				</td>
				</c:forEach>
			</tr>
			<tr>
				<th class="tg-031e">중식</th>
				<c:forEach items="${details}" var="detailVO">
				<td>
					<c:forEach items="${weeklis}" var="weeklyVO">
						
						<script type="text/javascript">
							if(('${weeklyVO.detailName}' == '${detailVO.detailName}') 
									&& ('${weeklyVO.dateFlag.num}' == 1) 
									&& ('${weeklyVO.wFlag.num}' == 6)){
								document.write('${weeklyVO.menuName}');
							}
						</script>
					<a href="#menuadd" id="add_pop">추가</a>
					<a href="#x" class="overlay" id="menuadd"></a>
					</c:forEach>
				</td>
				</c:forEach>
			</tr>
			<tr>
				<th class="tg-031e">석식</th>
				<c:forEach items="${details}" var="detailVO">
				<td>
					<c:forEach items="${weeklis}" var="weeklyVO">
						
						<script type="text/javascript">
							if(('${weeklyVO.detailName}' == '${detailVO.detailName}') 
									&& ('${weeklyVO.dateFlag.num}' == 2) 
									&& ('${weeklyVO.wFlag.num}' == 6)){
								document.write('${weeklyVO.menuName}');
							}
						</script>
					<a href="#menuadd" id="add_pop">추가</a>
					<a href="#x" class="overlay" id="menuadd"></a>
					</c:forEach>
				</td>
				</c:forEach>
			</tr>
		</table>
	</div>
	<!-- 일요일 -->
	<div align="center">
		<h5>일</h5>
		<table class="tg">
			<tr>
			<td> 시간\코너 </td>
			<c:forEach items="${details}" var="detailVO">
				<td>
					${detailVO.detailName}
				</td>
			</c:forEach>
			</tr>
			<tr>
				<th class="tg-031e">조식</th>
				<c:forEach items="${details}" var="detailVO">
				<td>
					<c:forEach items="${weeklis}" var="weeklyVO">
						
						<script type="text/javascript">
							if(('${weeklyVO.detailName}' == '${detailVO.detailName}') 
									&& ('${weeklyVO.dateFlag.num}' == 0) 
									&& ('${weeklyVO.wFlag.num}' == 7)){
								document.write('${weeklyVO.menuName}');
							}
						</script>
					<a href="#menuadd" id="add_pop">추가</a>
					<a href="#x" class="overlay" id="menuadd"></a>
					</c:forEach>
				</td>
				</c:forEach>
			</tr>
			<tr>
				<th class="tg-031e">중식</th>
				<c:forEach items="${details}" var="detailVO">
				<td>
					<c:forEach items="${weeklis}" var="weeklyVO">
						
						<script type="text/javascript">
							if(('${weeklyVO.detailName}' == '${detailVO.detailName}') 
									&& ('${weeklyVO.dateFlag.num}' == 1) 
									&& ('${weeklyVO.wFlag.num}' == 7)){
								document.write('${weeklyVO.menuName}');
							}
						</script>
					<a href="#menuadd" id="add_pop">추가</a>
					<a href="#x" class="overlay" id="menuadd"></a>
					</c:forEach>
				</td>
				</c:forEach>
			</tr>
			<tr>
				<th class="tg-031e">석식</th>
				<c:forEach items="${details}" var="detailVO">
				<td>
					<c:forEach items="${weeklis}" var="weeklyVO">
						
						<script type="text/javascript">
							if(('${weeklyVO.detailName}' == '${detailVO.detailName}') 
									&& ('${weeklyVO.dateFlag.num}' == 2) 
									&& ('${weeklyVO.wFlag.num}' == 7)){
								document.write('${weeklyVO.menuName}');
							}
						</script>
					<a href="#menuadd" id="add_pop">추가</a>
					<a href="#x" class="overlay" id="menuadd"></a>
					</c:forEach>
				</td>
				</c:forEach>
			</tr>
		</table>
	</div>
	
</body>
</html>