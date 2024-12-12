<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
	<h3>글상세화면(board.jsp)</h3>
	<%
	BoardVO bvo = (BoardVO) request.getAttribute("board");
	//파라미터 추가작업. 2024 12.12
	String sc = (String) request.getAttribute("searchConditon");
	String kw = (String) request.getAttribute("keyword");
	String pg = (String) request.getAttribute("page");
	%>
	<form action="modifyForm.do">
	<input type="hidden" name="board_no" value="${board.boardNo}">
	<!-- 파라미터 추가작업. 2024 12.12 -->
	<input type="hidden" name="searchConditon" value="${searchConditon}">
	<input type="hidden" name="keyword" value="${keyword}">
	<input type="hidden" name="page" value="${page}">
	<table class="table">
	<tr>
		<th>글번호</th><td><c:out value ="${board.boardNo}"></c:out></td>
		<th>작성자</th><td><c:out value ="${board.writer}"></c:out></td>
	</tr>
	<tr>
		<th>제목</th><td>${board.title}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="3">
		<textarea rows="5" readonly class="form-control"><c:out value ="${board.content}"></c:out></textarea>
		</td>
	</tr>
	<tr>
	<th>작성일시</th><td><c:out value ="${board.creationDate}"></c:out></td>
	<th>조회수</th><td><c:out value ="${board.viewCnt}"></c:out></td>
	</tr>
	<tr>
	<td colspan="4" align="center">
	


	<!--로그인 상태  권한에 따라 활성화 비활설화-->
	<!--로그인상태 아니면 -> 권한없음.-->
	
	<c:choose>
	<c:when test="${logId ne null and board.writer == logId }">
	 <input type="submit" class="btn btn-warning" value="수정화면" >
	 </c:when>
	 
	<c:otherwise>
	 <input type="submit" class="btn btn-warning" value="수정화면" disabled>
	
	 </c:otherwise>
	 </c:choose>
	 </td>
	 </tr>
	</table>
	</form>
<jsp:include page="../includes/footer.jsp"></jsp:include>
