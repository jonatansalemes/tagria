(function($) {
	$.widget("tagria.formGroup", {
		options: {
			atLeast : 0,
			empty : false,
			afterInsert : function (idx,element) {
			
			},
			afterRemove : function() {
				
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
		_afterRemove : function() {
			var self = this;
			self.options.afterRemove();
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
				self._afterRemove();
			});
		},
		_cloneLine : function() {
			var self = this;
			var detail = self.element;
			var currentIndex = self._size();
			var template = $('.fg-template',detail).val().replace(new RegExp('__0','g'),'__' + currentIndex);
			var clone = $(template);
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
					+ '</div>');
		},
		_reorganize : function (){
			var self = this;
			var detail = self.element;	
			$('.fg-row',detail).each(function(index){
				$('*',this).each(function(){
					var name = $(this).attr('name');
					if(name){
						$(this).attr('name',name.replace(/(\[.*?\])/,'['+index+']'));
					}
					var id = $(this).attr('id');
					if(id){
						$(this).attr('id',id.replace(new RegExp('__[0-9]{1,}','g'),'__' + index));
					}
				});
			});
		}
	});
})(jQuery);