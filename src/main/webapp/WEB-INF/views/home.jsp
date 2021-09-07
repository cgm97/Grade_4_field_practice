<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
	<title>DB Test</title>
</head>
<body>
	<h1>
		DB 테스트
	</h1>
	<form action="<c:url value="/searchMember" />" method="POST">
		<input type="submit" value="멤버 조회" />
	</form>
	<button type="button" onclick="location.href='addMember'">멤버 추가</button>
</body>
</html>
