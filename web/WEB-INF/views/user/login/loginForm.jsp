<%-- 
    Document   : loginForm
    Created on : Apr 10, 2020, 9:25:36 AM
    Author     : Long
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Form!!!</title>
        <base href="${pageContext.servletContext.contextPath}/">

<<<<<<< HEAD
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/all.min.css">
        <link rel="stylesheet" href="css/dn.css">
        <title>Đăng nhập</title>

        <link href="https://fonts.googleapis.com/css2?family=Baloo+2&family=Montserrat:wght@300&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Baloo+Tamma+2:wght@500&display=swap" rel="stylesheet">
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.min.js" ></script>

=======
        <link rel="stylesheet" href="css/dangnhap.css">
        <link rel="stylesheet" href="css/all.min.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Đăng nhập</title>

        <link href="https://fonts.googleapis.com/css2?family=Baloo+2&family=Montserrat:wght@300&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/reset.css">
        <link href="https://fonts.googleapis.com/css2?family=Baloo+Tamma+2:wght@500&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/style.css">
 
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.min.js" ></script>
        <script type="text/javascript" src="js/slider.js" ></script>
>>>>>>> origin/master
        <style>
            .error{
                color: red;
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
                    <form action="login/form.htm" method="post">
                    <div class="top">
                        <h2> Đăng nhập</h2>
                        <h4><i class="fas fa-user"></i> Tên đăng nhập</h4>
                        <input name="username" value="${cookie.username.value}" required="true" maxlength="50"/>
                        <p class="error">${unError}</p>
                        <h4><i class="fas fa-key"></i> Password</h4>
                        <input type="password" name="password" value="${cookie.password.value}" required="true" maxlength="50"/>
                        <p class="error">${paError}</p>
                    </div>
                    <div class="bot">
                        <div class="nho">
                            <div class="trai">
                                <h4><i class="fas fa-clipboard"></i> Ghi nhớ đăng nhập <input type="checkbox" name="chkremember" value="1" id="chkremember"/></h4>
                                
                            </div>
                        </div>
                        <div class="quen">
                            <h4><a href="password/recover/form.htm"> <i class="fas fa-question-circle"></i> Quên mật khẩu!</a></h4>
                        </div>
                    </div>
                    <div class="btn_xem" >
                        <button  class="xemthem">Đăng nhập <i class="far fa-paper-plane"></i></button>
                    </div>
                    </form>
                </div>
            </div>
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
        
        <div class="to">
            
            <div class="form">
                <form action="login/form.htm" method="post">           
                    <h2>Đăng nhập</h2>
                    <label>Username</label>
                    <input type="text" name="username" value="${cookie.username.value}" required maxlength="50"/>    
                    <p class="error">${unError}</p>
                    <label style="margin-left: -180px;">Password</label>
                    <input type="password" name="password" value="${cookie.password.value}" required maxlength="50"/>
                    <p class="error">${paError}</p>
                    <label for="chkremember">Remember me</label>
                    <input type="checkbox" name="chkremember" value="1" id="chkremember"/>                 
                    <input id="submit" type="submit" name="submit" value="Đăng nhập" />
                    <a href="password/recover/form.htm"><p>Quen mat khau ?</p></a>
                </form>
                <script>
                    function ketqua(){
                        alert("Đăng nhập thành công");
                    }
                </script>
                <!-- <script>
                    Nếu các điều kiện sai thì thông báo ở đây
                    function sai(){
                        alert("Sai cmnr, mời chọn lại :))");
                    }
                </script> -->
            </div>     
            
>>>>>>> origin/master
        </div>
                                
        <!--
        <h1>LOGIN</h1>
        ${message}
        <form action="login/validate.htm" method="post">
            <div>
                <label>Username</label>
                <input name="username" value="${cookie.username.value}"/>
                <p class="error">${unError}</p>
            </div>
            <div>
                <label>Password</label>
                <input type="password" name="password" value="${cookie.password.value}"/>
                <p class="error">${paError}</p>
            </div>
            <div>
                <input type="checkbox" name="chkremember" value="1" id="chkremember"/>
                <label for="chkremember">Remember me</label>
            </div>
            <div>
                <button>Login</button>
            </div>
        </form>
        <div>
            <a href="password/recover/form.htm"><p>Quen mat khau ?</p></a>
        </div>
        -->
    </body>
</html>
