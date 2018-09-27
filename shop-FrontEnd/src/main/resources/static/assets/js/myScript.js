/**
unstyle started bootsrap template https://startbootstrap.com/template-categories/unstyled/
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
console.log(window.rootContext)
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
    		data: 'code',
    			mRender: function(data, type, row) {
    				return '<img src="'+window.rootContext+'/img1.jpg" class="datatableimg" />';
    			}
    	},
    	{
    		data: 'name'
    	},
    	
    	{
    		data: 'brand'
    	},
    	{
    		data: 'unitPrice' ,
    		mRender: function(data, type, row) {
    				return '&#8364;' + data
    			}
    	},
    	{
    		data: 'quantity',
    		mRender: function(data, type, row) {
    				if (data<1) {
    					return '<span style="color:red">out of stock</span>';
    				}
    				return data;
    			}
    	},
    	{
    		data: 'id',
    			mRender: function(data, type, row) {
    				var str = '';
    				str+='<a href="/show/'+data+'/product" class="btn btn-outline-primary"><span class="glyphicon glyphicon-eye-open">View</span></a> &#160;';

    				if (row.quantity<1) {
        				str+=  '<a href="javascript:void(0)" class="btn btn-outline-success disabled"><span class="glyphicon glyphicon-shoping-cart"><strike>add</strike></span></a>';

    				}
    				else {
        				str+=  '<a href="/add/'+data+'/product" class="btn btn-outline-success active"><span class="glyphicon glyphicon-shoping-cart">add</span></a>';

    				}
    				return str;
    			}
    	}
    ]
    });
} );