package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp

data class CheckInfo(
    val title: String,
    var selected: Boolean = false,
    var onCheckedChange: (Boolean) -> Unit
)

@Composable
fun MyRadioButtonList(name: String, onItemSelected: (String) -> Unit) {


    Column(Modifier.fillMaxWidth()) {
        Row() {
            RadioButton(name == "Example 1", onClick = { onItemSelected("Example 1") })

            Text(text = "Example 1")
        }

        Row() {
            RadioButton(name == "Example 2", onClick = { onItemSelected("Example 2") })

            Text(text = "Example 2")
        }

        Row() {
            RadioButton(name == "Example 3", onClick = { onItemSelected("Example 3") })

            Text(text = "Example 3")
        }

        Row() {
            RadioButton(name == "Example 4", onClick = { onItemSelected("Example 4") })

            Text(text = "Example 4")
        }
    }
}


@Composable
fun MyRadioButton() {

    Row(Modifier.fillMaxWidth()) {
        RadioButton(
            selected = true, onClick = { }, colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Yellow,
                disabledSelectedColor = Color.Green,
            )
        )
    }
}


@Composable
fun MyTriStatusCheckBox() {
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }

    TriStateCheckbox(modifier = Modifier.padding(8.dp), state = status, onClick = {
        status = when (status) {
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })
}


@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var status by rememberSaveable {
            mutableStateOf(false)
        }

        CheckInfo(title = it, selected = status, onCheckedChange = { status = it })
    }
}

@Composable
fun MyCheckBoxWithTextCompleted(checkInfo: CheckInfo) {

    Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) },
        )
        Spacer(modifier = Modifier.width(8.dp))

        Text(text = checkInfo.title)
    }
}


@Composable
fun MyCheckBoxWithText() {
    var state by rememberSaveable {
        mutableStateOf(true)
    }

    Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = state,
            onCheckedChange = { state = !state },

            )
        Spacer(modifier = Modifier.width(8.dp))

        Text(text = "This is a checkbox")
    }
}


@Composable
fun MyCheckBox() {
    var state by rememberSaveable {
        mutableStateOf(true)
    }

    Checkbox(
        checked = state,
        onCheckedChange = { state = !state },
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Blue,
            uncheckedColor = Color.Cyan,
            checkmarkColor = Color.Magenta
        )
    )
}


@Composable
fun MySwitch() {
    var state by rememberSaveable {
        mutableStateOf(true)
    }

    Switch(
        checked = state,
        onCheckedChange = { state = !state },
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,
            uncheckedTrackColor = Color.Cyan,
            checkedThumbColor = Color.Green,
            checkedTrackColor = Color.Magenta,
            disabledUncheckedThumbColor = Color.Gray,
            disabledUncheckedTrackColor = Color.Gray,
            disabledCheckedThumbColor = Color.Gray,
            disabledCheckedTrackColor = Color.Gray
        )
    )
}