<%-- 
    Document   : info
    Created on : Apr 11, 2020, 9:28:49 PM
    Author     : Long
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie Info</title>
        <base href="${pageContext.servletContext.contextPath}/">
        <style>
            div{
                margin: 15px;
            }
        </style>
    </head>
    <body>
        <h1>${movie.ten}</h1>
        <c:set var="pa" value="resources/images/${movie.maphim}/${movie.poster}" scope="session"/>
        <img src="${pa}" alt="Poster ${movie.maphim}"/>
        <li>
            <ul>Dao dien: ${movie.daodien}</ul>
            <ul>Dien vien: ${movie.dienvien}</ul>
            <ul>Ngay chieu: ${movie.ngaychieu}</ul>
            <ul>Gioi han do tuoi: ${movie.gioihandotuoi}</ul>
            <ul>The loai: ${movie.theloai}</ul>
            <ul>Diem: ${movie.diem}</ul>
            <ul>Noi dung: ${plot}</ul>
        </li>
        <iframe width="560" height="315" src="${movie.trailer}" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>   
        <hr/>
        <c:choose>
            <c:when test="${sessionScope.loggedin==true}">
                <form:form action="movies/validate/${movie.maphim}.htm" modelAttribute="bl">
                    <div>            
                        <form:textarea path="noidung" cols="20" rows="5" title="Suy nghi"/>
                    </div>
                    <div>
                        <label>Diem</label>
                        <form:select path="diem">
                            <form:option value="null" label="----Select----"/> 
                            <form:options items="${scoreList}"/>
                        </form:select>
                    </div>
                    <div>
                        <button>Post</button>
                    </div>
                </form:form>
            </c:when>
        </c:choose>
        <hr/>
        <h3>Binh Luan</h3>
        <c:forEach var="bl" items="${listBl}">
            <p>${bl.noidung}</p>
            <p>Diem: ${bl.diem}</p>
        </c:forEach>
    </body>
</html>
