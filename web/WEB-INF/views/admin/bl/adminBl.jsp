<%-- 
    Document   : adminBl
    Created on : May 23, 2020, 9:17:26 PM
    Author     : Long
--%>

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
        <!--<link rel="stylesheet" href="css/ad.scss">-->
        <link rel="stylesheet" href="css/new.css"/>
        <link rel="stylesheet" href="css/reset.css">
        <title>Quản lý BL</title>
    
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
                        <li><a href="logout/admin.htm">Đăng xuất</a></li>
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
                            <th>ID</th>
                            <th>Nội dung</th>
                            <th>Điểm</th>
                            <th>Thời gian</th>
                            <th>Mã phim</th>
                            <th>Tên phim</th>
                            <th>Username</th>
                            <th>Duyệt</th>
                            <th></th>
                            <th></th>
                        </tr>
                        <c:forEach var="bl" items="${blListAdmin}">

                            <tr>
                                <td>${bl.id}</td>
                                <td>${bl.noidung}</td>
                                <td>${bl.diem}</td>
                                <td>${bl.ngaygio}</td>
                                <td>${bl.phim.maphim}</td>
                                <td>${bl.phim.ten}</td>
                                <td>${bl.user.username}</td>
                                <td>${bl.duyet}</td>

                                <td><a href="admin/bl/delete/${bl.id}.htm">Xóa</a></td>
                                <td><a href="admin/bl/duyet/${bl.id}.htm">Duyệt</a></td>	
                            </tr>

                        </c:forEach>               
                    </table>
                </div>
                <div class="chuyentrang">
                    <div class="pagination">
                        <c:if test="${numPage>1}">
                            <a href="admin/bl/${numPage-1}.htm">&laquo;</a>
                        </c:if>
                        <!-- Trang nào được chọn thì class"active"ở đó -->
                        <c:forEach varStatus="page" begin="1" end="${totalPages}">
                            <c:choose>
                                <c:when test="${page.index==numPage}">
                                    <a href="admin/bl/${page.index}.htm" class="active">${page.index}</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="admin/bl/${page.index}.htm">${page.index}</a>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        <c:if test="${numPage<totalPages}">
                            <a href="admin/bl/${numPage+1}.htm">&raquo;</a>
                        </c:if>
                      </div>
                </div>
            </div>
        </div>
    </body>
</html>
