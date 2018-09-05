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

<title>Eats And Treats - ${title}</title>
<script>
	window.menu = '${title}';
</script>

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.css" rel="stylesheet">
<!-- self coded css -->
<link href="${css}/myWeb.css" rel="stylesheet">
</head>

<body>

	<div class="wrapper">
		<!-- NAVIGATION BAR -->
		<%@include file="./shared/navbar.jsp"%>

		<div class="content">

			<!-- PAGE CONTENT -->
			<c:if test="${userClickHome == true}">
				<%@include file="./shared/home.jsp"%>
			</c:if>

			<!-- PAGE CONTENT -->
			<c:if test="${userClickCakes == true}">
				<%@include file="./shared/cakes.jsp"%>
			</c:if>
			
			<!-- PAGE CONTENT -->
			<c:if test="${userClickAppetizers== true}">
				<%@include file="./shared/appetizers.jsp"%>
			</c:if>
			
			<!-- PAGE CONTENT -->
			<c:if test="${userClickContactUs== true}">
				<%@include file="./shared/contactUs.jsp"%>
			</c:if>

			<!-- PAGE CONTENT -->
			<c:if test="${userClickAbout == true}">
				<%@include file="./shared/about.jsp"%>
			</c:if>
		</div>

		<!-- FOOTER -->
		<%@include file="./shared/footer.jsp"%>

	</div>


	<!-- JQUERY -->
	<script src="${js}/jquery.js"></script>
	<!-- BOOTSTRAP JS  -->
	<script src="${js}/bootstrap.min.js"></script>
	<!-- MY WEB JS  -->
	<script src="${js}/myWeb.js"></script>



</body>
</html>