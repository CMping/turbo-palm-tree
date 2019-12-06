<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head></head>
<body>
<%@ include file="usermenu.jsp" %>
<h2>Post Job</h2>
<s:form action="createJob" method="post">
	<s:textfield label="Job Tittle" name="jobTittle" />
	<s:textfield label="Job Details" placeholder="Input Job Details such as salary,point of contact etc..." name="jobDetails" />
	<input type="hidden" name="userID" value="${id}">
	<s:submit cssClass="button-register" value="Post" />
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