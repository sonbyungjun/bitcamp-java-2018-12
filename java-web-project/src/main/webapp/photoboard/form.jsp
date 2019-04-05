<%@page import="com.eomcs.lms.domain.Lesson"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
List<Lesson> list = (List<Lesson>) request.getAttribute("list");
%>
<html>
<head>
<title>사진게시판 등록</title>
</head>
<body>
  <jsp:include page="/header.jsp" />
  <h1>사진게시판 등록(JSP)</h1>
  <form action='add' method='post' enctype='multipart/form-data'>
    <table border='1'>
      <tr>
        <th>수업 번호</th>
        <td><select name='lessonNo'>
            <option value='0'>수업을 선택하세요</option>
            <%for (Lesson lesson : list) {%>
            <option value='<%=lesson.getNo()%>'><%=lesson.getTitle()%></option>
            <%}%>
        </select></td>
      </tr>
      <tr>
        <th>사진 제목</th>
        <td><input type='text' name='title'></td>
      </tr>
      <tr>
        <td colspan='3'>최소 한개 이상 사진을 등록해야 합니다.</td>
      </tr>
      <tr>
        <th>사진1</th>
        <td><input type='file' name='photo'></td>
      </tr>
      <tr>
        <th>사진2</th>
        <td><input type='file' name='photo'></td>
      </tr>
      <tr>
        <th>사진3</th>
        <td><input type='file' name='photo'></td>
      </tr>
      <tr>
        <th>사진4</th>
        <td><input type='file' name='photo'></td>
      </tr>
      <tr>
        <th>사진5</th>
        <td><input type='file' name='photo'></td>
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
