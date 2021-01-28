<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">							<!-- 한글 깨짐 방지하기!!! / 반복문 돌리기 위해 태그 라이브러리 가져오기!!! -->
<title>Home</title>								<!-- EL은 예민해서 주석에만 써도 에러날 수 있으니 주의할 것!!! -->
<style>
	table, tr, td{
		border:1px solid black;
	}
	
	table{	
		width:500px;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td>히트</td>
		</tr>	
		
		<c:forEach items="${list }" var="list">
		<tr>
			<td>${list.iId }</td>
			<td>${list.iName }</td>
			<td>
				<c:forEach begin="1" end="${list.iIndent }">[re:]</c:forEach>		
				<a href="content_view?iId=${list.iId }">${list.iTitle }</a>			
			</td>
			<td>${list.iDate }</td>
			<td>${list.iHit }</td>
		</tr>
		</c:forEach>
		
		<tr>
			<td colspan="5"><a href="write_view">글 작성</a></td>
		</tr>
	</table>
</body>
</html>
