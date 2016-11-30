<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="../include/header.jsp"%>
	
<!DOCTYPE html>
<html>
<style>
form {
    border: 3px solid #f1f1f1;
}

input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

button {
    background-color: #EF6C00;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

.container {
    padding: 16px;
}

span.psw {
    float: right;
    padding-top: 16px;
}
fieldset {
	width: 500pt;
	border: 3;
	border-color: pink;
	}


/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}

</style>
	<body bgcolor="#e1e1e1">
	
	<h2 align="center">Login Form</h2>
	
	<center>
		<fieldset>
		
		<form action="/user/loginPost" method="post">
			  <div class="container">
			    <label><b>Uid</b></label>
			    <input type="text" placeholder="Enter Username" name="uid" required>
			
			    <label><b>Password</b></label>
			    <input type="password" placeholder="Enter Password" name="upw" required>
			        
			    <button type="submit">Login</button>
			    <input type="checkbox"> Remember me
			  </div>
			
		</form>
		</fieldset>
	</center>
	</body>
</html>

