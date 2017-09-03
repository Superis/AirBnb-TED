<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>
<%@ page import="javaClasses.*" %>
<%
List<Message> messages = (List<Message>) request.getAttribute("messages");

%>
<input type="submit" class="buttonNW" value="Back to search" onclick="show_search()">
<table style="width:10%">
<%
int i=0;
for(Message temp: messages){
	String str = "reply"+i;
	String content = "content"+i;
	%>
	<tr>
	<td><textarea readonly onclick="reply('<%=str%>')" class="textinput" ><%=temp.from%>: <%=temp.content %></textarea></td>
	<td hidden id="<%=str%>"><textarea class="textinput" id="<%=content %>" placeholder="Click again to close" rows="3" cols="50"></textarea>
	<input type="submit" class="button" onclick="send_reply('<%=temp.to%>','<%=content %>','<%=temp.from%>','<%=str %>')" value="Reply"></td>
	<td><input type="submit" class="button" value="Delete"></td>
	</tr>
	<%
	i++;
}
%>
</table>