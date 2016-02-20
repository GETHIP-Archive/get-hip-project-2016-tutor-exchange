$( document ).ready(function() {
    $.ajax({url: "https://raw.githubusercontent.com/GETHIP-Classroom/get-hip-project-2016-tutor-exchange/master/UI/users.json", success: function(result){
        console.log(result);
    }});
});
