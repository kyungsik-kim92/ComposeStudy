package com.example.calendarpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calendarpractice.ui.theme.ComposeStudyTheme
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                CalendarApp()

            }
        }
    }
}


@Composable
fun CalendarApp() {
    val calendarInstance = Calendar.getInstance()
    val time = remember {
        mutableStateOf(calendarInstance)

    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        CalendarHeader(time)
        CalendarHeaderBtn(time)
        CalendarDayName()
        CalendarDayList(time)
    }
}

@Composable
fun CalendarHeader(date: MutableState<Calendar>) {
    val resultTime = SimpleDateFormat("yyyy년 MM월", Locale.KOREA).format(date.value.time)

    Text(
        text = resultTime,
        fontSize = 30.sp
    )
}

@Composable
fun CalendarHeaderBtn(date: MutableState<Calendar>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp, bottom = 30.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Button(onClick = {
            val newDate = Calendar.getInstance()
            newDate.time = date.value.time
            newDate.add(Calendar.MONTH, -1)
            date.value = newDate
        }) {
            Text(text = "<")

        }

        Button(onClick = {
            val newDate = Calendar.getInstance()
            newDate.time = date.value.time
            newDate.add(Calendar.MONTH, +1)
            date.value = newDate
        }) {
            Text(text = ">")
        }

    }
}

@Composable
fun CalendarDayName() {
    val nameList: List<String> = listOf("일", "월", "화", "수", "목", "금", "토")
    Row {
        nameList.forEach {
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = it,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun CalendarDayList(date: MutableState<Calendar>) {
    date.value.set(Calendar.DAY_OF_MONTH, 1)

    val monthDayMax = date.value.getActualMaximum(Calendar.DAY_OF_MONTH)
    val monthFirstDay = date.value.get(Calendar.DAY_OF_WEEK) - 1
    val monthWeekCount = (monthDayMax + monthFirstDay + 6) / 7


    Column {
        repeat(monthWeekCount) { week ->
            Row() {
                repeat(7) { day ->

                    val resultDay = week * 7 + day - monthFirstDay + 1

                    if (resultDay in 1..monthDayMax) {
                        Box(modifier = Modifier.weight(1f)
                            .padding(10.dp),
                            contentAlignment = Alignment.Center
                            ) {
                            Text(text = resultDay.toString(), fontSize = 15.sp)
                        }
                    } else {
                        Spacer(modifier = Modifier.weight(1f))
                    }


                }
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeStudyTheme {
        CalendarApp()
    }
}