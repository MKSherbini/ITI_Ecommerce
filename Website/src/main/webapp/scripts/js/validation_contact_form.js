
$(window).ready(function (){
    $( "#con_form" ).submit(function( event ) {

        // Stop form from submitting normally
        event.preventDefault();
        if(validateContactInputs()){
            $("#result").hide();
            // Get some values from elements on the page:
            var message = {
                "name":$("#c-name").val(),
                "email":$("#c-email").val(),
                "subject":$("#c-subject").val(),
                "message":$("#c-message").val()
            }
            console.log(message);
            // Send the data using post
            var posting = $.post( "contact", message ,function (response, status, xhr) {
                if (status == "success") {
                    clearInputs();
                    $("#result").show();
                    $("#result").html("Message sent successfully check your mail .");

                } else {
                    console.log(status + response );
                }
            });

        }else {
            $("#result").show();
            $("#result").html( "Please email like : example@gmail.com and enter all required data .");
        }



    })
});



function  validateContactInputs(){
    var valid = true ;

    if( $("#c-message").val().trim().length<20){
        valid = false ;
    }else if($("#c-subject").val().trim().length <5){
        valid = false ;
    }else if ($("#c-name").val().trim().length<3){
        valid = false ;
    }else {
        if (validateEmail($("#c-email").val())){
            valid = valid && true;
            // todo notify good mail

            console.log($("#c-email").val()+valid);
        }else {
            valid = false;

            console.log($("#c-email").val()+valid);
        }
    }


    return valid ;
}

function validateEmail(email){
    var pattern = /^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/
    return pattern.test(email) ;

}
function clearInputs(){
    $("c-message").val("");
    $("c-email").val("");
    $("c-subject").val("");
    $("c-name").val("");
}

