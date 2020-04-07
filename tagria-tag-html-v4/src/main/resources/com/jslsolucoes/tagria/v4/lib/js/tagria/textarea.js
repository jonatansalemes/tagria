(function($) {
	$.widget("tagria.textarea", {
		options: {
			
		},
		_create: function() {
			var self = this;
			var container = self.element;
			var parentSelectors = '.form-control-container,.form-group';
			$('textarea',container).on('change keyup',function(){
				if($(this).val() !== ''){
					$(this).parents(parentSelectors).removeClass('is-empty').addClass('is-not-empty');
				} else {
					$(this).parents(parentSelectors).removeClass('is-not-empty').addClass('is-empty');
				}
			}).on('focus',function(e){
				$(this).parents(parentSelectors).addClass('is-focus');		
			}).on('blur',function(e){
				$(this).parents(parentSelectors).removeClass('is-focus');
			});
		}
	});
})(jQuery);