<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<!--
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="/profile">Profile</a></li>
					<li class="active"><a href="/">Home</a></li>
					<li><a href="/dashboard">DashBoard</a></li>
				</ul>
			<div class="navbar-header" style='float: right;'>>
            				<a class="navbar-brand" href="/profile">@${mydetails.first_name} ${mydetails.last_name}</a>
            </div>
			</div>
		</div>
	</nav>

	<div class="container">

    	<br />

    	<h3>Welcome</h3>


       <h3>List of Employees in Organisation</h3>

        		<table class="table table-striped">
        			<thead>
        				<tr>
        					<th>Name</th>
        					<th>email</th>
        					<th>Active</th>
        					<th>View</th>

        				</tr>
        			</thead>

        			<c:forEach var="employee" items="${allEmployees}">
        			    <tr>
        				<td>${employee.user.first_name}</td>
        				<td>${employee.user.email}</td>
        				<td>${employee.user.is_active}</td>

        				<td>
        				 <spring:url value="/dashboard/${employee.user.first_name}" var="userUrl" />
                        <button class="btn btn-info" onclick="location.href='${userUrl}'">View in DashBoard</button>
        				</td>
        				</tr>
        			</c:forEach>
        		</table>



    	</div>

       </div>
	<!-- /.container -->

    <jsp:include page="footer.jsp" />
	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>
