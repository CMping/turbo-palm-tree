<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Delete User</title>
</head>
<body>
<%@ include file="usermenu.jsp" %>
	<h2>Delete Job</h2>
	<form action=deleteJob.action method="post">
		<pre>
		<s:textfield label="Job ID:" name="jobID" readOnly="true" />
		<s:textfield label="Job Title:" name="jobTittle" readOnly="true" />
		<s:textfield label="Job Details:" name="jobDetails" readOnly="true" />
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