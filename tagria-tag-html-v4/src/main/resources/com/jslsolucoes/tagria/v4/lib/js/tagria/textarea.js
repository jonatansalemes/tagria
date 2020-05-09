(function($) {
	$.widget("tagria.textarea", {
		options: {
			maxLengthCount: false
		},
		_create: function() {
			var self = this;
			var container = self.element;
			var parentSelectors = '.form-control-container,.form-group';
			var textarea = self._textarea();
			var maxLengther = $('.maxlenght-counter',container);
			var maxLengthCount = self.options.maxLengthCount;
			textarea.on('change keyup',function(){
				var textareaValue = self._value();
				var textareaValueLength = textareaValue.length;
								
				if(textareaValue !== ''){
					$(this).parents(parentSelectors).removeClass('is-empty').addClass('is-not-empty');
				} else {
					$(this).parents(parentSelectors).removeClass('is-not-empty').addClass('is-empty');
				}
				
				if(maxLengthCount) {
					maxLengther.text(textareaValueLength + '/' + self._maxLength());
				}

			}).on('focus',function(e){
				$(this).parents(parentSelectors).addClass('is-focus');		
			}).on('blur',function(e){
				$(this).parents(parentSelectors).removeClass('is-focus');
			});

		},
		_value: function() {
			var self = this;
			var maxLengthCount = self.options.maxLengthCount;
			if(maxLengthCount) {
				var textarea = self._textarea();
				var maxLength = self._maxLength();
				var textareaValue = textarea.val();
				var textareaValueLength = textareaValue.length;
				if(textareaValueLength > maxLength) {
				   textarea.val(textareaValue.substring(0, maxLength));
				}
			}
			return textarea.val();
		},
		_maxLength: function() {
			var self = this;
			return self._textarea().attr('data-maxlength');
		},
		_textarea: function() {
			var self = this;
			return $('textarea',self.element);
		}
	});
})(jQuery);