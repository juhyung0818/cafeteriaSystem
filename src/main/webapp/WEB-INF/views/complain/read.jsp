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

.jh {
    border: 2px solid orange;
    Roundest border : 5px;
}

</style>

				<div class="box-header">
					<h3 class="box-title">READ COMPLAIN#${complainVO.complainNum}</h3>
				</div>

				<div class="box-body">
					<div>
						<label>TITLE</label>
						<input type="text" class="jh"
							name='title' jh" value="${complainVO.title}"
							readonly="readonly">
					</div>
					<div>
						<label>CONTENT</label>
						<textarea class="form-control jh" name="content" rows="3"
							readonly="readonly">${complainVO.content}</textarea>
					</div>
					<div class="">
						<label>USER</label>
						<input type="text"
							name="uid" class="form-control jh" value="${complainVO.uid}"
							readonly="readonly">
					</div>
					<div>
						<script>
							if(!"${complainVO.reply}"){
							document.write('<form action="/complain/inReply" method="post">' +
								'<label">REPLY</label>' +
								'<input type="hidden" name="complainNum" value="${complainVO.complainNum}">' + 
								'<input type="text" name="reply" class="form-control jh" id="reply">' +
								'<button type="submit" class="w3-btn w3-white w3-border "> 등록 </button>' +
								'</form>');
							}else{
								document.write('<label">REPLY</label>' +
									'<input type="text" class="jh"' +
									'name="uid" class="form-control jh" value="${complainVO.reply}"' +
									'readonly="readonly">'
								);
							}
						</script>
					</div>
				</div>
				<!-- /.box-body -->

				<div class="box-footer">
					<button type="submit" >REMOVE</button>
					<a href="/complain/list">
						<button type="submit">BACK</button>
					</a>
				</div>
				