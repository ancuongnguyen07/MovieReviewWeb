<%-- 
    Document   : loginForm
    Created on : May 18, 2020, 3:34:12 PM
    Author     : Long
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADMIN LOGIN</title>
        <base href="${pageContext.servletContext.contextPath}/">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/all.min.css">
        <link rel="stylesheet" href="css/dn.css">
        <link href="https://fonts.googleapis.com/css2?family=Baloo+2&family=Montserrat:wght@300&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Baloo+Tamma+2:wght@500&display=swap" rel="stylesheet">
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.min.js" ></script>
    </head>
    <body>
        
        <div class="content1">
            <div class="container1">
                <div class="form">
                    <form action="login/admin/form.htm" method="post">
                    <div class="top">
                        <h2> Đăng nhập</h2>
                        <h4><i class="fas fa-user"></i> Tên đăng nhập</h4>
                        <input name="manv" value="${cookie.adminID.value}" required="true" maxlength="50"/>
                        <p class="error">${unError}</p>
                        <h4><i class="fas fa-key"></i> Password</h4>
                        <input type="password" name="password" value="${cookie.passwordAdmin.value}" required="true" maxlength="50"/>
                        <p class="error">${paError}</p>
                    </div>
                    <div class="bot">
                        <div class="nho">
                            <div class="trai">
                                <h4><i class="fas fa-clipboard"></i> Ghi nhớ đăng nhập <input type="checkbox" name="chkremember" value="1" id="chkremember"/></h4>
                                
                            </div>
                        </div>
                        <!--
                        <div class="quen">
                            <h4><a href="password/recover/form.htm"> <i class="fas fa-question-circle"></i> Quên mật khẩu!</a></h4>
                        </div>
                        -->
                    </div>
                    <div class="btn_xem" >
                        <button  class="xemthem">Đăng nhập <i class="far fa-paper-plane"></i></button>
                    </div>
                    </form>
                </div>
            </div>
        </div>
        
        <!--
        <div class="to">           
            <div class="form">
                <form action="login/admin/form.htm" method="post">           
                    <h2>Đăng nhập ADMIN</h2>
                    <label>ID</label>
                    <input type="text" name="manv" value="${cookie.adminID.value}" required maxlength="50"/>    
                    <p class="error">${unError}</p>
                    <label style="margin-left: -180px;">Password</label>
                    <input type="password" name="password" value="${cookie.passwordAdmin.value}" required maxlength="50"/>
                    <p class="error">${paError}</p>
                    <label for="chkremember">Remember me</label>
                    <input type="checkbox" name="chkremember" value="1" id="chkremember"/>                 
                    <input id="submit" type="submit" name="submit" value="Đăng nhập" />
                    <!--<a href="password/recover/form.htm"><p>Quen mat khau ?</p></a>
                </form>
            </div>     
            
        </div>
        -->
    </body>
</html>
