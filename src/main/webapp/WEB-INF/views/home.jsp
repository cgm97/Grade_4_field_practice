<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
	<title>업무 관리 게시판</title>
	<link href="<c:url value="/css/main.css" />" rel='stylesheet' />
	<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
</head>
<body>
<!--  
	<h1>
		DB 테스트
	</h1>
	<form action="<c:url value="/searchMember" />" method="POST">
		<input type="submit" value="멤버 조회" />
	</form>
	<button type="button" onclick="location.href='addMember'">멤버 추가</button>
-->
	<div class="title">
		<label style="font:40px bold;">공지사항</label>
	</div>
	<div class="container">
	    <div class="top">
	    	<select>
	    		<option>제목</option>
	    		<option>작성자</option>
	    	</select>
	  		<input type="text" placeholder="검색어 입력" />
	  		<input type="button" class="fas fa-search fa-lg"  />
	    </div>
	    
	    <div>
	      	<table>
	      		<colgroup>
	      			<col style="width:5%;" />
	      			<col style="width:52%;" />
	      			<col style="width:8%;" />
	      			<col style="width:5%;" />
	      			<col style="width:5%;" />
	      		</colgroup>
	      		<thead>
	          		<tr bgcolor="#EDEDED">
	              		<th>No.</th>
	                    <th>제목</th>
	                    <th>작성자</th>
	                  	<th>등록일</th>
	                 	<th>조회수</th>
	              	</tr>
	        	</thead>
	          	<tbody>
	          	<c:forEach var="boardList" items="${getBoardList}">
	          		<tr>
	              		<td>${boardList.getCon_no()}</td>
	                    <td><a href="content?con_no=${boardList.getCon_no()}">${boardList.getCon_title()}</a></td>
	                    <td>${boardList.getCon_id()}</td>
	                  	<td>${boardList.getReg_date()}</td>
	                 	<td>${boardList.getRead_count()}</td>
	              	</tr>
	          	</c:forEach>
	            </tbody>
	      	</table>
	    </div>
   </div>
   
    <div class='bottom'>
      <div class="pagingBtn">1 2 3 4 5</div>
      <div class="writeBtn"><input class="button" type="button" onClick="location.href='editContent?key=1'" value="글쓰기" /></div>
    </div>
    
</body>
</html>
