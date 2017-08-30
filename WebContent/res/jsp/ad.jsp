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
<%@ page import="javaClasses.mysqlConnector" %>
<%@ page import="java.sql.*" %>
<%
	String id = request.getParameter("id");
	mysqlConnector Connector = new mysqlConnector();
	Connector.establishConnection();
	ResultSet rs = Connector.searchForAds("ID",id);
	ResultSetMetaData rsmd = rs.getMetaData();
	int columnsNumber = rsmd.getColumnCount();
	String[] strs = new String[columnsNumber];
	if(rs.next()){
		 for (int i = 1; i <= columnsNumber; i++) {
		         String columnValue = rs.getString(i);
		         strs[i-1] = columnValue;	
		 }
	}
		 
%>


<div class="green">
	<h3>
 		<center><%=strs[1]%></center>
 	</h3>
</div>
<br>
<h4>
 DESCRIPTION :
</h4>
<br>
<br>
  <%= strs[2] %>
<br>
<img src=<%=strs[6]%> height="300" width="500">
<br>

<%
String user = "none";
if(request.getSession(false) != null)
{

	user = (String)request.getSession(false).getAttribute("user");
	if(user == null)
	{
%>
		<div hidden id="case" value="no"></div>
<%

	}
	else {
%>
	<div hidden id="case" value="yes"></div>
<%	}
}%>

<input style="display: none"type="submit" value="Make Reservation" class="buttonNW" id="mkbtn" onclick="make_reservation('<%=user%>','<%=id%>')">
<div id="toChangeAd"></div>
<br>
</div>
</body>
</html>
