<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Update</title>
</head>
<body>
<%@ include file="usermenu.jsp" %>
	<h2>Update Job</h2>
	<form action=updateJob.action method="post">
		<pre>
			<s:textfield label="Job ID:" name="jobID" readOnly="true" />
			<s:textfield label="Job Title:" name="jobTittle" />
			<s:textfield label="Job Details:" name="jobDetails" />
			<button name="submitType" value="UPDATE" type="submit">Update</button>
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