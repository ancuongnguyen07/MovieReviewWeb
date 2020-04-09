<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <h1>Movies Review</h1>
        <c:choose>
            <c:when test="${sessionScope.loggedin==true}">
                <h3>Xin chao ${sessionScope.username}!!!</h3>
                <form action="logout/home.htm">
                    <button>Log out</button>
                </form>
            </c:when>
            <c:otherwise>
                <form action="user/access.htm" method="post">
                    <button name="login">Login</button>
                    <button name="signup">Sign Up</button>
                </form>
            </c:otherwise>
        </c:choose>   
        <c:forEach var="m" items="${movies}">
            <c:set var="path" value="resources/images/${m.maphim}/${m.poster}" scope="session"/>
            <div>
                <a href="movies/${m.maphim}.htm"><img src="${path}" alt="${m.maphim}---${m.poster}"></a>
                <p>${m.ten}</p>             
            </div>
        </c:forEach>
        <h3>Tin Tuc </h3>
    </body>
</html>
