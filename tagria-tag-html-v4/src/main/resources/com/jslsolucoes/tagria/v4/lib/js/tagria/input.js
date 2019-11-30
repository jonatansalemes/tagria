(function($) {
	$.widget("tagria.input", {
		options: {
			
		},
		_create: function() {
			var self = this;
			var input = self.element;
			$(input).on('change keyup',function(e){
				if($(this).val() !== ''){
					$(this).removeClass('is-empty').addClass('is-not-empty');
				} else {
					$(this).removeClass('is-not-empty').addClass('is-empty');
				}
				
				if(e.keyCode==13) {
					const id = $(this).attr('id');
					const enterEvent = new CustomEvent('inputEnterEvent', {
						  detail: { src: id }
					});
					dispatchEvent(enterEvent);
        		}
			});
		}
	});
})(jQuery);