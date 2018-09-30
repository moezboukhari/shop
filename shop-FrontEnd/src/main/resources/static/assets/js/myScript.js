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
	case "Manage Products" :
		$('#manageProducts').addClass('active');
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
    				return '<img src="/assets/images/'+data+'.jpg" class="datatableimg" />';
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
    				str+='<a href="/show/'+data+'/product" class="btn btn-outline-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';

    				if (row.quantity<1) {
        				str+=  '<a href="javascript:void(0)" class="btn btn-outline-success disabled"><strike><span class="glyphicon glyphicon-shopping-cart"></strike></span></a>';

    				}
    				else {
        				str+=  '<a href="/add/'+data+'/product" class="btn btn-outline-success active"><span class="glyphicon glyphicon-shopping-cart"></span></a>';

    				}
    				return str;
    			}
    	}
    ]
    });
    
    var $alert = $('.alert');
    if ($alert.length) {
    	setTimeout(function() {
    		$alert.fadeOut('slow');
    	},300)
    }
    

    
    /**********************************************************************
     ********************** Admin dataTable *******************************
     * 
     * *********************************************************************/
    var path2 = '/json/data/admin/all/products';
   
        $('#adminProductTable').DataTable({
        	lengthMenu: [[10,30,50,-1],["10 Records","30 Records","50 Records","All Records"]],
        	pageLength: 30,
        	ajax: {
        		url: path2,
        		dataSrc: ''
        	},
        columns: [
        	{
        		data: 'id'
        	},
        	{
        		data: 'code',
        			mRender: function(data, type, row) {
        				return '<img src="/assets/images/'+data+'.jpg" class="adminiDataTableImg" />';
        			}
        	},
        	{
        		data: 'name'
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
        		data: 'unitPrice' ,
        		bsortable: false,
        		mRender: function(data, type, row) {
        				return '&#8364;' + data
        			}
        	},
        	
        	{
        		data: 'active',
        			mRender: function(data, type, row) {
        				var str = '';
        				if (data) {
        					str = `<label class="switch"> <input type="checkbox"
        				checked="checked" 
									 value="`+row.id+`"> <span
									class="slider round"></span>
							</label>`;
        				}
        				else{
        					str = `<label class="switch"> <input type="checkbox"
                				
								 value="`+row.id+`"> <span
								class="slider round"></span>
						</label>`;
        				}
        				return str;
        					}
        	 },
        	
        	 {
        		data: 'id',
        			mRender: function(data, type, row) {
        				var str = '';
        				
        					str = `<a href="/manage/`+data+`/product"
								class="btn btn-outline-warning"><span
								class="glyphicon glyphicon-pencil"></span></a> `;
        					return str;
        				}
        	}
        					
        	
        ],
        initComplete: function() {
        	this.api().    $('.switch input[type="checkbox"]').on('change',function(){
            	
            	var checkbox = $(this);
            	var checked = checkbox.prop('checked');
            	var dMsg = (checked) ? 'You want activate the product ?' :
            							'You want deactivate the product ?';
            	var value = checkbox.prop('value');
            	bootbox.confirm({
            		size: 'medium',
            		title: 'Product Activation & Deactivation',
            		message: dMsg,
            		callback: function(confirmed) {
            			if(confirmed){
            				console.log(value);
            				
            				var activationUrl = '/manage/product/'+value+'/activation';
            				$.post(activationUrl,function(data) {
            					bootbox.alert({
                					size: 'medium',
                					title: 'Information',
                					message: data
                				});
            					
            				});
            				
            			}
            			else {
            				checkbox.prop('checked',!checked);
            			}
            		}
            	})
            });
        }
        });
});
    
  /**************************************/