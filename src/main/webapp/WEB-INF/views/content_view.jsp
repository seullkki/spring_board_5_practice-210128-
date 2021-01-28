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
<form action="modify" >
	<table>
		<input type="hidden" name="iId" value="${content_view.iId }" />			<!-- 아래 id는 폼태그가 아니므로 넘어가지 않으니, hidden으로 값을 줘야 수정할 떄 id를 조건으로 줄 수 있음. -->
		<tr>																	<!-- 매우 주의 : 폼태그에 name 꼭 줘야 함!!!!! -->
			<td>번호</td>
			<td>${content_view.iId}</td>
		</tr>		
	
		<tr>
			<td>조회수</td>
			<td>${content_view.iHit}</td>
		</tr>		
	
		<tr>
			<td>이름</td>
			<td><input type="text" name="iName" value="${content_view.iName}"/></td>		<!-- 주의 : value로 넣어줘야 내용이 폼 안에 들어감 -->
		</tr>																		
		
		<tr>
			<td>제목</td>
			<td><input type="text" name="iTitle" value="${content_view.iTitle}"/></td>
		</tr>	

		<tr>
			<td>내용</td>
			<td><input type="text" name="iContent" value="${content_view.iContent}"/></td>
		</tr>	
		
		<tr>
			<td colspan="2">
				<input type="submit" value="수정" />
				<a href="list">목록 보기</a>
				<a href="delete?iId=${content_view.iId}">삭제</a>
				<a href="reply_view?iId=${content_view.iId}">답변</a>
			</td>
		</tr>
	</table>
</form>
</body>
</html>
