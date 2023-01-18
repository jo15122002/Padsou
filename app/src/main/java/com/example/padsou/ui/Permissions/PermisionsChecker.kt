package com.example.padsou.ui.Permissions

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.padsou.ui.theme.MainCorail
import com.example.padsou.ui.theme.MainPurple
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState


@ExperimentalPermissionsApi
@Composable
fun PermissionsChecker(
    permissionsState: MultiplePermissionsState,
    description: String,
) {
    lateinit var titleText: String
    lateinit var descriptionText : String
    lateinit var buttonText: String
    lateinit var buttonAction: () -> Unit

    val context = LocalContext.current
    val dialogState: MutableState<Boolean> = remember { mutableStateOf(true) }

    permissionsState.let {
        when {
            !it.permissionRequested || it.shouldShowRationale -> {
                titleText = "Active les notifications"
                descriptionText = "Si t'as plus de thunes ca peut toujours servir 😁"
                buttonAction = { permissionsState.launchMultiplePermissionRequest() }
                buttonText = "C'est parti !"
            }

            else -> {
                titleText = "Tu avais desactivé les notifications"
                descriptionText = "Si tu les réactives, tu pourras economiser pleins de thune 🤑"
                buttonAction = {
                    context.startActivity(
                        Intent(
                            Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                            Uri.fromParts("package", context.packageName, null)
                        )
                    )
                }
                buttonText = "Réactiver"
            }
        }
    }

    if (dialogState.value){
        AlertDialog(
            onDismissRequest = { dialogState.value = false },
            backgroundColor = MainPurple,
            title = { Text(titleText, color = Color.White, style = MaterialTheme.typography.h3)},
            text = {Text(descriptionText, color = Color.White)},
            confirmButton = {
                Button(onClick = { buttonAction() }, colors = ButtonDefaults.buttonColors(Color.White)) {
                    Text(text = buttonText, color= MainPurple)
                }
            },
            dismissButton = {
                Button(onClick = { dialogState.value = false }, colors = ButtonDefaults.buttonColors(MainCorail)) {
                    Text("Fermer", color= Color.White)
                }
            }
        )
    }
}
