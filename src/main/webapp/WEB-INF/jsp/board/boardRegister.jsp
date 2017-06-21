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
			alert('제목을 입력해주세요.');
		}else if($.trim($('#content').val()) == "" ){
			alert('내용을 입력해주세요.');
		}else{
			$('#form').attr("action","/board/insert.do").submit();
		}
	});
	$('#update').click(function(){
		if($.trim($('#subject').val()) == "" ){
			alert('제목을 입력해주세요.');
		}else if($.trim($('#content').val()) == "" ){
			alert('내용을 입력해주세요.');
		}else{
			$('#form').attr("action","/board/update.do").submit();
		}
	});
	$('#delete').click(function(){
		$('#form').attr("action","/board/delete.do").submit();
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
				<td>번호</td> 
				<td><input type="text" class="form-control" readOnly name="no" id="no" value='<c:if test="${boardVO.no ne null}">${boardVO.no}</c:if>'/></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" class="form-control" name="subject" id="subject" value="<c:if test="${boardVO.subject ne null}">${boardVO.subject}</c:if>"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" class="form-control" name="content" id="content" value="<c:if test="${boardVO.content ne null}">${boardVO.content}</c:if>"/></td>
			</tr>
			<tr>
				<td>날짜</td>
				<td><input type="text" class="form-control" readOnly name="creatEd" id="creatEd" value="<c:if test="${boardVO.creatEd ne null}">${boardVO.creatEd}</c:if>"/></td>
			</tr>
			<tr>
				<c:if test="${registerFlag == 'I' }"><td colspan="2" style="text-align: center;"><input type="button" class="btn btn-default" value="등록" id="insert" ></td></c:if>
				<c:if test="${registerFlag == 'U' }">
				<td colspan="2" style="text-align: center;"><input type="button" class="btn btn-primary" value="수정" id="update" >
				<input type="button" class="btn btn-danger" value="삭제" id="delete" >	
				</td></c:if>
			</tr>
			<tr>
			</tr>
		</tbody>
	</table>
    </form>
</body>
</html>