$( document ).ready(function() {
    var pending = [];

 $.ajax({
        url: "http://localhost:9998/api/request?param=1967&type=tuteeID", 
        method: 'GET',
        success: function(result){
            pending = result;
        var rows = [];
        console.log(rows);
        $.each(pending.request, function(){
        rows += "<tr><td>" + this.subject + "</td><td>" + this.description + "</td></tr>";
                });

        $( rows ).appendTo( "#pendtable" );

            console.log(rows);
        }
    });






});
