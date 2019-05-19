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
    if (x === "" || y === "" || c === "" || b === "") {
        alert("Venligst indtast gyldig information");
        return false;
    }
    ;
}

window.addEventListener("load", function () {
    window.cookieconsent.initialise({
        "palette": {
            "popup": {
                "background": "#edeff5",
                "text": "#838391"
            },
            "button": {
                "background": "#4b81e8"
            }
        },
        "theme": "classic"
    });
});

