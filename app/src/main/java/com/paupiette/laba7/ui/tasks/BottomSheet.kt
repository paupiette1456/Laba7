package com.paupiette.laba7.ui.tasks

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
@Preview
@Composable
fun BottomSheet() {
    val scaffoldState = rememberBottomSheetScaffoldState()
    var dialogShown by remember { mutableStateOf(false) }
    val context = LocalContext.current

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetPeekHeight = 128.dp,
        sheetContent = {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(128.dp),
                contentAlignment = Alignment.Center
            ) {
                Text("Свайпните вверх")
            }
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(64.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Контент")
                Spacer(Modifier.height(20.dp))
                Button(
                    onClick = {dialogShown = true}

                ) {
                    Text("Показать диалог")
                }
            }
        })
    {

    }
    AlertDialog(
        dialogShown = dialogShown,
        onDismiss = { dialogShown = false },
        onOkClicked = { Toast.makeText(context, "OK", Toast.LENGTH_SHORT).show() }
    )
}

@Preview
@Composable
fun PreviewBottomSheet() {
    BottomSheet()
}