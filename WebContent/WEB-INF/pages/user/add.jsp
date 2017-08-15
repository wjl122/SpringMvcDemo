<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>user add</title>
</head>
<body>
<!-- enctype=" multipart/form-data" 上传文件       控制器中添加参数 -- MutipartFile file-->
   <sf:form method ="post" modelAttribute="user">
     username:<sf:input path="username"/><sf:errors path="username"/><br>
    nickname:<sf:input path="nickname"/><sf:errors path="nickname"/><br>
    password:<sf:input path="password"/><sf:errors path="password"/><br>
    email:<sf:input path="email"/><sf:errors path="email"/><br>
    <input type="submit"  value="提交"/><br>
   </sf:form>
</body>
</html>