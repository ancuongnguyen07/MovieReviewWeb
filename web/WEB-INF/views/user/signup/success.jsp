<%-- 
    Document   : success
    Created on : Apr 10, 2020, 9:22:16 AM
    Author     : Long
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Successfully!!!</title>
        <base href="${pageContext.servletContext.contextPath}/">
    </head>
    <body>
        <h1>Be a great member!</h1>
        <h3>${mess}</h3>
        <h2>${photoPath}</h2>
        <img src="files\23.jpg" alt="ANH NE"/>
        <form action="welcome.htm" >
            <button>Return to home page</button>
        </form>
    </body>
</html>
