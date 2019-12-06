<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head></head>
<body>
<%@ include file="adminmenu.jsp" %>
<h2>Create Admin Here</h2>
<s:form action="createAdmin" method="post">
	<s:textfield label="First Name" name="firstName" />
	<s:textfield label="Last Name" name="lastName" />
	<s:textfield label="Email" name="email" />
	<s:password label="Password" name="password"/>
	<s:password label="Confirm Password" name="cPassword"/>
	<s:submit cssClass="button-register" value="Create" />
</s:form>
	<s:if test="ctr>0">
		<span style="color: red;"><s:property value="msg" /></span>
	</s:if>
	<s:else>
		<span style="color: red;"><s:property value="msg" /></span>
	</s:else>
<%@ include file="../footer.jsp" %>
</body>
</html>