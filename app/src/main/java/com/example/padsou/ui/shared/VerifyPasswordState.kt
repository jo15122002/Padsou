package com.example.padsou.ui.shared

class VerifyPasswordState: TextFieldState(
    validator = {password, toBeVerifiedPassword -> isPasswordVerified(password, toBeVerifiedPassword)},
    errorMessage = { passwordErrorMessage()},
)

fun isPasswordVerified(password : String, toBeVerifiedPassword : String?): Boolean{
    return password == toBeVerifiedPassword;
}

private fun passwordErrorMessage(): String{
    return "Ton mot de passe ne correspond pas";
}