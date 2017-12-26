<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
  
  <!-- 这是html注释 -->
  <%--这是jsp注释 	是安全的，并且省流量--%>
   		<%
   			Date date =new Date();
   			
   		 %>
   		 <%=date.toLocaleString()
   		  %>
		<%!	//这里的num1是全局变量
			int num1=10;
		 %>
		 <%	//这是在service里面的，运行一次后就会摧毁
		 	int num2=10;
		 	num1++;
		 	num2++;
		  %>//多运行几次，会发现,num1会一直改变，num2不会变 
		  <%=num1 %>	
		  <%=num2 %>
  </body>
</html>
