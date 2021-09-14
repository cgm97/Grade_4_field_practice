<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 상세보기</title>
	<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
	<link href="<c:url value="/css/content.css" />" rel='stylesheet' />
</head>
<body>
		<div class="container">
			<h2>게시물 상세보기</h2>
			<div>
				<div class="board_title"><span style="font:25px bold;">${content.getCon_title()}</span></div>
				<div class="board_content">
					${content.getCon_txt()}
				</div>
			</div>

			<div class="bottom">
				<input class="fas fa-angle-double-left" type="button"/>
				<input type="button" class="button"  onclick="location.href='identification?key=2'" value="수정" />
				<input class="button-delete" type="button" onclick="location.href='identification?key=3'" value="삭제" />
				<input class="fas fa-angle-double-right" type="button" />
			</div>
		</div>
</body>
</html>