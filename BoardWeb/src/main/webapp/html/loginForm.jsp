<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<form action="login.do" method="POST">
<h3>로그인 화면(login.Form.jsp)</h3>
<table>
  <tr>
    <th>아이디</th>
    <td><input type="text" class="form-control" name="id"></td>
  </tr>
    
   <tr>
    <th>비밀번호</th>
    <td><input type="password" class="form-control" name="pw"></td>
   </tr>
   
    <tr>
    	<td align="center" align="center">
    	<input type="submit" class="btn btn-primary" value="로그인">
    	</td>
    </tr>
</table>
</form>







<jsp:include page="../includes/footer.jsp"></jsp:include>