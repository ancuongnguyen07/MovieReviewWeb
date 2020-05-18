<%-- 
    Document   : form
    Created on : Apr 10, 2020, 8:41:01 AM
    Author     : Long
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up Page</title>
        <base href="${pageContext.servletContext.contextPath}/">
        <link href="https://fonts.googleapis.com/css2?family=Baloo+2&family=Montserrat:wght@300&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/reset.css">
        <link href="https://fonts.googleapis.com/css2?family=Baloo+Tamma+2:wght@500&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/all.min.css">
        <link rel="stylesheet" href="css/dangki.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.min.js" ></script>
        <script type="text/javascript" src="js/slider.js" ></script>
        
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
                            <li><a href=""><i class="far fa-file-video" style="color: red;" ></i> Phim</a></li>
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
                                <li><a>Xin chao ${sessionScope.username}!!!</a></li>
                                <li><a href="logout/home.htm">Log out</a></li>
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
        
        <div class="to">
            <div class="form">
                <form:form modelAttribute="user" action="user/validate.htm" method="post">
                    <h2>Đăng kí thành viên</h2>
                    <label style="margin-left: -150px;">Họ</label>
                    <form:input path="ho" maxlength="50" type="text" required="true"/>
                    <form:errors path="ho" cssClass="error"/>
                    <label>Tên</label>
                    <form:input path="ten" maxlength="50" type="text" required="true"/>
                    <form:errors path="ten" cssClass="error"/>
                    <label>Email</label>
                    <form:input path="email" maxlength="50" type="email" required="true"/>
                    <form:errors path="email" cssClass="error"/>
                    <label>Username</label>
                    <form:input path="username" maxlength="50" type="text" required="true"/>
                    <form:errors path="username" cssClass="error"/>  
                    <p class="error">${dupUsername}</p>
                    <label>Password</label>
                    <form:input path="password" maxlength="50" type="password" required="true"/>
                    <form:errors path="password" cssClass="error"/>    
                    <label style="margin-left: -180px;">Confirm Password</label>
                    <input type="password" name="confirmPass"/>
                    <p class="error">${errorMess}</p>
                    <input id="submit" type="submit" name="submit" value="Gửi" >
                </form:form>
                <script>
                    function ketqua(){
                        alert("Chào mừng thành viên mới");
                    }
                </script>
                <!-- <script>
                    Nếu các điều kiện sai thì thông báo ở đây
                    function sai(){
                        alert("Sai cmnr, mời chọn lại :))");
                    }
                </script> -->
            </div>                
        </div>
        
        <!--
        <h1>Fill INFO!</h1>
        <p class="error">${message}</p>
        <form:form modelAttribute="user" action="validate.htm" method="post" enctype="multipart/form-data">
            <div>
                <label>Ho</label>
                <form:input path="ho"/>
                <form:errors path="ho" cssClass="error"/>              
            </div>
            <div>
                <label>Ten</label>
                <form:input path="ten"/>
                <form:errors path="ten" cssClass="error"/>
            </div>
            <div>
                <label>Email</label>
                <form:input path="email"/>
                <form:errors path="email" cssClass="error"/>
            </div>
            <div>
                <label>Username</label>
                <form:input path="username"/>
                <form:errors path="username" cssClass="error"/>
                <p class="error">${dupUsername}</p>
            </div>
            <div>
                <label>Password</label>
                <form:password path="password"/>
                <form:errors path="password" cssClass="error"/>
            </div>
            <div>
                <lable>Confirm Password</lable>
                <input type="text" name="confirmPass"/>
                <p class="error">${errorMess}</p>
            </div>
            <div>
                <button>Submit</button>
            </div>
            
        </form:form>
        -->
    </body>
</html>
