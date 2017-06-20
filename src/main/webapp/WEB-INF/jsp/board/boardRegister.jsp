<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"         uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"      uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring"    uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="registerFlag" value="${empty boardVO.no ? 'I' : 'U'}"/>
<title>게시판페이지</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#insert').click(function(){
		$('#form').attr("action","/board/insert.do").submit();
	});
	$('#update').click(function(){
		$('#form').attr("action","/board/update.do").submit();
	});
});
</script>
</head>
<body>
	<form name="form" id="form" method="post" action="" >
	<table>
		<colgroup>
			<col width="150"></col>
			<col width="?"></col>
		</colgroup>
		<tbody>
			<tr>
				<td>번호</td>
				<td><input type="text" name="no" id="no" value='<c:if test="${boardVO.no ne null}">${boardVO.no}</c:if>'/></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject" id="subject" value="<c:if test="${boardVO.subject ne null}">${boardVO.subject}</c:if>"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="content" id="content" value="<c:if test="${boardVO.content ne null}">${boardVO.content}</c:if>"/></td>
			</tr>
			<tr>
				<td>날짜</td>
				<td><input type="text" name="creatEd" id="creatEd" value="<c:if test="${boardVO.creatEd ne null}">${boardVO.creatEd}</c:if>"/></td>
			</tr>
			<tr>
				<c:if test="${registerFlag == 'I' }"><td colspan="2" style="text-align: center;"><input type="button" value="등록" id="insert" ></td></c:if>
				<c:if test="${registerFlag == 'U' }"><td colspan="2" style="text-align: center;"><input type="button" value="수정" id="update" ></td></c:if>
				<c:if test="${registerFlag == 'D' }"><td colspan="2" style="text-align: center;"><input type="button" value="수정" id="delete" ></td></c:if>
			</tr>
		</tbody>
	</table>
    <%-- <input type="hidden" name="searchKeyword" value="<c:out value='${searchVO.searchKeyword}'/>"/>
    <input type="hidden" name="pageIndex" value="<c:out value='${searchVO.pageIndex}'/>"/> --%>
    </form>
</body>
</html>