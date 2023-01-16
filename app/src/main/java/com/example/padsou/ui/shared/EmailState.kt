package com.example.padsou.ui.shared

import java.util.regex.Pattern

class EmailState : TextFieldState(
    validator = {email, s1 -> isEmailValid(email, s1) },
    errorMessage = {email -> emailErrorMessage(email)}
){

}
private const val EMAIL_VALIDATION_REGEX = "^(.+)@(.+)\\.(.+)\$";
private fun isEmailValid(email:String, s1:String?): Boolean{
    return Pattern.matches(EMAIL_VALIDATION_REGEX, email);
}

private fun emailErrorMessage(email:String): String{
    return "Ton email est invalide";
}