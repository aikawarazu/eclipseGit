<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>error</title>
</head>
<body>
	struts:
	<p>
		<q>error page</q>
	</p>

	<c:if test="${!empty errorMessage }">
		<div>ERRORS:</div>
		<ol>
			<c:forEach items="${errorMessage }" var="err">
				<li>${err.value}</li>
			</c:forEach>
		</ol>
	</c:if>
</body>
</html>