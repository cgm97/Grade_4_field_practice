<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
	<title>업무 관리 게시판</title>
	<link href="<c:url value="/css/boardList.css" />" rel='stylesheet' />
	<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
</head>
<script>
	var content = function(data){

		var form = document.content;
		form.con_no.value = data;
		form.key.value = 0;

	    form.action = "<c:url value='/notice/detailContent.do' />";
	    form.method = "POST";
	    form.submit();
	};
	var key = function(data){

		var form = document.content;
		form.con_no.value = null;
		form.key.value = data;

	    form.action = "<c:url value='/notice/editContent.do' />";
	    form.method = "POST";
	    form.submit();
	};
</script>
<body>
	<div class="title">
		<label style="font:45px bold;">공지사항</label>
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
	          	<c:forEach var="boardList" items="${boardList}">
	          		<tr>
	              		<td style="text-align: center;"><c:out value="${boardList.getCon_no()}" /></td>
	                    <td><a href="javascript:content(${boardList.getCon_no()});"><c:out value="${boardList.getCon_title()}" /></a></td>
	                    <td style="text-align: center;"><c:out value="${boardList.getCon_id()}" /></td>
	                  	<td style="text-align: center;"><c:out value="${boardList.getReg_date()}" /></td>
	                 	<td style="text-align: center;"><c:out value="${boardList.getRead_count()}"/></td>
	              	</tr>
	          	</c:forEach>
	            </tbody>
	      	</table>
	    </div>
   </div>
   
    <div class='bottom'>
      <div class="pagingBtn">1 2 3 4 5</div>
      <div class="writeBtn"><input class="button" type="button" onclick="key(1);" value="글쓰기" /></div>
    </div>
    <form name="content">
    	<input type="hidden" name="con_no"/>
    	<input type="hidden" name="key"/>
    </form>
</body>
</html>