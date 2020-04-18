<%-- 
    Document   : searchResults
    Created on : Apr 17, 2020, 12:19:37 PM
    Author     : Long
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Results</title>
        <base href="${pageContext.servletContext.contextPath}/">
    </head>
    <body>
        <h1>Results:</h1>
        <h3>${emptyError}</h3>
        <c:forEach var="m" items="${sessionScope.moviesList}" 
                   begin="${start}" end="${end}">
            <c:set var="path" value="resources/images/${m.maphim}/${m.poster}" scope="session"/>
            <div>
                <a href="movies/${m.maphim}.htm"><img src="${path}" alt="${m.maphim}---${m.poster}"></a>
                <p>${m.ten}</p>  
            </div>
        </c:forEach>
        <c:if test="${numPage<totalPages}">
            <form action="search/${key}/${numPage+1}.htm">
            <button>Next Page</button>
        </form>
        </c:if>
        <c:if test="${numPage>1}">
            <form action="search/${key}/${numPage-1}.htm">
            <button>Previous Page</button>
        </form>
        </c:if>
        
    </body>
</html>
