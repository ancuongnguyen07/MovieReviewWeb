<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <base href="${pageContext.servletContext.contextPath}/">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/all.min.css">
    <link rel="stylesheet" href="css/addmovie.css">
    <title>Thêm Phim</title>
</head>
<body>
    <div class="content1">
        <div class="container1">
            <div class="form">
                <form:form action="admin/phim/addForm.htm" method="POST" modelAttribute="phim" enctype="multipart/form-data">
                <h2>Thêm Phim</h2>
                <div class="con">
                    <div class="left">
                        <h4>Mã Phim </h4>
                        <form:input path="maphim" type="text" required="true"/>
                        <form:errors path="maphim"/>
                        <p>${dupMaphim}</p>
                        <h4> Tên Phim </h4>
                        <form:input path="ten"  required="true"/>
                        <form:errors path="ten"/>
                        <h4> Diễn Viên </h4>
                        <form:input path="dienvien" required="true"/>
                        <form:errors path="dienvien"/>
                        <h4> Đạo Diễn </h4>
                        <form:input  path="daodien" required="true" />
                        <form:errors path="daodien"/>
                        <h4></i> Ngày chiếu</h4>
                        <form:input path="ngaychieu" placeholder="yyyy/MM/dd" required="true"/>
                        <form:errors path="ngaychieu"/>
                        
                        <h4>Giới hạn độ tuổi</h4>
                        <form:select path="gioihandotuoi">
                            <form:option value="13" label="13" />
                            <form:option value="16" label="16"/>
                            <form:option value="18" label="18"/>
                            <form:option value="21" label="21"/>
                        </form:select>
                        <form:errors path="gioihandotuoi"/>
                        
                    </div>
                    <div class="right">
                        <h4>Thời lượng </h4>
                        <form:input path="thoiluong" required="true" type="number" min="90" max="180"/>
                        <form:errors path="thoiluong"/> 
                        <h4>Điểm </h4>
                        <form:input path="diem"  required="true" type="number" min="0" max="10" step="0.01"/>
                        <form:errors path="diem"/> 
                        <h4>Trailer </h4>
                        <form:input path="trailer" required="true"/>
                        <form:errors path="trailer"/>                         
                        <h4> Poster </h4>
                        <input type="file" name="pic" required="true"/>
                        <div class="error-message">${posterMessage}</div>  
                        <h4> Tóm tắt </h4>
                        <input type="file" name="plot" required="true"/>
                        <div class="error-message">${tomtatMessage}</div> 
                        <h4> Thể loại </h4>
                        <form:input path="theloai" required="true" maxlength="50"/>
                        <form:errors path="theloai"/> 
                    </div>
                </div>
                <div class="btn_xem" >
                    <button class="xemthem">Thêm Phim<i class="far fa-paper-plane"></i></button>
                </div>
                </form:form>
            </div>
        </div>
    </div>
    
    <!--
	<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles 

    <!-- Icon 
    <div class="fadeIn first">
      <img src="resources/logo.png" id="icon" alt="User Icon" />
    </div>
    <h3>${mess}</h3>
    <!-- Register Form 
    <form:form action="admin/phim/addForm.htm" method="POST" modelAttribute="phim" enctype="multipart/form-data">
        <div>
            <label>Ma Phim</label>
            <form:input path="maphim" type="text"/>
            <form:errors path="maphim"/>
            <p>${dupMaphim}</p>
        </div>
        <div>
            <label>Ten phim</label>
            <form:input path="ten"  />
            <form:errors path="ten"/>
        </div>
        
        <div>
            <label>Dien vien</label>
            <form:input path="dienvien" />
            <form:errors path="dienvien"/>
        </div>
        
        <div>
            <label>Dao dien</label>
            <form:input  path="daodien"  />
            <form:errors path="daodien"/>
        </div>
        
        <div>
            <label>Ngay chieu</label>
            <form:input path="ngaychieu" placeholder="yyyy/MM/dd" />
            <form:errors path="ngaychieu"/>
        </div>
        
        <div>
            <label>Gioi han do tuoi</label>
            <form:select path="gioihandotuoi">
                <form:option value="13" label="13" />
                <form:option value="16" label="16"/>
                <form:option value="18" label="18"/>
                <form:option value="21" label="21"/>
            </form:select>
            <form:errors path="gioihandotuoi"/>
        </div>
        
        <div>
            <label>Thoi luong</label>
            <form:input path="thoiluong" />
            <form:errors path="thoiluong"/> 
        </div>
          
        <div>
            <label>Diem</label>
            <form:input path="diem"  />
            <form:errors path="diem"/> 
        </div>

        <div>
            <label>Trailer</label>
            <form:input path="trailer"  />
            <form:errors path="trailer"/> 
        </div>
        
        <div>
            <lable>Poster</lable>
            <input type="file" name="pic" />
            <div class="error-message">${posterMessage}</div>   
        </div>    
        <div>
            <lable>Tom tat</lable>
            <input type="file" name="plot"/>
            <div class="error-message">${tomtatMessage}</div>  
        </div>
        
        <div>
            <label>The loai</label>
            <form:input path="theloai" />
            <form:errors path="theloai"/>  
        </div>

        

        <input type="submit"  value="Thêm phim"/>
    </form:form>

  </div>
</div>
-->
</body>
</html>