function empty() {
    var x;
    var y;
    var z;
    var c;
    var b;
    x = document.getElementById("nameInput").value;
    y = document.getElementById("emailInput").value;
    z = document.getElementById("zipcodeInput").value;
    c = document.getElementById("telInput").value;
    b = document.getElementById("adresseInput").value;
    if (x === "" || y === "" || z === "" || c === "" || b === "") {
        alert("Venligst indtast gyldig information");
        return false;
    }
}

$('.carousel').carousel({
    interval: 2000
});

function shedvisibility() {
    if (document.getElementById("shedInput").checked === false) {
        $('#display').fadeOut(200);
    }
    if (document.getElementById("shedInput").checked === true) {
        $('#display').fadeIn(200);
    }
}

function roofvisibility() {
    if (document.getElementById("roofInput").checked === false) {
        $('#display1').fadeOut(200);
    }
    if (document.getElementById("roofInput").checked === true) {
        $('#display1').fadeIn(200);

    }
}

function rooftypevisibility() {
    if (document.getElementById("roofTypeInput").checked === false) {
        $('#display2').fadeOut(200);
    }
    if (document.getElementById("roofTypeInput").checked === true) {
        $('#display2').fadeIn(200);

    }
}

function showPassword() {
    var x = document.getElementById("pwd");
    if (x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
}