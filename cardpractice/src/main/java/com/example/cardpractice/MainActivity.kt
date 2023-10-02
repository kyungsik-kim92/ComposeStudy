package com.example.cardpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cardpractice.ui.theme.ComposeStudyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                Card()
            }
        }
    }
}

@Composable
fun Card() {

    var cardFront by remember {
        mutableStateOf(true)
    }

    val animationDegree by animateFloatAsState(targetValue = if (cardFront) 0f else 180f)
    Box(
        Modifier
            .fillMaxSize()
            .padding(top = 50.dp, bottom = 50.dp, start = 20.dp, end = 20.dp)
            .graphicsLayer {
                rotationY = animationDegree
            }
            .clickable {
                cardFront = !cardFront

            }
            .background(Color.Gray))


}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeStudyTheme {

    }
}