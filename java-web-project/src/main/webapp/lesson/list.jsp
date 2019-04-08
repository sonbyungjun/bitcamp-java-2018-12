<%@page import="com.eomcs.lms.domain.Lesson"%>
<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>강의 목록</title>
</head>
<body>
  <jsp:include page="/header.jsp"/>
  <h1>강의 목록(JSP2)</h1>
  <p>
    <a href='add'>강의등록</a>
  </p>
  <table border='1'>
    <tr>
      <th>번호</th>
      <th>제목</th>
      <th>시작일</th>
      <th>종료일</th>
      <th>총 강의시간</th>
    </tr>
    <jsp:useBean scope="request" id="list" type="java.util.List<Lesson>"/>
    <%for (Lesson lesson : list) { %>
    <tr>
      <td><%=lesson.getNo()%></td>
      <td><a href='detail?no=<%=lesson.getNo()%>'><%=lesson.getTitle()%></a></td>
      <td><%=lesson.getStartDate()%></td>
      <td><%=lesson.getEndDate()%></td>
      <td><%=lesson.getTotalHours()%></td>
    </tr>
    <%}%>
  </table>
</body>
</html>