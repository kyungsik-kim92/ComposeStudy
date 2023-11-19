package com.example.constraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.example.constraintlayout.ui.theme.ComposeStudyTheme

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
                    ConstraintSetEx()
                }
            }
        }
    }
}

@Composable
fun ConstraintSetEx() {
    val constraintSet = ConstraintSet {
        val redBox = createRefFor("redBox")
        val magentaBox = createRefFor("magentaBox")
        val greenBox = createRefFor("greenBox")
        val yellowBox = createRefFor("yellowBox")

        constrain(redBox){
            bottom.linkTo(parent.bottom, 10.dp)
            end.linkTo(parent.end, 30.dp)
        }

        constrain(magentaBox){
            start.linkTo(parent.start,10.dp)
            end.linkTo(parent.end, 30.dp)
        }

        constrain(greenBox){
            centerTo(parent)
        }

        constrain(yellowBox){
            start.linkTo(greenBox.end)
            top.linkTo(greenBox.bottom)
        }





    }

    // 단계 5: ConstraintLayout의 첫 인자로 ConstraintSet을 전달합니다.
    ConstraintLayout(
        constraintSet,
        modifier = Modifier.fillMaxSize()
    ) {



        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .layoutId("redBox")
//                .constrainAs(redBox) {
//                    bottom.linkTo(parent.bottom, 10.dp)
//                    end.linkTo(parent.end, 30.dp)
//                }
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .layoutId("magentaBox")

//                .constrainAs(magentaBox) {
//                    start.linkTo(parent.start, 10.dp)
//                    end.linkTo(parent.end, 30.dp)
//                }
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Green)
                .layoutId("greenBox")

//                .constrainAs(greenBox) {
//                    centerTo(parent)
//                }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
                .layoutId("yellowBox")

//                .constrainAs(yellowBox) {
//                    start.linkTo(greenBox.end)
//                    top.linkTo(greenBox.bottom)
//                }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeStudyTheme {
        ConstraintSetEx()
    }
}