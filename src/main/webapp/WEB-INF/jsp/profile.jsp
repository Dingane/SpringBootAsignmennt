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
					<li class="active"><a href="/profile">Profile</a></li>
					<li><a href="/">Home</a></li>
					<li><a href="/dashboard">DashBoard</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">

       <h2>User Detail</h2>
    	<br />

    	<div class="row">
    		<label class="col-sm-2">User Name</label>
    		<div class="col-sm-10">${profile.user.username}</div>
    	</div>

    	<div class="row">
    		<label class="col-sm-2">Email</label>
    		<div class="col-sm-10">${profile.user.email}</div>
    	</div>

    	<div class="row">
    		<label class="col-sm-2">First Name</label>
    		<div class="col-sm-10">${profile.user.first_name}</div>
    	</div>

    	<div class="row">
    		<label class="col-sm-2">Last Name</label>
    		<div class="col-sm-10">${profile.user.last_name}</div>
    	</div>

    	<div class="row">
    		<label class="col-sm-2">Active</label>
    		<div class="col-sm-10">${profile.user.is_active}</div>
    	</div>

    	<div class="row">
    		<label class="col-sm-2">Is Staff</label>
    		<div class="col-sm-10">${profile.user.is_staff}</div>
    	</div>

    	 <div class="row">
             		<label class="col-sm-2">Phone Number</label>
             		<div class="col-sm-10">${profile.phone_number}</div>
             	</div>

        	 <div class="row">
             		<label class="col-sm-2">Physical Address</label>
             		<div class="col-sm-10">${profile.physical_address}</div>
             	</div>

        	 <div class="row">
             		<label class="col-sm-2">Tax number</label>
             		<div class="col-sm-10">${profile.tax_number}</div>
             	</div>

        	 <div class="row">
             		<label class="col-sm-2">Personal Email</label>
             		<div class="col-sm-10">${profile.personal_email}</div>
             	</div>

        	 <div class="row">
             		<label class="col-sm-2">Github User</label>
             		<div class="col-sm-10">${profile.github_user}</div>
             	</div>

        	 <div class="row">
             		<label class="col-sm-2">Birth Date</label>
             		<div class="col-sm-10">${profile.birth_date}</div>
             	</div>

             	<div class="row">
             		<label class="col-sm-2">Start Date</label>
             		<div class="col-sm-10">${profile.start_date}</div>
             	</div>

             	<div class="row">
             		<label class="col-sm-2">End Date</label>
             		<div class="col-sm-10">${profile.end_date}</div>
             	</div>

             	<div class="row">
             		<label class="col-sm-2">Id Document</label>
             		<div class="col-sm-10">${profile.id_document}</div>
             	</div>

             	 <div class="row">
             		<label class="col-sm-2">Visa Document</label>
             		<div class="col-sm-10">${profile.visa_document}</div>
             	</div>

             	 <div class="row">
             		<label class="col-sm-2">Is Employed</label>
             		<div class="col-sm-10">${profile.is_employed}</div>
             	</div>

             	 <div class="row">
             		<label class="col-sm-2">Is Foreigner</label>
             		<div class="col-sm-10">${profile.is_foreigner}</div>
             	</div>

             	 <div class="row">
             		<label class="col-sm-2">Gender</label>
             		<div class="col-sm-10">${profile.gender}</div>
             	</div>

               <div class="row">
             		<label class="col-sm-2">Race</label>
             		<div class="col-sm-10">${profile.race}</div>
             	</div>

             	<div class="row">
             		<label class="col-sm-2">Years Worked</label>
             		<div class="col-sm-10">${profile.years_worked}</div>
             	</div>

             	<div class="row">
             		<label class="col-sm-2">Age</label>
             		<div class="col-sm-10">${profile.age}</div>
             	</div>

             	<div class="row">
             		<label class="col-sm-2">Next Review Date</label>
             		<div class="col-sm-10">${profile.next_review}</div>
             	</div>

             	<div class="row">
             		<label class="col-sm-2">Number of Days to Birth Date</label>
             		<div class="col-sm-10">${profile.days_to_birthday}</div>
             	</div>

             	<div class="row">
             		<label class="col-sm-2">Leave Days</label>
             		<div class="col-sm-10">${profile.leave_remaining}</div>
             	</div>

       <h2>Position</h2>
    	<br />

    	<div class="row">
    		<label class="col-sm-2">Name</label>
    		<div class="col-sm-10">${profile.position.name}</div>
    	</div>

    		<div class="row">
    		<label class="col-sm-2">Level</label>
    		<div class="col-sm-10">${profile.position.level}</div>
    	</div>

    	<h2>Reviews</h2>

        		<table class="table table-striped">
        			<thead>
        				<tr>
        					<th>Date</th>
        					<th>Salary</th>
        					<th>Type</th>
        				</tr>
        			</thead>

        			<c:forEach var="employee_review" items="${profile.employee_review}">
        			    <tr>
        				<td>${employee_review.date}</td>
        				<td>${employee_review.salary}</td>
        				<td>${employee_review.type}</td>
        				 </tr>
        			</c:forEach>
        		</table>

	</div>
	<!-- /.container -->

    <jsp:include page="footer.jsp" />
	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>
