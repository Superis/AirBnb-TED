<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="javaClasses.*" %>
<%Ad ad = (Ad) request.getAttribute("ad");

String func = request.getParameter("func");
%>
<div>
<input type="submit" class="buttonNW" value="Back to search" onclick="show_search()">
<form action="${pageContext.request.contextPath}/ConnectedServlet?func=<%= func%>&id=<%=ad.id %>" method="post" enctype="multipart/form-data">
<table>
 <tr>
 <td style="vertical-align:top">
 <table>
 	<tr><td style="vertical-align:top">Πρόσβαση</td>
 	<td><textarea class="textinput" name="access" rows="3" cols="50"><%=ad.name%></textarea></td>
 	</tr>
 	<tr><td style="vertical-align:top">Περιγραφή</td>
 	<td><textarea class="textinput" name="description" rows="3" cols="50"><%=ad.desc %></textarea></td>
 	</tr>
 	<tr><td style="vertical-align:top">Κανόνες Ενοικίασης</td>
 	<td><textarea class="textinput" name="rules" rows="3" cols="50"></textarea></td>
 	</tr>
 	<%
 	if(request.getParameter("dates").equals("yes")){
 	%>
 	<tr><td style="vertical-align:top">Ημερομηνίες</td>
 	<td><input type="text" class="search" name="from" id="from" onclick="$('#from').datepicker();$('#from').datepicker('show');" placeholder="Stay from(date)..">
 	<input type="text" class="search" name="to" id="to" onclick="$('#to').datepicker();$('#to').datepicker('show');" placeholder="To(date).."></td>
 	</tr>
 	<% }%>
 </table>
 </td>
 <td><textarea class="textinput" id="pos" value="none" name="position" rows="1" cols="38"></textarea>
 <input class="buttonNW" id="submit" type="button" value="Ψάξε διεύθυνση">
 <div  id = "map" style = "width:350px; height:300px;"></div></td>
 </tr>
 <tr><td>
 <table style="width:50%">
 	<tr>
 	<td style="vertical-align:top">Μέγιστος αριθμός ατόμων
 	<input type="text" class="textinput" value="<%=ad.maxp%>" name="maxpeople"></td>
 	<td style="vertical-align:top">Ελάχιστη τιμή
 	<input type="text" class="textinput" value="<%=ad.price%>" name="minprice"></td>
 	<td style="vertical-align:top">Eπιπλέον κόστος ανά άτομο
 	<input type="text" class="textinput" value="<%=ad.ppr%>" name="adcost" ></td>
 	</tr>
 </table>
 </td></tr>
 <tr><td>
 <table style="width:50%">
 	<tr>
 	<td style="vertical-align:top">Τύπος ενοικιαζόμενου χώρου
 	<input type="text" class="textinput" value="<%=ad.type%>" name="type"></td>
 	<td style="vertical-align:top">Αριθμός κρεβατιών
 	<input type="text" class="textinput" value="<%=ad.beds%>" name="beds"></td>
 	<td style="vertical-align:top">Αριθμός μπάνιων
 	<input type="text" class="textinput" value="<%=ad.wcs%>" name="wcs"></td>
 	</tr>
 </table>
 </td>
 <td style="vertical-align:top">Επιλέξτε εικόνες:<label class="fileContainer" >Choose image...<input type="file" name="file" onchange="show_path(this.value)"></label>
	<font id="path" color="green" style="display: none;">Image has been selected</font></td>
 </tr>
 <tr><td>
 <table style="width:50%">
 	<tr>
 	<td style="vertical-align:top">Αριθμός υπνοδωματίων
 	<input type="text" class="textinput" value="<%=ad.bedrooms%>" name="bedrooms"></td>
 	<td style="vertical-align:top">Αριθμός καθιστικών
 	<input type="text" class="textinput" value="<%=ad.living_rooms%>" name="living_rooms"></td>
 	<td style="vertical-align:top">Εμβαδό χώρου
 	<input type="text" class="textinput" value="<%=ad.area%>" name="area"></td>
 	</tr>
 </table>
 </td></tr>
 

</table>
<br>
<input type="submit" class="buttonNW" value="Υποβολή Αγγελίας" onclick="ad_alert()" name="submitAd">
</form>
</div>
 

