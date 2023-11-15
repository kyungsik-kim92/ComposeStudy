package com.example.slotapipractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Checkbox
import androidx.compose.ui.tooling.preview.Preview
import com.example.slotapipractice.ui.theme.ComposeStudyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SlotEx()
                }
            }
        }
    }
}


@Composable
fun CheckboxWithSlot(
    checked: Boolean,
    onCheckedChanged: () -> Unit, content: @Composable RowScope.() -> Unit
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {
            onCheckedChanged
        }) {
        Checkbox(
            checked = checked,
            onCheckedChange = {onCheckedChanged()}
        )
        content()

    }
}

@Composable
fun SlotEx() {
    var checked1 by remember { mutableStateOf(false) }
    var checked2 by remember { mutableStateOf(false) }

    Column {
        CheckboxWithSlot(checked = checked1, onCheckedChanged =
        { checked1= !checked1 }) {
            Text("텍스트 1")
        }
        CheckboxWithSlot(checked = checked2, onCheckedChanged =
        { checked2 = !checked1}) {
            Text("텍스트 2")
        }

    }

//        Row(verticalAlignment = Alignment.CenterVertically) {
//            Checkbox(
//                checked = checked2.value,
//                onCheckedChange = { checked2.value = it }
//            )
//            Text(
//                text = "텍스트 2",
//                modifier = Modifier.clickable { checked2.value = !checked2.value }
//            )
//        }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeStudyTheme {
        SlotEx()
    }
}