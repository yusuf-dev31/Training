function activated()
{
var email = $("#emailadd").val();
var destination = $("#destination").val();
$.ajax({
         type: 'GET',
         url:'/bin/emailDestination',
         data:{
         'email':email,
         'destination':destination
         },
       //  'email='+email+'&destination='+destination,
         success: function(msg){
           $('#gen').html(msg)
         },
         error: function() {
                   alert("error!");
                 }
     });
}
