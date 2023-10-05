package com.example.themepractice

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.themepractice.ui.theme.ComposeStudyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RadiusTest2()
                }

            }
        }
    }


    @Composable
    fun RadiusTest1() {

        Column() {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(20.dp)
                    .clip(MaterialTheme.shapes.extraLarge)
                    .background(Color.Red)
            ) {

            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(20.dp)
                    .clip(MaterialTheme.shapes.large)
                    .background(Color.Red)
            ) {

            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(20.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .background(Color.Red)
            ) {

            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(20.dp)
                    .clip(MaterialTheme.shapes.small)
                    .background(Color.Red)
            ) {

            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(20.dp)
                    .clip(MaterialTheme.shapes.extraSmall)
                    .background(Color.Red)
            ) {

            }

        }

    }

    @Composable
    fun RadiusTest2() {

        Column() {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(20.dp)
                    .clip(MaterialTheme.shapes.extraLarge)
                    .background(Color.Blue)
            ) {

            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(20.dp)
                    .clip(MaterialTheme.shapes.large)
                    .background(Color.Blue)
            ) {

            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(20.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .background(Color.Blue)
            ) {

            }


        }

    }


    @Preview(showBackground = true)
    @Composable
    fun TestPreview1() {
        ComposeStudyTheme() {
            RadiusTest2()
        }

    }
}

