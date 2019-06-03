(function($) {
	$.widget("tagria.form", {
		options: {
			validation : '',
			invalid : {
				email : 'Invalid email',
				max : 'Must not be greater than',
				min : 'Must not be less than'
			}
		},
		_create: function() {
			var self = this;
			var form = self.element;  
			
			$("input[type=text]",form).on('keydown.form',function(e) {
				if(e.keyCode==13) {
					self._validateAndSubmit();
        		}
			});
			
			$(form).on('submit',function(e){
				self._validateAndSubmit();
				e.preventDefault();
			});
			
			var submit = $('a.btn[data-type=submit]',form);
			var target = submit.attr('data-target');
			if(target){
				submit = $('a.sure',target);
			}
			submit.on('click.form',function(){
		    	self._scrollToTop();
				self._validateAndSubmit();
		    }); 
		},
		_scrollToTop : function () {
			window.parent.parent.scrollTo(0,0);
			window.parent.scrollTo(0,0);
			window.scrollTo(0,0);
		},
		_block : function () {
			var self = this;
			var form = this.element;
			$('a.btn[data-type=submit]',form).addClass("disabled");
		},
		_unblock : function () {
			var self = this;
			var form = this.element;
			$('a.btn[data-type=submit]',form).removeClass("disabled");
		},
		_clean : function() {
			var self = this;
			var form = self.element;
			$('.form-error',form).hide();
			$('.form-has-error',form).removeClass('form-has-error');
		},
		_validateAndSubmit : function() {
			var self = this;
			var form = this.element;
			self._clean();
			self._block();
			
			if(!self._hasRequiredFieldBlank() && !self._hasValidationError()){
				if(self.options.validation == '') {
					self._submit();
				} else {
					var data = new Array();
					data.push({name:'_format',value : 'json'});
					$(':input[name]:not(:checkbox:not(:checked),:radio),:input[name]:radio:checked',form).each(function(){
						data.push({name: $(this).attr('name'), value: $(this).val()});
					});
									
					$.ajax({ 
				     	url:       self.options.validation, 
				        type:      'post',
				        data : data,
				        dataType : 'json',
				        success:  function(data){
				        	if(data == null) {
				        		throw new Error('data response cannot be null. Please return empty FormErrors. ex:. FormErrors.newBuilder().build()')
				        	} else if(data.errors && data.errors.length > 0) {
								var ul = $(document.createElement('ul')).addClass('list-group shadow-sm');
								$.each(data.errors,function( index, value ) {
									ul.append($(document.createElement('li')).addClass('list-group-item list-group-item-danger').text(value));
								});					
								$('.form-error',form).html(ul).show();
								self._unblock();
							} else {
								self._submit();
							}					           	
				        },
				        error : function (jqXHR, textStatus, errorThrown) {
				        	self._unblock();
				        }
				    });
				}
			} else {
				self._unblock();
			}
		},
        _submit : function() {
        	var self = this;
        	var form = this.element;
        	$('.disabled',form).attr('disabled',false);
        	
        	if(form.attr('target') != '_self' || !$('form').attr('action').indexOf('javascript:')){
        		self._unblock();
        	}
        	self.element[0].submit();
        },
		_hasRequiredFieldBlank: function() {
			 var self = this;
			 var form = self.element;
			 var empty = false;
         	 $('.form-required:visible',form).each(function(){
         		if($(this).val() == ''){
         			$(this).addClass('form-has-error');
         			empty = true;
         		}
         	 });
        	 return empty;
		},
		_popover: function(element,content) {
			element.popover({
			       content : content,
			       html : true,
			       placement : 'bottom',
			       container : 'body',
			       trigger : 'focus'
			}).popover('show');
			setTimeout(function() {
				element.popover('dispose');
			},5000);
		},
		_hasValidationError : function() {
			var self = this;
			var form = self.element;
			var error = false;
			$('input[type=email]',form).each(function(){
				if(!/[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/.test( $(this).val() )){
					var input = $(this).addClass('form-has-error');
					self._popover(input,self.options.invalid.email);
					error = true;
				}
			});
			
			$('input[type=number][max]',form).each(function(){
				if(parseInt($(this).val()) > parseInt($(this).attr("max"))){
					var input = $(this).addClass('form-has-error');
					self._popover(input,self.options.invalid.max + ' ' + input.attr("max"));
					error = true;
				}
			});
			
			$('input[type=number][min]',form).each(function(){
				if(parseInt($(this).val()) < parseInt($(this).attr("min"))){
					var input = $(this).addClass('form-has-error');
					self._popover(input,self.options.invalid.min + ' ' + input.attr("min"));
					error = true;
				}
			});
			
			return error;
		}
	});
})(jQuery);