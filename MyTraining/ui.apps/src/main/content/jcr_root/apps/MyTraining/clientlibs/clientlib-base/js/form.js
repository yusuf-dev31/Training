function xy()
{
var fName = $("#F_name").val();
var lName = $("#L_name").val();
var Email = $("#email").val();

$.ajax({
         type: 'GET',
         url:'/bin/FormServletDemo',
         data : {
            'first_name':fName,
            'last_name':lName,
            'email':Email
         },
         success: function(msg){
            $("#abc").hide();
            $("#pqr").show();
         },
         error: function() {
                   alert("error!");
                 }
     }
     );
}

