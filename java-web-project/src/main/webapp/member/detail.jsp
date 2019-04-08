<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>회원 상세조회</title>
</head>
<body>
  <jsp:include page="/header.jsp" />
  <jsp:useBean scope="request" id="member" type="com.eomcs.lms.domain.Member"/>
  <h1>회원 상세조회(JSP2)</h1>
  <form action='update' method='post' enctype='multipart/form-data'>
    <table border='1'>
      <tr>
        <th>번호</th>
        <td><input type='text' name='no' value='<%=member.getNo()%>' readonly></td>
      </tr>
      <tr>
        <th>이름</th>
        <td><input type='text' name='name' value='<%=member.getName()%>'></td>
      </tr>
      <tr>
        <th>암호</th>
        <td><input type='password' name='password'></td>
      </tr>
      <tr>
        <th>이메일</th>
        <td><input type='text' name='email' value='<%=member.getEmail()%>'></td>
      </tr>
      <tr>
        <th>전화</th>
        <td><input type='text' name='tel' value='<%=member.getTel()%>'></td>
      </tr>
      <tr>
        <th>사진</th>
        <td><img src='../<%=(member.getPhoto() == null) ? "images/default.jpg" : "upload/member/"+member.getPhoto() %>' style='height: 80px'> <input
          type='file' name='photo'></td>
      </tr>
      <tr>
        <th>가입일</th>
        <td><%=member.getRegisteredDate()%></td>
      </tr>
    </table>
    <p>
      <a href='list'>목록</a><a href='delete?no=<%=member.getNo()%>'>삭제</a>
      <button type='submit'>변경</button>
    </p>
    </from>
</body>
</html>
