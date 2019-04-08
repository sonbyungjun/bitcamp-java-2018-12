<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ page import="bitcamp.vo.Board"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex11</title>
</head>
<body>
<h1>JSP 액션 태그 - JSP에서 기본으로 제공하는 JSP 전용 태그</h1>
<jsp:useBean id="b1" class="bitcamp.vo.Board" scope="page"/>

<jsp:useBean id="b2" class="bitcamp.vo.Board"/>

<jsp:useBean id="b3" class="bitcamp.vo.Board"/>

<jsp:setProperty name="b3" property="no" value="100"/>
<jsp:setProperty name="b3" property="contents" value="내용입니다."/>
<jsp:setProperty name="b3" property="viewCount" value="88"/>
<%--
<jsp:setProperty name="b3" property="createdDate" value="2019-4-8"/>
 --%>
<%=b1%><br>
<%=b2%><br>
<%=b3%>
</body>
</html>