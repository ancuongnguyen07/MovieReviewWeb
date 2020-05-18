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
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/all.min.css">
        <link rel="stylesheet" href="css/main.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div class="header">
            <div class="container">
                <div class="left">
                    <div class="logo">
                        <a href="welcome.htm" >
                            <img src="img/logo1.PNG" alt="" height="40px" width="100px">
                        </a>
                    </div>
                    <div class="menu1">
                        <ul>
                            <li><a href="all.htm">Phim</a></li>                            
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
                                <li><a href="user/editForm/${sessionScope.username}.htm">Xin chao ${sessionScope.username}!!!</a></li>
                                <li><a href="logout/user.htm">Log out</a></li>
                            </ul>
                        </c:when>
                        <c:otherwise>
                            <ul>
                                <li><a href="user/access.htm?signup" target="_blank" >Đăng kí</a></li>
                                <li><a href="user/access.htm?login"target="_blank">Đăng nhập</a></li>
                            </ul>
                        </c:otherwise>
                    </c:choose>   
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="Noibat">
            <div class="container" >
                <div class="noidung">
                    <c:set var="path" value="resources/images/" scope="session"/>
                    <div class="poster">
                        <img src="${path}${movie.maphim}/${movie.poster}" alt="HIHI" height="400px" width="auto">
                    </div>
                    <div class="right">
                        <div class="gioithieu_tieude">
                            <h2>${movie.ten}</h2>
                        </div>
                        <div class="danhgia" >
                            <p> Được đánh giá: <span>${movie.diem}</span></p>
                        </div>
                        <div class="mota">
                            <p>${plot}</p>
                        </div>
                        <!--
                        <div class="btn_xem" >
                            <a href="" class="xemthem">Đánh giá <i class="fas fa-star"></i> </a>
                            <a href="" class="xemthem">Mua vé <i class="fas fa-film"></i></a>
                        </div>
                        -->
                    </div>
                </div>
                <div class="trailer" >
                    <h2>Trailer <i class="fas fa-compact-disc"></i></h2>
                    <iframe width="700" height="394" src="${movie.trailer}" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                </div>
                <div class="card-body-container">
                    <div class="card-body">
                        <div class="tieude">
                            <h2>Đánh giá</h2>
                            <i class="fas fa-star"></i>
                        </div>
                        <c:choose>
                            <c:when test="${sessionScope.username!=null && !sessionScope.blockedUser}">
                                <div class="user-comment">
                                    <div class="iduser">
                                        <h4 class="info-user">
                                            <a class="id-user" href="#">${sessionScope.username}</a>
                                        </h4>
                                    </div>
                                    <div class="comment">
                                        <form:form action="user/comment/${movie.maphim}.htm" modelAttribute="bl" method="post">
                                            <form:input path="noidung" required="true" type="text" name="review" placeholder="Nhận xét của bạn" maxlength="100"/>
                                            <form:errors path="noidung"/>
                                                <form:select path="diem" id="DanhGia">
                                                    <form:options items="${scoreList}"/>
                                                    <form:errors path="diem"/>
                                                </form:select>
                                            <div class="submit">   
                                                <button>Gửi</button>
                                            </div>
                                        </form:form>
                                    </div>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="iduser">
                                    <h4 class="info-user">
                                        <a class="id-user" href="#">Tài khoản của bạn đã bị khóa hoặc bạn chưa đăng nhập để sử dụng chức năng bình luận</a>
                                    </h4>
                                </div>
                            </c:otherwise>
                        </c:choose>
                        <c:forEach var="bl" items="${listBl}">
                            <div class="card-review">
                                <div class="comment-info">
                                    <h4 class="info-user">
                                        <a class="id-user" href="#">${bl.user.username}</a>
                                        <span>
                                            <i class="fas fa-star"></i>
                                            ${bl.diem}
                                        </span>
                                    </h4>
                                    <!-- Time 
                                    <p class="comment-time">
                                        <time datetime="2020-03-06 22:12:46">2 tháng trước</time>
                                    </p>-->
                                </div> <!-- / .row -->
                                <div class="">
                                    <div class="review-content">
                                        ${bl.noidung}
                                    </div>
                                </div>        
                            </div>   
                        </c:forEach>
                    </div>

                </div>
            </div>
        </div>
        <!--
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
                <form:form action="comment/${movie.maphim}.htm" modelAttribute="bl">
                    <div>            
                        <form:textarea path="noidung" cols="20" rows="5" />
                        <form:errors path="noidung"/>
                    </div>
                    <div>
                        <label>Diem</label>
                        <form:select path="diem">
                            <form:options items="${scoreList}"/>
                            <form:errors path="diem"/>
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
            <div>
                <p>${bl.user.username}</p>
                <p>${bl.noidung}</p>
                <p>Diem: ${bl.diem}</p>
            </div>         
        </c:forEach>
        -->
    </body>
</html>
