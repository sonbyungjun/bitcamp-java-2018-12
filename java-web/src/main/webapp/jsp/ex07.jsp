<%@ page 
    language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.net.Socket"
    import="java.net.ServerSocket"
    import="java.util.List,java.util.Map,java.util.Set"
    trimDirectiveWhitespaces="true"
    buffer="1kb"
    autoFlush="ture"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex06</title>
</head>
<body>
<h1>지시문(directive element)</h1>
<%
for (int i = 0; i < 1000; i++) {
  out.print(". ");
}
%>
</body>
</html>