<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex10</title>
</head>
<body>
<h1>JSP 빌트인 객체 - JSP에서 기본으로 사용할 수 있는 객체</h1>
<%
request.setAttribute("aaa", "okok");
session.setAttribute("bbb", "nono");
application.setAttribute("ccc", "haha");
out.println("okok");
%>
</body>
</html>