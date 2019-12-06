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
<th>Job ID</th>
<th>Job Title</th>
<th>Action</th>
</tr>
</thead>

<s:iterator value="jobs">
<tr>
<td><s:property value="jobID" /></td>
<td><s:property value="jobTittle" /></td>
<td><a href="updateJob.action?submitType=fetchDetails&jobID=<s:property value="jobID"/>">
<button class="button-update">Update</button></a>
<a href="deleteJob.action?submitType=fetchDetails&jobID=<s:property value="jobID"/>">
<button class="button-update">Delete</button></a></td>
</tr>
</s:iterator>

</table>

<p><b><s:property value="message"/></b></p>
<%@ include file="../footer.jsp" %>
</body>
</html>