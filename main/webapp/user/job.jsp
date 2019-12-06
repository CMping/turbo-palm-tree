<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Job</title>
</head>
<body>
<%@ include file="usermenu.jsp" %>
<h2>Jobs</h2>
<form action="searchJob.action">
      <input type="text" placeholder="Search Job's.." name="search">
      <button type="submit">Search</button>
      
      <a href="postJobPage.action">Post Job</a>
      
      <a href="manageJobPage.action?userID=${sessionScope.id}">Manage Job</a>
      
</form>	
<%@ include file="../footer.jsp" %>
</body>
</html>