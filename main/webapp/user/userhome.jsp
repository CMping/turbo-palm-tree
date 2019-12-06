<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>User Home</title>
</head>
<body>
<%@ include file="usermenu.jsp" %>
<h2>User Home</h2>
<p> <i><s:property value="firstName" /></i> Profile</p>
<p> First Name      : <s:property value="firstName" /></p>
<p> Last Name       : <s:property value="lastName" /></p>
<p> Email           : <s:property value="email" /></p>
<p> Company Name    : <s:property value="companyName" /></p>
<p> Country         : <s:property value="country" /></p>
<p> City            : <s:property value="city" /></p>
<p> Phone           : <s:property value="phone" /></p>
<p><s:textarea label="Work Experience" readOnly="true" name="workExperience" cols="30" rows="10"/></p>
<p><s:textarea label="Education" readOnly="true" name="education" cols="30" rows="10"/></p>
<p><s:textarea label="Skills" readOnly="true" name="skills" cols="30" rows="10"/></p>
<p><s:textarea label="Hobbies" readOnly="true" name="hobbies" cols="30" rows="10"/></p>
	
<a href="updateProfile.action?submitType=fetchProfile&email=${sessionScope.email}">
<button class="button-update">Update</button></a>

<%@ include file="../footer.jsp" %>
</body>
</html>