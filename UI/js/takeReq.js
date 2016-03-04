var input;
var response;
$('#takebtn').click(function(){
        input = $('#enterrequestid').val();
       $.ajax({
        url: "http://localhost:9998/api/request?param=8422&type=tutorID", 
        method: 'GET',
        success: function(result){
            response = result.request;
            response.tutorID = 8422;
    $.ajax({
        url: "http://localhost:9998/api/request", 
        method: 'PUT',
         contentType: 'application/json',
        data: JSON.stringify(response),
        success: function(result){
            console.log('success');
             window.location.reload();
        }
              });
        });
});




