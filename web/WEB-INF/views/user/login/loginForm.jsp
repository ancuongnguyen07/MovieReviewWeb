<%-- 
    Document   : loginForm
    Created on : Apr 10, 2020, 9:25:36 AM
    Author     : Long
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Form!!!</title>
        <base href="${pageContext.servletContext.contextPath}/">
        <style>
            div{
                margin: 10px;
            }
            .error{
                color: #ff3333
            }
            #chkremember{
                
            }
        </style>
    </head>
    <body>
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
    </body>
</html>
