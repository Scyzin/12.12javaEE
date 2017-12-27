<%@ page import="login.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Student stu = new Student();
		stu.setName("tom");
		
		out.print(stu.getName());
		
		request.getRequestDispatcher("index.jsp");
	 %>
	 <jsp:useBean id="stu1" class="login.Student"></jsp:useBean>
	 <jsp:setProperty property="name" name="stu1" value="tom"/>
	 <jsp:getProperty property="name" name="stu1"/>
	 
	 <jsp:forward page="index.jsp">
	 	<jsp:param value="11111" name="name"/>
	 </jsp:forward>

</body>
</html>