<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Eats And Treats - ${title}</title>


<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.css" rel="stylesheet">
<!-- datatable Bootstrap -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
<!-- self coded css -->
<link href="${css}/myWeb.css" rel="stylesheet">
</head>

<body>
	<div class="container">

		
		<nav class="my-navbar navbar-default navbar-fixed-top">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="logo" "href="${contextRoot}/home"> <img alt="Brand"
				src="${images}/entlogo1.png">
			</a>
				</div>
			</div>
		</nav>

		<div class="container" style="margin-top: 80px;">
			<div class="col-md-offset-3 col-md-6">


				<c:if test="${not empty message}">
					<div class="row">
						<div class="col-xs-12 ">
							<div class="alert alert-success alert-dismissible">
								<button type="button" class="close" data-dismiss="alert">&times;</button>

								${message}
							</div>
						</div>
					</div>
				</c:if>



				<div class="panel panel-primary">

					<div class="panel-heading">

						<h4>Register Here!</h4>

					</div>

					<div class="panel-body">
						<sf:form id="registerForm" class="form-horizontal"
							modelAttribute="user" action="${contextRoot}/register"
							method="POST">

							<div class="form-group">
								<label class="control-label col-md-4">First Name</label>
								<div class="col-md-8">
									<sf:input type="text" path="firstName" class="form-control" />
									<sf:errors path="firstName" cssClass="help-block" element="em" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4">Last Name</label>
								<div class="col-md-8">
									<sf:input type="text" path="lastName" class="form-control" />
									<sf:errors path="lastName" cssClass="help-block" element="em" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4">Email</label>
								<div class="col-md-8">
									<sf:input type="email" path="email" class="form-control" />
									<sf:errors path="email" cssClass="help-block" element="em" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4">Contact Number</label>
								<div class="col-md-8">
									<sf:input type="number" path="contactNumber"
										class="form-control" />
									<sf:errors path="contactNumber" cssClass="help-block"
										element="em" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4">Password</label>
								<div class="col-md-8">
									<sf:input type="password" path="password" id="password"
										class="form-control" />
								</div>
							</div>


							<div class="form-group">
								<label class="control-label col-md-4">Confirm Password</label>
								<div class="col-md-8">
									<input type="password" name="confirmPassword"
										id="confirmPassword" class="form-control" />
								</div>
							</div>

							<sf:hidden path="id" />
							<sf:hidden path="role" />

							<div class="form-group">

								<div class="col-md-offset-4 col-md-4">

									<div class="row">
										<input type="submit" name="submit" value="Register"
											class="btn btn-primary" />
										<c:if test="${not empty msg}">
											<a href="${contextRoot}/login" class="btn btn-success">&nbsp;Login
												Here !</a>
										</c:if>
									</div>
								</div>
							</div>
						</sf:form>
					</div>
				</div>
			</div>
		</div>
	</div>


	<%@include file="./shared/footer.jsp"%>

	<!-- JQUERY -->
	<script src="${js}/jquery.js"></script>
	<!-- JQUERY VALIDATOR -->
	<script src="${js}/jquery.validate.js"></script>
	<!-- BOOTSTRAP JS  -->
	<script src="${js}/bootstrap.min.js"></script>
	<!-- MY WEB JS  -->
	<script src="${js}/myWeb.js"></script>
</body>

</html>
