<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
	<title>업무 관리 게시판</title>
	<link href="<c:url value="/css/boardList.css" />" rel='stylesheet' />
</head>
<script>
	var content = function(data){

		var form = document.content;
		form.con_no.value = data;
		form.key.value = 0; // form 하나 쓰기위해 지정함

	    form.action = "<c:url value='/notice/detailContent.do' />";
	    form.method = "POST";
	    form.submit();
	};
	var key = function(data){

		var form = document.content;
		form.con_no.value = null; // form 하나 쓰기위해 지정함
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
	    	<form action='<c:url value="/notice/search.do" />' method="POST">	    	
		    	<select name="search_option">
		    		<option value="title">제목</option>
		    		<option value="id">작성자</option>
		    	</select>
		  		<input type="text" name="keyword" placeholder="검색어 입력" />
		  		<input type="submit" value="검색"  />
	    	</form>
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
	              		<td style="text-align: center;"><c:out value="${boardList.getRn()}" /></td>
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
    
      <div class="pagingBtn">
		  <ul>
		    <c:if test="${pageMaker.prev}">
		    	<li><a href="list.do${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
		    </c:if> 
		
		    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
		    	<li><a href="list.do${pageMaker.makeQuery(idx)}">${idx}</a></li>
		    </c:forEach>
		
		    <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
		    	<li><a href="list.do${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
		    </c:if> 
		  </ul>
      </div>
      
      <div class="writeBtn"><input class="button" type="button" onclick="key(1);" value="글쓰기" /></div>
    </div>
    <form name="content"> <!-- 상세보기 와 글쓰기 판단 후 POST 하기 위한 FORM -->
    	<input type="hidden" name="con_no"/>
    	<input type="hidden" name="key"/>
    </form>
</body>
</html>
