jQuery.extend(jQuery.expr[':'], {
	truncated : function(el) {
		if (el.scrollWidth > el.clientWidth) {
			return true;
		} else {
			return false;
		}
	}
});

(function($){
	
	var originalShow = $.fn.show;
    $.fn.show = function(){
    	if($(this).hasClass('d-none')){
			$(this).removeClass('d-none');
    	}
    	return originalShow.apply(this,arguments);
    };
    
    var originalHide = $.fn.hide;
    $.fn.hide = function(){
    	if(!$(this).hasClass('d-none')){
			$(this).addClass('d-none');
    	}
    	return originalHide.apply(this,arguments);
    };
	
	var originalVal = $.fn.val;
    $.fn.val = function(){
        var result =originalVal.apply(this,arguments);
        if(arguments.length > 0) {
        	var val = arguments[0]; 
        	if(val !== ''){
				$(this).removeClass('is-empty').addClass('is-not-empty');
			} else {
				$(this).removeClass('is-not-empty').addClass('is-empty');
			}
    	}
        return result;
    };
})(jQuery);