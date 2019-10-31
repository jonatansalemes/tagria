(function($) {
	$.widget("tagria.textarea", {
		options: {
			
		},
		_create: function() {
			var self = this;
			var textarea = self.element;
			$(textarea).on('keyup.textarea',function(e) {
				if($(this).val() !== ''){
					$(this).removeClass('is-empty').addClass('is-not-empty');
				} else {
					$(this).removeClass('is-not-empty').addClass('is-empty');
				}
			});
		}
	});
})(jQuery);