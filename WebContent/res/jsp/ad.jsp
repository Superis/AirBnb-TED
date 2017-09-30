<!DOCTYPE html>
<html>
<head>
	<Title> AD </Title>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/style.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/style2.css"/>

</head>

<body>

<div class="adContent">
<%@ page import="javaClasses.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%	
	Ad item=null;
	if (request.getAttribute("results")==null){
		%> PROBLEM <%
	}
	else{
		List<Ad> adList = (List<Ad>) request.getAttribute("results");
		item=adList.get(0);
	}
	
	if (item!=null){	 
%>


<div class="green">
	<h3>
 		<center><%=item.name%></center>
 	</h3>
</div>
<br>
<h4>
 DESCRIPTION :
</h4>
<br>
<br>
  <%= item.desc %>
<br>
<img src=<%=item.pic%> height="300" width="500">
<br>

<%

String user = "none";
if(request.getSession(false) != null)
{

	user = (String)request.getSession(false).getAttribute("user");
	if(user == null)
	{
		System.out.print("problem");
%>

<%

	}
	else {
		System.out.print("not that");
%>
	<input type="submit" value="Make Reservation" class="buttonNW" id="mkbtn" onclick="make_reservation('<%=user%>','<%=item.id%>')">
	<div id="toChangeAd"></div>
	<textarea class="textinput" id="content" rows="3" cols="50"></textarea>
	<input type="submit" name="send_message" class="buttonNW" value="Send message to host" onclick="send_message('<%=user%>','<%=item.id%>')">
<%	}
  }
}%>


<br>
</div>
</body>
</html>
