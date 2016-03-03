$( document ).ready(function() {
    var pending = [];

 $.ajax({
        url: "http://localhost:9998/api/request?param=1967&type=tuteeID", 
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
        rows += "<tr><td>" + this.subject + "</td><td>" + this.description + "</td></tr>";
                });

        $( rows ).appendTo( "#pendtable" );

            console.log(rows);
        }
    });






});
