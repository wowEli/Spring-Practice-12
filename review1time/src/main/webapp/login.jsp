<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
  table {
    width: 100%;
    border: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border: 1px solid #444444;
    padding: 10px;
  }
</style>
<body>
<form action="login.do" method="POST">
 <table>
      <thead>
        <tr>
          <th>아이디</th><th>비밀번호</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td><input type="text" name="mid" style="width: 100%"></td><td><input type="password" name="mpw" style="width: 100%"></td><td rowsapn="2"><input type="submit" value="로그인" style="width: 100%"></td>
        </tr>
      </tbody>
    </table>
</form>
</body>
</html>