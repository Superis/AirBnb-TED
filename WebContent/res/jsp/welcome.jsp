 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
	<title> TED </title>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/style.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/style2.css"/>
</head>

<body>
<%
String user = (String) request.getSession(false).getAttribute("user");
if(user != null) response.sendRedirect("./res/jsp/login_success.jsp");
%>
 <div class="topnav">
  <a href="#" id="registerform">Register</a> 
  <a href="#" id="loginform">Login</a> 
  <a href="#" id="about">About</a>
 </div>

<form action="${pageContext.request.contextPath}/Servlet" method="post">
<div class="login">
 <div class="formholder">
 <div class="randompad">
 <fieldset> <label name="email">Username</label>
 <input name="user" value="username" type="text" onchange="search_for_user_login(this.value)">
 <div id="toChange3"></div>
 <label>Password</label> <input name="password"
 type="password"> <input value="Login" name="login" id="login" type="submit">
  <!--  <font color="red" id="error" hidden>Either user name or password is wrong</font> -->
 </fieldset>
 </div>
 </div>
</div>
</form>

<form action="${pageContext.request.contextPath}/Servlet" method="post">
<div class="register">
 <div class="formholder">
 <div class="randompad">
 <fieldset> <label>Enter username</label>
 <input type="text" name="ruser" onchange="search_for_user_register(this.value)">
 <div id="toChange2"></div>
 <div id="erroru" style="display:none"><font color="red">Username already exists !</font></div>
 <label>Enter password</label>
 <input type="password" name="rpassword" id="p1">
 <label>Confirm password</label>
 <input type="password" onchange="match()" name="rpassword2" id="p2">
 <div id="errorp" style="display:none"><font color="red">Passwords don't match !</font></div>
 <label>Enter Email</label>
 <input value="example@email.com " type="text" name="email">
 <label>Enter phonenumber</label>
 <input type="text" name="phone">
 <table>
 <tr>
 <td>Choose your roles: Tenant <input type="radio" name="host/tenant" id="tenant" value="Y"></td>
 <td> Host <input type="radio" name="host/tenant" id="host" value="N"></td>
 </tr>
 </table>
  
 <input value="Register" name="register" id="register" type="submit">
 </fieldset>
 </div>
 </div>
</div>
</form>

<br>
<p style="color: red;" id="errorW">${registerMessage} ${loginMessage}</p>
<div id="toChange"> 
	<table class="search_table">
	<tr>
  	 <td><input type="text" class="search" id="place" placeholder="Place..."></td>
 	 <td><input type="text" class="search" id="from" onclick="$('#from').datepicker();$('#from').datepicker('show');" placeholder="Stay from(date).."></td>
 	 <td><input type="text" class="search" id="to" onclick="$('#to').datepicker();$('#to').datepicker('show');" placeholder="To(date).."></td>
 	 <td><input type="text" class="search"  placeholder="Number of people..."></td>  
  	 <td><input type="submit" class="button" value="Search" onclick="show_boxes(0)"></td>
  	 </tr>
	</table>
	<br>
	<br>
	<div class="center"><img src="${pageContext.request.contextPath}/res/img/logo.png" height="200" width="600"></div>
</div>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/res/js/js_test.js" type="text/javascript"> </script>
<script src="${pageContext.request.contextPath}/res/js/index.js" type="text/javascript"> </script>
</body>

</html>