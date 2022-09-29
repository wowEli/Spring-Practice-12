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
          <th>상품 번호</th><th>상품이름</th><th>상품가격</th><th><a href="listPayAll.do?mid=${member.mid }">구매 목록</a></th>
        </tr>
      </thead>
      <tbody>
      <c:forEach var="p" items="${pDatas }">
       <form action="listPay.do">
       <input type="hidden" name="ppk" value="${p.ppk}">
       <input type="hidden" name="mid" value="${member.mid }">
        <tr>
          <td>${p.ppk}</td><td>${p.pname }</td><td>${p.price}</td><td><input type="submit" value="구매하기"></td>
        </tr>
       </form>
        <c:forEach var="r" items="${rDatas}">
        <c:if test="${p.ppk == r.ppk }">
        <tr>
        	<td colspan="3">상품후기: ${r.title } | 내용: ${r.content} | 작성자: ${r.mid}</td>
        </tr>
        </c:if>
        </c:forEach>
        
      </c:forEach>
      </tbody>
    </table>

</body>
</html>