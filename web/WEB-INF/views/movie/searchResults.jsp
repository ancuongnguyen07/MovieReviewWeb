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
        <link rel="stylesheet" href="css/all.min.css">
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/timkiem.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
    </head>
    <body>   
        <div class="header">
            <div class="container">
                <div class="left">
                    <div class="logo">
                        <a href="welcome.htm" >
                            <img src="img/logo1.PNG" alt="HIHIHI" height="40px" width="100px">
                        </a>
                    </div>
                    <div class="menu1">
                        <ul>
                            <li><a href=""><i class="far fa-file-video" style="color: red;" ></i> Phim</a></li>
                            <li><a href="https://www.cgv.vn/default/movies/now-showing.html" target="_blank" >Lịch chiếu</a></li>
                            <li><a href="https://kenh14.vn/cine.chn" target="_blank" >Sự kiện</a></li>
                        </ul>
                    </div>
                </div>
                <div class="find" >
                    <span class="icon"><i class="fa fa-search"></i></span>
                    <form action="search.htm">
                        <input type="text" placeholder="Nhap ten phim" name="keySearch" required/>
                        <button>Search</button>
                        <p class="error">${sessionScope.error}</p>
                    </form>
                </div>
                <div class="right" >
                    <c:choose>
                        <c:when test="${sessionScope.username!=null}">
                            <ul>
                                <li><a>Xin chao ${sessionScope.username}!!!</a></li>
                                <li><a href="logout/home.htm">Log out</a></li>
                            </ul>
                        </c:when>
                        <c:otherwise>
                            <ul>
                                <li><a href="user/access.htm?signup" target="_blank" >Đăng kí</a></li>
                                <li><a href="user/access.htm?login" >Đăng nhập</a></li>
                            </ul>
                        </c:otherwise>
                    </c:choose>   
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="content">
            <div class="products">
                <div class="GoiY">
                    <h2><i class="fas fa-lightbulb"></i> Gợi ý cho tìm kiếm "${key}"</h2>
                </div>
                
                <c:set var="path" value="resources/images/" scope="session"/>
                <c:forEach varStatus="row" begin="1" end="${numOfRows}">
                    <div class="row">
                        
                        <c:forEach var="m" items="${sessionScope.moviesList}" varStatus="sta"
                        begin="${start+itemsInRow*(row.index-1)}" end="${start+itemsInRow*(row.index-1)+itemsInRow-1}">
                            <div class="blog__details">
                                <!-- tên phim -->
                                <div class="thumbnail">
                                    <a href="movies/${m.maphim}.htm"><img src="${path}${m.maphim}/${m.poster}" alt="Hình ảnh phim trang chủ"></a>
                                </div>
                                <h2><a href="movies/${m.maphim}.htm">${m.ten}</a></h2>
                                <!-- nhận xét sơ lược phim -->
                                
                                <div class="danhgia" >
                                    <p>Được đánh giá: <span>${m.diem}</span></p>
                                </div>
                                <div class="btn_xem" >
                                    <button  ><a href="movies/${m.maphim}.htm" class="xemthem" >Xem thêm <i class="far fa-paper-plane"></i></a></button>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </c:forEach> 
                <div class="chuyentrang">
                    <div class="pagination">
                        <c:if test="${numPage>1}">
                            <a href="search/${key}/${page-1}.htm">&laquo;</a>
                        </c:if>
                        
                        <c:forEach varStatus="page" begin="1" end="${totalPages}">
                            
                            <!-- Trang nào được chọn thì class"active"ở đó -->
                            <c:choose>
                                <c:when test="${page.index==numPage}">
                                    <a href="search/${key}/${page.index}.htm"class="active">${page.index}</a> 
                                </c:when>
                                <c:otherwise>
                                    <a href="search/${key}/${page.index}.htm">${page}</a> 
                                </c:otherwise>
                            </c:choose>                        
                        </c:forEach>
                        <c:if test="${numPage<totalPages}">
                            <a href="search/${key}/${numPage+1}.htm">&raquo;</a>
                        </c:if>
                        
                      </div>
                </div>
            </div>
            
        </div>
        <h2 >${emptyError}</h2>
        <!--
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
        -->
    </body>
</html>
