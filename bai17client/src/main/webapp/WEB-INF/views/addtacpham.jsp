<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../layouts/header.jsp" %>
		<form:form method="post" modelAttribute="tp" enctype="multipart/form-data">
			<form:input type="hidden" path="maTP"/>
			<table>
				<tr> 
					<td>tenTP</td>
					<td><form:input path="tenTP"/> </td>
					<td><form:errors path="tenTP" /> </td>
				</tr>
				<tr> 
					<td>loaiTP</td>
					<td><form:input path="loaiTP"/> </td>
					<td><form:errors path="loaiTP" /> </td>
				</tr>
				<tr> 
					<td>soTrang</td>
					<td><form:input type="number" path="soTrang"/> </td>
					<td><form:errors path="soTrang" /> </td>
				</tr>
				<tr> 
					<td>gia</td>
					<td><form:input type="number" path="gia"/> </td>
					<td><form:errors path="gia" /> </td>
				</tr>
				<tr> 
					<td>tomtat</td>
					<td><form:input path="tomtat"/> </td>
					<td><form:errors path="tomtat" /> </td>
				</tr>
				<tr> 
					<td>hinh</td>
					<td><input name="file" type="file"> </td>
					<td><form:errors path="hinh" /> </td>
				</tr>
				
				<tr> 
					<td>tacgia</td>
					<td>
						<select name="idTG">
							<c:forEach items="${listTG}" var="tg">
								<option 
								<c:if test="${tg.maTG == tp.tacGia.maTG}"> selected </c:if>
								 value="${tg.maTG}" >
									${tg.hoTen }
								</option>
							
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr> 
					
					<td><input  type="submit" value="Submit"> </td>
				</tr>
			</table>
			
			
		</form:form>
	
	<%@ include file="../layouts/footer.jsp" %>
</body>
</html>