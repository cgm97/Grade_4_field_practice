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
	<div class="title">
		<input class="fas fa-chevron-circle-left fa-3x" type="button" onclick="location.href='/board'"/>
		<label style="font:45px bold;">게시물 상세보기</label>
	</div>
		<div class="container">
			<div class="middle">
		    	<table>
		    		<colgroup>
		    			<col style="width:10%;" />
	      				<col style="width:80%;" />
		    		</colgroup>
			          <tr>
			          	<td bgcolor="#EDEDED">제목</td>
			          	<td colspan="3"><span style="font:20px bold;">${content.getCon_title()}</span></td>
			          </tr>
			          <tr>
			          	<td style= "height: 200px;" bgcolor="#EDEDED">내용</td>
			          	<td colspan="3">${content.getCon_txt()}</td>
			          </tr>
	    		</table>  
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