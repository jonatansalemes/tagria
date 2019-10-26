(function($) {
	$.widget("tagria.grid", {
		options : {
			url : '',
			queryString : '',
			exporter : ''
		},
		_create : function() {
			var self = this;
			self._pagination();
			self._resultsPerPage();
			self._exportation();
			self._search();
		},
		_search : function() {
			var self = this;
			var grid = self.element;
			$('.grid-search', grid).on('keydown.grid',function(event){
				if(event.keyCode==13 && $(this).val()!=''){
					window.location = self.options.url + '?search=true&term=' + encodeURIComponent($(this).val());
				}
			});
		},
		_pagination : function (){
			var self = this;
			var grid = self.element;
			$('.grid-paginate-item', grid).on('click.grid',function(){
				$('.grid-paginate-item.active').removeClass('active');
				$(this).addClass('active');
				self._paginate(false);
			});
		},
		_resultsPerPage : function() {
			var self = this;
			var grid = self.element;
			$('.grid-results-per-page-item', grid).on('click.grid',function(){
				$('.grid-results-per-page-item.active').removeClass('active');
				$(this).addClass('active');
				self._paginate(true);
			});
		},
		_paginate : function (reset) {
			var self = this;
			var grid = self.element;
			var resultsPerPage = parseInt($('.grid-results-per-page-item.active').text());
			var page = parseInt($('.grid-paginate-item.active').text());
			if(reset) {
				page = 1;
			}
			window.location = self.options.url + '?page='+page+'&resultsPerPage='+resultsPerPage + '&' +  self.options.queryString;			
		},
		_exportation : function() {
			var self = this;
			var grid = self.element;
			$('.grid-export-pdf',grid).on('click.grid',function(){
				self._export('pdf');
			});
			
			$('.grid-export-csv',grid).on('click.grid',function(){
				self._export('csv');
			});
			
			$('.grid-export-xml',grid).on('click.grid',function(){
				self._export('xml');
			});
			
			$('.grid-export-excel',grid).on('click.grid',function(){
				self._export('xlsx');
			});
		},
		_export : function(type) {
			var self = this;
			var grid = self.element;
			$('.grid-export-type',grid).val(type);
			$('.grid-export-json',grid).val(self._json());
			$('.grid-export-form',grid).submit();
		},
		_json : function(){
			
			var self = this;
			var grid = self.element;
			
			var headers = new Array();
			$('table:first > thead > tr > th:visible.grid-column-exportable',grid).each(function(){
				headers.push({
					align : ($(this).hasClass('text-left') ? 'left' : $(this).hasClass('text-right') ? 'right' : 'center'),
					content : $.trim($(this).text())
				});
			});
			
			var columns = new Array();
			$('table:first > tbody > tr:visible',grid).each(function(){
				var column = new Array();
				$('td:visible.grid-column-exportable',this).each(function(){
					column.push({
						align : ($(this).hasClass('text-left') ? 'left' : $(this).hasClass('text-right') ? 'right' : 'center'),
						content : $.trim($(this).text())
					});
				});
				columns.push({columns : column});
			});
			
			return JSON.stringify({ 
				title :  $('.panel-heading',grid).text(),
				headers : headers,
				rows : columns
			});
		}
	});
})(jQuery);