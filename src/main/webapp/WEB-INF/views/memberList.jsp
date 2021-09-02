<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<title>DB 확인</title>
<style>
  table {
    width: 10%;
    border: 1px solid #444444;
  }
  th, td {
    border: 1px solid #444444;
  }
</style>
</head>
<body>
	<p>
	DB 이름 조회 결과
	</p>
	
	<table>
		<thead> 
			<tr><th>이름</th><th>나이</th></tr>
		</thead>
		<tbody>
			<c:forEach var="member" items="${member}">
				<tr>
					<th>${member.getName()}</th>
					<th>${member.getAge()}</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>