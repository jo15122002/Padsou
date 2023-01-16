package com.example.padsou.ui.shared

import java.util.regex.Pattern

class HyperLinkState : TextFieldState(
    validator = {hyperlink, s1 -> isHyperlinkValid(hyperlink, s1) },
    errorMessage = {hyperlink -> emailErrorMessage(hyperlink)}
){

}
private const val HYPERLINK_VALIDATION_REGEX = "^www\\.(.+)\\.(.+)\$";
private fun isHyperlinkValid(email:String, s1:String?): Boolean{
    return Pattern.matches(HYPERLINK_VALIDATION_REGEX, email);
}

private fun emailErrorMessage(email:String): String{
    return "L'url renseignée n'est pas valide";
}