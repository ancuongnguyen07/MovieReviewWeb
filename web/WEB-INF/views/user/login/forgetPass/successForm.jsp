<%-- 
    Document   : successForm
    Created on : Apr 18, 2020, 1:52:23 PM
    Author     : Long
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recovery Page</title>
        <base href="${pageContext.servletContext.contextPath}/">
    </head>
    <body>
        <h1>Your new password is sent to the registered email</h1>
        <h3>Visit inbox (even spam box) to have further information</h3>
        <p>${message}</p>
        <a href="welcome.htm">Return homepage</a>
    </body>
</html>
