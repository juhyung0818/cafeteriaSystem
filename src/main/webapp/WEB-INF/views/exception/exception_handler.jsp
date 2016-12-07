<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script>
var result = '${code}';

	if(result == "NOT_EXIST"){
		alert("잘못된 접근입니다.");
		history.back();
	}
	if(result == "NOT_EXIST_RESULT"){
		alert("검색결과가 없습니다.");
		history.back();
	}
	if(result == "NOT_EXIST_URL"){
		alert("잘못된 접근입니다.");
		history.back();
	}
	if(result == "PRIMARY_KEY_DUPLICATE"){
		alert("이미 존재합니다.");
		history.back();
	}
	if(result == "ACCESS_DENIED"){
		alert("로그인이 필요한 기능입니다.");
		self.location.href = "/";
	}

</script>	
