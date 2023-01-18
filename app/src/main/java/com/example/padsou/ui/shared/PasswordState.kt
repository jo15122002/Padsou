package com.example.padsou.ui.shared

class PasswordState(defaultText:String = ""): TextFieldState(
    defaultText,
    validator = {password, s1 -> isPasswordValid(password, s1)},
    errorMessage = { passwordErrorMessage()},
)

fun isPasswordValid(password : String, s1 : String?): Boolean{
    return password.length >= 4
}

private fun passwordErrorMessage(): String{
    return "Ton mot de passe est trop court !";
}