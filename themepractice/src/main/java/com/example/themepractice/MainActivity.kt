package com.example.themepractice

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.themepractice.ui.theme.ComposeStudyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThemeTest1()
            }
        }
    }


@Composable
fun ThemeTest1(){
    ComposeStudyTheme(
        darkTheme = true
    ){
        Surface(
         modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ){
            Text(text = "HELLO")
        }
    }
    
    
    
}
@Preview(showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "LIGHT")
@Preview(showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,name = "DARK")
@Composable
fun TestPreview1() {
    ThemeTest1()
}


//@Preview(showBackground = true,uiMode = Configuration.UI_MODE_NIGHT_YES)
//@Composable
////fun TestPreview2() {
////    ThemeTest1()
////}