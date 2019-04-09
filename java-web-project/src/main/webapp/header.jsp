<%@page import="com.eomcs.lms.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRootPath" value="${pageContext.servletContext.contextPath}"/>
<header>
  <img src='http://bitcamp.co.kr/img/logo.jpg' style='height: 50px'>
  <c:choose>
    <c:when test="${empty loginUser}">
      <a href='${contextRootPath}/auth/login'>로그인</a>
    </c:when>
    <c:otherwise>
        <a href='${contextRootPath}/upload/member/${loginUser.photo}' target = "_blank">
       <img src='${contextRootPath}/upload/member/${loginUser.photo}' style='height: 50px;'></a>
                ${loginUser.name}<a href='${contextRootPath}/auth/logout'>로그아웃</a>
    </c:otherwise>
  </c:choose>
</header>