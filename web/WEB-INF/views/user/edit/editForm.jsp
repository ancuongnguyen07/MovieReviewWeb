<%-- 
    Document   : editForm
    Created on : May 23, 2020, 3:05:33 PM
    Author     : Long
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Page</title>
        <base href="${pageContext.servletContext.contextPath}/">
        <link href="https://fonts.googleapis.com/css2?family=Baloo+2&family=Montserrat:wght@300&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap" rel="stylesheet">
        
        <link href="https://fonts.googleapis.com/css2?family=Baloo+Tamma+2:wght@500&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/all.min.css">
        <link rel="stylesheet" href="css/dk.css">
        <link rel="stylesheet" href="css/reset.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.min.js" ></script>
        
        <style>
            .error{
                color: #ff0000
            }
        </style>
    </head>
    <body>
        
        <div class="header">
            <div class="container">
                <div class="left">
                    <div class="logo">
                        <a href="welcome.htm" >
                            <img src="img/logo1.PNG" alt="HIHIHI" height="40px" width="100px">
                        </a>
                    </div>
                    <div class="menu1">
                        <ul>
                            <li><a href="all.htm"><i class="far fa-file-video" style="color: red;" ></i> Phim</a></li>
                            <li><a href="https://www.cgv.vn/default/movies/now-showing.html" target="_blank" >Lịch chiếu</a></li>
                            <li><a href="https://kenh14.vn/cine.chn" target="_blank" >Sự kiện</a></li>
                        </ul>
                    </div>
                </div>
                <div class="find" >
                    <span class="icon"><i class="fa fa-search"></i></span>
                    <form action="search.htm">
                        <input type="text" placeholder="Nhap ten phim" name="keySearch" required/>
                        <button>Search</button>
                        <p class="error">${sessionScope.error}</p>
                    </form>
                </div>
                <div class="right" >
                    <c:choose>
                        <c:when test="${sessionScope.username!=null}">
                            <ul>
                                <li><a href="user/editForm/${sessionScope.username}.htm">Xin chao ${sessionScope.username}!!!</a></li>
                                <li><a href="logout/user.htm">Log out</a></li>
                            </ul>
                        </c:when>
                        <c:otherwise>
                            <ul>
                                <li><a href="user/access.htm?signup">Đăng kí</a></li>
                                <li><a href="user/access.htm?login" >Đăng nhập</a></li>
                            </ul>
                        </c:otherwise>
                    </c:choose>   
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
                    
        <div class="content1">
            <div class="container1">
                <div class="form">
                    <form:form modelAttribute="user" action="user/edit.htm" method="post">
                    <div class="top">
                        <h2>Cập nhật thông tin</h2>
                        <h4><i class="fas fa-user-circle" ></i> Họ </h4>
                        <form:input path="ho" maxlength="50" type="text" required="true"/>
                        <form:errors path="ho" cssClass="error"/>
                        <h4><i class="far fa-user-circle"></i> Tên </h4>
                        <form:input path="ten" maxlength="50" type="text" required="true"/>
                        <form:errors path="ten" cssClass="error"/>
                        <h4><i class="fas fa-envelope"></i> Email </h4>
                        <form:input path="email" maxlength="50" type="email" required="true"/>
                        <form:errors path="email" cssClass="error"/>
                        <h4><i class="fas fa-user"></i> Tên đăng nhập </h4>
                        <form:input path="username" maxlength="50" type="text" required="true" readonly="true"/>
                        <form:errors path="username" cssClass="error"/> 
                        <h4><i class="fas fa-key"></i> Password</h4>
                        <form:input path="password" maxlength="50" type="password" required="true"/>
                        <form:errors path="password" cssClass="error"/> 
                        <h4><i class="fas fa-lock"></i> Nhập lại password</h4>
                        <input type="password" name="confirmPass" required="true" maxlength="50" value="${user.password}"/>
                        <p class="error">${errorMess}</p>
                    </div>
                    <div class="btn_xem" >
                        <button class="xemthem" >Cập nhật <i class="far fa-paper-plane"></i></button>
                    </div>
                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>
