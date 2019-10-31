(function($){
    var originalVal = $.fn.val;
    $.fn.val = function(){
        var result =originalVal.apply(this,arguments);
        if(arguments.length > 0)
            $(this).change();
        return result;
    };
})(jQuery);