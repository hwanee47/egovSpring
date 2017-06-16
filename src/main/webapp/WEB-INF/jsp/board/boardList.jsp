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

<body>
<table>
	<thead></thead>
	<thead></thead>
	<thead></thead>
	<thead></thead>
	<tbody>
		<tr>
			<c:forEach var="list" items="${list}">
				<td>${list.no}</td>
				<td>${list.subject}</td>
				<td>${list.content}</td>
				<td>${list.creatEd}</td>
			</c:forEach>
		</tr>
	</tbody>
</table>
</body>
</html>
