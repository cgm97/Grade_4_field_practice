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
<script>
function identification(key,con_no){ 
	var url = "/board/identification.do?key="+ key +"&&con_no="+con_no;
	var name = "본인 확인";
	var option = "width = 600, height = 600 left = 100, top=50,location=no";
	window.open(url,name,option)

};
</script>
<body>	
	<div class="title">
		<div class="back">
			<input class="fas fa-chevron-circle-left fa-3x" type="button" onclick="location.href='/board'"/>		
		</div>
		<div>
			<label style="font:45px bold;">게시물 상세보기</label>		
		</div>
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
				<input class="fas fa-angle-double-left" type="button" onClick="location.href='/board/content?con_no=${con_no-1}'" />
				<input type="button" class="button"  onclick="identification(2, ${con_no})" value="수정" />
				<input class="button-delete" type="button" onclick="identification(3, ${con_no})" value="삭제" />
				<input class="fas fa-angle-double-right" type="button" onClick="location.href='/board/content?con_no=${con_no+1}'" />
			</div>
		</div>
</body>
</html>