(function($) {
	$.widget("tagria.pdf", {
		options : {
			selector: '',
			filename: '',
			asImage: false
		},
		_create : function() {
			var self = this;
			var button = self.element;
			$(button).click(function(){
				self._export();
			});			
		},
		_export: function() {
			var self = this;
			var selector = self.options.selector;
			var filename = self.options.filename;
			var element = $(selector);
			var width = element.width(),height = element.height(),paddingLeft = 10,paddingTop = 10;
			var asImage = self.options.asImage;
			
			if(asImage) {
				html2canvas(element.get(0), {
		            onrendered: function(canvas) {
		                var imgData = canvas.toDataURL('image/jpeg');
		                var pdf = new jsPDF();
		                pdf.addImage(imgData, 'JPEG', paddingLeft, paddingTop);
		                pdf.save(filename);
		            }
		        });
			} else {
				var pdf = new jsPDF();
		    	pdf.fromHTML(element.get(0), paddingLeft, paddingTop, {
			    		background: '#fff',
			    		useCORS: true,
			    		width: width, 
			    		height: height,
			    		elementHandlers : {
			    		    
			    		}
		    		});
		    	pdf.save(filename);
			}
		}
	});
})(jQuery);