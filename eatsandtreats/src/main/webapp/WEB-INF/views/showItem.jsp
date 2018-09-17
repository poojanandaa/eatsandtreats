<div class="container" style="margin-top:130px;">

	<!-- Breadcrumb -->
	<div class="row">

		<div class="col-xs-12">


			<ol class="breadcrumb">

				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/items">Items</a></li>
				<li class="active">${item.name}</li>

			</ol>


		</div>


	</div>


	<div class="row">

		<!-- Display the item image -->
		<div class="col-xs-12 col-sm-4">

			<div class="thumbnail">

				<img src="${images}/${item.code}.jpg" class="img img-responsive" />

			</div>

		</div>


		<!-- Display the item description -->
		<div class="col-xs-12 col-sm-8">

			<h3>${item.name}</h3>
			<hr />

			<p>${item.description}</p>
			<hr />

			<h4>
				Price: <strong> &#8377; ${item.unitPrice} /-</strong>
			</h4>
			
			<h6> 
			  Quantity Avalable : ${item.quantity}
			</h6>
			
			<a href="${contextRoot}/cart/add/${iten.id}/item" class="btn">
			<span class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</a>
			
			<a href="${contextRoot}/show/all/items" class="btn btn-primary">
			<span class=""></span>Back</a>
			



		<%-- 	<c:choose>

				<c:when test="${item.quantity < 1}">

					<h6>
						Qty. Available: <span style="color: red">Out of Stock!</span>
					</h6>

				</c:when>
				<c:otherwise>

					<h6>Qty. Available: ${item.quantity}</h6>

				</c:otherwise>

			</c:choose>


			<a href="${contextRoot}/show/all/items" class="btn btn-warning">
				Continue Shopping</a> --%>

		</div>


	</div>

</div>