(function($) {
	$.widget("tagria.formGroup", {
		options : {
			overflowCheckPeriod : 1000
		},
		_create : function() {
			var self = this;
			var container = self.element;
			var overflowCheckPeriod = self.options.overflowCheckPeriod;
			var label = $('label.text-truncate', container);
			setInterval(function() {
				if(label.is(':truncated') && !label.hasClass('text-truncated')){
					label
							.addClass('text-truncated')
							.attr('data-toogle','tooltip')
							.attr('data-placement', 'top')
							.attr('title', label.html())
							.tooltip({
								html : true,
								delay: { 
									"show": 1000, 
									"hide": 100 
								}
							});
				} else if(!label.is(':truncated') && label.hasClass('text-truncated')) {
						label
							.removeClass('text-truncated')
							.removeAttr('data-toogle data-placement')
							.tooltip('dispose');
				}
			}, overflowCheckPeriod);
		}
	});
})(jQuery);