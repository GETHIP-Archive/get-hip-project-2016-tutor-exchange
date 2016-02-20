$( document ).ready(function() {
    $.ajax({url: "https://raw.githubusercontent.com/GETHIP-Classroom/get-hip-project-2016-tutor-exchange/master/UI/users.json", success: function(result){
        result = JSON.parse(result);
        console.log(result);
        console.log(result.user.schedule);
    }});
});
