var input;
var response;
$('#takebtn').click(function(){
    input = $('#enterrequestid').val();
    $.ajax({
        url: "http://localhost:9998/api/request?param="+input+"&type=requestID", 
        method: 'GET',
        success: function(result){
            response = result.request;
            $.ajax({
                url: "http://localhost:9998/api/user?param=8422&type=userID", 
                method: 'GET',
                success: function(result){
                    console.log(result.user);
                    response.tutorID = result.user;
                    console.log(response.tutorID);
                    console.log(response);


                    console.log(response);
                    $.ajax({
                        url: "http://localhost:9998/api/request", 
                        method: 'PUT',
                        contentType: 'application/json',
                        data: JSON.stringify(response),
                        success: function(result){
                            console.log(JSON.stringify(response));
                            window.location.reload();

                        }

                    });
                }
            });
            

        }
    });
});




