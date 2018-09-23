/**
 * 
 */

$(function() {
	switch($('title').text()) {
	case  "About Shop" :
		$('#about').addClass('active');
		break;
	case  "Contact Shop" :
		$('#contact').addClass('active');
		break;
	case "All Products" :
		$('#products').addClass('active');
		break;
	default : 
		$('#home').addClass('active');
			break;
			
	}
});
var path = '/json/data/all/products';
//console.log(window.categoryId)
if (window.categoryId !=null) {
	path = '/json/data/category/'+ window.categoryId + '/products'
}


$(document).ready( function () {
    $('#productTable').DataTable({
    	lengthMenu: [[3,5,10,-1],["3 Records","5 Records","10 Records","All Records"]],
    	pageLength: 5,
    	ajax: {
    		url: path,
    		dataSrc: ''
    	},
    columns: [
    	{
    		data: 'id'
    	},
    	{
    		data: 'code'
    	},
    	{
    		data: 'name'
    	},
    	{
    		data: 'views'
    	}
    ]
    });
} );