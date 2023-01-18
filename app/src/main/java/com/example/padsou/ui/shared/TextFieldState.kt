package com.example.padsou.ui.shared

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

open class TextFieldState(
    defaultText: String = "",
    private val validator : (String, String?) -> Boolean,
    private val errorMessage : (String) -> String
){


    var text by mutableStateOf(defaultText)
    var error by mutableStateOf<String?>(null)

    fun validate(passwordToVerifie : String?){
        if(passwordToVerifie == null){
            error = if(validator(text, null)){
                null
            }else{
                errorMessage(text)
            }
        }

        else{
            error = if(validator(text, passwordToVerifie)){
                null
            }else{
                errorMessage(text)
            }
        }
    }

    fun isValid() = validator(text, null)


}