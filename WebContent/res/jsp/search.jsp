<table class="search_table">
	<tr>
  	 <td><input type="text" class="search" id="place" placeholder="Place..."></td>
 	 <td><input type="text" class="search" id="from" onclick="$('#from').datepicker();$('#from').datepicker('show');" placeholder="Stay from(date).."></td>
 	 <td><input type="text" class="search" id="to" onclick="$('#to').datepicker();$('#to').datepicker('show');" placeholder="To(date).."></td>
 	 <td><input type="text" class="search"  placeholder="Number of people..."></td>  
  	 <td><input type="submit" class="button" value="Search" onclick="show_boxes(0)"></td>
  	 </tr>
	</table>
		<br>
	<br>
	<div class="center"><img src="${pageContext.request.contextPath}/res/img/logo.png" height="200" width="600"></div>