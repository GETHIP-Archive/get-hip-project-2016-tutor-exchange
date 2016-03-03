$('#rbtn').click(function(){
    var obj;
    var requester;
    $.ajax({
        url: "http://localhost:9998/api/user?param=1967&type=userID", 
        method: 'GET',
        success: function(result){
            requester = result.user;
            console.log(result);
            var obj = {subject: $('#rform1').val(), description: $('#rform2').val(), tuteeID: requester};
            console.log(obj);
            $.ajax({
                url: "http://localhost:9998/api/request", 
                method: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(obj),
                success: function(result){
                  $('#rform2').val("")
                  $('#rform1').val("")
                    window.location.reload();
                }
            });
        }
    });





});