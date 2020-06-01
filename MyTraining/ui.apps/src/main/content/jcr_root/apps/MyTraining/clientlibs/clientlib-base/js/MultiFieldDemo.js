//
//function loadDoc() {
//  var xhttp = new XMLHttpRequest();
//  xhttp.onreadystatechange = function() {
//    if (this.readyState == 4 && this.status == 200) {
//      document.getElementById("demo").innerHTML =
//      this.responseText;
//    }
//  };
//  xhttp.open("GET", "/bin/student", true);
//  xhttp.send();
//}

$(document).ready(function () {
    $('.s-button').click(function(e) {
    e.preventDefault();
    let data = $('#search').val();
   $.ajax({
      url: '/bin/studentDetails',
      data: {
            search: data
      },
      error: function() {
         $('#output').html('<p>An error has occurred</p>');
      },
      success: function(data) {
         var $names = $('<div>').text(data);
         $('#output').html('').append($names);
      },
      type: 'GET'
   });
})});