$( document ).ready(function() {
    var dayList = ["Monday", "Tuesday" , "Wednesday" , "Thursday" ,"Friday"];
    var pending = [];
    var rresult = [];

 $.ajax({
        url: "http://localhost:9998/api/request?param=1&type=status", 
        method: 'GET',
        success: function(result){
            rresult = result;
            console.log(result);
          var pending = [];
       $.each(rresult.request, function(){
        if(this.tutorID == null){
        var binary_array = (""+this.tuteeID.schedule).split("");
        var boolean = [];
        $.each(binary_array, function(index,value){
        if(value == "0"){
            boolean.push(false)
        }
        if(value == "1"){
            boolean.push(true)
        }
        });
        var sString = "";
        for(var i=0;i<10;i=i+2){
            if(boolean[i] + boolean[i+1] > 0){
                sString += dayList[i-(i/2)];
                sString += " ";
            if(boolean[i] == 1){
                sString += "A";
            }
            if(boolean[i] == 1 && boolean[i+1] == 1){
                sString += "/";
            }
            if(boolean[i+1] == 1){
                sString += "P";
            }
             if(i-(i/2) != 4){
             sString += ", ";
                    }
                }
        }
        console.log(sString);
        this.tuteeID.schedule = sString;
            pending.push(this)
            console.log(this);
        }
    });
       console.log(pending);
        var rows = [];
        console.log(rows);
        $.each(pending, function(){
        rows += "<tr><td>" + this.requestID + "</td><td>" + this.subject + "</td><td>"+ this.description + "</td><td>"+ this.tuteeID.firstName + " " + this.tuteeID.lastName + "</td><td>" + this.tuteeID.schedule+ "</td></tr>";
                });

        $( rows ).appendTo( "#trTable" );

            console.log(rows);
        }
    });
});

