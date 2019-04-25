<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <title>강의 상세조회</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link rel="stylesheet" href="${contextRootPath}/css/common.css">
</head>
<body>
  <jsp:include page="../header.jsp" />
  
  <div class="container">
    <h1>강의 상세조회</h1>
    <c:choose>
    
      <c:when test="${empty lesson}">
        <p>해당 수업이 없습니다</p>
      </c:when>
      
      <c:otherwise>
      
      
      <form action='update' method='post'>
      
        <div class="form-group row">
          <label for="no" class="col-sm-2 col-form-label">번호</label>
          <div class="col-sm-10">
            <input type="text" class="form-control-plaintext" name="no" id="no" value="${lesson.no}" readonly>
          </div>
        </div>
      
        <div class="form-group row">
          <label for="title" class="col-sm-2 col-form-label">수업명</label>
          <div class="col-sm-10">
            <input type="text" class="form-control-plaintext" name="title" id="title" value="${lesson.title}">
          </div>
        </div>
        
        <div class="form-group row">
          <label for="contents" class="col-sm-2 col-form-label">설명</label>
          <div class="col-sm-10">
            <textarea class="form-control" id="contents" name='contents' rows='5'>${lesson.contents}</textarea>
          </div>
        </div>     
         
        <table border='1'>
          
          <tr>
            <th>기간</th>
            <td><input type='date' name='startDate' value='${lesson.startDate}'>~<input type='date'
              name='endDate' value='${lesson.endDate}'></td>
          </tr>
          <tr>
            <th>총수업시간</th>
            <td><input type='number' name='totalHours' value='${lesson.totalHours}'></td>
          </tr>
          <tr>
            <th>일수업시간</th>
            <td><input type='number' name='dayHours' value='${lesson.dayHours}'></td>
          </tr>
        </table>
        <p>
          <a href='./'>강의목록</a><a href='delete/${lesson.no}'>삭제</a>
          <button type='submit'>변경</button>
        </p>
        
        </form>
        
        
      </c:otherwise>
      
      
    </c:choose>
  </div> <!-- .container -->
  <jsp:include page="../javascript.jsp"/>
</body>
</html>
