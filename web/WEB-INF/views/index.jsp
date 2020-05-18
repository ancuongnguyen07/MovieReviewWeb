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
        <base href="${pageContext.servletContext.contextPath}/">
        <link href="https://fonts.googleapis.com/css2?family=Baloo+2&family=Montserrat:wght@300&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/reset.css">
        <link href="https://fonts.googleapis.com/css2?family=Baloo+Tamma+2:wght@500&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/all.min.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.min.js" ></script>
        <script type="text/javascript" src="js/slider.js" ></script>
        
        <title>Trang chủ</title>
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
                            <li><a href="all.htm"><i class="far fa-file-video" style="color: red;" ></i> Phim</a></li>
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
                                <li><a href="user/access.htm?signup">Đăng kí</a></li>
                                <li><a href="user/access.htm?login" >Đăng nhập</a></li>
                            </ul>
                        </c:otherwise>
                    </c:choose>   
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
                    
        <c:set var="path" value="resources/images/" scope="session"/>
        <div class="slide">
            <div class="container_slide">
                <div class="slider">
                    <a href="movies/${noibat[0].maphim}.htm"><img class="slider1" src="${path}${noibat[0].maphim}/${noibat[0].poster}" stt="0" /></a>
                    <c:forEach var="m" items="${noibat}" begin="1" varStatus="index">
                        <a href="movies/${m.maphim}.htm"><img class="slider1" src="${path}${m.maphim}/${m.poster}"  stt="${index.index}"  style="display:none" /></a>                        
                    </c:forEach>
                    <a  id="prev"  ><i class="fas fa-chevron-circle-left" style="font-size: 40px;" ></i></a>
                    <a  id="next"  ><i class="fas fa-chevron-circle-right" style="font-size: 40px;" ></i></a>
                </div>
            </div>
        </div>
                    
        <div class="Noibat">
            <div class="container" >
                <div class="gioithieu">
                    <h1><i class="fas fa-medal"></i> ĐÁNH GIÁ CAO</h1>
                </div>
                <div class="noidung">
                    <div class="trailer">
                        <iframe width="580" height="320" src="${noibat[0].trailer}"autoplay = "1" frameborder="0" allow="accelerometer; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                    </div>
                    <div class="right">
                        <div class="gioithieu_tieude">
                            <h2>${noibat[0].ten}</h2>
                        </div>
                        <div class="mota">
                            <p>${noibatPlot}</p>
                        </div>
                        <div class="btn_xem" >
                            <button  ><a href="movies/${noibat[0].maphim}.htm" class="xemthem"  >Xem thêm  <i class="far fa-paper-plane"></i></a></button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="content">
            <div class="Item" >
                <div class="Tieude">
                    <p><i class="fas fa-film"></i> Phim sắp chiếu</p>
                </div>
                <div class="Item_phim" >
                    <div class="blog">
                        <c:forEach var="p" items="${sapchieu}">
                            <div class="blog__details">
                            <!-- tên phim -->
                            <div class="thumbnail">
                                <a href="movies/${p.maphim}.htm"><img src="${path}${p.maphim}/${p.poster}" alt="Hình ảnh phim trang chủ"></a>
                            </div>
                            <h2><a href="movies/${p.maphim}.htm">${p.ten}</a></h2>
                            
                            
                            <div class="danhgia" >
                                <p>Được đánh giá: <span>${p.diem}</span></p>
                            </div>
                            <div class="btn_xem" >
                                <button  ><a href="movies/${p.maphim}.htm" class="xemthem" >Xem thêm <i class="far fa-paper-plane"></i></a></button>
                            </div>
                        </div>
                        </c:forEach>
                        
                        <!-- Tải phần tử từ cơ sở dữ liệu lên -->
                    </div>
                </div>
            </div>
            <div class="Item" >
                <div class="Tieude">
                    <p><i class="fas fa-film"></i> Phim đang chiếu</p>
                </div>
                <div class="Item_phim" >
                    <div class="blog">
                        <c:forEach var="p" items="${dangchieu}">
                            <div class="blog__details">
                            <!-- tên phim -->
                            <div class="thumbnail">
                                <a href="movies/${p.maphim}.htm"><img src="${path}${p.maphim}/${p.poster}" alt="Hình ảnh phim trang chủ"></a>
                            </div>
                            <h2><a href="movies/${p.maphim}.htm">${p.ten}</a></h2>
                            
                            
                            <div class="danhgia" >
                                <p>Được đánh giá: <span>${p.diem}</span></p>
                            </div>
                            <div class="btn_xem" >
                                <button  ><a href="movies/${p.maphim}.htm" class="xemthem" >Xem thêm <i class="far fa-paper-plane"></i></a></button>
                            </div>
                        </div>
                        </c:forEach>
                        
                        <!-- Tải phần tử từ cơ sở dữ liệu lên -->
                    </div>
                </div>
            </div>
            <div class="Item" >
                <div class="Tieude">
                    <p><i class="fas fa-film"></i> Phim hot</p>
                </div>
                <div class="Item_phim" >
                    <div class="blog">
                        <c:forEach var="p" items="${hot}">
                            <div class="blog__details">
                            <!-- tên phim -->
                            <div class="thumbnail">
                                <a href="movies/${p.maphim}.htm"><img src="${path}${p.maphim}/${p.poster}" alt="Hình ảnh phim trang chủ"></a>
                            </div>
                            <h2><a href="movies/${p.maphim}.htm">${p.ten}</a></h2>
                            
                            
                            <div class="danhgia" >
                                <p>Được đánh giá: <span>${p.diem}</span></p>
                            </div>
                            <div class="btn_xem" >
                                <button  ><a href="movies/${p.maphim}.htm" class="xemthem" >Xem thêm <i class="far fa-paper-plane"></i></a></button>
                            </div>
                        </div>
                        </c:forEach>
                        
                        <!-- Tải phần tử từ cơ sở dữ liệu lên -->
                    </div>
                </div>
            </div>
            <div class="footer">
                <div class="container">
                    <div class="thongtin">
                        <div class="left">
                            <a href=""><img src="img/logo1.PNG" alt=""  height="100px" width="200px" ></a>
                        </div>
                        <div class="right">
                            <h1>HỌC VIỆN CÔNG NGHỆ BƯU CHÍNH VIỄN THÔNG</h1>
                            <h1>Lớp: D17CQAT01-N</h1>
                            <h1>Nhóm: 10</h1>
                            <h1>Huỳnh Thị Xuân Thịnh</h1>
                            <h1>Nguyễn An Cương</h1>
                            <h1>Nguyễn Đăng Minh</h1>
                        </div>
                    </div>  
                    <div class="detai">
                        <p>Đề tài: Web đánh giá phim ảnh và bình luận phim</p>
                    </div>
                </div>
            </div>
        </div>
    </body>       
</html> 
            
            
        <!--            
        <div>
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
        </div>
        <div>
            <form action="search.htm">
                <input type="text" placeholder="Nhap ten phim" name="keySearch"/>
                <button>Search</button>
                <p class="error">${sessionScope.error}</p>
            </form>
        </div>
        <c:forEach var="m" items="${movies}">
            <c:set var="path" value="resources/images/${m.maphim}/${m.poster}" scope="session"/>
            <div>
                <a href="movies/${m.maphim}.htm"><img src="${path}" alt="${m.maphim}---${m.poster}"></a>
                <p>${m.ten}</p>             
            </div>
        </c:forEach>
        <h3>Tin Tuc </h3>
        -->
        
    </body>
</html>
