<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Public Profile</title>
</head>
<body>
<%@ include file="usermenu.jsp" %>
<h2><s:property value="firstName" /> Profile</h2>
<p> First Name : <s:property value="firstName" /></p>
<p> Last Name  : <s:property value="lastName" /></p>
<p> Email 	   : <s:property value="email"/></p>	
<%@ include file="../footer.jsp" %>	
</body>
</html>