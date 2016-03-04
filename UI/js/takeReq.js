var btn;
var return;
$('#btnsub').click(function(){
       $.ajax({
        url: "http://localhost:9998/api/request?param=8422&type=tutorID", 
        method: 'GET',
        success: function(result){
            return = result.request;
            return.tutorID = 8422;
    $.ajax({
        url: "http://localhost:9998/api/request", 
        method: 'PUT',
         contentType: 'application/json',
        data: JSON.stringify(request),
        success: function(result){
            console.log('success');
             window.location.reload();
        }
              });
        });
});




