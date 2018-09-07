$(function() {
	// to show active menu
	switch (menu) {
	
	case 'Home' :
		$('#home').addClass('active');
		break;
		
	case 'Cakes and Pasteries' :
		$('#cakes').addClass('active');
		break;
		
	case 'Appetizers' :
		$('#appetizers').addClass('active');
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
});