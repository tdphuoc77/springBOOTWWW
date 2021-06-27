<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<%@include file="../layouts/header.jsp" %>

<div style="width: 70%;margin: auto auto;">

<table>
	<tr>
		<td>maTP :</td>
		<td>${tp.maTP}</td>
	 </tr>
	 <tr>
		<td>tenTP :</td>
		<td>${tp.tenTP}</td>
	 </tr>
	 <tr>
		<td>loaiTP :</td>
		<td>${tp.loaiTP}</td>
	 </tr>
	 <tr>
		<td>soTrang :</td>
		<td>${tp.soTrang}</td>
	 </tr>
	 <tr>
		<td>gia :</td>
		<td>${tp.gia}</td>
	 </tr>
	 <tr>
		<td>tomtat :</td>
		<td>${tp.tomtat}</td>
	 </tr>
	 <tr>
		<td>tacGia :</td>
		<td>${tp.tacGia.hoTen}</td>
	 </tr>
	  <tr>
		<td>Hinh anh :</td>
		<td> <img alt="" style="width: 200px;height: 200px;" src="<c:url value="/images/${tp.hinh}" />"> </td>
	 </tr>
</table>
	
</div>

<%@include file="../layouts/footer.jsp" %>
</body>
</html>