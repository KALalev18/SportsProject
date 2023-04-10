function registerUser(event) {
    event.preventDefault();
    var firstName = document.getElementById("firstName").value;
    var lastName = document.getElementById("lastName").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    var pass = password;
    var message = document.getElementById("message");
    if (firstName && lastName && email && password && pass && (password == pass)) {
        message.innerHTML = "Registered successfully!";
    } else {
        message.innerHTML = "Please fill out all fields.";
    }
}