<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>

<html>
<head>
<title>강의등록</title>
</head>
<body>
  <jsp:include page="/header.jsp"/>
  <h1>강의등록(JSP)</h1>
  <form action='add' method='post'>
    <table border='1'>
      <tr>
        <th>수업명
        <th>
        <td><input type='text' name='title'></td>
      </tr>
      <tr>
        <th>설명
        <th>
        <td><textarea name='contents' rows='3' cols='50'></textarea></td>
      </tr>
      <tr>
        <th>시작일
        <th>
        <td><input type='date' name='startDate'></td>
      </tr>
      <tr>
        <th>종료일
        <th>
        <td><input type='date' name='endDate'></td>
      </tr>
      <tr>
        <th>총수업시간
        <th>
        <td><input type='number' name='totalHours'></td>
      </tr>
      <tr>
        <th>일수업시간
        <th>
        <td><input type='number' name='dayHours'></td>
      </tr>
    </table>
    <p>
      <button type='submit'>등록</button>
    </p>
    <p>
      <a href='list'>목록</a>
    </p>
  </form>
</body>
</html>
