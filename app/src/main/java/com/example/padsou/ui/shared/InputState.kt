package com.example.padsou.ui.shared

import java.util.regex.Pattern

class InputState : TextFieldState(
    validator = {input, s1 -> isInputValid(input, s1) },
    errorMessage = {input -> inputErrorMessage(input)}
){

}
private fun isInputValid(input:String, s1:String?): Boolean{
    return input.length >= 4;
}

private fun inputErrorMessage(email:String): String{
    return "Le champs doit contenir au minimum 4 caractères";
}