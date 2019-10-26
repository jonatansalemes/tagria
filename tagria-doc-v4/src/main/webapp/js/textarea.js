(function($) {
	$.widget("tagria.textarea", {
		options: {
			
		},
		_create: function() {
			var self = this;
			var textarea = self.element;
			$(textarea).focus(function(){
				if($(this).parent().hasClass('form-group')){
					$(this).parent().addClass('is-focused');
				}
			}).blur(function(){
				if($(this).parent().hasClass('form-group')){
					$(this).parent().removeClass('is-focused');
				}
			}).keyup(function(){
				if($(this).val() !== ''){
					$(this).removeClass('is-empty').removeClass('form-has-error').addClass('is-not-empty');
				} else {
					$(this).removeClass('is-not-empty').addClass('is-empty');
				}
			});
		}
	});
})(jQuery);