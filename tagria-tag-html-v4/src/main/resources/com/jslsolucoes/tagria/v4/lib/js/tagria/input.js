(function($) {
	$.widget("tagria.input", {
		options: {
			
		},
		_create: function() {
			var self = this;
			var input = self.element;
			$(input).on('keyup.input',function(e) {
				if($(this).val() !== ''){
					$(this).removeClass('is-empty').addClass('is-not-empty');
				} else {
					$(this).removeClass('is-not-empty').addClass('is-empty');
				}
			});
		}
	});
})(jQuery);