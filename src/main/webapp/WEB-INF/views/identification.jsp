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
<script>
	function submit(con_no) {
		
		// 비동기로 처리해야함 오류난다.
		var form =  document.identify;
		
		form.submit();
		//window.close();
	};
	function del(con_no) {
		var choice = confirm(con_no + " 해당 게시물 정말 삭제 하시겠습니까?");
		
		if(choice){
			window.close();
		}
		else {
			alert('거절');
			windeo.close();
		}
	};
</script>
<body>
	<div class="container">
		<c:if test="${key eq 2}">
			<h2>게시물 수정 본인확인</h2>
		</c:if>
		<c:if test="${key eq 3}">
			<h2>게시물 삭제 본인확인</h2>
		</c:if>
		
		<form name="identify" action="/board/update" method="POST">
			<div class="idDiv">
				<i style="width: 50px; height: 28px" class="fas fa-user fa-lg"></i>
				<input type="text" name="con_id" placeholder="ID 입력" size="30"/>	
			</div>	
			<div class="pwDiv">
				<i style="width: 50px; height: 28px" class="fas fa-key fa-lg"></i>
				<input type="password" name="password" placeholder="PW 입력" size="30"/>	
			</div>
		</form>
		
		<div class="bottom">
			<div class="item">
				<i class="fas fa-user-check fa-3x"></i>
				<p style="font-size: 20px;">작성자 본인 확인</p>
			</div>
			
			<c:if test="${key eq 2}">
				<div style="padding-left: 95px">
					<input class="button-cancel" type="button" onclick="window.close();" value="Cancel" />
					<!-- 비동기 처리 수정 삭제 con_no-->
					<input class="button" type="button" value="OK" onClick="submit(${con_no});"/>
				</div>
			</c:if>
			<c:if test="${key eq 3}">
				<div style="padding-left: 95px">
					<input class="button-cancel" type="button" onclick="window.close()" value="Cancel" />
					<!-- 비동기 처리 수정 삭제 -->
					<input class="button" type="button" value="OK" onClick="del(${con_no});"/>
				</div>
			</c:if>
			
		</div>
	</div>
</body>
</html>