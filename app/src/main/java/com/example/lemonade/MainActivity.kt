package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
               LemonadeApp(Modifier.fillMaxSize())
            }
        }
    }
}


@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {

}

@Preview
@Composable
fun LemonadePreview() {
    LemonadeTheme {
        LemonadeApp(Modifier.fillMaxSize())
    }
}