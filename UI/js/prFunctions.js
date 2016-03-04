$('#btnsub').click(function(){
        var booleanarray = [];
        var binaryString = '';
    for(var i = 0; i < 10; i++){
        booleanarray.push($('#cb'+ i).is(':checked'));
    }
    $.each(booleanarray, function(index,value){
        if(value){
             binaryString = binaryString + 1;
        }else{
            binaryString = binaryString + 0;
        }
    });
    user.user.schedule = binaryString;
    console.log(binaryString);
    $.ajax({
        url: "http://localhost:9998/api/user", 
        method: 'PUT',
         contentType: 'application/json',
        data: JSON.stringify(user.user),
        success: function(result){
            console.log('success');
             window.location.reload();
        }
    });
});
