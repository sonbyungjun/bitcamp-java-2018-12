<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRootPath" value="${pageContext.servletContext.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<title>실행 오류</title>
<meta http-equiv="Refresh" content="2;url=${(empty header.Referer) ? contextRootPath : header.Referer}">
</head>
<body>
  <jsp:include page="/header.jsp"/>
  <h1>${requestScope["error.title"]}</h1>
  <p>${requestScope["error.content"]}</p>
</body>
</html>
