(function($) {
	$.widget("tagria.textarea", {
		options: {
			
		},
		_create: function() {
			var self = this;
			var textarea = self.element;
			$(textarea).keyup(function(){
				if($(this).val() !== ''){
					$(this).removeClass('is-empty').addClass('is-not-empty');
				} else {
					$(this).removeClass('is-not-empty').addClass('is-empty');
				}
			});
		}
	});
})(jQuery);