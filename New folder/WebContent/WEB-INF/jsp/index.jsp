<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome</title>
</head>
<body>
	<c:if test="${empty username}">
	访客,请<a href="${pageContext.request.contextPath}/loginAction">登陆</a>
	</c:if>
	<c:if test="${not empty username}">ようこそ：${username}</c:if>
	<h1>welcome to my webside</h1>
</body>
</html>