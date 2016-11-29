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
</head>
<html>
<style type="text/css">


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
	width: 600px;
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
</style>
<body>
<br>
<br>
  <div align="center">
	<table>
  <tr>
    <th class="tg-031e">제목</th>
    <th class="tg-031e" colspan="2"><input type="text"  name='title'
				" value="${complainVO.title}" size=50 readonly="readonly"></th>
  </tr>
  <tr>
    <td class="tg-031e">내용</td>
    <td class="tg-031e" colspan="2"><textarea class="form-control" name="content" cols=60 rows="3"
				readonly="readonly">${complainVO.content}</textarea></td>
  </tr>
  <tr>
    <td class="tg-031e">작성자</td>
    <td class="tg-031e" colspan="2"> <input type="text" name="uid" size=60
				class="form-control" value="${complainVO.uid}"
				readonly="readonly"></td>
  </tr>
  <tr>
    <td class="tg-031e">답변</td>
    <td class="tg-031e"><script>
							if(!"${complainVO.reply}"){
							document.write('<form action="/complain/inReply" method="post">' +
									'<input type="hidden" name="complainNum" value="${complainVO.complainNum}">' + 
									'<input type="text" name="reply" class="form-control" size=50  id="reply ">&nbsp &nbsp' +
									'<button type="submit" class="w3-btn w3-white w3-border "> 등록 </button>' +
									'</form>'
								);
							}else{
								document.write('<form action="/complain/outReply" method="post">' +
									'<input type="hidden" name="complainNum"  value="${complainVO.complainNum}">' + 
									'<input type="text"  name="uid" size=50 class="form-control "' + 
									'value="${complainVO.reply}"readonly="readonly"> &nbsp &nbsp' +
									'<button type="submit" class="w3-btn w3-white w3-border "> 삭제 </button>' +
									'</form>'
								);
							}
						</script></td>
   
  </tr>
</table>
<br>
<br>
	
		<form action="/complain/delete?complainNum=${complainVO.complainNum}"
			method="post">
			<button type="submit" class="w3-btn w3-white w3-border">글 삭제</button>
		</form>
		<a href="/complain/list">
			<button type="submit" class="w3-btn w3-white w3-border">뒤로가기</button>
		</a>
	
</div>

</body>
</html>
