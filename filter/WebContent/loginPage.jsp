<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if(request.getAttribute("tip") != null)
{
	out.println("<font color='red'>" 
		+ request.getAttribute("tip")
		+ "</font>");
}
%>
<form method="post" action="proLogin.jsp">
	用户名：<input type="text" name="username"><br><br>
	<input type="submit" value="确定">
	<input type="reset" value="重置"><br><br>
</form>

</body>
</html>
