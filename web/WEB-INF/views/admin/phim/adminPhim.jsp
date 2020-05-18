<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/adminUser.css">
<base href="${pageContext.servletContext.contextPath}/">
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
<a href="${pageContext.request.contextPath}/admin/phim/addForm.htm">Them</a>
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
			<th>Mã Phim</th>
			<th>Tên</th>
			<th>Diễn viên</th>
			<th>Đạo diễn</th>
			<th>Ngày chiếu</th>
			<th>Thời lượng</th>
			<th>Giới hạn độ tuổi</th>
			<th>Điểm</th>
                        <th>Thể loại</th>
			
			<th></th>
		</tr>
		<c:forEach var="phim" items="${list}">
				
				<tr>
					<td>${phim.maphim}</td>
                                        <td>${phim.ten}</td>
                                        <td>${phim.dienvien}</td>
                                        <td>${phim.daodien}</td>
                                        <td>${phim.ngaychieu}</td>
                                        <td>${phim.thoiluong}</td>
                                        <td>${phim.gioihandotuoi}</td>
                                        <td>${phim.diem}</td> 
                                        <td>${phim.theloai}</td>
	
					<td><a href="${pageContext.request.contextPath}/admin/phim/delete/${phim.maphim}.htm">Xóa</a></td>
					<td><a href="admin/phim/updateForm/${phim.maphim}.htm">Sửa</a></td>	
				</tr>
	
			</c:forEach>
	
	</table>
</div>
</body>
</html>