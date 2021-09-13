<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>게시물 편집</title>
	<link href="<c:url value="/css/editContent.css" />" rel='stylesheet' />
</head>
<body>
	<form action="" method="POST">
		<div class="container">
		  	<div class="top">
		  	  <h2> 게시물 작성 / 수정  </h2>	  
		 	</div>
		 	
		  	<div class="middle">
		    	<table>
			          <tr>
			          	<td bgcolor="#EDEDED">제목</td>
			          	<td colspan="3"><input style="width: 380px" type="text" id="con_title" placeholder="제목 입력"></td>
			          </tr>
			          <tr>
			          	<td style= "height: 200px;" bgcolor="#EDEDED">내용</td>
			          	<td colspan="3"><textarea rows="18" cols="50" style = "resize:none;"></textarea></td>
			          </tr>
			          <tr>
			          	<td style= "width: 90px;" bgcolor="#EDEDED">ID</td>
			          	<td><input type="text" placeholder="ID 입력"/></td>
			          	<td style= "width: 80px;" bgcolor="#EDEDED">PW</td>
			          	<td><input type="password" placeholder="PW 입력"/></td>
			          </tr>
		    	</table>  
		    </div>
		    
		    <div class="bottom">
		    	<input class="button" type="submit" value="저장" />
		    </div>
		</div>
	</form>
</body>
</html>