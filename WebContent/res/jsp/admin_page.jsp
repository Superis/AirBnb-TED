<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin page</title>
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
  <%@ page import="javaClasses.*" %>
  <%@ page import="java.sql.*" %>
  <%@ page import="java.util.List" %>
  <%
  List<User> usrList = (List<User>)request.getAttribute("users");

  String[] strs = new String[6];
  
  if(usrList != null){
  for(User temp: usrList){
 	  temp.getAll(strs);
 	  String img_loc="/files/"+strs[5];
 	 String userrole;
	  String ucolor="w3-white";
	  if (strs[4].equals("A")){
		  userrole="Tenant,waiting for a host approval!";
		  ucolor="w3-red";
	  }
	  else if (strs[4].equals("H"))
		  userrole="Host";
	  else
		  userrole="Tenant";
  %>
    <li class="w3-bar">
      <span onclick="show_profile('<%=strs[0] %>')" class="w3-bar-item w3-button <%= ucolor %> w3-xlarge w3-right">></span>
      <img   height="60" width="40" src=<%=img_loc %> class="w3-bar-item w3-circle w3-hide-small" style="width:85px">
      <div class="w3-bar-item">
        <span class="w3-large"><%=strs[0] %> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><%= userrole %></strong>  </span><br>
      </div>
    </li>

    
    <%}
  }

%>
  </ul>
</div>

<form action="${pageContext.request.contextPath}/LogoutServlet" method="post">
   <input type="submit" class="button" value="Logout" >
	</form>
<script src="${pageContext.request.contextPath}/res/js/js_test.js" type="text/javascript"> </script>

</body>
</html>