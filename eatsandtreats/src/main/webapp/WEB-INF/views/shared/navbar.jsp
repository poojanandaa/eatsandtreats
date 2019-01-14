<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<nav class="my-navbar navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="logo" "href="${contextRoot}/home"> <img alt="Brand"
				src="${images}/entlogo1.png">
			</a>
		</div>
		<ul class="nav navbar-nav navbar-right ">
			<li>
				<div id="" search-btn" class="form-group">
					<input type="text" class="form-control" placeholder="Search"
						style="display: none;">
				</div>
			</li>
		</ul>
	</div>
	<div class="container-fluid">

		<ul class="nav navbar-nav">
			<li id="home"><a href="${contextRoot}/home">Home</a></li>
			<li id="cakes"><a href="${contextRoot}/show/category/1/items">Cakes</a></li>
			<li id="appetizers"><a
				href="${contextRoot}/show/category/3/items">Appetizers</a></li>
			<li id="listItems"><a href="${contextRoot}/show/all/items">All
					Items</a></li>
			<security:authorize access="hasAuthority('ADMIN')">
				<li id="manageItems"><a href="${contextRoot}/manage/items">Manage
						Items</a></li>
			</security:authorize>
			<li id="contact"><a href="${contextRoot}/contactUs">Contact
					Us</a></li>
			<li id="about"><a href="${contextRoot}/about">About Us</a></li>
		</ul>

		<ul class="nav navbar-nav navbar-right">

			<security:authorize access="isAnonymous()">
				<li><a href="${contextRoot}/login"><button
							class="btn btn-info btn-sm">
							<span class="glyphicon glyphicon-log-in"></span>&nbsp;Login
						</button></a></li>
				<li><a href="${contextRoot}/register"><button
							class="btn btn-info btn-sm">
							<span class="glyphicon glyphicon-user"></span>&nbsp;Register
							Here!
						</button></a></li>
			</security:authorize>
			</li>
			<security:authorize access="isAuthenticated()">
				<li class="dropdown" id="userModel"><a
					class="btn btn-default dropdown-toggle" href="javascript:void(0)"
					id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="true">Hello ${userModel.fullName} <span
						class="caret"></span>
				</a>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
						<security:authorize access="hasAuthority('USER')">
							<li id="cart"><a href="${contextRoot}/cart/show"> <span
									class="glyphicon glyphicon-shopping-cart"></span>&#160;<span
									class="badge">${userModel.cart.cartLines}</span> - &#8377;
									${userModel.cart.grandTotal}
							</a></li>
						</security:authorize>
						<li role="separator" class="divider"></li>

						<li id="logout"><a href="${contextRoot}/logout">Logout</a></li>
			</security:authorize>
		</ul>
	</div>
</nav>
<script>
	window.userRole = "${userModel.role}";
</script>
