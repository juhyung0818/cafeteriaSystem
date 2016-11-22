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
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
	
<head>
	<title> 학 식 세 끼 </title>	
</head>

<script>	

	var empty = "등록된 식사가 없습니다.";
	var time = new Array();
	time[0] = '조식';
	time[1] = '중식';
	time[2] = '석식';
	
	var table = new Array();
 	table[0] = new Array();
	table[1] = new Array();
	table[2] = new Array();
	for(var i=0; i<3; i++){
		for(var j=0; j<7; j++){
			table[i][j] = 'empty';
		}
	}
	var Times = {
			BREAKFAST : {name : "BREAKFAST", value : 0}, 
			LUNCH : {name : "LUNCH", value : 1}, 
			DINER : {name: "DINER", value : 2}
			};  
	var Days = {
			SUNDAY : {name : "SUNDAY", value : 0},
			MONDAY : {name : "MONDAY", value : 1},
			SUNDAY : {name : "THESDAY", value : 2},
			SUNDAY : {name : "WEDNESDAY", value : 3},
			SUNDAY : {name : "THURSDAY", value : 4},
			SUNDAY : {name : "FRIDAY", value : 5},
			SUNDAY : {name : "SATURDAY", value : 6}
			};  
	  
		var time = new Array();
		var day = new Array();
	</script>
	<c:forEach items='${list}' var='menuVO' varStatus='i'>
		<script>
		time[${i.index}] = Times.${menuVO.dateFlag};
		day[${i.index}] = Days.${menuVO.wFlag};
			table[time[${i.index}].value][day[${i.index}].value] = "${menuVO.menuName}";
		</script>
	</c:forEach>

<body>
	<p> </p> 
	<h1> Menu list </h1>

	<table class="w3-table w3-bordered">
		<tr>
			<th> 시간/요일 </th>
			<th> 일요일 </th>
			<th> 월요일 </th>
			<th> 화요일 </th>
			<th> 수요일 </th>
			<th> 목요일 </th>
			<th> 금요일 </th>
			<th> 토요일 </th>
		</tr>
	
		<script> 
			for(var i=0; i<3; i++){
				document.write("<tr>"+ 
					"<td>" + time[i] + "</td>");
				for(var j=0; j<7; j++){
					if(table[i][j] != "empty"){
						 document.write("<td>" + table[i][j] + 
									"<form action='/weekly/delete?cafeName=${cafeName}&menuName=" + table[i][j]
									+ "&dateFlag=" + Times.i + "&wFlag=" + Days.j +"'" + 
									"method='post'>" + "<button type='submit' class='w3-btn w3-white w3-border'>REMOVE</button>" +
									"</form>" + "</td>");
					} else{
						document.write("<td>" + empty + "</td>");
					}
				}
				document.write("</tr>");
			}
		</script>
	</table>

</body>

<%-- document.write("<td>" + table[i][j] + 
							"<form action='/weekly/delete?cafeName=${cafeName}&menuName=" + table[i][j]
							+ "&dateFlag=" + i + "&wFlag=" + j +"'" + 
							"method='post'>" + "<button type='submit' class='w3-btn w3-white w3-border'>REMOVE</button>" +
							"</form>" + "</td>"); --%>