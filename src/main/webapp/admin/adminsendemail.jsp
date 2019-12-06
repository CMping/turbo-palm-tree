<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>      <%--Importing all the dependent classes--%>
<%@page import="org.apache.struts.user.model.Receipient"%>
<%@page import="java.util.Iterator"%> 
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Send Bulk Email</title>
</head>
<body>
<%@ include file="adminmenu.jsp" %>
<h2>Send Bulk Invitation Email</h2>

<s:form action="addReceipient" method="post">
	<s:textfield label="Name" name="name" />
	<s:textfield label="Email" name="email" />
	<s:submit cssClass="button-register" value="Add" />
</s:form>
<span style="color: red;"><s:property value="msg" /></span>

<h3>Receipient List</h3>
<table border="1">
	<thead>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Action</th>
		</tr>
	</thead>
	<s:iterator value="receipients">
		<tr>
			<td><s:property value="receipientId"/></td>
			<td><s:property value="receipientName" /></td>
			<td><s:property value="receipientEmail" /></td>
			<td><a href="deleteReceipient.action?receipientId=<s:property value="receipientId"/>">
			<button class="button-update">Delete</button></a></td>
		</tr>
	</s:iterator>
</table>
<a href="sendMail"><button class="button-update">Send</button></a>

<%@ include file="../footer.jsp" %>
</body>
</html>