$( document ).ready(function() {
    $.ajax({url: "", success: function(result){
        $("#div1").html(result);
    }});
});
