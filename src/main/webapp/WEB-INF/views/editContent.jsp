<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>게시물 편집</title>
	<link href="<c:url value="/css/editContent.css" />" rel='stylesheet' />
	<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
</head>
<body>
	<form action="" method="POST">
	  	<div class="title">
		  	<div class="back">
		  		<input class="fas fa-chevron-circle-left fa-3x" type="button" onclick="location.href='/board'"/>
		  	</div>
		  	<div>
			  	<c:if test="${key eq 1}">
			  		<label style="font:45px bold;">게시물 작성</label>
			  	</c:if>
			  	<c:if test="${key eq 2}">
			  		<label style="font:45px bold;">게시물 수정</label>
			  	</c:if>
		  	</div>
		  	
	 	</div>
		<div class="container">		 	
		  	<div class="middle">
		    	<table>
			          <tr>
			          	<td bgcolor="#EDEDED">제목</td>
			          	<td colspan="3"><input style="width: 550px" type="text" id="con_title" placeholder="제목 입력"></td>
			          </tr>
			          <tr>
			          	<td style= "height: 200px;" bgcolor="#EDEDED">내용</td>
			          	<td colspan="3"><textarea rows="18" cols="75" style = "resize:none;"></textarea></td>
			          </tr>
			        <c:if test="${key eq 1}">
			          <tr>
			          	<td style= "width: 90px;" bgcolor="#EDEDED">ID</td>
			          	<td><input type="text" placeholder="ID 입력" />
			          	<td style= "width: 80px;" bgcolor="#EDEDED">PW</td>
			          	<td><input type="password" placeholder="PW 입력" />
			          </tr>
			        </c:if>			          
		    	</table>  
		    </div>
		    
		    <div class="bottom">
		    	<input class="button" type="submit" onClick="location.href='wrtie.do'" value="저장" />
		    </div>
		</div>
	</form>
</body>
</html>