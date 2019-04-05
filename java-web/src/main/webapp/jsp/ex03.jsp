<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
int i;

%>
<html>
<head>
<meta charset="UTF-8">
<title>ex03</title>
<%
i = 5;
%>
</head>
<body>

<h1>스크립트릿(scriptlet)과 JSP 주석<%out.print(i);%></h1>

<%
if (i < 10) {
  for (int x = 0; x < i; x++) {
    out.println("<p>" + x + "</p>");
  }
}
%>

</body>
</html>