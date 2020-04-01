(function($) {
	$.widget("tagria.input", {
		options: {
			
		},
		_create: function() {
			var self = this;
			var container = self.element;
			$('input',container).on('change keyup',function(e){
				if($(this).val() !== ''){
					$(this).parent().removeClass('is-empty').addClass('is-not-empty');
				} else {
					$(this).parent().removeClass('is-not-empty').addClass('is-empty');
				}
				if(e.keyCode==13) {
					const id = $(this).attr('id');
					const enterEvent = new CustomEvent('inputEnterEvent', {
						  detail: { src: id }
					});
					dispatchEvent(enterEvent);
        		}
			}).on('focus',function(e){
				$(this).parent().addClass('is-focus');		
			}).on('blur',function(e){
				$(this).parent().removeClass('is-focus');
			});
		}
	});
})(jQuery);