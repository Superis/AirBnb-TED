<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<label> My Profile</label>
<br>
<br>
<br>

<%@ page import="javaClasses.mysqlConnector" %>
<%@ page import="java.sql.*" %>
<%
mysqlConnector Connector = new mysqlConnector();
Connector.establishConnection();
ResultSet rs = Connector.userInfo((String) request.getSession(false).getAttribute("user"));

ResultSetMetaData rsmd = rs.getMetaData();
int columnsNumber = rsmd.getColumnCount();
String[] strs = new String[columnsNumber];
while(rs.next()){
	 for (int i = 1; i <= columnsNumber; i++) {
	         String columnValue = rs.getString(i);
	         strs[i-1] = columnValue;	 
	 }
}

Connector.destroyConnection();

for(String str: strs){
	System.out.print(str+" ");
}
%>


	
<form action="${pageContext.request.contextPath}/ConnectedServlet"
	method="post"
	enctype="multipart/form-data"
	>
<table style="width:50%">
<tr>
	<td><label>Profile picture: </label></td>
	</tr>
<tr>
	<td><img src=<%= "/files/"+strs[6] %> height=200 width=200></td>
	<td>Please select a JPEG (.jpg) file to be sent:</td>
	<td><label class="fileContainer" >Choose image...<input type="file" name="file" onchange="show_path(this.value)"></label>
	<font id="path" color="green" style="display: none;">Image has been selected</font></td>
</tr>
<tr>
<td><label> Username: </label></td>
<td><%=strs[0]%></td>
</tr>
<tr>
<td><label>Password: </label></td>
<td><input type="password" class="textinput" id="p1" placeholder="new password"></td>
<td><input type="password" class="textinput" id="p2" name="password" placeholder="confirm password" onchange="match()"></td>
</tr>
<tr>
<td></td>
<td><div id="errorp" style="display:none"><font color="red">Passwords don't match !</font></div></td>
</tr>
<tr>
<td><label> Email: </label></td>
<td><%=strs[3]%></td>
<td><input type="text" name="email" class="textinput" placeholder="new email"></td>
</tr>
<tr>
<td><label>Phone number: </label></td>
<td><%=strs[4]%></td>
<td><input type="text" name="phone" class="textinput" placeholder="new phone number"></td>
</tr>
<tr>
<td></td>
<td>
<input type="submit" class="buttonNW" value="Save Changes" onclick="info_alert()" name="saveChanges"></td>
<td><input type="submit" class="buttonNW" value="Back to search" onclick="show_search()"></td>
</tr>
</table>
</form>


</body>
</html>