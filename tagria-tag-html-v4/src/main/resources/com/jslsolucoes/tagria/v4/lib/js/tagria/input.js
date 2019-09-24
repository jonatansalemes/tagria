(function($) {
	$.widget("tagria.input", {
		options: {
			
		},
		_create: function() {
			var self = this;
			var input = self.element;
			$(input).focus(function(){
				if($(this).parent().hasClass('form-group')){
					$(this).parent().addClass('is-focused');
				}
			}).blur(function(){
				if($(this).parent().hasClass('form-group')){
					$(this).parent().removeClass('is-focused');
				}
			}).keyup(function(){
				if($(this).val() !== ''){
					$(this).removeClass('is-empty').addClass('is-not-empty');
				} else {
					$(this).removeClass('is-not-empty').addClass('is-empty');
				}
			});
		}
	});
})(jQuery);