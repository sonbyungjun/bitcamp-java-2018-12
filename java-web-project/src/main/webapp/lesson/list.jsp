<%@page import="com.eomcs.lms.domain.Lesson"%>
<%@page import="java.util.List"%>
<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%
List<Lesson> list = (List<Lesson>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<title>강의 목록</title>
</head>
<body>
  <jsp:include page="/header.jsp"/>
  <h1>강의 목록(JSP)</h1>
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