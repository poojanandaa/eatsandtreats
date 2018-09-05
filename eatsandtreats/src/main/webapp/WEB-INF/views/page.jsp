<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Eats And Treats</title>

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.css" rel="stylesheet">
</head>

<body>

	<!-- NAVIGATION BAR -->

	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="home"> <img alt="Brand" src="">
			</a>
		</div>
		<ul class="nav navbar-nav navbar-right ">
			<li>
				<div id="" search-btn" class="form-group">
					<input type="text" class="form-control" placeholder="Search"
						style="display: none;">
				</div>
			</li>
			<li><a href=" "><span class="glyphicon glyphicon-search"></span>
					Search</a></li>
		</ul>
	</div>
	<div class="container-fluid">

		<ul class="nav navbar-nav">
			<li class="active"><a href="#">Home</a></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown">Categories<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="#">Cakes and Pastries</a></li>
					<li><a href="#">Cookies</a></li>
					<li><a href="#">Fast Food</a></li>
				</ul></li>
			<li><a href="#">Order Online</a></li>
			<li><a href="#">Contact Us</a></li>
			<li><a href="#">About Us</a></li>
		</ul>

		<ul class="nav navbar-nav navbar-right">

			<li><a href="register"><button type="button"
						class="btn btn-info btn-sm"
						style="padding: 0px; height: 23px; width: 70px">
						<span class="glyphicon glyphicon-user"></span> Sign Up
					</button></a></li>


			<li><a href="login">
					<button type="button" class="btn btn-info btn-sm"
						style="padding: 0px; height: 23px; width: 70px">
						<span class="glyphicon glyphicon-log-in"></span>&nbsp;Login
					</button>
			</a></li>
		</ul>
	</div>
	</nav>


	<!-- PAGE CONTENT -->
	<div class="container-fluid" style="margin-top:110px;paddig:0px;">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>

			<div class="carousel-inner">

				<div class="item active">
					<img src="${images}/download_app.jpg" alt="download_app"
						style="width: 100%;">
				</div>

				<div class="item">
					<img src="${images}/geographical_print.jpg"
						alt="geographical_print" style="width: 100%;">
				</div>

				<div class="item">
					<img src="${images}/HD-Entertainment.jpg" alt="HD-Entertainment"
						style="width: 100%;">
				</div>

				<div class="item">
					<img src="${images}/home-the-theatr.jpg" alt="home-the-theatr"
						style="width: 100%;">

				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
</div>








		<!-- JQUERY -->
		<script src="${js}/jquery.js"></script>
		<!-- BOOTSTRAP JS  -->
		<script src="${js}/bootstrap.min.js"></script>
</body>
</html>