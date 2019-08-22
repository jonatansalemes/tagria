(function($) {
	$.widget("tagria.autocomplete", {
		options: {
			url : '',
			minLength: 3,
			delay: 3000,
			text: ''
		},
		_create: function() {
			var self = this;
			self.oldTerm = self.options.text;
			setInterval(function(){
				self._queryForTerm();
			},self.options.delay);
		},
		_input: function() {
			var self = this;
			var container = self.element;
			return $('.autocomplete-input',container);
		},
		_inputHidden: function() {
			var self = this;
			var container = self.element;
			return $('.autocomplete-input-hidden',container);
		},
		_results: function() {
			var self = this;
			var container = self.element;
			return $('.autocomplete-results',container);
		},
		_prepareItems: function() {
			var self = this;
			var container = self.element;
			$('.autocomplete-item',container).each(function(){
				$(this).on('click',function(){
					self._input().val($(this).attr('data-text'));
					self._inputHidden().val($(this).attr('data-value'));
				});
			});
		},
		_queryForTerm: function() {
			var self = this;
			var newTerm = self._input().val();
			if(newTerm !== '' && newTerm.length >= self.options.minLength && newTerm !== self.oldTerm){
				self.oldTerm = newTerm;
				$.ajax({
					type : 'get',
					processData: false,
					dataType : 'html',
					beforeSend: function(jqXHR, settings) {
						var data = {};
						for (var property in settings.data) {
							data[property] = settings.data[property].value;
							if(settings.data[property].required && settings.data[property].value == ''){
								return false;
							}
						}
						settings.data = $.param(data);
						return true;
					},
					url : self.options.url,
					async: true,
					data : {
						term: newTerm
					},
					error : function (jqXHR, textStatus, errorThrown) {

					},
					success : function(data, textStatus, jqXHR) {
						self._results().removeClass('d-none').html(data);
						self._prepareItems();
					}
				});
			}
		}
	});
})(jQuery);																		







