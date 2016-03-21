<%@ page language="java" import="java.util.*" contentType="text/html; utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增用户</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<form action='<c:url value="/user.html"></c:url>' method="post">
  		<table>
  			<tr>
  				<td>用户名：</td>
  				<td><input type="text" name="userName" /></td>
  			</tr>
  			<tr>
  				<td>密码：</td>
  				<td><input type="text" name="password" /></td>
  			</tr>
  			<tr>
  				<td>姓名：</td>
  				<td><input type="text" name="realName" /></td>
  			</tr>
  			<tr>
  				<td colspan="2"><input type="submit" name="提交" /></td>
  			</tr>
  		</table>
  	</form>
  </body>
</html>
