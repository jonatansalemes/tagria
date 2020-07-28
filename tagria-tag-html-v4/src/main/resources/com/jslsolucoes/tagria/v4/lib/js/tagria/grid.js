(function($) {
	$.widget("tagria.grid", {
		options : {
			id: '',
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
			var id = self._id();
			$('.grid-search[data-parent='+id+']').on('keydown.grid',function(event){
				if(event.keyCode==13 && $(this).val()!=''){
					window.location = self.options.url + '?search=true&term=' + encodeURIComponent($(this).val());
				}
			});
		},
		_pagination : function (){
			var self = this;
			var id = self._id();
			$('.grid-paginate-item[data-parent='+id+']').on('click.grid',function(){
				$('.grid-paginate-item[data-parent='+id+'].active').removeClass('active');
				$(this).addClass('active');
				self._paginate(false);
			});
		},
		_resultsPerPage : function() {
			var self = this;
			var id = self._id();
			$('.grid-results-per-page-item[data-parent='+id+']').on('click.grid',function(){
				$('.grid-results-per-page-item[data-parent='+id+'].active').removeClass('active');
				$(this).addClass('active');
				self._paginate(true);
			});
		},
		_paginate : function (reset) {
			var self = this;
			var id = self._id();
			var resultsPerPage = parseInt($('.grid-results-per-page-item[data-parent='+id+'].active').text());
			var page = parseInt($('.grid-paginate-item[data-parent='+id+'].active').text());
			if(reset) {
				page = 1;
			}
			window.location = self.options.url + '?page='+page+'&resultsPerPage='+resultsPerPage + '&' +  self.options.queryString;			
		},
		_exportation : function() {
			var self = this;
			var id = self._id();
			console.log(id);
			$('.grid-export-pdf[data-parent='+id+']').on('click.grid',function(){
				console.log('click');
				self._export('pdf');
			});
			
			$('.grid-export-csv[data-parent='+id+']').on('click.grid',function(){
				self._export('csv');
			});
			
			$('.grid-export-xml[data-parent='+id+']').on('click.grid',function(){
				self._export('xml');
			});
			
			$('.grid-export-excel[data-parent='+id+']').on('click.grid',function(){
				self._export('xlsx');
			});
		},
		_export : function(type) {
			var self = this;
			var id = self._id();
			$('.grid-export-type[data-parent='+id+']').val(type);
			$('.grid-export-json[data-parent='+id+']').val(self._json());
			$('.grid-export-form[data-parent='+id+']').submit();
		},
		_id : function() {
			var self = this;
			return self.options.id;
		},
		_json : function(){
			
			var self = this;
			var id = self._id();
			
			var headers = new Array();
			$('th[data-parent='+id+']:visible.grid-column-exportable').each(function(index,th){
				headers.push({
					align : ($(th).hasClass('text-left') ? 'left' : $(th).hasClass('text-right') ? 'right' : 'center'),
					content : $.trim($(th).text())
				});
			});
			
			var columns = new Array();
			$('tr[data-parent='+id+']:visible').each(function(index,tr){
				var column = new Array();
				$('td[data-parent='+id+']:visible.grid-column-exportable',$(tr)).each(function(index,td){
					column.push({
						align : ($(td).hasClass('text-left') ? 'left' : $(td).hasClass('text-right') ? 'right' : 'center'),
						content : $.trim($(td).text())
					});
				});
				columns.push({columns : column});
			});
			
			var title = $('.grid-title[data-parent='+id+']').text();
			
			return JSON.stringify({
				id: id,
				title :  title,
				headers : headers,
				rows : columns
			});
		}
	});
})(jQuery);