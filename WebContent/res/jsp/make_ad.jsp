<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div>
<input type="submit" class="buttonNW" value="Back to search" onclick="show_search()">
<form action="${pageContext.request.contextPath}/DbServlet" method="post">
<table>
 <tr>
 <td style="vertical-align:top">
 <table>
 	<tr><td style="vertical-align:top">Πρόσβαση</td>
 	<td><textarea class="textinput" name="access" rows="3" cols="50"></textarea></td>
 	</tr>
 	<tr><td style="vertical-align:top">Περιγραφή</td>
 	<td><textarea class="textinput" name="description" rows="3" cols="50"></textarea></td>
 	</tr>
 	<tr><td style="vertical-align:top">Κανόνες Ενοικίασης</td>
 	<td><textarea class="textinput" name="rules" rows="3" cols="50"></textarea></td>
 	</tr>
 	<tr><td style="vertical-align:top">Ημερομηνίες</td>
 	<td><input type="text" class="search" name="from" id="from" onclick="$('#from').datepicker();$('#from').datepicker('show');" placeholder="Stay from(date)..">
 	<input type="text" class="search" name="to" id="to" onclick="$('#to').datepicker();$('#to').datepicker('show');" placeholder="To(date).."></td>
 	</tr>
 </table>
 </td>
 <td><input class="buttonNW" id="submit" type="button" value="Ψάξε διεύθυνση">
 <input class="textinput" type="text" id="pos" value="none" ></input>
 <div  id = "map" style = "width:350px; height:300px;"></div></td>
 </tr>
 <tr><td>
 <table style="width:50%">
 	<tr>
 	<td style="vertical-align:top">Μέγιστος αριθμός ατόμων
 	<input type="text" class="textinput" name="maxpeople"></td>
 	<td style="vertical-align:top">Ελάχιστη τιμή
 	<input type="text" class="textinput" name="minprice"></td>
 	<td style="vertical-align:top">Eπιπλέον κόστος ανά άτομο
 	<input type="text" class="textinput" name="adcost"></td>
 	</tr>
 </table>
 </td></tr>
 <tr><td>
 <table style="width:50%">
 	<tr>
 	<td style="vertical-align:top">Τύπος ενοικιαζόμενου χώρου
 	<input type="text" class="textinput" name="type"></td>
 	<td style="vertical-align:top">Αριθμός κρεβατιών
 	<input type="text" class="textinput" name="beds"></td>
 	<td style="vertical-align:top">Αριθμός μπάνιων
 	<input type="text" class="textinput" name="wcs"></td>
 	</tr>
 </table>
 </td>
 <td style="vertical-align:top">Επιλέξτε εικόνες:<input class="fileContainer" type="file" name="img" multiple></td>
 </tr>
 <tr><td>
 <table style="width:50%">
 	<tr>
 	<td style="vertical-align:top">Αριθμός υπνοδωματίων
 	<input type="text" class="textinput" name="bedrooms"></td>
 	<td style="vertical-align:top">Αριθμός καθιστικών
 	<input type="text" class="textinput" name="living_rooms"></td>
 	<td style="vertical-align:top">Εμβαδό χώρου
 	<input type="text" class="textinput" name="area"></td>
 	</tr>
 </table>
 </td></tr>
 

</table>
<br>
<input type="submit" class="buttonNW" value="Υποβολή Αγγελίας" onclick="ad_alert()" name="submitAd">
</form>
</div>
 

