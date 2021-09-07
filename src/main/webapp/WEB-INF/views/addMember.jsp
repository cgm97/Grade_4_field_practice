<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<c:url value="/addMember.do" />" method="post">
		<table>
			<thead> 
				<tr><th>이름</th><th>나이</th></tr>
			</thead>
			<tbody>
				<tr>
					<th><input type="text" name="name" /></th>
					<th><input type="number" name="age" /></th>
				</tr>
			</tbody>
		</table>
		<input type="submit" value="멤버 추가" />
	</form>
	
</body>
</html>