(function($) {
	$.widget("tagria.textarea", {
		options: {
			
		},
		_create: function() {
			var self = this;
			var container = self.element;
			$('textarea',container).on('change keyup',function(){
				if($(this).val() !== ''){
					$(this).parent().removeClass('is-empty').addClass('is-not-empty');
				} else {
					$(this).parent().removeClass('is-not-empty').addClass('is-empty');
				}
			}).on('focus',function(e){
				$(this).parent().addClass('is-focus');		
			}).on('blur',function(e){
				$(this).parent().removeClass('is-focus');
			});
		}
	});
})(jQuery);