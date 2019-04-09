<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>회원 상세조회</title>
</head>
<body>
  <jsp:include page="/header.jsp" />
  <h1>회원 상세조회(JSP2 + EL + JSTL)</h1>
<c:choose>
  <c:when test="${empty member}">
    <p>해당하는 회원이 없습니다.</p>
  </c:when>
  <c:otherwise>
  <form action='update' method='post' enctype='multipart/form-data'>
    <table border='1'>
      <tr>
        <th>번호</th>
        <td><input type='text' name='no' value='${member.no}' readonly></td>
      </tr>
      <tr>
        <th>이름</th>
        <td><input type='text' name='name' value='${member.name}'></td>
      </tr>
      <tr>
        <th>암호</th>
        <td><input type='password' name='password'></td>
      </tr>
      <tr>
        <th>이메일</th>
        <td><input type='text' name='email' value='${member.email}'></td>
      </tr>
      <tr>
        <th>전화</th>
        <td><input type='text' name='tel' value='${member.tel}'></td>
      </tr>
      <tr>
        <th>사진</th>
        <c:set var="contextRootPath" value="${pageContext.servletContext.contextPath}"/>s
        <c:set var="photo" value="upload/member/${member.photo}"/>
        <td><img src='${contextRootPath}/${member.photo == null ? "images/default.jpg" : photo}'
         style='height: 80px'> <input type='file' name='photo'></td>
      </tr>
      <tr>
        <th>가입일</th>
        <td>${member.registeredDate}</td>
      </tr>
    </table>
    <p>
      <a href='list'>목록</a><a href='delete?no=${member.no}'>삭제</a>
      <button type='submit'>변경</button>
    </p>
    </form>
  </c:otherwise>
  </c:choose>
</body>
</html>
