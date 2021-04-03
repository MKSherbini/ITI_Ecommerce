var gender ;
$(window).ready(function(){
    $("#subscibe_form").submit(function(event){
        event.preventDefault();
        if(validateInputs()){
            $("#error_message").hide();
            /// check if the id is registerd before

            var posting = $.get( "registerSubscriber?email="+$("#newsletter").val()+"&gender="+gender ,function (response, status, xhr) {
                if (status === "success") {
                    if( response.trim() ==="exists".trim()){
                        // user registered  notify the user that his email registered
                        $("#success_message").html("This email is registered before ,Please check your email ");
                    }else{
                        /// register the user emaill and gender
                        var subscriber = {
                            "email":$("#newsletter").val(),
                            "gender":gender
                        }
                        console.log(subscriber);
                        // Send the data using post
                        var posting = $.post( "registerSubscriber", subscriber ,function (response, status, xhr) {
                            if (status == "success") {
                                $("#success_message").html(response);
                                console.log(response + status);
                            } else {
                                console.log(status + response );
                                $("#success_message").html(response);
                            }
                        });

                    }

                } else {
                    console.log(status + response );
                    $("#success_message").html(response);
                }
            });


            ////end of the check




        }else {
            $("#error_message").show();
        }


    });
});
function  validateInputs(){
    var valid = false ;

    if( $("#male").prop('checked')){
        gender = "Male";
    }else if($("#female").prop('checked')){
        gender = "Female";
    }
    if((gender == null)){

        // todo notifi not valid gender
        console.log(gender);
        valid = false;
        $("error_message").text( "you must choose Gender");

    }else {
        valid = true ;
        console.log(gender+valid);
    }
    if ((validateEmail($("#newsletter").val()))){
        valid = valid && true;
        // todo notify good mail

        console.log($("#newsletter").val()+valid);
    }else {
        valid = false;
        $("error_message").text( $("error_message").text()+" enter valid email like : example@gmail.com .");
        console.log($("#newsletter").val()+valid);
    }


    return valid ;
}

function validateEmail(email){
    var pattern = /^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/
    return pattern.test(email) ;

}