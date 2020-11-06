(function($) {
	$.widget("tagria.form", {
		options: {
			validation : '',
			invalid : {
				email : 'Invalid email',
				max : 'Must not be greater than',
				min : 'Must not be less than',
				cpf: 'Invalid cpf',
				date: 'Invalid date',
			},
			errors: {
				required: {
					title: 'Form fillment error',
					text: 'You cant leave required fields empty. Please check'
				},
				invalid : {
					title: 'Form fillment error',
					text: 'Some fields are invalid. Please check'
				}
			},
			beforeSubmit: function() {
				return true;
			}
		},
		submit: function(errorCallback,successCallback) {
			var self = this;
			self._scrollToTop();
			self._validateAndSubmit(errorCallback,successCallback);
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
		    	self.submit();
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
		_validateAndSubmit : function(errorCallback,successCallback) {
			var self = this;
			var form = this.element;
			self._block();
			
			var hasRequiredFieldBlank = self._hasRequiredFieldBlank();
			var hasValidationError = self._hasValidationError();
			
			if(!hasRequiredFieldBlank && !hasValidationError){
				if(self.options.validation == '') {
					if(successCallback){
						successCallback();
					}
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
				        		if(errorCallback){
									errorCallback();
								}
								self._alertWith(self.options.errors.required.title,data.errors);
								self._unblock();
							} else {
								if(successCallback){
									successCallback();
								}
								self._submit();
							}					           	
				        },
				        error : function (jqXHR, textStatus, errorThrown) {
				        	if(errorCallback){
								errorCallback();
							}
				        	self._unblock();
				        }
				    });
				}
			} else {
				if(errorCallback){
					errorCallback();
				}
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
			});
		},
		_alertWith: function(title,messages) {
			var self = this;
			var ul = $(document.createElement('ul')).addClass('list-group');
			$.each(messages,function( index, message ) {
				var li = $(document.createElement('li')).addClass('list-group-item list-group-item-danger').text(message);
				ul.append(li);
			});
			self._alert(title,ul[0].outerHTML);
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
		_isValidDate: function(dateString) {
			if (typeof dateString !== "string") {
				return false;
			}
			
			var regex_date = /^\d{2}\/\d{2}\/\d{4}$/;

		    if(!regex_date.test(dateString))
		    {
		    	return false;
		    }

		    var parts   = dateString.split("/");
		    var day     = parseInt(parts[0], 10);
		    var month   = parseInt(parts[1], 10);
		    var year    = parseInt(parts[2], 10);
        
		    if(year < 1000 || year > 3000 || month == 0 || month > 12)
		    {
		        return false;
		    }

		    var monthLength = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ];

		    if(year % 400 == 0 || (year % 100 != 0 && year % 4 == 0))
		    {
		        monthLength[1] = 29;
		    }

		    return day > 0 && day <= monthLength[month - 1];
		},
		_isValidCpf: function(cpf) {
			if (typeof cpf !== "string") {
				return false;
			}
			
			var newCpf = cpf.replace(/[\s.-]*/igm, '')
			if (!newCpf || newCpf.length != 11 || newCpf === "00000000000" || newCpf === "11111111111" || newCpf === "22222222222" ||
		        newCpf === "33333333333" || newCpf === "44444444444" || newCpf === "55555555555" || newCpf === "66666666666" || newCpf === "77777777777" ||
		        newCpf === "88888888888" || newCpf === "99999999999") {
		        return false
		    }
			
			var soma = 0;
		    var resto;
		    for (var i = 1; i <= 9; i++){
		        soma = soma + parseInt(newCpf.substring(i-1, i)) * (11 - i);
		    }
		    resto = (soma * 10) % 11;
		    if ((resto == 10) || (resto == 11))  resto = 0;
		    if (resto != parseInt(newCpf.substring(9, 10))){
		    	return false;
		    }
		    soma = 0;
		    for (var i = 1; i <= 10; i++) {
		    	soma = soma + parseInt(newCpf.substring(i-1, i)) * (12 - i);
		    }
		    resto = (soma * 10) % 11;
		    if ((resto == 10) || (resto == 11)){
		    	resto = 0;
		    }
		    if (resto != parseInt(newCpf.substring(10, 11))) return false;
		    return true;
		},
		_invalid: function(input,message) {
			input.parents('.form-control-container,.form-group').addClass('is-empty');
			$('.form-control-container-toolbar-invalid',input.parents('.form-control-container'))
				.empty()
				.append('<span>' + message + '</span>');
			return message;
		},
		_hasValidationError : function() {
			var self = this;
			var form = self.element;
			var errors = [];
			
			$('input[type=email]',form).each(function(){
				var input = $(this);
				if(input.val() !== '' && !/[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/.test(input.val())){
					errors.push(self._invalid(input, self.options.invalid.email));
				}
			});
			
			$('input[type=number][max]',form).each(function(){
				var input = $(this);
				if(input.val() !== '' && parseInt(input.val()) > parseInt(input.attr("max"))){
					errors.push(self._invalid(input,self.options.invalid.max + ' ' + input.attr("max")));
				}
			});
			
			$('input[type=number][min]',form).each(function(){
				var input = $(this);
				if(input.val() !== '' && parseInt(input.val()) < parseInt(input.attr("min"))){
					errors.push(self._invalid(input, self.options.invalid.min + ' ' + input.attr("min")));
				}
			});
			
			$('input[data-validate=cpf]',form).each(function(){
				var input = $(this);
				if(input.val() !== '' && !self._isValidCpf(input.val())){
					errors.push(self._invalid(input, self.options.invalid.cpf));
				}
			});
			
			$('input[data-validate=date]',form).each(function(){
				var input = $(this);
				if(input.val() !== '' && !self._isValidDate(input.val())){
					errors.push(self._invalid(input, self.options.invalid.date));
				}
			});
			
			if(errors.length > 0){
				self._alert(self.options.errors.invalid.title,self.options.errors.invalid.text);
				return true;
			} else {
				return false;
			}
		}
	});
})(jQuery);