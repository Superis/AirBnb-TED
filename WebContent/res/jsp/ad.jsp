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
	String id = request.getParameter("id");
	mysqlConnector Connector = new mysqlConnector();
	Connector.establishConnection();
	List<Ad> adList = (List<Ad>)Connector.searchForAds("ID",id);
	Ad temp = adList.get(0);
	Connector.destroyConnection();
%>


<div class="green">
	<h3>
 		<center><%=temp.name%></center>
 	</h3>
</div>
<br>
<h4>
 DESCRIPTION :
</h4>
<br>
<br>
  <%= temp.desc %>
<br>
<img src=<%=temp.pic%> height="300" width="500">
<br>

<%
String user = "none";
if(request.getSession(false) != null)
{

	user = (String)request.getSession(false).getAttribute("user");
	if(user == null)
	{
%>

<%

	}
	else {
%>
	<input type="submit" value="Make Reservation" class="buttonNW" id="mkbtn" onclick="make_reservation('<%=user%>','<%=id%>')">
	<textarea class="textinput" id="content" rows="3" cols="50"></textarea>
	<input type="submit" name="send_message" class="buttonNW" value="Send message to host" onclick="send_message('<%=user%>','<%=temp.id%>')">
<%	}
}%>


<br>
</div>
</body>
</html>
