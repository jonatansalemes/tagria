(function($) {
	$.widget("tagria.textarea", {
		options: {
			
		},
		_create: function() {
			var self = this;
			var textarea = self.element;
			$(textarea).keyup(function(){
				if($(this).val() !== ''){
					$(this).removeClass('form-has-error');
				}
			});
		}
	});
})(jQuery);