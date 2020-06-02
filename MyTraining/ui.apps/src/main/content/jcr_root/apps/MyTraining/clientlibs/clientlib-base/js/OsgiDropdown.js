function xyz()
{
var mName = $("#movie").val();


$.ajax({
         type: 'GET',
         url:'/bin/MovieGenre',
         data : {
            'movieGen':mName

         },
         success: function(msg)
         {
            $('#out').html(msg)

         },
         error: function() {
                   alert("error!");
                 }
     }
     );
}
