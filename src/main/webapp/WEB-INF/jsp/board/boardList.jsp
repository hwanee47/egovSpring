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
</head>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#write').click(function(){
		location.href="/board/insert.do";
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
<body>
<form name="form" id="form" method="post">
<table>
	<thead>번호</thead>
	<thead>제목</thead>
	<thead>내용</thead>
	<thead>날짜</thead>
	<tbody>
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
			<td colspan="4" style="text-align: center;"><input type="button" value="글쓰기" id="write" ></td>
		</tr>
	</tbody>
</table>
<div id="paging">
	<ui:pagination paginationInfo = "${paginationInfo}" type="text" jsFunction="link_page" />
	<input type="hidden" name="pageIndex" id="pageIndex" value="${searchVO.pageIndex}" />
</div>
</form>
</body>
</html>
