<%-- 
    Document   : addMovie
    Created on : Apr 27, 2020, 10:55:46 PM
    Author     : Long
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <base href="${pageContext.servletContext.contextPath}/">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add Movie !</h1>
        <form:form action="movieMGR/add.htm" method="post" enctype="multipart/form-data" modelAttribute="movie">
            <div>
                <label>Ma phim</label>
                <form:input path="maphim"/>
            </div>
            <div>
                <label>Ten phim</label>
                <form:input path="ten"/>
            </div>
            <div>
                <label>Dien vien</label>
                <form:input path="dienvien"/>
            </div>
            <div>
                <label>Dao dien</label>
                <form:input path="daodien"/>
            </div>
            
            <div>
                <label>Ngay chieu</label>
                <form:input path="ngaychieu"/>
            </div>
            <div>
                <label>Thoi luong</label>
                <form:input path="thoiluong"/>
            </div>
            <div>
                <label>Gioi han do tuoi</label>
                <form:input path="gioihandotuoi"/>
            </div>
            <div>
                <label>Diem</label>
                <form:input path="diem"/>
            </div>
            
            <div>
                <label>Trailer</label>
                <form:input path="trailer"/>
            </div>
            <div>
                <label>Poster</label>
                <input type="file" name="pic"/>
            </div>
            <div>
                <label>Tom tat</label>
                <form:input path="tomtat"/>
            </div>
            <div>
                <label>The loai</label>
                <form:input path="theloai"/>
            </div>
            <div>
                <button>Submit</button>
            </div>
        </form:form>
    </body>
</html>
