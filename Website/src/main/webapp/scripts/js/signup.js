    var wsocket = new WebSocket("ws://localhost:9090/ITI_Ecommerce_Website_war_exploded/echo");
    wsocket.onopen = onOpen;
    wsocket.onmessage = onMessage;

   function validateEmail(emailregex){
       console.log(emailregex);
        var emailpattern =  /[A-Za-z._]{3,}@[A-Za-z]{3,}[ . ]{1}[A-Za-z.]{2,6}/;
        if(!emailpattern.test(emailregex)){
         document.getElementById("emailValid").innerHTML ="Please enter a valid form of an email";
    } else{
         document.getElementById("emailValid").innerHTML ="";
         wsocket.send(emailregex);
    }
}

    function onOpen(){
        console.log("connection established");
    }

    function onMessage(evt){
        document.getElementById("emailValid").innerHTML = evt.data;
    }

    function disconnect(){
        wsocket.close();
    }


    function validatePassword(){
        var passwordregex = document.getElementById("reg-password").value;
        var passwordreregex =document.getElementById("reg-repassword").value;
        var passwordpattern = /[A-Za-z._0-9]{5,}/;
    if(!passwordpattern.test(passwordregex)){
    document.getElementById("passwordValid").innerHTML ="Short Password are easy to guess! Try one with at least 5 characters";
}
    else{
    document.getElementById("passwordValid").innerHTML ="";
}
    if(passwordregex != passwordreregex){
    document.getElementById("repasswordValid").innerHTML ="Those Passwords didn't match please try again ";
}
    else{
    document.getElementById("repasswordValid").innerHTML ="";
}}