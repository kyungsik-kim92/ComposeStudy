package com.example.graphstudypractice

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.graphstudypractice.ui.theme.ComposeStudyTheme

@Composable
fun Graph1() {

    Text(
        text = "1",
        fontSize = 30.sp
    )

}

@Preview(showBackground = true)
@Composable
fun Graph1Preview() {
    ComposeStudyTheme {
        Graph1()
    }
}