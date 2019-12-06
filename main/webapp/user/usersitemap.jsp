<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Site Map</title>
</head>
<body>
<%@ include file="usermenu.jsp" %>
<h2>Site Map</h2>
	<p>User</p>
	<ul>
		<li><a href="viewProfile">View Profile</a></li>
      	<li><a href="updateProfile.action?submitType=fetchProfile&email=${sessionScope.email}">Update Profile</a></li>
    </ul> 	
<%@ include file="../footer.jsp" %>
</body>
</html>