$(document).ready(function() { 
	$('.drop-back-layer').hide(); 
}).ajaxStart(function() {
	$('.ajax-loading').show();
}).ajaxStop(function() {
	$('.ajax-loading').hide();
});