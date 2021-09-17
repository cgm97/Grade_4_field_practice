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
	window.onload = function(){

		var key = "<c:out value='${key}'/>"; 
		var flag = ${flag}
		console.log(flag);
		
		// 수정 본인인증 판단 후
		if (flag == true && key == 2) {
			alert("수정 본인 인증 성공")
			window.opener.name = "editContent"; // 부모창의 이름 설정
		    document.identify.target = "editContent"; // 타켓을 부모창으로 설정
		    document.identify.key.value = key;
		    document.identify.con_no.value = "${boardInfo.getCon_no()}"
		    document.identify.con_title.value = "${boardInfo.getCon_title()}";
		    document.identify.con_txt.value = "${boardInfo.getCon_txt()}"
		    document.identify.action = "/board/notice/editContent.do";
		    document.identify.method = "POST"
		    document.identify.submit();
		    self.close();
		}
		// 삭제 본인인증 판단 후
		else if (flag == true && key == 3) {
			alert("삭제 본인 인증 성공")
			window.opener.name = "editContent"; // 부모창의 이름 설정
		    document.identify.target = "editContent"; // 타켓을 부모창으로 설정
		    document.identify.key.value = key;
		    document.identify.con_no.value = "${boardInfo.getCon_no()}"
		    document.identify.action = "/board/notice/delete.do";
		    document.identify.method = "POST"
		    document.identify.submit();
		    self.close();
		}
		else if (flag == false) { 
			alert("본인 인증 실패")
			window.close();
		}

	};
	// 수정 본인인증
	var submit = function(con_no) {
		
		var form =  document.beforeIdentify;
		form.key.value = 2;
		form.con_no.value = "${boardInfo.getCon_no()}"
		form.con_title.value = "${boardInfo.getCon_title()}";
		form.con_txt.value = "${boardInfo.getCon_txt()}"
		form.submit();
	};
	// 삭제 본인인증
	var del = function(con_no) {
		var choice = confirm("해당 게시물 정말 삭제 하시겠습니까?");
		
		if(choice){
			var form =  document.beforeIdentify;
			form.key.value = 3;
			form.con_no.value = "${boardInfo.getCon_no()}"
			form.submit();
		}
		else {
			alert('삭제가 취소되었습니다.');
			windeo.close();
		}
	};
</script>
<body>
	<div class="container">
		<c:if test="${boardInfo.getKey() eq 2}">
			<h2>게시물 수정 본인확인</h2>
		</c:if>
		<c:if test="${boardInfo.getKey() eq 3}">
			<h2>게시물 삭제 본인확인</h2>
		</c:if>
		<form name="beforeIdentify" action="/board/notice/checkIdentify.do" method="POST"> <!-- 본인인증 하기 전 -->
			<div class="idDiv">
				<i style="width: 50px; height: 28px" class="fas fa-user fa-lg"></i>
				<input type="text" name="con_id" placeholder="ID 입력" size="30"/>	
			</div>	
			<div class="pwDiv">
				<i style="width: 50px; height: 28px" class="fas fa-key fa-lg"></i>
				<input type="password" name="password" placeholder="PW 입력" size="30"/>	
			</div>
			<input type="hidden" name="con_no"/>	<!-- 수정페이지에 전달하기 위햐 사용 -->
			<input type="hidden" name="con_txt"/>	
			<input type="hidden" name="con_title"/>	
			<input type="hidden" name="key" />
		</form>
		
		<form name="identify"> <!-- 본인인증 된 후  제목, 내용 수정페이지에 전달하기 위해 사용-->
			<input type="hidden" name="key" />
			<input type="hidden" name="con_no"/>	
			<input type="hidden" name="con_title" />	
			<input type="hidden" name="con_txt" />	
		</form>
		
		<div class="bottom">
			<div class="item">
				<i class="fas fa-user-check fa-3x"></i>
				<p style="font-size: 20px;">작성자 본인 확인</p>
			</div>
			
			<c:if test="${boardInfo.getKey() eq 2}">
				<div style="padding-left: 95px">
					<input class="button-cancel" type="button" onclick="window.close();" value="Cancel" />
					<!-- 비동기 처리 수정 -->
					<input class="button" type="button" value="OK" onClick="submit(${boardInfo.getCon_no()});"/>
				</div>
			</c:if>
			<c:if test="${boardInfo.getKey() eq 3}">
				<div style="padding-left: 95px">
					<input class="button-cancel" type="button" onclick="window.close()" value="Cancel" />
					<!-- 비동기 처리 삭제 -->
					<input class="button" type="button" value="OK" onClick="del(${boardInfo.getCon_no()});"/>
				</div>
			</c:if>
			
		</div>
	</div>
</body>
</html>