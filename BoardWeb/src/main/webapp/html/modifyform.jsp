<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
	<h3>글수정화면(modify.jsp)</h3>
	
	<form action="modifyForm.do" method="post">
	<table class="table">
	<tr>
		<th>글번호</th><td></td>
		<th>작성자</th><td></td>
	</tr>
	<tr>
		<th>제목</th><td></td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="3">
		<textarea rows="5" readonly class="form-control"></textarea>
		</td>
	</tr>
	<tr>
	<th>작성일시</th><td></td>
	<th>조회수</th><td></td>
	</tr>
	<tr>
	<td colspan="4" align="center">
	 <input type="submit" class="btn btn-warning" value="수정">
	 </td>
	 </tr>
	</table>
	</form>
<jsp:include page="../includes/footer.jsp"></jsp:include>
    