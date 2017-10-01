<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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



<br>
<h1 align="center">ΠΛΗΡΟΦΟΡΙΕΣ ΑΓΓΕΛΙΑΣ</h1>

<br>
<table>
 <tr>
 <td style="vertical-align:top">
 <table>
 	<tr><td style="vertical-align:top">Πρόσβαση</td>
 	<td><textarea readonly class="textinput" rows="3" cols="50"><%=item.name%></textarea></td>
 	</tr>
 	<tr><td style="vertical-align:top">Περιγραφή</td>
 	<td><textarea readonly class="textinput" rows="3" cols="50"><%=item.desc %></textarea></td>
 	</tr>
 	<tr><td style="vertical-align:top">Κανόνες Ενοικίασης</td>
 	<td><textarea readonly class="textinput" rows="3" cols="50"></textarea></td>
 	</tr>
 </table>
 </td>
 <td> <img src=<%=item.pic%> height="300" width="500"></td>
 </tr>
 <tr><td>
 <table style="width:50%">
 	<tr>
 	<td style="vertical-align:top">Μέγιστος αριθμός ατόμων
 	<input readonly type="text" class="textinput" value="<%=item.maxp%>" ></td>
 	<td style="vertical-align:top">Ελάχιστη τιμή
 	<input type="text" class="textinput" value="<%=item.price%>"></td>
 	<td style="vertical-align:top">Eπιπλέον κόστος ανά άτομο
 	<input readonly type="text" class="textinput" value="<%=item.ppr%>"></td>
 	</tr>
 </table>
 </td></tr>
 <tr><td>
 <table style="width:50%">
 	<tr>
 	<td style="vertical-align:top">Τύπος ενοικιαζόμενου χώρου
 	<input readonly type="text" class="textinput" value="<%=item.type%>"></td>
 	<td style="vertical-align:top">Αριθμός κρεβατιών
 	<input readonly type="text" class="textinput" value="<%=item.beds%>"></td>
 	<td style="vertical-align:top">Αριθμός μπάνιων
 	<input readonly type="text" class="textinput" value="<%=item.wcs%>"></td>
 	</tr>
 </table>
 </td>
 </tr>
 <tr><td>
 <table style="width:50%">
 	<tr>
 	<td style="vertical-align:top">Αριθμός υπνοδωματίων
 	<input readonly type="text" class="textinput" value="<%=item.bedrooms%>"></td>
 	<td style="vertical-align:top">Αριθμός καθιστικών
 	<input readonly type="text" class="textinput" value="<%=item.living_rooms%>"></td>
 	<td style="vertical-align:top">Εμβαδό χώρου
 	<input readonly type="text" class="textinput" value="<%=item.area%>"></td>
 	</tr>
 </table>
 </td>
 </tr>
 <tr>
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
		String initContent = "For "+item.city+","+item.address+", id:"+item.id+" : ";
%>
 <tr><td><h1> ΕΠΙΚΟΙΝΩΝΙΑ</h1></td></tr>
 <tr>
 <td><textarea class="textinput" id="content" rows="3" cols="75"><%=initContent %></textarea></td>
 <td><div class="ratinga">
	<span style="font-size: 250%;" onclick="clicked()">☆</span><span style="font-size: 250%;">☆</span><span style="font-size: 250%;">☆</span><span style="font-size: 250%;">☆</span><span style="font-size: 250%;">☆</span>
	</div></td>
 <tr> <td><input type="submit" name="send_message" class="buttonNW" value="Send message to host" onclick="send_message('<%=user%>','<%=item.id%>','<%=initContent%>')">
 <input type="submit" value="Make Reservation" class="buttonNW" id="mkbtn" onclick="make_reservation('<%=user%>','<%=item.id%>')">
 </td>
 </tr>
 <%	}
  }
}%>
 </tr>

 

</table>





<br>
</div>
</body>
</html>
