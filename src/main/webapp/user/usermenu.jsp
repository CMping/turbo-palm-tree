<%@taglib prefix="s" uri="/struts-tags"%>
<link href="BootStrap\styles\bootstrap.min.css" rel="stylesheet"/>
<script src="BootStrap\scripts\jquery-3.4.1.min.js"></script>
<script src="BootStrap\scripts\bootstrap.min.js.map"></script>

<body>
    <nav class="navbar navbar-expand-sm navbar-light bg-light">
      <a class="navbar-brand" href="viewProfile?email=${sessionScope.email}"><img src="img\logo.png"></a>
      <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#navbarcollapse" aria-controls="collapsibleNavId"
        aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarcollapse">
        <ul class="nav navbar-nav mr-auto mt-2 mt-lg-0">
          <li class="nav-item active">
            <form action="searchProfile.action">
              <input type="text" placeholder="Search User's.." name="search">
              <button type="submit">Search</button>
            </form>    
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="viewProfile?email=${sessionScope.email}">My Profile</a>
          </li>
          <li class="nav-item">
              <a class="nav-link" href="updateProfile.action?submitType=fetchProfile&email=${sessionScope.email}">Update Profile</a>
          </li>
          <li class="nav-item">
              <a class="nav-link" href="viewJobs">Jobs</a>
          </li>
          <li class="nav-item">
              <a class="nav-link" href="logout">Log Out</a>
          </li>
        </ul>
      </div>
    </nav>
  </body>