<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Profile</title>
<%@ include file="usermenu.jsp" %>
</head>
<body>

<table border="1">

<thead>
	<tr>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Action</th>
	</tr>
</thead>

<s:iterator value="users">
<tr>
	<td><s:property value="firstName" /></td>
	<td><s:property value="lastName" /></td>
	<td><a href="publicProfile.action?id=<s:property value="id"/>">
	<button class="button-update">View More</button></a>
	<input type="hidden" name="id" value='<s:property value="id"/>'></td>
</tr>
</s:iterator>

</table>

<p><b><s:property value="message"/></b></p>

<a href="viewProfile">Return Home</a>
<%@ include file="../footer.jsp" %>
</body>
</html>