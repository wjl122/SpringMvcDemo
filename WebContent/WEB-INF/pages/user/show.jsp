<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>user add</title>
</head>
<body>
	<sf:form method="post" modelAttribute="user">
     username:${user.username}<br>
    nickname:${user.nickname}<br>
    password:${user.password }<br>
    email:${user.email}<br>
		<input type="submit" value="提交" />
		<br>
	</sf:form>
</body>
</html>