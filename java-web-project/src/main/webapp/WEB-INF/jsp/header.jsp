<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRootPath" value="${pageContext.servletContext.contextPath}"/>
<header>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="${contextRootPath}">수업관리시스템</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
    <!-- 
      <li class="nav-item active">
        <a class="nav-link" href="${contextRootPath}/app/auth/form">로그인</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="${contextRootPath}/app/auth/logout">로그아웃</a>
      </li>
     -->
      <li class="nav-item active">
        <a class="nav-link" href="${contextRootPath}/app/board/">게시판</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="${contextRootPath}/app/member/">회원관리</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="${contextRootPath}/app/lesson/">수업관리</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="${contextRootPath}/app/photoboard/">수업사진관리</a>
      </li>
    </ul>
    
    <div id="bit-login-state">
      <c:choose>
      <c:when test="${empty loginUser}">
        <a class="btn btn-success btn-sm" href='${contextRootPath}/app/auth/form'>로그인</a>
      </c:when>
      <c:otherwise>
          <a href='${contextRootPath}/upload/member/${loginUser.photo}'  data-toggle="modal" data-target="#bit-photo">
         <img src='${contextRootPath}/upload/member/${loginUser.photo}' style='height: 50px;'></a>
                  ${loginUser.name}
          <a class="btn btn-dark btn-sm" href='${contextRootPath}/app/auth/logout'>로그아웃</a>
      </c:otherwise>
      </c:choose>
    </div>
    
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="검색" aria-label="검색">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
    </form>
  </div>
  </nav>
  
  
  <!-- Modal -->
<div class="modal fade bd-example-modal-xl" id="bit-photo" tabindex="-1" role="dialog" aria-labelledby="myExtraLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-xl" role="document">
    <div class="modal-content">
      <div class="modal-body">
        <img src='${contextRootPath}/upload/member/${loginUser.photo}' class="img-thumbnail"/>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

</header>