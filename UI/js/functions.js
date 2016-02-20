$( document ).ready(function() {
    $.ajax({url: "users.json", success: function(result){
        console.log(result);
    }});
});
