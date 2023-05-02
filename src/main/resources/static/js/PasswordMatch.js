function checkPasswordMatch() {
    var password = document.getElementById("password");
    var confirmPassword = document.getElementById("confirm-password");
    var passwordMatch = document.getElementById("password-match");

    if (password.value != confirmPassword.value) {
        passwordMatch.innerHTML = "Passwords do not match.";
    } else {
        passwordMatch.innerHTML = "Passwords match!";
    }
}