/**
 * table-2-json
 * jQuery plugin that reads an HTML table and returns a javascript object representing the values and columns of the table
 *
 * @author Lin Jiawei
 * @copyright Lin Jiawei 2017
 * @module table-2-json
 * @version 0.0.1
 */
(function($) {
	'use strict';

	$.fn.convertTable2Json = function(opts) {

		var defaultSettings = {};

		var tabledata = [];
		this.find('tr').each(function(i) {
			var row = {};
			if (i == 0) {
				return;
			}
			$(this).find("input,select").each(function(i) {
				var name = $(this).attr('name');
				var val = $(this).val();
				row[name] = val;
			});
			tabledata.push(row);
		})

		return tabledata;
	};

	$.fn.add = function() {
		var defaultSettings = {};
		
		console.log($('#sample').html());
		this.find('tbody').append($('#sample tbody').html());
		//alert('---');
	}
})(jQuery);
