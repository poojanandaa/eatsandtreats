$(function() {
	// to show active menu
	switch (menu) {
	
	case 'Home' :
		$('#home').addClass('active');
		break;
		
	case 'Cakes' :
		$('#cakes').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
		
	case 'Appetizers' :
		$('#appetizers').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
		
	case 'All Items' :
		$('#listItems').addClass('active');
		break;
		
	case 'About Us' :
		$('#about').addClass('active');
		break;
		
	case 'Contact Us' :
		$('#contact').addClass('active');
		break;
		
	default:
		$('#listItems').addClass('active');
		$('#a_'+menu).addClass('active');
	    break;
		}
	
	

	
	var $table = $('#showAllItems');
	if($table.length)
		{
//		console.log('table inserted');
		
		var jsonUrl = '';
		if(window.categoryId == '')
			{
			jsonUrl = window.contextRoot + '/json/data/all/items';
			}
		else
			{
			jsonUrl = window.contextRoot + '/json/data/category/'+ window.categoryId +'/items';
			}
		
		
		$table.DataTable(
				{
					lengthMenu : [[5,10,15,20,-1],['FIVE','TEN','FIFTEEN','TWENTY','ALL']],
					pageLength :15,
					
					ajax:{
						url: jsonUrl, 
						dataSrc: ''
					},
					columns:
						[
						 {
							 data: 'code',
							 mRender: function(data, type, row)
							 {
								 return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>'
							 }
						 },
						 {
							 data: 'name'
						 },
						 {
							 data: 'unitPrice',
							 mRender : function(data, type, row)
							 {
								 return '&#8377; ' + data
							 }
						 },
						 {
							 data: 'quantity'
						 },
						 {
							 data: 'id',
							 bSortable: false,
							 mRender: function(data, type, row)
							 {
								 var str = '';
								 str += '<a href="'+window.contextRoot+'/show/'+data+'/item" class="btn"><span class="glyphicon glyphicon-eye-open"></span> View</a>';
								 str += '<a href="'+window.contextRoot+'/cart/add/'+data+'/item" class="btn text-success"><span class="glyphicon glyphicon-shopping-cart text-success"></span> Add to cart</a>';
								 return str;
							 }
								 
						 }
						 
						 ]
					
					
					
				})
		}
	
	
});