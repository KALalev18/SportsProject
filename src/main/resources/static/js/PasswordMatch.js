function checkPasswordMatch() {
    var password = document.getElementById("password");
    var confirmPassword = document.getElementById("confirm-password");
    var passwordMatch = document.getElementById("password-match");

    if (password.value != confirmPassword.value) {
        passwordMatch.innerHTML = "Паролите не съвпадат.";
    } else {
        passwordMatch.innerHTML = "Паролите съвпадат.";
    }
}