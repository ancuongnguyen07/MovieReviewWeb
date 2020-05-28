<%-- 
    Document   : forgetPassForm
    Created on : Apr 18, 2020, 1:17:39 PM
    Author     : Long
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forget Password Form</title>
        <base href="${pageContext.servletContext.contextPath}/">

<<<<<<< HEAD
        <link rel="stylesheet" href="css/dn.css">
        <link rel="stylesheet" href="css/all.min.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link href="https://fonts.googleapis.com/css2?family=Baloo+2&family=Montserrat:wght@300&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/reset.css">
        <link href="https://fonts.googleapis.com/css2?family=Baloo+Tamma+2:wght@500&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/style.css">

        <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.min.js" ></script>
=======
        <link rel="stylesheet" href="css/dangnhap.css">
        <link rel="stylesheet" href="css/all.min.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link href="https://fonts.googleapis.com/css2?family=Baloo+2&family=Montserrat:wght@300&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/reset.css">
        <link href="https://fonts.googleapis.com/css2?family=Baloo+Tamma+2:wght@500&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/style.css">
 
        <meta charset="UTF-8">
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.min.js" ></script>
        <script type="text/javascript" src="js/slider.js" ></script>
>>>>>>> origin/master
        <style>
            .error{
                color: #ff0000;
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
<<<<<<< HEAD
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
                    <form:form modelAttribute="user" action="password/recover/form.htm" method="post">
                    <div class="top">
                        <h2> Khôi phục mật khẩu</h2>
                        <h4><i class="fas fa-user"></i> Tên đăng nhập</h4>
                        <form:input path="username" maxlength="50" required="true"/>
                        <form:errors path="username" cssClass="error"/>
                        <p class="error">${nonExistUser}</p>
                        <h4><i class="fas fa-key"></i> Email</h4>
                        <form:input path="email" type="email" maxlength="50" required="true" />
                        <form:errors path="email" cssClass="error"/>
                        <p class="error">${nonExistEmail}</p>
                    </div>
                    
                    <div class="btn_xem" >
                        <button  class="xemthem">Khôi phục <i class="far fa-paper-plane"></i></button>
                    </div>
                    </form:form>>
                </div>
            </div>
        </div>
                    
        <!--          
=======
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
                    
>>>>>>> origin/master
        <div class="to">
            
            <div class="form">
                <form:form modelAttribute="user" action="password/recover/form.htm">
                    <h2>Khôi phục mật khẩu</h2>
                    <p class="error">${message}</p>
                    <label>Username</label>
                    <form:input path="username" maxlength="50" required="true"/>
                    <form:errors path="username" cssClass="error"/>
                    <p class="error">${nonExistUser}</p>
                    <label>Email</label>
                    <form:input path="email" type="email" maxlength="50" required="true" />
                    <form:errors path="email" cssClass="error"/>
                    <p class="error">${nonExistEmail}</p>
                    <input id="submit" type="submit" name="submit" value="Khôi phục" />
                </form:form>
            </div>
        </div>
        <!--
        <h1>Recover Password!</h1>
        <p class="error">${message}</p>
        <form:form modelAttribute="user" action="password/recover/form.htm">
            <div>
                <label>Username</label>
                <form:input path="username"/>
                <form:errors path="username" cssClass="error"/>
                <p class="error">${nonExistUser}</p>
            </div>
            <div>
                <label>Email</label>
                <form:input path="email"/>
                <form:errors path="email" cssClass="error"/>
                <p class="error">${nonExistEmail}</p>
            </div>
            <div>
                <button>Submit</button>
            </div>
        </form:form>
        -->
    </body>
</html>
