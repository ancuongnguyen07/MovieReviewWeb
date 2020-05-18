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
    <title>Quản lý User</title>
    
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
                        <th>Username</th>
                        <th>Họ</th>
                        <th>Tên</th>
                        <th>Email</th>
                        <th>Trạng thái</th>
                        <th></th>
                    </tr>
                    <c:forEach var="user" items="${userListAdmin}">

                        <tr>
                            <td>${user.username}</td>
                            <td>${user.ho}</td>
                            <td>${user.ten}</td>
                            <td>${user.email}</td>
                            <c:choose>
                                <c:when test="${user.trangthai==true}">
                                    <td>Hoạt động</td>
                                </c:when>
                                <c:otherwise>
                                    <td>Khóa</td>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${user.trangthai==true}">
                                    <td><a href="admin/user/block/${user.username}.htm">Block</a></td>
                                </c:when>
                                <c:otherwise>
                                    <td><a href="admin/user/unblock/${user.username}.htm">Unblock</a></td>
                                </c:otherwise>
                            </c:choose>	
                        </tr>
                
                    </c:forEach>               
                </table>
            </div>
            <div class="chuyentrang">
                    <div class="pagination">
                        <c:if test="${numPage>1}">
                            <a href="admin/user/${numPage-1}.htm">&laquo;</a>
                        </c:if>
                        <!-- Trang nào được chọn thì class"active"ở đó -->
                        <c:forEach varStatus="page" begin="1" end="${totalPages}">
                            <c:choose>
                                <c:when test="${numPage==page.index}">
                                    <a href="admin/user/${page.index}.htm" class="active">${page.index}</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="admin/user/${page.index}.htm">${page.index}</a>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        <c:if test="${numPage<totalPages}">
                            <a href="admin/user/${numPage+1}.htm">&raquo;</a>
                        </c:if>
                      </div>
                </div>
        </div>
    </div>
</body>
</html>