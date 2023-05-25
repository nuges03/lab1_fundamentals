package com.raywenderlich.android.lab1.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raywenderlich.android.lab1.router.BackButtonHandler
import com.raywenderlich.android.lab1.router.FundamentalsRouter
import com.raywenderlich.android.lab1.router.Screen

@Composable
fun ExploreButtonsScreen() {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        MyButton()
        MyRadioGroup()
        MyFloatingActionButton()

        BackButtonHandler {
            FundamentalsRouter.navigateTo(Screen.Navigation)
        }
    }
}

@Composable
fun MyButton() {
    var count by remember { mutableStateOf(0) }

    Button(
        onClick = { count++ },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Blue,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(16.dp)
            .size(40.dp)
    ) {
        Text(
            text = "+",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }

    Text(
        text = "Count: $count",
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        ),
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun MyRadioGroup() {
    val colors = listOf(
        Color.Blue,
        Color.Red,
        Color.Green
    )
    val selectedColor = remember { mutableStateOf(colors[0]) }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        RadioButtonGroup(
            selectedColor = selectedColor.value,
            onColorSelected = { color ->
                selectedColor.value = color
            }
        )

        Box(
            modifier = Modifier
                .width(200.dp)
                .height(50.dp)
                .background(selectedColor.value)
        )
    }
}

@Composable
fun RadioButtonGroup(
    selectedColor: Color,
    onColorSelected: (Color) -> Unit
) {
    val colors = listOf(
        Color.Blue,
        Color.Red,
        Color.Green
    )

    Row(
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        colors.forEach { color ->
            val isSelected = color == selectedColor
            RadioButton(
                selected = isSelected,
                onClick = { onColorSelected(color) },
                colors = RadioButtonDefaults.colors(
                    selectedColor = color
                )
            )
        }
    }
}

@Composable
fun MyFloatingActionButton(
) {
    FloatingActionButton(
        onClick = {

        },
        modifier = Modifier.height(50.dp),
        backgroundColor =Color.Blue,
        contentColor = Color.White
    ){
        Icon(Icons.Default.Person, contentDescription = "icon")
    }
}

