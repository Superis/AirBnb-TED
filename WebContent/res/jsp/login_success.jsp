<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javaClasses.mysqlConnector" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login Success Page</title>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/style.css"/>
</head>
<body>
<%
//allow access only if session exists
String user = (String) request.getSession(false).getAttribute("user");
if(user != null && user.equals("admin")) response.sendRedirect("/TED/Servlet");
if(user == null) response.sendRedirect("/TED/Servlet");
String userName = null;
String sessionID = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("user")) userName = cookie.getValue();
	if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
}
}
String img_loc=" ";
mysqlConnector Connector = new mysqlConnector();
Connector.establishConnection();
try {
	img_loc=Connector.FindImage(user);
}catch(SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
img_loc="/files/"+img_loc;
String thisad=(String)request.getSession(false).getAttribute("strtarget");
%>
<!--  <h3>Hi <%=userName %>, Login successful. Your Session ID=<%=sessionID %></h3>
<br>
User=<%=user %>
<br>-->

<div class="topnav">
  <a onclick="show_dropdown()"> <img src=<%=img_loc%> height="40" width="40"> <%=userName%> </a> 
</div>

<% if (thisad!=null && thisad.equals("ok")){%>

<div id="myDropdown" class="dropdown-content">
    <a href="#" onclick="show_settings()">Profile Settings</a>
    <a href="#" onclick="show_reservations()">Reservations</a>
    <a href="#" onclick="show_messages('<%=user%>')">My Messages</a>
    <a href="#" onclick="show_ads(0)">My Ads</a>
    <a href="#" onclick="make_ad()" id="ad">Make new ad</a>
    <form action="${pageContext.request.contextPath}/LogoutServlet" method="post">
    <a href="#"><input type="submit" class="button" value="Logout" ></a>
	</form>
</div> 
<%}
else{%>
<div id="myDropdown" class="dropdown-content">
    <a href="#" onclick="show_settings()">Profile Settings</a>
    <a href="#" onclick="show_reservations()">Reservations</a>
    <a href="#" onclick="show_messages('<%=user%>')">My Messages</a>
    <form action="${pageContext.request.contextPath}/LogoutServlet" method="post">
    <a href="#"><input type="submit" class="button" value="Logout" ></a>
	</form>
</div> 
<% }%>
 <br>
 
<a style="color: red;">${errormessage} </a>

 <div id="toChange">
	<table class="search_table">
	<tr>
  	 <td><input type="text" class="search" id="place" placeholder="Place..."></td>
 	 <td><input type="text" class="search" id="from" onclick="$('#from').datepicker();$('#from').datepicker('show');" placeholder="Stay from(date).."></td>
 	 <td><input type="text" class="search" id="to" onclick="$('#to').datepicker();$('#to').datepicker('show');" placeholder="To(date).."></td>
 	 <td><input type="text" class="search" id="max" placeholder="Number of people..."></td>  
  	 <td><input type="submit" class="button" value="Search" onclick="show_boxes(0)"></td>
  	 </tr>
	</table>
		<br>
	<br>
	<div class="center"><img src="${pageContext.request.contextPath}/res/img/logo.png" height="200" width="600"></div>
	<a href="${pageContext.request.contextPath}/Recommend" > SEE RECOMENDATIONS </a>
</div>

<script src="https://maps.googleapis.com/maps/api/js?libraries=places&key=AIzaSyDp-buvGy-gXQey238T7oF5NOzw4I6Z6jY"></script>
<script src="${pageContext.request.contextPath}/res/js/google_maps.js" type="text/javascript"> </script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/res/js/js_test.js" type="text/javascript"> </script>
</body>
</html>