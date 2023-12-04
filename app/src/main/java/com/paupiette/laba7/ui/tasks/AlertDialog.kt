package com.paupiette.laba7.ui.tasks

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AlertDialog(
    dialogShown: Boolean,
    onDismiss: () -> Unit,
    onOkClicked: () -> Unit
) {

    val context = LocalContext.current
    val version = "1.0.0-alpha"

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        if (dialogShown) {
            AlertDialog(
                onDismissRequest = onDismiss,
                title = {
                    Text("О приложении")
                },
                text = {
                    Text("Вы используете версию $version. Данная версия находится в разработке и можете содеражть баги и вылеты. Используйте на свой страх и риск.")
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            onDismiss()
                            onOkClicked()
                            Toast.makeText(context, "OK", Toast.LENGTH_SHORT).show()
                        }
                    ) {
                        Text("Ок")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            onDismiss()
                        }
                    ) {
                        Text("Назад")
                    }
                }
            )
        }
    }
}
