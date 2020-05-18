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
    <title>Cập nhật Phim</title>
</head>
<body>
    <div class="content1">
        <div class="container1">
            <div class="form">
                <form:form action="admin/phim/update.htm" method="POST" modelAttribute="phim" enctype="multipart/form-data">
                <h2>Cập nhật Phim</h2>
                <div class="con">
                    <div class="left">
                        <h4>Mã Phim </h4>
                        <form:input path="maphim" type="text" readonly="true"/>
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
                        <form:input path="ngaychieu" placeholder="yyyy/MM/dd" required="true" typw="text" pattern="[1-9][0-9]{3}/[0-9]{2}/[0-9]{2}"/>
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
                        <form:errors path="thoiluong"/>
                        <h4>Trailer </h4>
                        <form:input path="trailer" required="true"/>
                        <form:errors path="trailer"/>                   
                        <h4> Poster </h4>
                        <input type="file" name="picture" />
                       
                        <h4> Tóm tắt </h4>
                        <input type="file" name="content" />
                        
                        <h4> Thể loại </h4>
                        <form:input path="theloai" required="true" maxlength="50"/>
                        <form:errors path="theloai"/>
                    </div>
                </div>
                <div class="btn_xem" >
                    <button class="xemthem">Cập nhật Phim<i class="far fa-paper-plane"></i></button>
                </div>
                </form:form>
            </div>
        </div>
    </div>
    
    <!--
    <form:form action="update.htm" modelAttribute="phim" enctype="multipart/form-data" method="POST">
        <div>
            <form:input type="text" id="maphim" path="maphim" placeholder="Ma phim" readonly="true"/>
        </div>
        
        <div>
            <form:input type="text" id="ten" path="ten" placeholder="Ten" />
        </div>
        
        <div>
            <form:input type="text" id="dienvien" path="dienvien" placeholder="Dien vien" />
        </div>
        
        <div>
            <form:input type="text" id="daodien" path="daodien" placeholder="Dao dien"/>
        </div>
        
        <div>
            <form:input type="text" id="ngaychieu" path="ngaychieu" placeholder="Ngay chieu" />
        </div>
        
        <div>
            <form:input type="text" id="thoiluong" path="thoiluong" placeholder="thoi luong" />
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
            <form:input type="text" id="diem" path="diem" placeholder="diem" />
        </div>
        
        <div>
            <form:input type="text" id="trailer" path="trailer" placeholder="trailer" />
        </div>
        
        <div>
            <label>Poster</label>
            <input type="file" name="picture" />
        </div>
        
        <div>
            <lable>Tom tat</lable>
            <input type="file" name="content"/>
        </div>
        
        <div>
            <form:input type="text" id="theloai" path="theloai" placeholder="theloai" />
        </div>
        
        <div>
           <form:input type="text" path="luotbl" readonly="true"/> 
        </div>
        


        <input type="submit" value="Cap nhat phim"/>
    </form:form>
    -->

</body>
</html>