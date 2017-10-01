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
	String rid = "reply"+i;
	String mid = "msg"+i;
	String content = "content"+i;
	%>
	<tr>
	<td id="<%=mid%>"><textarea readonly onclick="reply('<%=rid%>')" class="textinput" rows="3" cols="50"><%=temp.from%>: <%=temp.content %></textarea>
	<input type="submit" class="button" value="Delete" onclick="delete_message('<%=temp.content%>','<%=temp.from%>','<%=rid%>','<%=mid%>')"></td>
	<td hidden id="<%=rid%>"><textarea class="textinput" id="<%=content %>" placeholder="Click again to close" rows="3" cols="50"></textarea>
	<input type="submit" class="button" onclick="send_reply('<%=temp.to%>','<%=content %>','<%=temp.from%>','<%=rid %>')" value="Reply"></td>
	<td></td>
	</tr>
	<%
	i++;
}
%>
</table>