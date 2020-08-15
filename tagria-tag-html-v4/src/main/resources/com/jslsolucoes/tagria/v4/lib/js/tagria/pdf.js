(function($) {
	$.widget("tagria.pdf", {
		options : {
			selector: '',
			filename: ''
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
			var filename = self.options.filename + '.pdf';
			var element = $(selector);
			
			
			html2canvas(document.querySelector(selector), {
	            onrendered: function(canvas) {
	                var imgData = canvas.toDataURL('image/png');
	                var pdfInstance = new jsPDF('p', 'mm', [297, 210]);
	                pdfInstance.addImage(imgData, 'PNG', 10, 10);
	                pdfInstance.save(filename);
	            }
	        });
			
			/*
			var width = element.width(),height = element.height(),paddingLeft = 10,paddingTop = 10;
			var pdf = new jsPDF();
			pdf.addHTML(element.html(),paddingLeft,paddingTop,{background: '#fff',useCORS: true,width: width + (paddingLeft * 2),height: height - (paddingTop * 2)});
			pdf.save(filename);
			*/
		}
	});
})(jQuery);