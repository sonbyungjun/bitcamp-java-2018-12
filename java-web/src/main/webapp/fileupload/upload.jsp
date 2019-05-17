<%@ page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>업로드 데이터</h1>
<%
request.setCharacterEncoding("UTF-8");
Collection<Part> parts = request.getParts();
for (Part part : parts) {
  if (part.getContentType() == null) {
    out.println(String.format("%s=%s<br>\n", part.getName(), request.getParameter(part.getName())));
  } else {
    out.println(String.format("%s=%s<br>\n", part.getName(), part.getSubmittedFileName()));
  }
}
%>
</body>
</html>
