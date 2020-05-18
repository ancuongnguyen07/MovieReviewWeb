<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Đăng ký</title>
    <base href="${pageContext.servletContext.contextPath}/">
</head>
<body>
	<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->

    <!-- Icon -->
    <div class="fadeIn first">
      <img src="resources/logo.png" id="icon" alt="User Icon" />
    </div>
    <h3>${mess}</h3>
    <!-- Register Form -->
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
</body>
</html>