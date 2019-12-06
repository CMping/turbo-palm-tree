<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Job Detail</title>
</head>
<body>
<%@ include file="usermenu.jsp" %>
<h2><s:property value="jobTittle"/></h2>
<div>
	<p> Posted By: <s:property value="firstName" /> <s:property value="lastName" /> </p>
	<p> On: <s:property value="jobTimestamp" /> </p>
	<p> Job Title: <s:property value="jobTittle"/></p>
	<p> Job Details: <s:property value="jobDetails"/></p>
</div>
<s:iterator value="replies">
	<div>
		<p>Replied By: <s:property value="replyerName" /> On <s:property value="jrTimestamp" /></p>
		<p><s:textarea readOnly="true" name="jrMessage" cols="40" rows="10"/></p>
	</div>
</s:iterator>
<%@ include file="jobreply.jsp" %>
<s:if test="ctr>0">
		<span style="color: red;"><s:property value="msg" /></span>
	</s:if>
	<s:else>
		<span style="color: red;"><s:property value="msg" /></span>
	</s:else>
<%@ include file="../footer.jsp" %>	
</body>
</html>