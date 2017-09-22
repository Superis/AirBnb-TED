<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.text.NumberFormat"%>

 
 <br>
<div class="ads">

<%@ page import="javaClasses.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.NumberFormat" %>
 
 
 <input type="submit" class="buttonNW" value="Back to search" onclick="show_search()">
 <%  
 int j; 
 int total = 0;

 String myinfo = request.getParameter("count"); 

 List<Ad> adList = (List<Ad>) request.getAttribute("results");
 
 for(Ad temp: adList){
	 total++;
 }
 if (myinfo==null){
	 j=0;
 }
 else {
	 j= Integer.parseInt(myinfo);
 }
 
 int count=0;
 %>
 <ul>
 <%
 for(Ad temp: adList){
	 count++;
	 if (count<=j)
		 continue;
	 if (count>j+10)
		 break;
	 /*StringBuilder sb = new StringBuilder(strs[7]);
	 sb.deleteCharAt(0);
	 String myres=sb.toString();
	 float num = Float.parseFloat(myres);*/
 %>
<li style="border: groove;,vertical-align:top;">
 <div class="Content">
	<br>
	<img src=<%=temp.pic	%> height="100" width="100">
	<%=temp.id%>,<%=temp.name%>,<%=temp.city %>,<%=temp.address %>,<%=temp.country %>, <%=temp.price %>,<%=j %>
	<!-- <input type="button" class="button" onclick="clicked()" value="More info"></input>-->
 </div>
 <input type="submit" class="buttonNW" value="Επεξεργασία" onclick="processing('<%=temp.id%>','<%=temp.address %>')">
</li>

 <%
 		
	 
 }
 %>
 </ul>
 
 <div id="velakia" class="center">
  <div class="pagination">
    <a href="#">&laquo;</a>
    <%for(int i=0;i<((total/10)+1);i++) {
    %>
    
    <a onclick="openNewTenAds('<%=10*i%>')" > <%=(i+1)%> </a>
    <%} %>
    <a href="#velakia" >&raquo;</a>
  </div>
</div>
</div>




