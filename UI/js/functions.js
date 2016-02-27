$( document ).ready(function() {
    $.ajax({url: "https://raw.githubusercontent.com/GETHIP-Classroom/get-hip-project-2016-tutor-exchange/master/UI/users.json", success: function(result){
        result = JSON.parse(result);
        var binary_array = (""+result.user.schedule).split("")
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
