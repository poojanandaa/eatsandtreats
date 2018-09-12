<div class="container" style="margin-top: 130px; paddig: 0px;">

	<div class="row">

		<%@include file="./shared/sideBar.jsp"%>

		<div class="col-xs-9">




			<br />
			<h4>
				<a href="#cakes">Cakes</a> | <a href="#pasteries">Pasteries</a>
			</h4>
			<hr />


			<div class="row" id="cakes">
				<div class="col-lg-9">

					<h1 class="page-header">
						<small>Cakes</small>
					</h1>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-9">
					<table id="showAllItems" class="table table-striped table-borderd ">
						<thead>
							<tr>
								<th>ID</th>
								<th>NAME</th>
							</tr>

						</thead>
					</table>
				</div>
			</div>



			<div id="pasteries" class="row">
				<div class="col-lg-9">

					<h1 class="page-header">
						<small>Pasteries</small>
					</h1>
				</div>
			</div>


			<div class="row">
				<div class="col-xs-9">
					<table id="showAllItems" class="table table-striped table-borderd ">
						<thead>
							<tr>
								<th>ID</th>
								<th>NAME</th>
							</tr>

						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>