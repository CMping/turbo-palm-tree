<%@taglib prefix="s" uri="/struts-tags"%>
<link href="BootStrap\styles\bootstrap.min.css" rel="stylesheet"/>
<script src="BootStrap\scripts\jquery-3.4.1.min.js"></script>
<script src="BootStrap\scripts\bootstrap.min.js.map"></script>

<form action="adminSearch.action">
      <input type="text" placeholder="Search.." name="search">
      <button type="submit">Search</button>
      
      <a href="createAdminPage">Create Administrator Account</a>
      
      <a href="sendBulkEmail">Send Bulk Email</a>
      
      <a href="logout">Log Out</a>
</form>
