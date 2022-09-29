<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %><%-- JSTL --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
  table {
    width: 100%;
    border: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border: 1px solid #444444;
    padding: 10px;
  }
</style>
<body>
<table>
      <thead>
      <tr>
      	<th colspan="2">구 매 목 록</th>
      </tr>
        <tr>
          <th>상품 번호</th><th>후기</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach var="l" items="${lDatas}">
        <tr>
        <c:if test="${l.mid == member.mid }">
          <td>${l.ppk}</td>
          
     		     <form action="insertR.do">
     			     <input type="hidden" name="ppk" value="${l.ppk }">
      			    <input type="hidden" name="mid" value="${member.mid }">
      			    
      			    <c:if test="${l.flag == true }">
      			    <td><input type="submit" value="후기 작성 하기"></td>
      			    </c:if>
      			   <c:if test="${l.flag == false }"><td>후기작성이 완료된 상품입니다.</td></c:if>
      			    
      		    </form>
        </c:if>
          	
        </tr>
      </c:forEach>
      </tbody>
    </table>

</body>
</html>