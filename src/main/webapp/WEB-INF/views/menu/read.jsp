<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
   
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
   
<title>학 식 세 끼</title>

<style>
table a:link {
   color: #666;
   font-weight: bold;
   text-decoration: none;
}

table a:visited {
   color: #999999;
   font-weight: bold;
   text-decoration: none;
}

table a:active, table a:hover {
   color: #bd5a35;
   text-decoration: underline;
}

table {
   width: 1000px;
   font-family: Arial, Helvetica, sans-serif;
   color: #666;
   font-size: 14px;
   text-shadow: 1px 1px 0px #fff;
   background: #eaebec;
   border: #ccc 1px solid;
   -moz-border-radius: 3px;
   -webkit-border-radius: 3px;
   border-radius: 3px;
   -moz-box-shadow: 0 1px 2px #d1d1d1;
   -webkit-box-shadow: 0 1px 2px #d1d1d1;
   box-shadow: 0 1px 2px #d1d1d1;
}

table th {
   padding: 21px 25px 22px 25px;
   border-top: 1px solid #fafafa;
   border-bottom: 1px solid #e0e0e0;
   background: #ededed;
   background: -webkit-gradient(linear, left top, left bottom, from(#ededed),
      to(#ebebeb));
   background: -moz-linear-gradient(top, #ededed, #ebebeb);
}

table th:first-child {
   text-align: left;
   padding-left: 20px;
}

table tr:first-child th:first-child {
   -moz-border-radius-topleft: 3px;
   -webkit-border-top-left-radius: 3px;
   border-top-left-radius: 3px;
}

table tr:first-child th:last-child {
   -moz-border-radius-topright: 3px;
   -webkit-border-top-right-radius: 3px;
   border-top-right-radius: 3px;
}

table tr {
   text-align: center;
   padding-left: 20px;
}

table td:first-child {
   text-align: left;
   padding-left: 20px;
   border-left: 0;
}

table td {
   padding: 10px;
   border-top: 1px solid #ffffff;
   border-bottom: 1px solid #e0e0e0;
   border-left: 1px solid #e0e0e0;
   background: #fafafa;
   background: -webkit-gradient(linear, left top, left bottom, from(#fbfbfb),
      to(#fafafa));
   background: -moz-linear-gradient(top, #fbfbfb, #fafafa);
}

table td.second {
   text-align: right;
   padding: 18px;
   border-top: 1px solid #ffffff;
   border-bottom: 1px solid #e0e0e0;
   border-left: 1px solid #e0e0e0;
   background: #fafafa;
   background: -webkit-gradient(linear, left top, left bottom, from(#fbfbfb),
      to(#fafafa));
   background: -moz-linear-gradient(top, #fbfbfb, #fafafa);
}

table tr.even td {
   background: #f6f6f6;
   background: -webkit-gradient(linear, left top, left bottom, from(#f8f8f8),
      to(#f6f6f6));
   background: -moz-linear-gradient(top, #f8f8f8, #f6f6f6);
}

table tr:last-child td {
   border-bottom: 0;
}

table tr:last-child td:first-child {
   -moz-border-radius-bottomleft: 3px;
   -webkit-border-bottom-left-radius: 3px;
   border-bottom-left-radius: 3px;
}

table tr:last-child td:last-child {
   -moz-border-radius-bottomright: 3px;
   -webkit-border-bottom-right-radius: 3px;
   border-bottom-right-radius: 3px;
}

table tr:hover td {
   background: #f2f2f2;
   background: -webkit-gradient(linear, left top, left bottom, from(#f2f2f2),
      to(#f0f0f0));
   background: -moz-linear-gradient(top, #f2f2f2, #f0f0f0);
}
#text1 { font-size:19pt; }
</style>
</head>
<body>
   <br>
   <br>
	<table>
		<tr>
			<th>CAFETERIA</th>
			<th>CORNER</th>
			<th>MENU</th>
			<th>PRICE</th>
			<th>POINT</th>
			<th>LIKE</th>
		</tr>		
		<tr>
			<td>${menu.cafeName}</td>
			<td>${menu.detailName}</td>
			<td>${menu.menuName}</td>
			<td>${menu.price}</td>
			<td>${menu.point}</td>
			<td>${menu.likeNum}</td>
		</tr>
	</table>
      
      <p><h1>댓글 목록</h1>
      <table>
         <tr>
            <th> 댓글 </th>
            <th> 작성자 </th>
            <th> 등록시간 </th>
            <th> 삭제 </th>
         </tr>
         <c:forEach items="${comments}" var="commentVO">
         <tr>
            <td>${commentVO.contents}</td>
   			<td>${commentVO.nick}</td>
   			<td>${commentVO.regDate}</td>
   			<td>               
	   			<form action="/comment/delete" method="post">
	   			<input type="hidden" name="cafeName" value="${commentVO.cafeName}">
	   			<input type="hidden" name="detailName" value="${commentVO.detailName}">
	   			<input type="hidden" name="menuName" value="${commentVO.menuName}">
	   			<input type="hidden" name="commentNum" value="${commentVO.commentNum}">
	   			<button type="submit" class="w3-btn w3-white w3-border btn-danger">REMOVE</button>
	   			</form>
	   		</td>
         </tr>
         </c:forEach>
      </table>
</body>
