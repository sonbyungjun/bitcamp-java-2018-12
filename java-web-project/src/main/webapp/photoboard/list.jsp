<%@page import="com.eomcs.lms.domain.PhotoBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>사진 게시판</title>
</head>
<body>
  <jsp:include page="/header.jsp"/>
  <h1>사진 게시판(JSP2 + EL + JSTL)</h1>
  <p>
    <a href='form'>사진게시판등록</a>
  </p>
  <table border='1'>
    <tr>
      <th>번호</th>
      <th>제목</th>
      <th>강의제목</th>
      <th>조회수</th>
      <th>생성일</th>
    </tr>
    <c:forEach items="${list}" var="board">
      <tr>
        <td>${board.no}</td>
        <td><a href='detail?no=${board.no}'>${board.title}</a></td>
        <td>${board.lessonNo}</td>
        <td>${board.viewCount}</td>
        <td>${board.createdDate}</td>
      </tr>
    </c:forEach>
  </table>
  <form action='search'>
    수업번호: <input type='text' name='lessonNo'> 검색어: <input type='text' name='keyword'>
    <button type='submit'>검색</button>
  </form>
</body>
</html>