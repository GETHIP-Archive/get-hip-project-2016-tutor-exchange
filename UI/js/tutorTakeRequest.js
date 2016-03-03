$( document ).ready(function() {
    var pending = [];

 $.ajax({
        url: "http://localhost:9998/api/request?param=1&type=status", 
        method: 'GET',
        success: function(result){
            console.log(result);
          var pending = [];
       $.each(result.request, function(){
        if(this.tutorID == null){
            pending.push(this)
        }
    });
       console.log(pending);
        var rows = [];
        console.log(rows);
        $.each(pending, function(){
        rows += "<tr><td>" + this.requestID + "</td><td>" + this.subject + "</td><td>"+ this.description + "</td><td>"+ this.tuteeID.firstName + " " + this.tuteeID.lastName + "</td></tr>";
                });

        $( rows ).appendTo( "#trTable" );

            console.log(rows);
        }
    });






});
