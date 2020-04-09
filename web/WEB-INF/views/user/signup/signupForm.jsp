<%-- 
    Document   : form
    Created on : Apr 10, 2020, 8:41:01 AM
    Author     : Long
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up Page</title>
        <style>
            div{
                margin: 20px;
            }
            .error{
                color: #ff0000
            }
        </style>
    </head>
    <body>
        <h1>Fill INFO!</h1>
        <p class="error">${message}</p>
        <form:form modelAttribute="user" action="validate.htm">
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
                <label>Gioi tinh</label>
                <form:radiobutton label="Nam" value="1" path="gioitinh" />
                <form:radiobutton label="Nu" value="0" path="gioitinh"/>
            </div>
            <div>
                <label>SDT</label>
                <form:input path="sdt"/>
                <form:errors path="sdt" cssClass="error"/>
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
                <lable>Confirm password</lable>
                <input type="password" name="confirmPass"/>
                <p class="error">${errorMess}</p>
            </div>
            <div>
                <button>Submit</button>
            </div>
            
        </form:form>
    </body>
</html>
