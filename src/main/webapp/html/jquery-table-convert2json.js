(function($) {
  $.extend($.fn, {
    tableRowsToJSONWithFilter : function (filter) {
      var tableSelector = this, item, attr, data, _JSON = [];
      if (typeof(tableSelector) !== 'object') {
        return new Error('Invalid tableSelect!');
      };
      $(tableSelector, 'tr').each(function(index, tr) {
        item = {};
        $('td', $(this)).each(function(index, td) {
          attr = $(td).attr('data-id');
          data = $(td).text();
          if (attr !== undefined && data !== '' && filter && new RegExp(filter, 'i').test(attr)) {
            item[attr] = data;
          };
        });
        _JSON.push(item);
      });
      return _JSON;
    }
  })
})(jQuery);