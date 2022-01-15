package com.example.pokeapp.ui.components.generics

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties

enum class DialogType{
    OK_ONLY,
    ERROR,
    WARNING,
    NONE
}

@Composable
fun GenericMsgDialog(
    dialogType: DialogType,
    msgTitle: String,
    msgText: String,
    btnPositiveText: String,
    btnNegativeText: String,
    imgResource: ImageVector? = null,
    dialogState: Boolean,
    onDialogStateChange: ((Boolean) -> Unit)?,
    onDialogPositiveButtonClicked: (() -> Unit)? = null,
    onDialogNegativeButtonClicked: (() -> Unit)? = null,
    onDismissRequest: (() -> Unit)? = null,
) {
    //var showDialog by rememberSaveable { mutableStateOf(true) }

    when(dialogType){
        DialogType.OK_ONLY -> {
            OkOnlyMsg(
                msgText = msgText,
                btnText = btnPositiveText,
                imgResource = imgResource,
                dialogState = dialogState,
                onDialogPositiveButtonClicked = onDialogPositiveButtonClicked,
                onDialogStateChange = onDialogStateChange,
                onDismissRequest = onDismissRequest
            )
        }
        DialogType.ERROR,
        DialogType.WARNING,
        DialogType.NONE
        -> {
            AlertMsg(
                dialogType = dialogType,
                msgTitle = msgTitle,
                msgText = msgText,
                imgResource = imgResource,
                btnPositiveText = btnPositiveText,
                btnNegativeText = btnNegativeText,
                dialogState = dialogState,
                onDialogPositiveButtonClicked = onDialogPositiveButtonClicked,
                onDialogNegativeButtonClicked = onDialogNegativeButtonClicked,
                onDialogStateChange = onDialogStateChange,
                onDismissRequest = onDismissRequest
            )
        }
    }


}

@Composable
fun AlertMsg(
    dialogType: DialogType,
    msgTitle: String,
    msgText: String,
    imgResource: ImageVector?,
    btnPositiveText: String,
    btnNegativeText: String,
    dialogState: Boolean,
    onDialogPositiveButtonClicked: (() -> Unit)?,
    onDialogNegativeButtonClicked: (() -> Unit)?,
    onDialogStateChange: ((Boolean) -> Unit)?,
    onDismissRequest: (() -> Unit)?,
) {

    if (dialogState) {
        AlertDialog(
            onDismissRequest = {
                onDialogStateChange?.invoke(false)
                onDismissRequest?.invoke()
            },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = false
            ),
            shape = RoundedCornerShape(16.dp),
            title = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (dialogType != DialogType.NONE && imgResource != null){
                        Image(
                            imageVector = imgResource,
                            contentDescription = null,
                            modifier = Modifier.size(64.dp),
                            colorFilter = ColorFilter.tint(
                                if (dialogType == DialogType.ERROR) Color.Red else Color.Yellow
                            )
                        )
                    }

                    Text(
                        modifier = Modifier.padding(12.dp,0.dp,0.dp,0.dp),
                        text = msgTitle,
                    )
                }
            },
            text = {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = msgText
                )
            },
            confirmButton = {
                GenericButton(
                    buttonType = ButtonType.HIGH_EMPHASIS,
                    text = btnPositiveText
                ) {
                    onDialogStateChange?.invoke(false)
                    onDialogPositiveButtonClicked?.invoke()
                }
            },
            dismissButton = {
                GenericButton(
                    buttonType = ButtonType.LOW_EMPHASIS,
                    text = btnNegativeText
                ) {
                    onDialogStateChange?.invoke(false)
                    onDialogNegativeButtonClicked?.invoke()
                }
            }
        )
    }
}

@Composable
fun OkOnlyMsg(
    msgText: String,
    btnText: String,
    imgResource: ImageVector?,
    dialogState: Boolean,
    onDialogPositiveButtonClicked: (() -> Unit)?,
    onDialogStateChange: ((Boolean) -> Unit)?,
    onDismissRequest: (() -> Unit)?,
) {
    if (dialogState) {
        AlertDialog(
            onDismissRequest = {
                onDialogStateChange?.invoke(false)
                onDismissRequest?.invoke()
            },
            shape = RoundedCornerShape(16.dp),
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = false
            ),
            title = null,
            text = null,
            buttons = {
                Column{
                    imgResource?.let {
                        Image(
                            imageVector = imgResource,
                            contentDescription = null,
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    Row(Modifier.padding(all = 24.dp)){
                        Text(
                            text = msgText
                        )
                    }
                    Divider(color = MaterialTheme.colors.primary, thickness = 1.dp)

                    Row(
                        modifier = Modifier.padding(all = 8.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        GenericButton(
                            modifier = Modifier.fillMaxWidth(),
                            buttonType = ButtonType.LOW_EMPHASIS,
                            text = btnText
                        ) {
                            onDialogStateChange?.invoke(false)
                            onDialogPositiveButtonClicked?.invoke()
                        }
                    }
                }

            }
        )
    }
}