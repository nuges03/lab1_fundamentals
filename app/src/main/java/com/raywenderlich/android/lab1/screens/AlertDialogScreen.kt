package com.raywenderlich.android.lab1.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.raywenderlich.android.lab1.router.BackButtonHandler
import com.raywenderlich.android.lab1.router.FundamentalsRouter
import com.raywenderlich.android.lab1.router.Screen

@Composable
fun AlertDialogScreen() {

    var showDialog by remember { mutableStateOf(false) }

    Button(onClick = { showDialog = true }) {
        Text("Открыть диалоговое окно")
    }

    MyAlertDialog(
        showDialog = showDialog,
        onDismiss = { showDialog = false }
    )

    BackButtonHandler {
        FundamentalsRouter.navigateTo(Screen.Navigation)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyAlertDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit
) {
    if (showDialog) {
        ModalBottomSheetLayout(
            sheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Expanded),
            sheetContent = {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text("Hello world!")
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = { onDismiss() },
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text("Закрыть")
                    }
                }
            },
            content = {

                Box(modifier = Modifier.fillMaxSize()) {

                }
            }
        )
    }
}