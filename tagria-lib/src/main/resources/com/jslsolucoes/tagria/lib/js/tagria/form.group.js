(function($) {
	$.widget("tagria.formGroup", {
		options: {
			atLeast : 0,
			empty : false,
			afterInsert : function (idx,element) {
			
			}
		},
		_create: function() {
			var self = this;
			var detail = self.element;
			
			$('.fg-plus',detail).on('click',function(){
				self._cloneLine();
				self._bindRemove();
				self._reorganize();
				self._atLeast();
				self._afterInsert();
			});
			
			self._cloneToTemplate();
			self._bindRemove();
			self._reorganize();
			self._atLeast();
			
			if(self.options.empty){
				self._empty();
			}
		},
		_afterInsert: function() {
			var self = this;
			var detail = self.element;
			var idx = self._size() - 1;
			var element = $('.fg-row:last',detail);
			self.options.afterInsert(idx,element);
		},
		_size: function() {
			var self = this;
			var detail = self.element;
			return $('.fg-row',detail).length;
		},
		_empty : function() {
			var self = this;
			var detail = self.element;
			$('.fg-minus',detail).trigger("click");
		},
		_atLeast : function() {
			var self = this;
			if( self.options.atLeast > 0 ) {
				var detail = this.element;
				if(self._size() == self.options.atLeast) {
					$('.fg-minus',detail).hide();
				} else {
					$('.fg-minus',detail).show();
				}
			}
		},
		_bindRemove : function() {
			var self = this;
			var detail = self.element;
			$('.fg-minus',detail).on('click.detail',function(){
				$(this).parent().parent().remove();	
				self._reorganize();
				self._atLeast();
			});
		},
		_cloneLine : function() {
			var self = this;
			var detail = self.element;
			var template = $('.fg-template',detail);
			var clone = $(template.val());
			var currentIndex = self._size();
			$('*',clone).each(function(){
				var id = $(this).attr('id');
				if(id){
					var generated = id + '__' + currentIndex;
					clone.html(clone.html().replace(new RegExp('\\b' + id + '\\b', 'g'), generated));
				}
			}); 
			
			$(':input:not(:button,:checkbox,:radio,.notClean)',clone).each(function(){
				$(this).val('');
			});
			
			$(':checkbox,:radio',clone).each(function(){
				$(this).prop('checked',false);
			});
			
			$('.fg-content',detail).append(clone);	
		},
		_cloneToTemplate : function() {
			var self = this;
			var detail = self.element;
			$('.fg-template',detail).val('<div class="row fg-row border rounded text-secondary mt-3 mb-3 p-3">' + $('.fg-row:first',detail).html()
					.replace(new RegExp('id="([A-Z0-9a-z_]+)__[0-9]{1,}"','g'),'id="$1"')
					.replace(new RegExp("<script>.*?<\/script>",'gs'),"") + '</div>');
		},
		_reorganize : function (){
			var self = this;
			var detail = self.element;	
			$('.fg-row',detail).each(function(index){
				$('*',this).each(function(){
					if($(this).attr('name')){
						var name = $(this).attr('name');
						$(this).attr('name',name.replace(/(\[.*?\])/,'['+index+']'));
					}
				});
			});
		}
	});
})(jQuery);