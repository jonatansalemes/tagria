(function($) {
	$.widget("tagria.input", {
		options: {
			
		},
		_create: function() {
			var self = this;
			var input = self.element;
			input.on('focus',function(){
				$('label[for="'+input.attr('id')+'"]').addClass('active');
			});
		}
	});
})(jQuery);