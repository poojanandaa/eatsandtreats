<div class="container" style="margin-top: 110px; paddig: 0px;">
	<br />
	<h4>
		<a href="#cakes">Cakes</a> | <a href="#pasteries">Pasteries</a>
	</h4>
	<hr />


	<div class="row" id="cakes">
		<div class="col-lg-12">

			<h1 class="page-header">
				<small>Cakes</small>
			</h1>
		</div>
	</div>

	<!-- Items Row -->
	<div class="row">
		<c:forEach var="i" begin="0" end="7">
			<div class="col-md-3 portfolio-item" style="border: 5pt;">
				<a href="#"> <img class="img-responsive"
					src="http://placehold.it/700x400" alt="">
				</a>
				<h3 class="pull-right">Rs. ${p.product_price}</h3>
				<h3>
					<a href="#">${p.product_name}</a>
				</h3>
				<h5>${p.key_feature}</h5>
				<p>${p.product_desc}</p>
			</div>
		</c:forEach>
	</div>

	<div  id="pasteries"  class="row"  >
		<div class="col-lg-12">

			<h1 class="page-header">
				<small>Pasteries</small>
			</h1>
		</div>
	</div>


	<div class="row">
		<c:forEach var="i" begin="0" end="12">
			<div class="col-md-3 portfolio-item" style="border: 5pt;">
				<a href="#"> <img class="img-responsive"
					src="http://placehold.it/700x400" alt="">
				</a>
				<h3 class="pull-right">Rs. ${p.product_price}</h3>
				<h3>
					<a href="#">${p.product_name}</a>
				</h3>
				<h5>${p.key_feature}</h5>
				<p>${p.product_desc}</p>
			</div>
		</c:forEach>
	</div>
</div>