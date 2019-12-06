<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head></head>
<body>
<%@ include file="header.jsp" %>
<div class="container">
	<div class="row">
		<div class="form-group">
			<h2>Forget Password</h2>
			<s:form action="forgetPassword" method="post">
				<s:textfield label="Email" name="email" />
				<s:submit cssClass="button-register" value="Send" />
			</s:form>
			<p style="color: red;"><b><s:property value="errorMessage"/></b></p>
		</div>
	</div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>