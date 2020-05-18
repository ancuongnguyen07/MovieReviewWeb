<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/adminUser.css">
<meta charset="UTF-8">
<title>Quản lý User</title>
<style type="text/css">

table {
  border: 1px solid black;
  width: 80%;
  text-align: left;
  
}
td,th,tr {
	border: 1px solid black;
}
th {
  height: 50px;
}
.deleteMessage{
	color: red;
}
</style>
</head>
<body>


<a href="#">${username}</a>  has logged in!</li>
<a href="#">Logout</a></li>
<hr>

<form action="#" method="get">
	<input type="text" name="search">
	<input type="submit" value="Tìm kiếm">
</form>
<div class="deleteMessage">${deleteMessage}</div>
<span class="editMessage">${editMessage}</span>
<div>
	<table>
				<tr>
			<th>Username</th>
			<th>Tên</th>
			<th>Ho</th>
			<th>Email</th>
			<th>Sdt</th>
			<th>Gioi tinh</th>
			<th>Password</th>
			<th></th>
		</tr>
		<c:forEach var="user" items="${list}">
				
				<tr>
					<td>${user.username}</td>
                                        <td>${user.ten}</td>
                                        <td>${user.ho}</td>
                                        <td>${user.email}</td>
                                        <td>${user.sdt}</td>
                                        <c:choose>
                                            <c:when test="${user.gioitinh}">
                                                <td>Nam</td>
                                            </c:when>
                                            <c:otherwise>
                                                <td>Nu</td>
                                            </c:otherwise>
                                        </c:choose>
                                        <td>${user.password}</td>
	
					<td><a href="/delete/${phim.maphim}.htm">Xóa</a></td>
					<td><a href="/edit/${phim.maphim}.htm">Sửa</a></td>	
				</tr>
	
			</c:forEach>
	
	</table>
</div>
</body>
</html>