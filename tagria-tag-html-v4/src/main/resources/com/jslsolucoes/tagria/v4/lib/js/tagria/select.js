(function($) {
	$.widget("tagria.select", {
		options: {
			
		},
		_create: function() {
			var self = this;
			var select = self.element;
			$(select).change(function(){
				if($(this).val() !== ''){
					$(this).removeClass('is-empty').addClass('is-not-empty');
				} else {
					$(this).removeClass('is-not-empty').addClass('is-empty');
				}
			});
		}
	});
})(jQuery);