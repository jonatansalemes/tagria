(function($) {
	$.widget("tagria.form", {
		options: {
			validation : '',
			invalid : {
				email : 'Invalid email',
				max : 'Must not be greater than',
				min : 'Must not be less than'
			},
			errors: {
				required: {
					title: 'Form fillment error',
					text: 'You cant leave required fields empty. Please check'
				}
			},
			beforeSubmit: function() {
				return true;
			}
		},
		_create: function() {
			var self = this;
			var form = self.element;  
			
			addEventListener('inputEnterEvent', e => {	
				if($('#' + e.detail.src,form).length === 1) {
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
		_validateAndSubmit : function() {
			var self = this;
			var form = this.element;
			self._block();
			
			var hasRequiredFieldBlank = self._hasRequiredFieldBlank();
			var hasValidationError = self._hasValidationError();
			
			if(!hasRequiredFieldBlank && !hasValidationError){
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
								var ul = $(document.createElement('ul')).addClass('list-group');
								$.each(data.errors,function( index, value ) {
									ul.append($(document.createElement('li')).addClass('list-group-item list-group-item-danger').text(value));
								});
								self._alert(self.options.errors.required.title,ul[0].outerHTML)
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
				if(hasRequiredFieldBlank){
					self._alert(self.options.errors.required.title,self.options.errors.required.text)
				}
			}
		},
		_alert: function(title,message) {
			Swal.fire({
				type: 'error',
				title: title,
				html: message
			})
		},
        _submit : function() {
        	var self = this;
        	if(self.options.beforeSubmit()){
	        	var form = this.element;
	        	$('.disabled',form).attr('disabled',false);
	        	
	        	if(form.attr('target') != '_self' || !$('form').attr('action').indexOf('javascript:')){
	        		self._unblock();
	        	}
	        	self.element[0].submit();
        	}
        },
		_hasRequiredFieldBlank: function() {
			 var self = this;
			 var form = self.element;
			 var empty = false;
			 var parentSelectors = '.form-control-container,.form-group';
         	 $('input[required],select[required],textarea[required]',form).filter(":visible")
         	 .each(function(){
         		if($(this).val() == ''){
         			empty = true;
         			$(this).parents(parentSelectors).addClass('is-empty');
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
			var parentSelectors = '.form-control-container,.form-group';
			$('input[type=email]',form).each(function(){
				if(!/[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/.test( $(this).val() )){
					var input = $(this).parents(parentSelectors).addClass('is-empty');
					self._popover(input,self.options.invalid.email);
					error = true;
				}
			});
			
			$('input[type=number][max]',form).each(function(){
				if(parseInt($(this).val()) > parseInt($(this).attr("max"))){
					var input = $(this).parents(parentSelectors).addClass('is-empty');
					self._popover(input,self.options.invalid.max + ' ' + input.attr("max"));
					error = true;
				}
			});
			
			$('input[type=number][min]',form).each(function(){
				if(parseInt($(this).val()) < parseInt($(this).attr("min"))){
					var input = $(this).parents(parentSelectors).addClass('is-empty');
					self._popover(input,self.options.invalid.min + ' ' + input.attr("min"));
					error = true;
				}
			});
			
			return error;
		}
	});
})(jQuery);