<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.joyandbiz.board.controller.FreeController" %>
<c:set var="TARGET" value="${FreeController.TARGET}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>게시물 편집</title>
	<link href="<c:url value="/css/editContent.css" />" rel='stylesheet' />
	<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
</head>
<body>
	<form action=<c:if test="${boardInfo.get('key') eq 1}">"<c:url value="/${TARGET}/write.do" />"</c:if> 
				 <c:if test="${boardInfo.get('key') eq 2}">"<c:url value="/${TARGET}/edit.do" />"</c:if> method="POST">
	  	<div class="title">
		  	<div class="back">
		  		<input class="fas fa-chevron-circle-left fa-3x" type="button" onclick="history.back()"/>
		  	</div>
		  	<div>
			  	<c:if test="${boardInfo.get('key') eq 1}">
			  		<label style="font:45px bold;">게시물 작성</label>
			  	</c:if>
			  	<c:if test="${boardInfo.get('key') eq 2}">
			  		<label style="font:45px bold;">게시물 수정</label>
			  	</c:if>
		  	</div>
		  	
	 	</div>
		<div class="container">		 	
		  	<div class="middle">
		    	<table>
			          <tr>
			          	<td bgcolor="#EDEDED">제목</td>
			          	<td colspan="3">
			          		<input type="hidden" name="con_no" value="${boardInfo.get('con_no')}" />
			          		<input style="width: 550px" type="text" name="con_title" placeholder="제목 입력" value="${boardInfo.get('con_title')}">
			          	</td>
			          </tr>
			          <tr>
			          	<td style= "height: 200px;" bgcolor="#EDEDED">내용</td>
			          	<td colspan="3"><textarea rows="18" cols="75" style = "resize:none;" name="con_txt">${boardInfo.get('con_txt')}</textarea></td>
			          </tr>
			        <c:if test="${boardInfo.get('key') eq 1}">
			          <tr>
			          	<td style= "width: 90px;" bgcolor="#EDEDED">ID</td>
			          	<td><input type="text" name="con_id" placeholder="ID 입력" />
			          	<td style= "width: 80px;" bgcolor="#EDEDED">PW</td>
			          	<td><input type="password" name="password" placeholder="PW 입력" />
			          </tr>
			        </c:if>			          
		    	</table>  
		    </div>
		    
		    <div class="bottom">
		    	<input class="button" type="submit" value="저장" />
		    </div>
		    
		</div>
	</form>
</body>
</html>