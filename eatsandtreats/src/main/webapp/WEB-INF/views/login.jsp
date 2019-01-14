<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
	<div class="container-fluid" style="margin-top: 110px; paddig: 0px;">

		<nav class="my-navbar navbar-default navbar-fixed-top" >
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="logo" "href="${contextRoot}/home"> <img alt="Brand"
				src="${images}/entlogo1.png">
			</a>
				</div>
			</div>
		</nav>

		<div class="col-md-offset-3 col-md-6">

			<c:if test="${not empty message}">
				<div class="row">
					<div class="col-md-offset-3 col-md-6">
						<div class="alert alert-danger alert-dismissible">
							<button type="button" class="close" data-dismiss="alert">&times;</button>

							${message}
						</div>
					</div>
				</div>
			</c:if>
			<c:if test="${not empty logout}">
				<div class="row">
					<div class="col-xs-12 col-md-offset-2 col-md-8">
						<div class="alert alert-success">${logout}</div>
					</div>
				</div>
			</c:if>

			<div class="panel panel-primary">

				<div class="panel-heading">

					<center>
						<h4>Login</h4>
					</center>

				</div>

				<div class="panel-body">
					<form id="loginForm" class="form-horizontal"
						action="${contextRoot}/login" method="POST">

						<div class="form-group">
							<label for="username" class="control-label col-md-4">Email:</label>
							<div class="col-md-8">
								<input type="text" name="username" id="username"
									class="form-control" placeholder="Email" />

							</div>
						</div>

						<div class="form-group">
							<label for="password" class="control-label col-md-4">Password:</label>
							<div class="col-md-8">
								<input type="password" name="password" id="password"
									class="form-control" placeholder="Password" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
							</div>
						</div>

						<div class="form-group">

							<div class="col-md-offset-4 col-md-4">


								<input type="submit" name="submit" value="Login"
									class="btn btn-primary" />

							</div>
						</div>

					</form>

					<div class="panel-footer">
						<div class="text-right">
							New User - <a href="${contextRoot}/register"
								class="btn btn-success"> <span
								class="glyphicon glyphicon-user"></span>&nbsp;Register Here!
								</button></a>
						</div>
					</div>


					<a href="register"></a>

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
