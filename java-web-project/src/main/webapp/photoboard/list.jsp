<%@page import="com.eomcs.lms.domain.Lesson"%>
<%@page import="com.eomcs.lms.domain.PhotoBoard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<%
List<PhotoBoard> list = (List<PhotoBoard>) request.getAttribute("list");
%>
<html>
<head>
<title>사진 게시판</title>
</head>
<body>
  <jsp:include page="/header.jsp"/>
  <h1>사진 게시판(JSP)</h1>
  <p>
    <a href='add'>사진게시판등록</a>
  </p>
  <table border='1'>
    <tr>
      <th>번호</th>
      <th>제목</th>
      <th>강의제목</th>
      <th>조회수</th>
      <th>생성일</th>
    </tr>
    <%for (PhotoBoard board : list)  {%>
    <tr>
      <td><%=board.getNo()%></td>
      <td><a href='detail?no=<%=board.getNo()%>'><%=board.getTitle()%></a></td>
      <td><%=board.getLessonNo()%></td>
      <td><%=board.getViewCount()%></td>
      <td><%=board.getCreatedDate()%></td>
    </tr>
    <%}%>
  </table>
  <form action='search'>
    수업번호: <input type='text' name='lessonNo'> 검색어: <input type='text' name='keyword'>
    <button type='submit'>검색</button>
  </form>
</body>
</html>