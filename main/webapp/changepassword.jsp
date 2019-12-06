<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Update</title>
</head>
<body>
<%@ include file="usermenu.jsp" %>
	<h2>Update Profile</h2>
	<form action=changePassword.action method="post">
		<pre>
			<input type="hidden" name="email" value='<s:property value="email"/>'>
			<b>Old Password:  	  </b><input type="password"  name="oldPassword">
			<b>New Password:  	  </b><input type="password"  name="newPassword">
			<b>Confirm Password: </b><input type="password"  name="confirmNewPassword">
			<button name="submitType" value="CHANGEPASSWORD" type="submit">Change Password</button>
		</pre>
	</form>
	<s:if test="ctr>0">
		<span style="color: red;"><s:property value="msg" /></span>
	</s:if>
	<s:else>
		<span style="color: red;"><s:property value="msg" /></span>
	</s:else>
</body>
</html>