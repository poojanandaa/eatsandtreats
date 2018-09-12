$(function() {
	// to show active menu
	switch (menu) {
	
	case 'Home' :
		$('#home').addClass('active');
		break;
		
	case 'Cakes and Pasteries' :
		$('cakesAndPasteries').addClass('active');
		break;
		
	case 'Appetizers' :
		$('#appetizers').addClass('active');
		break;
		
	case 'All Items' :
		$('#allItems').addClass('active');
		break;
		
	case 'About Us' :
		$('#about').addClass('active');
		break;
		
	case 'Contact Us' :
		$('#contact').addClass('active');
		break;
		
	default:
		$('#home').addClass('active');
	    break;
		}
	
	
	var items = [
	               
	               ['1','ABC'],
	               ['2','dsd'],
	               ['3','kse'],
	               ['4','khs'],
	               ['5','lkj'],
	               ['6','jhy'],
	               ['7','mjh'],
	               ['8','uyt']	
	                        
	              ];
	
	var $table = $('#showAllItems');
	if($table.length)
		{
//		console.log('table inserted');
		
		$table.DataTable(
				{
					lengthMenu : [[5,10,15,20,-1],['FIVE','TEN','FIFTEEN','TWENTY','ALL']],
					pageLength :5,
					data : items
				})
		}
	
	
});