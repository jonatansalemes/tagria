(function($) {
	$.widget("tagria.select", {
		options: {
			
		},
		_create: function() {
			var self = this;
			var selectElement = self.element;
			$(selectElement).on('change.select',function(e) {
				if($(this).val() !== ''){
					$(this).removeClass('is-empty').addClass('is-not-empty');
				} else {
					$(this).removeClass('is-not-empty').addClass('is-empty');
				}
			});
		}
	});
})(jQuery);