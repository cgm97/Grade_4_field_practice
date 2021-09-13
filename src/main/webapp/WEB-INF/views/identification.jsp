<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 본인 확인</title>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<link href="<c:url value="/css/identification.css" />" rel='stylesheet' />
</head>

<body>
	<div class="container">
		<h2>게시물 수정/삭제 본인확인</h2>
		
		<div class="idDiv">
			<i style="width: 50px; height: 28px" class="fas fa-user fa-lg"></i>
			<input type="text" placeholder="ID 입력" size="30"/>	
		</div>	
		<div class="pwDiv">
			<i style="width: 50px; height: 28px" class="fas fa-key fa-lg"></i>
			<input type="password" placeholder="PW 입력" size="30"/>	
		</div>
		<div class="bottom">
			<div class="item">
				<i class="fas fa-user-check fa-3x"></i>
				<p style="font-size: 20px;">작성자 본인 확인</p>
			</div>
			<div style="padding-left: 95px">
				<input class="button-cancel" type="button" value="Cancel" />
				<input class="button" type="button" value="OK" />
			</div>
		</div>
	</div>
</body>
</html>