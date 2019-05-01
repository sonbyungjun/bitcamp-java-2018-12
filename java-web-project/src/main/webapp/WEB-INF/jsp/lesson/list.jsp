<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <title>강의 목록</title>
  <jsp:include page="../commonCss.jsp" />
</head>
<body>
  <jsp:include page="../header.jsp" />
  
  <div class="container">
    <h1>강의 목록</h1>
    <p>
      <a href='form' class="btn btn-primary btn-sm">강의등록</a>
    </p>
    <div class="bit-list">
      <table class="table table-hover">
        <thead class="thead-dark">
          <tr>
            <th scope="col">번호</th>
            <th scope="col">제목</th>
            <th scope="col">시작일</th>
            <th scope="col">종료일</th>
            <th scope="col">총 강의시간</th>
          </tr>
         </thead>
         <tbody>
           <c:forEach items="${list}" var="lesson">
           <tr>
             <th scope="row">${lesson.no}</th>
             <td><a href='${lesson.no}' class="alert-link">${lesson.title}</a></td>
             <td>${lesson.startDate}</td>
             <td>${lesson.endDate}</td>
             <td>${lesson.totalHours}</td>
           </tr>
           </c:forEach>
         </tbody>
      </table>
    </div> <!-- .bit-list -->
  <nav aria-label="목록 페이지 이동">
    <ul class="pagination justify-content-center">
      <li class="page-item ${pageNo <= 1 ? 'disabled' : ''}"><a class="page-link" href="?pageNo=${pageNo-1}&pageSize=${pageSize}">&laquo;</a></li>
      <c:forEach begin="1" end="${totalPage}" step="1" varStatus="state">
      <li class="page-item ${(pageNo == state.count ? 'active' : '')}"><a class="page-link" href="?pageNo=${state.count}&pageSize=${pageSize}">${state.count}</a></li>
      </c:forEach>
      <li class="page-item ${pageNo >= totalPage ? 'disabled' : ''}"><a class="page-link" href="?pageNo=${pageNo+1}&pageSize=${pageSize}"">&raquo;</a></li>
    </ul>
  </nav>
    
    
  </div> <!-- .container -->
  
  <jsp:include page="../javascript.jsp"/>
</body>
</html>