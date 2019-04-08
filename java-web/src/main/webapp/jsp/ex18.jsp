<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ page import="bitcamp.vo.Board"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex14</title>
</head>
<body>
<h1>JSP 액션 태그 - jsp:useBean (계속)</h1>

<jsp:useBean id="list" type="java.util.List<String>" class="java.util.ArrayList" scope="page"/>


<%
for (String n : list) {
  out.println(n + "<br>");
}
%>

</body>
</html>