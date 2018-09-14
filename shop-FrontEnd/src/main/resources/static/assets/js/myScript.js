/**
 * 
 */
$(function() {
	switch($('#title').value) {
	case  "About Shop" :
		$('#about').addClass('active');
		break;
	case  "Contact Shop" :
		$('#contact').addClass('active');
		break;
	default : 
		$('#home').addClass('active');
			break;
			
	}
});