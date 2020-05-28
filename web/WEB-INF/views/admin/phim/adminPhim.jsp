<<<<<<< HEAD
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <base href="${pageContext.servletContext.contextPath}/">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/new.css">
    <link rel="stylesheet" href="css/reset.css">
    <title>Quản lý Phim</title>
    
</head>
<body>
    <div class="header">
        <div class="container">
            <div class="left">
                <div class="logo">
                    <a href="welcome.htm" >
                        <img src="img/logo1.PNG" alt="" height="40px" width="100px">
                    </a>
                </div>
            </div>
            <div class="find" >
                <span class="icon"><i class="fa fa-search"></i></span>
                <input type="text" name="search" placeholder="Tìm kiếm..">
            </div>
            <div class="right" >
                <ul>
                    <li><a href="logout/admin.htm" >Đăng xuất</a></li>
                </ul>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
    <div class="header1">
        <div class="contai">
            <div class="mov1">
                <a href="admin/phim.htm">Quản lí phim</a>
            </div>
            <div class="mov">
                <a href="admin/bl.htm">Quản lí bình luận</a>
            </div>
            <div class="mov2">
                <a href="admin/user.htm">Quản lí User</a>
            </div>
        </div>
    </div>
    <div class="quanli">
        <div class="content">
            <div class="Bang">
                <table>
                    <tr class="DeMuc">
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
                    <c:forEach var="phim" items="${phimListAdmin}" >

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

                            <td><a href="admin/phim/delete/${phim.maphim}.htm">Xóa</a></td>
                            <td><a href="admin/phim/updateForm/${phim.maphim}.htm">Sửa</a></td>	
                        </tr>
                
                    </c:forEach>               
                </table>
            </div>
            <div class="chuyentrang">
                    <div class="pagination">
                        <c:if test="${numPage>1}">
                            <a href="admin/phim/${numPage-1}.htm">&laquo;</a>
                        </c:if>
                        <!-- Trang nào được chọn thì class"active"ở đó -->
                        <c:forEach varStatus="page" begin="1" end="${totalPages}">
                            <c:choose>
                                <c:when test="${page.index==numPage}">
                                    <a href="admin/phim/${page.index}.htm" class="active">${page.index}</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="admin/phim/${page.index}.htm">${page.index}</a>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        <c:if test="${numPage<totalPages}">
                            <a href="admin/phim/${numPage+1}.htm">&raquo;</a>
                        </c:if>
                      </div>
                </div>
        </div>
    </div>
    
<!--
<a href="#">${username}</a>  has logged in!</li>
<a href="#">Logout</a></li>
<a href="${pageContext.request.contextPath}/admin/phim/addForm.htm">Them</a>
<hr>

<form action="#" method="get">
	<input type="text" name="search">
	<input type="submit" value="Tìm kiếm">
</form>

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
-->
=======
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
>>>>>>> origin/master
</body>
</html>
