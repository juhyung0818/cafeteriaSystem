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
   <form action="/cafe/register" method="post">
         <label for="cafeName">식당 이름</label>
         <input type="text" name="cafeName" placeholder="Cafe name"/>
         <input type='hidden' name='keyword' value="${keyword}">
         <button type="submit" class="w3-btn w3-white w3-border "> 추가 </button>
         <button type="reset" class="w3-btn w3-white w3-border "> 취소 </button>
      </form>
   
      
      <p><h1>메뉴 목록</h1>
      <form action="/cafe/search?cafeName=${cafeName}" method="post">
         <label for="keyword">검색</label>
         <input type="text" name="keyword" placeholder="Write keyword name"/>
         <button type="submit" class="w3-btn w3-white w3-border "> 검색 </button>
      </form></p>
      <table>
         <tr>
            <th> 메뉴 이름 </th>
            <th> 가격 </th>
            <th> 평점 </th>
            <th> 좋아요 수 </th>
            <th> 가격변경 </th>
            <th> 삭제 </th>
         </tr>
         <c:forEach items="${menus}" var="menuVO">
         <tr>
            <td>${menuVO.menuName}(${menuVO.detailName}) </td>
            <td><input type='text' name='price' value="${menuVO.price}"> </td>
            <td>${menuVO.point} </td>
            <td>${menuVO.likeNum} </td>

            <td>
               <form method="post">
                  <input type='hidden' name='cafeName' value="${menuVO.cafeName}">
                  <input type='hidden' name='menuName' value="${menuVO.menuName}">
                  <button type="submit" class="w3-btn w3-white w3-border btn-warning">MODIFY</button>
               </form>
            </td>
            <td>
               <form action="/menu/delete?cafeName=${menuVO.cafeName}&menuName=${menuVO.menuName}&keyword=${keyword}" method="post">
                  <button type="submit" class="w3-btn w3-white w3-border btn-danger" value="${keyword}">REMOVE</button>
               </form>
            </td>
         </tr>
         </c:forEach>
      </table>
</body>
