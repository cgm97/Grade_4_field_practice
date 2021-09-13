<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
	<title>DB Test</title>
	 <link href="<c:url value="/css/main.css" />" rel='stylesheet' />
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
	  		<input type="button" class="button" value="검색" />
	    </div>
	    
	    <div>
	      	<table>
	      		<colgroup>
	      			<col style="width:5%;" />
	      			<col style="width:55%;" />
	      			<col style="width:5%;" />
	      			<col style="width:5%;" />
	      			<col style="width:5%;" />
	      		</colgroup>
	      		<thead>
	          		<tr  bgcolor="grey">
	              		<th>No.</th>
	                    <th>제목</th>
	                    <th>작성자</th>
	                  	<th>등록일</th>
	                 	<th>조회수</th>
	              	</tr>
	        	</thead>
	          	<tbody>
	          		<tr>
	              		<td>No.</td>
	                    <td>제목</td>
	                    <td>작성자</td>
	                  	<td>등록일</td>
	                 	<td>조회수</td>
	              	</tr>
	             	<tr>
	              		<td>No.</td>
	                    <td>제목</td>
	                    <td>작성자</td>
	                  	<td>등록일</td>
	                 	<td>조회수</td>
	              	</tr>
	              	<tr>
	              		<td>No.</td>
	                    <td>제목</td>
	                    <td>작성자</td>
	                  	<td>등록일</td>
	                 	<td>조회수</td>
	              	</tr>
	            </tbody>
	      	</table>
	    </div>
   </div>
   
    <div class='bottom'>
      <div class="pagingBtn">페이지 이동</div>
      <div class="writeBtn"><input type="button" class="button" value="글쓰기" /></div>
    </div>
    
</body>
</html>
