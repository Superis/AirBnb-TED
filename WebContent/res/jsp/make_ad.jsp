<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div>
<input type="submit" class="buttonNW" value="Back to search" onclick="show_search()">
<table>
 <tr>
 <td style="vertical-align:top">
 <table>
 	<tr><td style="vertical-align:top">Πρόσβαση</td>
 	<td><textarea class="textinput" rows="3" cols="50"></textarea></td>
 	</tr>
 	<tr><td style="vertical-align:top">Περιγραφή</td>
 	<td><textarea class="textinput" rows="3" cols="50"></textarea></td>
 	</tr>
 	<tr><td style="vertical-align:top">Κανόνες Ενοικίασης</td>
 	<td><textarea class="textinput" rows="3" cols="50"></textarea></td>
 	</tr>
 	<tr><td style="vertical-align:top">Ημερομηνίες</td>
 	<td><input type="text" class="search" id="from" onclick="$('#from').datepicker();$('#from').datepicker('show');" placeholder="Stay from(date)..">
 	<input type="text" class="search" id="to" onclick="$('#to').datepicker();$('#to').datepicker('show');" placeholder="To(date).."></td>
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
 	<input type="text" class="textinput"></td>
 	<td style="vertical-align:top">Ελάχιστη τιμή
 	<input type="text" class="textinput"></td>
 	<td style="vertical-align:top">Eπιπλέον κόστος ανά άτομο
 	<input type="text" class="textinput"></td>
 	</tr>
 </table>
 </td></tr>
 <tr><td>
 <table style="width:50%">
 	<tr>
 	<td style="vertical-align:top">Τύπος ενοικιαζόμενου χώρου
 	<input type="text" class="textinput"></td>
 	<td style="vertical-align:top">Αριθμός κρεβατιών
 	<input type="text" class="textinput"></td>
 	<td style="vertical-align:top">Αριθμός μπάνιων
 	<input type="text" class="textinput"></td>
 	</tr>
 </table>
 </td>
 <td style="vertical-align:top">Επιλέξτε εικόνες:<input class="fileContainer" type="file" name="img" multiple></td>
 </tr>
 <tr><td>
 <table style="width:50%">
 	<tr>
 	<td style="vertical-align:top">Αριθμός υπνοδωματίων
 	<input type="text" class="textinput"></td>
 	<td style="vertical-align:top">Αριθμός καθιστικών
 	<input type="text" class="textinput"></td>
 	<td style="vertical-align:top">Εμβαδό χώρου
 	<input type="text" class="textinput"></td>
 	</tr>
 </table>
 </td></tr>
 

</table>
</div>
 

