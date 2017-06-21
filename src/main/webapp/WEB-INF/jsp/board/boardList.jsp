<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판페이지</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"> 
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> 
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#write').click(function(){
		location.href="/board/insert.do";
	});
	$('#searchList').click(function(){
		$('#form').attr("action","/board/list.do").submit();
	});
});
function select(no){
	location.href="/board/update.do?no="+no;
}
function link_page(pageNo){
	$('#pageIndex').val(pageNo);
	$('#form').attr("action","/board/list.do").submit();
}
</script>
</head>
<body>
<form name="form" id="form" method="post">
<table class="table table-hover">
	<colgroup>
		<col width="25%"/>
		<col width="?"/>
		<col width="?"/>
		<col width="?"/>
	</colgroup>
	<tbody>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>내용</th>
		<th>날짜</th>
	</tr>
		<c:forEach var="list" items="${list}">
		<tr>
			<input type="hidden" name="no" />
			<td>${list.no}</td>
			<td><a href="javascript:select('<c:out value="${list.no}"/>')"><c:out value="${list.subject}"/></a></td>
			<td>${list.content}</td>
			<td>${list.creatEd}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="4" style="text-align: center;"><input type="button" class="btn btn-primary" value="글쓰기" id="write" ></td>
		</tr>
		<tr>
			<td colspan="4" style="text-align: center;">
			<div class="row">
			  <div class="col-xs-6 col-md-4">
					<select name="searchCondition"  class="form-control">
					<option value="subject" <c:if test="${searchVO.searchCondition  == 'subject'}"> selected </c:if>>제목</option>
					<option value="content" <c:if test="${searchVO.searchCondition  == 'content'}"> selected </c:if>>내용</option>
					</select>
			  </div>
			  <div class="col-xs-6 col-md-4">
				<input type="text" name="searchKeyword" id="searchKeyword" class="form-control" value="${searchVO.searchKeyword}"/>
		      </div>
			  <div class="col-xs-6 col-md-4">
				<input type="button" name="searchList" id="searchList" class="btn btn-default" value="검색"/>	
			  </div>
			</div>
			</td>
		</tr>
		<tr>
			<td colspan="4" style="text-align: center;">
				<ui:pagination paginationInfo = "${paginationInfo}" type="text" jsFunction="link_page" />
				<input type="hidden" name="pageIndex" id="pageIndex" value="${searchVO.pageIndex}" />
			</td>
		</tr>
	</tbody>
</table>
</form>
</body>
</html>
