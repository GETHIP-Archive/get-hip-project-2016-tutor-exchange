$( document ).ready(function() {
    var pending = [];

 $.ajax({
        url: "http://localhost:9998/api/request?param=8422&type=tutorID", 
        method: 'GET',
        success: function(result){
            console.log(result);
          var pending = [];
       $.each(result.request, function(){
            pending.push(this)
    });
       console.log(pending);
        var rows = [];
        console.log(rows);
        $.each(pending, function(){
        rows += "<tr><td>" + this.subject + "</td><td>" + this.tuteeID.firstName + " " + this.tuteeID.lastName + "</td><td>" + this.description  +  "</td></tr>";
                });

        $( rows ).appendTo( "#tutorDB" );

            console.log(rows);
        }
    });






});
