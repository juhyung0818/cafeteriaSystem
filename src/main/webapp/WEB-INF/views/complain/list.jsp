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
	background-image: url("c:\User\Desktop\admin\teachr.jpg")
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

<div class="box-header with-border">
					<h3 class="box-title">COMPLAIN LIST</h3>
				</div>
				<div class="box-body">
					<table class="table table-bordered">
						<tr>
							<th>TITLE</th>
							<th>CONTENT</th>
							<th>WRITER</th>
							<th>REPLY</th>
						</tr>

						<c:forEach items="${complains}" var="complainVO">

							<tr>
								<td>
									<a href='/complain/read?complainNum=${complainVO.complainNum}'>
										${complainVO.title} </a></td>
								<td> "${complainVO.content}"</td>
								<td>${complainVO.uid}</td>
								<td>
									<!-- reply check null or not null -->
									<script type = "text/javascript">
										if("${complainVO.reply}"){
											document.write("O");
										} else{
											document.write("X");
										}
          							</script>
								</td>
							</tr>

						</c:forEach>

					</table>
				</div>