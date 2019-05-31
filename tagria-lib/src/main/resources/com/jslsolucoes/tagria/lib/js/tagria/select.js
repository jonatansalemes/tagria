(function($) {
	$.widget("tagria.select", {
		options: {
			
		},
		_create: function() {
			var self = this;
			self._createSearchOnClick();
			self._createFilter();
		},
		_createFilter: function() {
			var self = this;
			var input = self._selectSearchInput();
			input.keyup(function(){
				var value = $(this).val();
				self._doQuickSearch(value);
			});
		},
		_createSearchOnClick: function() {
			var self = this;
			var button = self._selectSearchButton();
			var modal = self._modal();
			var input = self._selectSearchInput();
			button.click(function(){
				self._createOptions(function(){
					modal.modal('show');
					input.val('')[0].focus();
				});
			});
		},
		_createOptions: function(callback) {
			var self = this;
			var select = self._select();
			var modal = self._modal();
			var container = self._selectSearchContainer();
			var input = self._selectSearchInput();
			var ul = $(document.createElement('ul')).addClass('list-group list-group-flush');
			$('option',select).each(function(index){
				var option = $(this);
				var li = $(document.createElement('li'))
					.attr('data-id',option.val())
					.addClass('list-group-item').html(option.text())
					.click(function(){
						select.val($(this).attr('data-id'));
						input.val('');
						modal.modal('hide');
						self._doQuickSearch('');
					});
				ul.append(li);
			});
			container.html(ul);
			callback();
		},
		_select: function() {
			var self = this;
			var container = self.element;
			return $('.select',container);
		},
		_selectSearchInput: function() {
			var self = this;
			var container = self.element;
			return $('.select-search-input',container);
		},
		_selectSearchContainer: function() {
			var self = this;
			var container = self.element;
			return $('.select-search-container',container);
		},
		_selectSearchButton: function() {
			var self = this;
			var container = self.element;
			return $('.select-search-button',container);
		},
		_modal: function () {
			var self = this;
			var container = self.element;
			return $('.modal',container);
		},
		_doQuickSearch : function (val) {
			var self = this;
			var container = self._selectSearchContainer();
			$('li',container).each(function(index){
				var text = $(this).text();
				if (self._testResults(val, text) || val == "") {
					$(this).show();
				} else {
					$(this).hide();
				}
			});
		},
		_stripAccents : function(strAccents){
			 strAccents = strAccents.replace(new RegExp("[àáâãäå]", 'g'),"a")
	            .replace(new RegExp("æ", 'g'),"ae")
	            .replace(new RegExp("ç", 'g'),"c")
	            .replace(new RegExp("[èéêë]", 'g'),"e")
	            .replace(new RegExp("[ìíîï]", 'g'),"i")
	            .replace(new RegExp("ñ", 'g'),"n")                      
	            .replace(new RegExp("[òóôõö]", 'g'),"o")
	            .replace(new RegExp("œ", 'g'),"oe")
	            .replace(new RegExp("[ùúûü]", 'g'),"u")
	            .replace(new RegExp("[ýÿ]", 'g'),"y");
           return strAccents;
		},
		_testResults : function(term, val) {
			var self = this;
			if(new RegExp(self._stripAccents(term.toLowerCase()), "i").test(self._stripAccents(val.toLowerCase()))){
				return true;
			} else {
				return false;
			}
		}
	});
})(jQuery);