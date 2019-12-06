<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Update</title>
</head>
<body>
<%@ include file="usermenu.jsp" %>
<div class="container">
	<div class="row">
		<div class="form-group">
			<h2>Update Profile</h2>
			<form action=updateProfile.action method="post">
				<pre>
					<input type="hidden" name="email" value='<s:property value="email"/>'>
					<s:textfield label="First Name:" name="firstName" />
					<s:textfield label="Last Name:" name="lastName" />
					<s:textfield label="Company Name:" name="companyName" />
					<s:textfield label="Country:" name="country" />
					<s:textfield label="City:" name="city" />
					<s:textfield label="Phone Number:" name="phone" />
					<s:textarea label="Work Experience" name="workExperience" cols="40" rows="10"/>
					<s:textarea label="Education" name="education" cols="40" rows="10"/>
					<s:textarea label="Skills" name="skills" cols="40" rows="10"/>
					<s:textarea label="Hobbies" name="hobbies" cols="40" rows="10"/>
					<button name="submitType" value="UPDATE" type="submit">Update</button>
				</pre>
			</form>
			<s:if test="ctr>0">
				<span style="color: red;"><s:property value="msg" /></span>
			</s:if>
			<s:else>
				<span style="color: red;"><s:property value="msg" /></span>
			</s:else>
		</div>
	</div>
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>