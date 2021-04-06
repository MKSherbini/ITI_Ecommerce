var wsocket = new WebSocket("ws://" + window.location.host + "/ITI_Ecommerce_Website_war_exploded/inEcho");
wsocket.onopen = onOpen;
wsocket.onmessage = onMessage;

function validateemail(email) {
    //var email = document.getElementById("login-email").value;
    var emailregix = /(^[A-Za-z0-9._-]+@[A-Za-z0-9]+\.[A-Za-z]{2,6}$)| [ \t\n]*/;
    var emailresult = emailregix.test(email);
    console.log(email);
    console.log(emailresult);
    if (emailresult == false) {
        document.getElementById("error-email").innerHTML = "Please Enter a valid email*";

        //return false;
        document.getElementById("login-email").value = '';
    } else {
        document.getElementById("error-email").innerHTML = "<span style='color: white;'></span>";
        wsocket.send(email);
    }
}

function onOpen() {
    console.log("connection established");
}

function onMessage(evt) {
    if (evt.data == "") {
        document.getElementById("error-email").innerHTML = evt.data;
    } else {
        document.getElementById("error-email").innerHTML = evt.data;
        document.getElementById("login-email").value = '';
    }
}

function disconnect() {
    wsocket.close();
}

function validatePass() {
    var pass = document.getElementById("login-password").value;
    var passregix = /[A-Za-z._0-9]{5,}/;
    var passresult = passregix.test(pass);
    if (passresult == false) {
        document.getElementById("error-pass").innerHTML = "Please Enter a valid password*";
        document.getElementById("login-password").value = '';
    } else {
        document.getElementById("error-pass").innerHTML =

            "<span style='color: white;'></span>";
    }
}







        
