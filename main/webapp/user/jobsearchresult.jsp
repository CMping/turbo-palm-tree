<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Job Search Results</title>
<%@ include file="usermenu.jsp" %>
</head>
<body>

<table border="1">

<thead>
<tr>
<th>Job Title</th>
<th>Posted By</th>
<th>On</th>
<th>Action</th>
</tr>
</thead>

<s:iterator value="jobs">
<tr>
<td><s:property value="jobTittle" /></td>
<td><s:property value="firstName" /></td>
<td><s:property value="jobTimestamp" /></td>
<td><a href="jobDetails.action?jobID=<s:property value="jobID"/>">
	<button class="button-update">View Details</button></a>
	<input type="hidden" name="jobID" value='<s:property value="jobID"/>'></td>
</tr>
</s:iterator>
</table>

<p><b><s:property value="message"/></b></p>
<%@ include file="../footer.jsp" %>
</body>
</html>