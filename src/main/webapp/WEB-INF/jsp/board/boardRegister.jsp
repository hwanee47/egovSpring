<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"         uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"      uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring"    uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="registerFlag" value="${empty boardVO.no ? 'I' : empty boardVO.no == 'U' ? 'U' : 'D'}"/>
<title>게시판페이지</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"> 
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> 
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#insert').click(function(){
		if($.trim($('#subject').val()) == "" ){
			alert('<spring:message code="subject.null"/>');
		}else if($.trim($('#content').val()) == "" ){
			alert('<spring:message code="content.null"/>');
		}else{
			$('#form').attr("action","/project/board/insert.do").submit();
		}
	});
	$('#update').click(function(){
		if($.trim($('#subject').val()) == "" ){
			alert('<spring:message code="subject.null"/>');
		}else if($.trim($('#content').val()) == "" ){
			alert('<spring:message code="content.null"/>');
		}else{
			$('#form').attr("action","/project/board/update.do").submit();
		}
	});
	$('#delete').click(function(){
		$('#form').attr("action","/project/board/delete.do").submit();
	});
});
</script>
</head>
<body>
	<form name="form" id="form" method="post" action="" >
	<table class="table table-hover">
		<colgroup>
			<col width="150"></col>
			<col width="?"></col>
		</colgroup>
		<tbody>
			<tr>
				<td>NO</td> 
				<td><input type="text" class="form-control" readOnly name="no" id="no" value='<c:if test="${boardVO.no ne null}">${boardVO.no}</c:if>'/></td>
			</tr>
			<tr>
				<td><spring:message code="board.subject"/></td>
				<td><input type="text" class="form-control" name="subject" id="subject" value="<c:if test="${boardVO.subject ne null}">${boardVO.subject}</c:if>"/></td>
			</tr>
			<tr>
				<td><spring:message code="board.content"/></td>
				<td><input type="text" class="form-control" name="content" id="content" value="<c:if test="${boardVO.content ne null}">${boardVO.content}</c:if>"/></td>
			</tr>
			<tr>
				<td><spring:message code="board.date"/></td>
				<td><input type="text" class="form-control" readOnly name="creatEd" id="creatEd" value="<c:if test="${boardVO.creatEd ne null}">${boardVO.creatEd}</c:if>"/></td>
			</tr>
			<tr>
				<c:if test="${registerFlag == 'I' }"><td colspan="2" style="text-align: center;"><input type="button" class="btn btn-default" value="<spring:message code="button.create"/>" id="insert" ></td></c:if>
				<c:if test="${registerFlag == 'U' }">
				<td colspan="2" style="text-align: center;"><input type="button" class="btn btn-primary" value="<spring:message code="button.modify"/>" id="update" >
				<input type="button" class="btn btn-danger" value="<spring:message code="button.delete"/>" id="delete" >	
				</td></c:if>
			</tr>
			<tr>
			</tr>
		</tbody>
	</table>
    </form>
</body>
</html>