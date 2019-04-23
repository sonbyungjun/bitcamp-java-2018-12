<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
</head>
<body>
  <jsp:include page="../header.jsp" />
  <h1>회원가입</h1>
  <form action='add' method='post' enctype='multipart/form-data'>
    <table border='1'>
      <tr>
        <th>이름</th>
        <td><input type='text' name='name'></td>
      </tr>
      <tr>
        <th>암호</th>
        <td><input type='password' name='password'></td>
      </tr>
      <tr>
        <th>이메일</th>
        <td><input type='text' name='email'></td>
      </tr>
      <tr>
      <tr>
        <th>전화</th>
        <td><input type='text' name='tel'></td>
      </tr>
      <tr>
        <th>사진</th>
        <td><input type='file' name='photoFile'></td>
      </tr>
    </table>
    <p>
      <button type='submit'>등록</button>
      <a href='./'>목록</a>
    </p>
  </form>
</body>
</html>
