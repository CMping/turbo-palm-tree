<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head></head>
<body>
<%@ include file="header.jsp" %>
<div class="container">
	<div class="row">
		<div class="form-group">
			<h2>Register Here</h2>
			<s:form action="register" method="post">
				<s:textfield label="First Name" name="firstName" />
				<s:textfield label="Last Name" name="lastName" />
				<s:textfield label="Email" name="email" />
				<s:password label="Password" name="password"/>
				<s:password label="Confirm Password" name="cPassword"/>
				<s:submit cssClass="button-register" value="Register" />
			</s:form>
			<p style="color: red;"><b><s:property value="errorMessage"/></b></p>
		</div>
	</div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>