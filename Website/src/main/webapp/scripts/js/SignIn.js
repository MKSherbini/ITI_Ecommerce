
        function validateemail(email)
        {
            //var email = document.getElementById("login-email").value;
            var emailregix =  /^[A-Za-z0-9+_.-]+@(.+)$/;
            var emailresult = emailregix.test(email);
            console.log(email);
            console.log(emailresult);

            if(emailresult == false)
                {
                    document.getElementById("error-email").innerHTML ="Please Enter a valid email*";

                   //return false;
                   document.getElementById("login-email").value = '';
                }
            else{
                document.getElementById("error-email").innerHTML = "<span style='color: white;'></span>";

            }
        }



function validatePass()
{
    var pass = document.getElementById("login-password").value;
    var passregix =  /[A-Za-z._0-9]{5,}/;
    var passresult = passregix.test(pass);
    if(passresult == false)
    {
        document.getElementById("error-pass").innerHTML ="Please Enter a valid password*";
        document.getElementById("login-password").value = '';
    }
    else{
        document.getElementById("error-pass").innerHTML =

            "<span style='color: white;'></span>";
    }
}







        
