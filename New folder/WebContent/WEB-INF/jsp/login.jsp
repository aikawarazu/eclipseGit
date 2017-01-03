<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/loginAction">
		<div>
			<label for="name">username</label> <input name="username" id="name" />
		</div>
		<div>
			<label for="pwd">password</label> <input name="password" id="pwd" />
		</div>
		<div>
			<input type="submit" value="login">
		</div>
	</form>
</body>
</html>