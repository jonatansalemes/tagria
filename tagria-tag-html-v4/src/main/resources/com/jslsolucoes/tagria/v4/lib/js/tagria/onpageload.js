$(document).ajaxStart(function() {
	$('.ajax-loading').fadeIn();
}).ajaxStop(function() {
	$('.ajax-loading').fadeOut();
});