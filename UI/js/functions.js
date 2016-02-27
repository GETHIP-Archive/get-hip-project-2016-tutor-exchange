var user;
$( document ).ready(function() {
    $.ajax({
        url: "http://localhost:9998/api/user?param=3061&type=uID", 
        method: 'GET',
        success: function(result){
        result = JSON.parse(result);
        user = result;
        var binary_array = (""+result.user.schedule).split("");
        var boolean = [];
        $.each(binary_array, function(index,value){
        if(value == "0"){
            boolean.push(false)
        }
        if(value == "1"){
            boolean.push(true)
        }
        });
        result.user.schedule = boolean;
        console.log(result.user.schedule);
        $.each(boolean, function(index, value){
            $('#cb'+ index).prop('checked', value);
        });
    }});
});

$('btnsub').click(function(){
        var booleanarray = [];
        var binaryString;
    for(var i = 0; i < 10; i++){
        boolean.push($('#cb'+ index).is(':checked'));
    }
    $.each(booleanarray, function(index,value){
        if(value){
             binaryString = binaryString + 1;
        }else{
            binaryString = binaryString + 0;
        }
    });
    user.user.schedule = binaryString;
    $.ajax({
        url: "http://localhost:9998/api/user", 
        method: 'POST',
        data: user,
        success: function(result){
            console.log('success');
        }
    });
});
