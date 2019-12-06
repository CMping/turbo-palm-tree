<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Delete User</title>
</head>
<body>
<%@ include file="adminmenu.jsp" %>
	<h2>Delete <s:property value="firstName" /> <s:property value="lastName" /></h2>
			<p>ID: <s:property value="id" /></p>
			<p>Email: <s:property value="email" /></p>
			<p>First Name: <s:property value="firstName" /></p>
			<p>Last Name: <s:property value="lastName" /></p>
			<p>Company Name: <s:property value="companyName" /></p>
			<p>Country: <s:property value="country" /></p>
			<p>City: <s:property value="city" /></p>
			<p>Phone Number: <s:property value="phone" /></p>
			<p><s:textarea readOnly="true" label="Work Experience" name="workExperience" cols="40" rows="10"/></p>
			<p><s:textarea readOnly="true" label="Education" name="education" cols="40" rows="10"/></p>
			<p><s:textarea readOnly="true" label="Skills" name="skills" cols="40" rows="10"/></p>
			<p><s:textarea readOnly="true" label="Hobbies" name="hobbies" cols="40" rows="10"/></p>
	<form action=adminDeleteProfile.action method="post">
		<pre>
			<input type="hidden" name="id" value='<s:property value="id"/>'>
			<button name="submitType" value="DELETE" type="submit">Confirm Delete</button>
		</pre>
	</form>
	<s:if test="ctr>0">
		<span style="color: red;"><s:property value="msg" /></span>
	</s:if>
	<s:else>
		<span style="color: red;"><s:property value="msg" /></span>
	</s:else>
<%@ include file="../footer.jsp" %>
</body>
</html>