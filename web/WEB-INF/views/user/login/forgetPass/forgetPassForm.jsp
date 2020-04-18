<%-- 
    Document   : forgetPassForm
    Created on : Apr 18, 2020, 1:17:39 PM
    Author     : Long
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forget Password Form</title>
        <base href="${pageContext.servletContext.contextPath}/">
        <style>
            .error{
                color: #ff0000;
            }
            div{
                margin: 10px;
            }
        </style>
    </head>
    <body>
        <h1>Recover Password!</h1>
        <p class="error">${message}</p>
        <form:form modelAttribute="user" action="password/recover/validate.htm">
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
    </body>
</html>
