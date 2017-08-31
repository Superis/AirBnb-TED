<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/style.css"/>
<body>
Hello Admin!
<div id="myModal" class="modal">
  <span class="close cursor" onclick="closeModal()">&times;</span>
  <div class="modal-content" id="modalContent">
  </div>
 </div>
 
<div class="w3-container">
  <ul class="w3-ul w3-card-4">
  <%@ page import="javaClasses.mysqlConnector" %>
  <%@ page import="java.sql.*" %>
  <%
  mysqlConnector Connector = new mysqlConnector();
  Connector.establishConnection();
  ResultSet rs = Connector.allUsers();
  
  ResultSetMetaData rsmd = rs.getMetaData();
  int columnsNumber = rsmd.getColumnCount();
  String[] strs = new String[columnsNumber];
  
  while(rs.next()){
 	 for (int i = 1; i <= columnsNumber; i++) {
 	         String columnValue = rs.getString(i);
 	         strs[i-1] = columnValue;	 
 	 }
 	  String img_loc="/files/"+strs[6];
 	  String userrole;
 	  String ucolor="w3-white";
 	  if (strs[5].equals("A")){
 		  userrole="Tenant,waiting for a host approval!";
 		  ucolor="w3-red";
 	  }
 	  else if (strs[5].equals("H"))
 		  userrole="Host";
 	  else
 		  userrole="Tenant";
  %>
    <li class="w3-bar">
      <span onclick="show_profile('<%=strs[0] %>')" class="w3-bar-item w3-button <%= ucolor %> w3-xlarge w3-right">></span>
      <img  src=<%=img_loc %> class="w3-bar-item w3-circle w3-hide-small" style="width:85px">
      <div class="w3-bar-item">
        <span class="w3-large"><%=strs[0] %> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><%= userrole %></strong>  </span><br>
      </div>
    </li>

    
    <%}

%>
	<li class="w3-bar">
      <span onclick="this.parentElement.style.display='none'" class="w3-bar-item w3-button w3-white w3-xlarge w3-right">×</span>
      <img  class="w3-bar-item w3-circle w3-hide-small" style="width:85px">
      <div class="w3-bar-item">
        <span class="w3-large">Jill</span><br>
        <span>Support</span>
      </div>
    </li>

    <li class="w3-bar">
      <span onclick="this.parentElement.style.display='none'" class="w3-bar-item w3-button w3-white w3-xlarge w3-right">×</span>
      <img src="img_avatar6.png" class="w3-bar-item w3-circle w3-hide-small" style="width:85px">
      <div class="w3-bar-item">
        <span class="w3-large">Jane</span><br>
        <span>Accountant</span>
      </div>
    </li>
  </ul>
</div>

<form action="${pageContext.request.contextPath}/LogoutServlet" method="post">
   <input type="submit" class="button" value="Logout" >
	</form>
<script src="${pageContext.request.contextPath}/res/js/js_test.js" type="text/javascript"> </script>

</body>
</html>