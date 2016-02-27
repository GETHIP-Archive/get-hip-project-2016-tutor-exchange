$('#rbtn').click(function(){
    var obj = {subject: $('#rform1').val, description: $('#rform2').val, tuteeID: '1967'};
    console.log(obj);

        $.ajax({
        url: "http://localhost:9998/api/request", 
        method: 'POST',
         contentType: 'application/json',
        data: JSON.stringify(obj),
        success: function(result){
            console.log('success');
        }
    });

});