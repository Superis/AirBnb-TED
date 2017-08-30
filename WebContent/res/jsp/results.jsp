<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.text.NumberFormat"%>


<table class="search_table">
	<tr>
  	 <td><input type="text" class="search" id="place" placeholder="Search..."></td>
 	 <td><input type="text" class="search" id="from" onclick="$('#from').datepicker();$('#from').datepicker('show');" placeholder="Stay from(date).."></td>
 	 <td><input type="text" class="search" id="to" onclick="$('#to').datepicker();$('#to').datepicker('show');" placeholder="To(date).."></td>
 	 <td><input type="text" class="search"  placeholder="Number of people..."></td>  
  	 <td><input type="submit" class="button" value="Search" onclick="show_boxes(0)"></td>
  	 </tr>
	</table>
<br>
<div id="mySidenav" class="sidenav">
<br><br><br>
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a>Wifi <input type="checkbox"></a>
  <a>Κλιματισμός <input type="checkbox"></a>
  <a>Κεντρική θέρμανση <input type="checkbox"></a>
  <a>Κουζίνα <input type="checkbox"></a>
  <a>Τηλεόραση <input type="checkbox"></a>
  <a>Πάρκινγκ <input type="checkbox"></a>
  <a>Aσανσέρ <input type="checkbox"></a>
  <input type="submit" class="button">
</div>
<span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; ADD FILTERS</span>

<div id="myModal" class="modal">
  <span class="close cursor" onclick="closeModal()">&times;</span>
  <div class="modal-content" id="modalContent">
  </div>
 </div>
 
 <br>
<div class="ads">

<%@ page import="javaClasses.mysqlConnector" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.text.NumberFormat" %>
 <% 
 
 int j; 
 int total = 0;

 String myinfo = request.getParameter("count");
 String cityname=request.getParameter("str");
 
 ResultSet rs = (ResultSet)request.getAttribute("results");
 ResultSetMetaData rsmd = rs.getMetaData();
 int columnsNumber = rsmd.getColumnCount();
 String[] strs = new String[columnsNumber];
 
 
 while(rs.next()){
	 total++;
 }
 if (myinfo==null){
	 j=0;
 }
 else {
	 j= Integer.parseInt(myinfo);
 }
 
 int count=0;
 rs.beforeFirst();
 while(rs.next()){
	 count++;
	 if (count<=j)
		 continue;
	 if (count>j+10)
		 break;
	 for (int i = 1; i <= columnsNumber; i++) {
	         String columnValue = rs.getString(i);
	         strs[i-1] = columnValue;	 
	 }
	 /*StringBuilder sb = new StringBuilder(strs[7]);
	 sb.deleteCharAt(0);
	 String myres=sb.toString();
	 float num = Float.parseFloat(myres);*/
 %>
<div onclick="openModal('<%=strs[0]%>')" class="box">
 <div class="Content">
	<br>
	<img src=<%=strs[6]%> height="100" width="100">
	<%=strs[0] %>,<%=strs[1]%>,<%=strs[3] %>,<%=strs[4] %>,<%=strs[5] %>, <%=strs[7] %>,<%=j %>
	<!-- <input type="button" class="button" onclick="clicked()" value="More info"></input>-->
 </div>
</div> 

 <%
 		
	 
 }
 %>
 
 <div id="velakia" class="center">
  <div class="pagination">
    <a href="#">&laquo;</a>
    <%for(int i=0;i<((total/10)+1);i++) { //anti gia 8a einai to plh9os twn aggeliwn / 10 mallon
    %>
    
    <a onclick="openNewTen('<%=10*i%>','<%= cityname %>')" > <%=(i+1)%> </a> 
    <%} %>
    <a href="#velakia" >&raquo;</a>
  </div>
</div>
</div>




