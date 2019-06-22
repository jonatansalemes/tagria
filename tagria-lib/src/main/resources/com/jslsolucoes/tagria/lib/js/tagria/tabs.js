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
		
			$('li',panel).click(function(){
				var iframe = $('iframe',$('a',this).attr('href'));
				if($(this).hasClass('tab-reload-on-select')||iframe.attr('src')==''){
					iframe.attr('src',iframe.attr('data-url'));	
				}
			});
			
			$('a[data-toggle="tab"]',panel).on('shown.bs.tab', function (e) {
				self.options.afterShow(e.relatedTarget.parentElement,e.target.parentElement);
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
