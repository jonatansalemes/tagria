(function($) {
	$.widget("tagria.tabs", {
		options: {
			afterShow : function (oldTab,newTab) {
				
			}
		},
		_create: function() {
			
			var self = this;
			var panel = self.element;
			
			self._active('iframe.active');
			self._active('iframe:first');
		
			$('li',panel).click(function(e){
				var iframe = $('iframe',$('a',this).attr('href'));
				if($(this).hasClass('tab-reload-on-select')||iframe.attr('src')==''){
					iframe.attr('src',iframe.attr('data-url'));	
				}
				var oldTab = $('li.active',panel)[0];
				var newTab = $(this)[0];
				self.options.afterShow(oldTab,newTab);
				$('li.active',panel).removeClass('active');
				$(this).addClass('active');
			});
		},
		_active: function(selector){
			var self = this;
			var panel = self.element;
			var iframe = $(selector,panel);
			iframe.attr('src',iframe.attr('data-url'));
		}
	});
})(jQuery);
