/*// Wait for the DOM to be ready
$(function() {
    // Initialize form validation on the registration form.
    // It has the name attribute "registration"
    $("form[name='contact_form']").validate({
        // Specify validation rules
        rules: {
            // The key name on the left side is the name attribute
            // of an input field. Validation rules are defined
            // on the right side
            customerName: "required",
            subject: "required",
            email: {
                required: true,
                // Specify that email should be validated
                // by the built-in "email" rule
                email: true
            },
            message: {
                required: true,
                minlength: 5,
                maxlength: 200
            }
        },
        // Specify validation error messages
        messages: {
            customerName: "Please enter your first name at least 3 characters ",
            subject: "Please enter subject title ",
            message: {
                required: "Please provide a message",
                minlength: "Your message must be at least 25 characters long",
                maxlength: "Your message must be at least 25 characters long"
            },
            email: "Please enter a valid email address : example@example.com"
        },
        // Make sure the form is submitted to the destination defined
        // in the "action" attribute of the form when valid
        submitHandler: function(form) {
            form.submit();
        }
    });
});*/



function validateInput(input , reg , err , msg){

    if (pattern.test(input.value)){
        err.classList.remove('error');
        return true;
    }else{
        // document.getElementById(event.target.id).focus();
        err.innerHTML = msg;
        document.getElementById(event.target.id).classList.remove('valid');
        document.getElementById(event.target.id).classList.add('error');
        return false ;
    }

}