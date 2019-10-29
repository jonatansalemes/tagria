(function($) {
	$.widget("tagria.input", {
		options: {
			
		},
		_create: function() {
			var self = this;
			var input = self.element;
			$(input).keyup(function(){
				if($(this).val() !== ''){
					$(this).removeClass('form-has-error');
				}
			});
		}
	});
})(jQuery);