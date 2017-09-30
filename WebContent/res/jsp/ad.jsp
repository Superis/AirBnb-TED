<!DOCTYPE html>
<html>
<head>
	<Title> AD </Title>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/style.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/style2.css"/>
	<link rel="stylesheet" href="jquery.rating.css">
    <script type="text/javascript" src="jquery.js"></script>
    <script type="text/javascript" src="jquery.rating.js"></script>
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
  <form>
            <input type="radio" name="rating" value="1" class="star" id="n1"><label for="n1">Bad</label>
            <input type="radio" name="rating" value="2" class="star" id="n2"><label for="n2">Not Impressed</label>
            <input type="radio" name="rating" value="3" class="star" id="n3"><label for="n3">Fair</label>
            <input type="radio" name="rating" value="4" class="star" id="n4"><label for="n4">Very Good</label>
            <input type="radio" name="rating" value="5" class="star" id="n5"><label for="n5">Brilliant</label>
            <input type="submit" value="Rate It!"  class="buttonNW" onclick="make_review('<%=user%>','<%=item.id%>')">
  </form>
HELLO
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
