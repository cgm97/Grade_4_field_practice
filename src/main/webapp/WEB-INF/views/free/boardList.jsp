<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="com.joyandbiz.board.controller.FreeController" %>
<c:set var="TARGET" value="${FreeController.TARGET}" />

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
		form.key.value = 0; // form 하나 쓰기위해 지정함

	    form.action = "<c:url value='/${TARGET}/detailContent.do' />";
	    form.method = "POST";
	    form.submit();
	};
	var key = function(data){

		var form = document.content;
		form.con_no.value = null; // form 하나 쓰기위해 지정함
		form.key.value = data;

	    form.action = "<c:url value='/${TARGET}/editContent.do' />";
	    form.method = "POST";
	    form.submit();
	};
	var paging = function(page){

		var form = document.paging;
		form.page.value = page; // form 하나 쓰기위해 지정함
		form.searchType.value = "${SearchAndPagingData.get('searchType')}";
		form.keyword.value = "${SearchAndPagingData.get('keyword')}";
	    form.action = "<c:url value='/${TARGET}/list.do' />";
	    form.method = "GET";
	    form.submit();
	};
</script>
<body>
	<div class="title">
		<input class="fas fa-chevron-circle-left fa-3x" type="button" onclick="location.href='/board/'"/>		
		<label style="font:45px bold;">자유게시판 </label>
	</div>
	<div class="container">
	    <div class="top">
	    	<%-- <form action='<c:url value="/notice/search.do" />' method="POST"> --%>	    	
	    	<form action='<c:url value="/free/list.do" />' method="GET">
		    	<!-- <select name="search_option">
		    		<option value="title">제목</option>
		    		<option value="id">작성자</option>
		    	</select> -->
		    	<select name="searchType">
		    		<option value="title" <c:if test="${SearchAndPagingData.get('searchType') eq 'title' }"> selected </c:if>>제목</option>
		    		<option value="id" <c:if test="${SearchAndPagingData.get('searchType') eq 'id'}"> selected </c:if>>작성자</option>
		    	</select>
		    	
		  		<input type="text" name="keyword" placeholder="검색어 입력" value="${SearchAndPagingData.get('keyword')}"/> 
		  		    	<input type="hidden" name="page" value="1"/>
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
	          	<c:if test="${boardList ne null}">
		          	<c:forEach var="boardList" items="${boardList}">
		          		<tr>
		              		<td style="text-align: center;"><c:out value="${boardList.get('RN')}" /></td>
		                    <td><a href="javascript:content(${boardList.get('CON_NO')});"><c:out value="${boardList.get('CON_TITLE')}" /></a></td>
		                    <td style="text-align: center;"><c:out value="${boardList.get('CON_ID')}" /></td>
		                  	<td style="text-align: center;"><c:out value="${boardList.get('REG_DATE')}" /></td>
		                 	<td style="text-align: center;"><c:out value="${boardList.get('READ_COUNT')}"/></td>
		              	</tr>
		          	</c:forEach>
	          	</c:if>
	          	<c:if test="${boardList.isEmpty()}">		       
	          		<tr>
	              		<td colspan="5" style="text-align: center;">검색된 데이터 없음</td>
	              	</tr>
	          	</c:if>
	            </tbody>
	      	</table>
	    </div>
   </div>
   
    <div class='bottom'>
    <c:if test="${!boardList.isEmpty()}">	
      <div class="pagination">
	      <ul>
		    <c:if test="${SearchAndPagingData.prev}">
				<li> <a href="javascript:paging(${SearchAndPagingData.startPage - 1})">이전</a></li>
		    </c:if> 
			
			
			    <c:forEach begin="${SearchAndPagingData.get('startPage')}" end="${SearchAndPagingData.get('endPage')}" var="idx">
					<li <c:out value="${SearchAndPagingData.page == idx ? 'class=active' : '' }"/>> <a href="javascript:paging(${idx});">${idx}</a></li>
			    </c:forEach>		
			
		
		    <c:if test="${SearchAndPagingData.next && SearchAndPagingData.endPage > 0}">
				<li><a href="javascript:paging(${SearchAndPagingData.endPage + 1})">다음</a></li>
		    </c:if> 
		  </ul>
      </div>
     </c:if>
      <div class="writeBtn"><input class="button" type="button" onclick="key(1);" value="글쓰기" /></div>
    </div>
    <form name="content"> <!-- 상세보기 와 글쓰기 판단 후 POST 하기 위한 FORM -->
    	<input type="hidden" name="con_no"/>
    	<input type="hidden" name="key"/>
    </form>
    
    <form name="paging"> <!-- 상세보기 와 글쓰기 판단 후 POST 하기 위한 FORM -->
    	<input type="hidden" name="page"/>
    	<input type="hidden" name="searchType"/>
    	<input type="hidden" name="keyword"/>
    </form>
</body>
</html>
