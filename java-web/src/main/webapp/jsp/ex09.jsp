<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex06</title>
</head>

<body>
<h1>지시문(directive element) - tablib</h1>
<c:forEach items="홍길동,임꺽정,유관순,안중근,윤봉길,김구,김원봉" var="n">
이름=<%=pageContext.getAttribute("n")%>, ${n}<br>
</c:forEach>

</body>
</html>