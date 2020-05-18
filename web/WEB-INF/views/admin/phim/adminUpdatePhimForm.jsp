<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng ký</title>
<style>
    .disable{
        pointer-events: none;
        background: grey;
    }
</style>
</head>
<body>
    <div class="wrapper fadeInDown">
    <div id="formContent">
    <!-- Tabs Titles -->

    <!-- Icon -->
    <div class="fadeIn first">
        <img src="resources/logo.png" id="icon" alt="User Icon" />
    </div>
    <!-- Update Form -->
    
    
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
    
  </div>
</div>
</body>
</html>