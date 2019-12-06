<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Profile</title>
<%@ include file="adminmenu.jsp" %>
</head>
<body>

<table border="1">

<thead>
<tr>
<th>ID</th>
<th>First Name</th>
<th>Last Name</th>
<th>Email</th>
<th>Action</th>
</tr>
</thead>

<s:iterator value="users">
<tr>
<td><s:property value="id" /></td>
<td><s:property value="firstName" /></td>
<td><s:property value="lastName" /></td>
<td><s:property value="email" /></td>
<td><a href="adminUpdateProfile.action?submitType=fetchProfile&email=<s:property value="email"/>">
<button class="button-update">Update</button></a>
<a href="adminDeleteProfile.action?submitType=fetchProfile&email=<s:property value="email"/>">
<button class="button-update">Delete</button></a></td>
</tr>
</s:iterator>

</table>

<p><b><s:property value="message"/></b></p>
<%@ include file="../footer.jsp" %>
</body>
</html>