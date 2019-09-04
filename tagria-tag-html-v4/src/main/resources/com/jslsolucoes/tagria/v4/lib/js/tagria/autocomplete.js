(function($) {
	$.widget("tagria.autocomplete", {
		options: {
			url : '',
			minLength: 3,
			delay: 1000,
			text: '',
			onSelect: function(value,text) {}
		},
		_create: function() {
			var self = this;
			var results = self._results();
			self._setCurrentTerm(self.options.text);
			self._input().keyup(function(event){
				if(event.keyCode === 38){
					self._navigate('up');
				} else if(event.keyCode === 40){
					self._navigate('down');
				} else if(event.keyCode === 13){
					var activeItem = self._activeItem();
					if(activeItem){
						self._chooseActive(activeItem);
					}
				}
			}).focus(function(){
				if(self._items().length > 0){
					results.show();
				}
			}).blur(function(event){
				if(event.relatedTarget != results.get(0)) {
					results.hide();
				}		
			});
			
			setInterval(function(){
				self._queryForTerm();
			},self.options.delay);
		},
		_items: function() {
			var self = this;
			var container = self.element;
			return $('.autocomplete-item',container);
		},
		_activeItem: function() {
			var self = this;
			var container = self.element;
			return $('.autocomplete-item-active',container);
		},
		_navigate: function(direction) {
			var self = this;
			var activeItem = self._activeItem();
			if(activeItem.length === 0 && direction === 'down') {
				$('.autocomplete-item:eq(0)').addClass('autocomplete-item-active');
			} else if(activeItem.length === 1 && direction === 'down') {
				var next = activeItem.next('.autocomplete-item');
				if(next.length > 0) {
					self._clearActiveItems();
					next.addClass('autocomplete-item-active');
				}
			} else if(activeItem.length === 1 && direction === 'up') {
				var prev = activeItem.prev('.autocomplete-item');
				if(prev.length > 0) {
					self._clearActiveItems();
					prev.addClass('autocomplete-item-active');
				}
			}
		},
		_chooseActive: function(item) {
			var self = this;
			var text = item.attr('data-text');
			var value= item.attr('data-value');
			self._setCurrentTerm(text);
			self._input().val(text);
			self._inputHidden().val(value);
			self._results().hide();
			self.options.onSelect(value,text);
		},
		_setCurrentTerm: function(term) {
			this.term = term;
		},
		_getCurrentTerm: function() {
			return this.term;
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
		_loading: function() {
			var self = this;
			var container = self.element;
			return $('.autocomplete-loading',container);
		},
		_results: function() {
			var self = this;
			var container = self.element;
			return $('.autocomplete-results',container);
		},
		_clearActiveItems: function() {
			var self = this;
			self._activeItem().removeClass('autocomplete-item-active');
		},
		_prepareItems: function() {
			var self = this;
			var container = self.element;
			$('.autocomplete-item',container).each(function(){
				$(this).click(function(){
					self._chooseActive($(this));
				}).hover(function(){
					self._clearActiveItems();
					$(this).addClass('autocomplete-item-active');
				},function() {
					
				});
			});
		},
		_queryForTerm: function() {
			var self = this;
			var newTerm = self._input().val();
			var loading = self._loading();
			if(newTerm !== '' && newTerm.length >= self.options.minLength && newTerm !== self._getCurrentTerm()){
				self._setCurrentTerm(newTerm);
				$.ajax({
					type : 'get',
					dataType : 'html',
					beforeSend: function(jqXHR, settings) {
						loading.show();
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
						self._results().show().html(data);
						self._prepareItems();
					}
				}).done(function() { 
					loading.hide();
				});
			}
		}
	});
})(jQuery);