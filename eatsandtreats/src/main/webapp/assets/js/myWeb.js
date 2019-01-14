$(function() {
	// to show active menu
	switch (menu) {

	case 'Home':
		$('#home').addClass('active');
		break;

	case 'Cakes':
		$('#cakes').addClass('active');
		$('#a_' + menu).addClass('active');
		break;

	case 'Appetizers':
		$('#appetizers').addClass('active');
		$('#a_' + menu).addClass('active');
		break;

	case 'All Items':
		$('#listItems').addClass('active');
		break;

	case 'About Us':
		$('#about').addClass('active');
		break;

	case 'Contact Us':
		$('#contact').addClass('active');
		break;

	default:
		$('#listItems').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}

	/* validating the loginform */

	// validating the product form element
	// fetch the form element
	var $loginForm = $('#loginForm');

	if ($loginForm.length) {

		$loginForm.validate({
			rules : {
				username : {
					required : true,
					email : true

				},
				password : {
					required : true
				}
			},
			messages : {
				username : {
					required : 'Please enter your email!',
					email : 'Please enter a valid email address!'
				},
				password : {
					required : 'Please enter your password!'
				}
			},
			errorElement : "em",
			errorPlacement : function(error, element) {
				// Add the 'help-block' class to the error element
				error.addClass("help-block");

				// add the error label after the input element
				error.insertAfter(element);
			}
		}

		);

	}


	var $registerForm = $('#registerForm');

	if ($registerForm.length) {

		$registerForm.validate({
			rules : {
				password : {
					required : true
				},
				confirmPassword : {
					equalTo : "#password"

				},
			},
			messages : {
				password : {
					required : 'Please enter a password!'
				},
				confirmPassword : {
					equalTo : 'Passwords do not match'
				}
			},
			errorElement : "em",
			errorPlacement : function(error, element) {
				// Add the 'help-block' class to the error element
				error.addClass("help-block");

				// add the error label after the input element
				error.insertAfter(element);
			}

		});

	}

	var $table = $('#showAllItems');
	if ($table.length) {
		// console.log('table inserted');

		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/items';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/items';
		}

		$table
				.DataTable({
					lengthMenu : [ [ 5, 10, 15, 20, -1 ],
							[ 'FIVE', 'TEN', 'FIFTEEN', 'TWENTY', 'ALL' ] ],
					pageLength : 15,

					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'code',
								mRender : function(data, type, row) {
									return '<img src="' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg" class="dataTableImg"/>'
								}
							},
							{
								data : 'name'
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377; ' + data
								}
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1) {
										return '<span style="color:red">Out of Stock !</span>';
									}
									return data;
								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/item" class="btn "><span class="glyphicon glyphicon-eye-open"></span> View</a>';

									if (row.quantity < 1) {
										str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span> </a>';

									} else {
										if (userRole == 'ADMIN') {
											str += '<a href="'
													+ window.contextRoot
													+ '/manage/'
													+ data
													+ '/item" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span> </a>';
										} else {
											str += '<a href="'
													+ window.contextRoot
													+ '/cart/add/'
													+ data
													+ '/item" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span> </a>';
										}
									}

									return str;
								}

							}

					]

				})
	}

	// ---------------------------------------------
	// ITEM TABLE FOR ADMIN
	// ---------------------------------------------

	var $adminItemsTable = $('#adminItemsTable');
	if ($adminItemsTable.length) {
		// console.log('table inserted');

		var jsonUrl = window.contextRoot + '/json/data/admin/all/items';

		$adminItemsTable
				.DataTable({
					lengthMenu : [
							[ 10, 30, 50, -1 ],
							[ 'Ten Records', 'Thirty Records', 'Fifty Records',
									'All' ] ],
					pageLength : 10,

					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'id'
							},
							{
								data : 'code',
								mRender : function(data, type, row) {
									return '<img src="'
											+ window.contextRoot
											+ '/resources/images/'
											+ data
											+ '.jpg" class="adminProductTableImg"/>';
								}
							},
							{
								data : 'name'
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1) {
										return '<span style="color:red">Out of Stock !</span>';
									}
									return data;
								}
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377; ' + data;
								}
							},

							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';

									str += '<a href="' + window.contextRoot
											+ '/manage/' + data
											+ '/item" class="btn btn-warning">';
									str += '<span class="glyphicon glyphicon-pencil"></span></a>';

									return str;
								}

							}

					]

				})
	}
	/* handle refresh cart */
	$('button[name="refreshCart"]')
			.click(
					function() {
						var cartLineId = $(this).attr('value');
						var countField = $('#count_' + cartLineId);
						var originalCount = countField.attr('value');
						// do the checking only the count has changed
						if (countField.val() !== originalCount) {
							// check if the quantity is within the specified
							// range
							if (countField.val() < 1 || countField.val() > 3) {
								// set the field back to the original field
								countField.val(originalCount);
								bootbox
										.alert({
											size : 'medium',
											title : 'Error',
											message : 'Product Count should be minimum 1 and maximum 3!'
										});
							} else {
								// use the window.location.href property to send
								// the request to
								// the server
								var updateUrl = window.contextRoot + '/cart/'
										+ cartLineId + '/update?count='
										+ countField.val();
								window.location.href = updateUrl;
							}
						}
					});

});