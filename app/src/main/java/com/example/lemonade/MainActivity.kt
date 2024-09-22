package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

    var stepCounter by remember { mutableIntStateOf(0) }
    val squeezeCounter = (2..4).random()
    var counter = 0

    val currentImage = when(stepCounter) {
        0 -> painterResource(id = R.drawable.lemon_tree)
        1 -> painterResource(id = R.drawable.lemon_squeeze)
        2 -> painterResource(id = R.drawable.lemon_drink)
        else -> painterResource(id = R.drawable.lemon_restart)
    }

    val currentText = when(stepCounter) {
        0 -> stringResource(id = R.string.select_lemon)
        1 -> stringResource(id = R.string.squeeze_lemon)
        2 -> stringResource(id = R.string.drink_lemonade)
        else -> stringResource(id = R.string.empty_glass)
    }


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Button(
            onClick = {
                if(stepCounter == 3) {
                    stepCounter = 0
                } else {
                    if(stepCounter == 1){
                        if(counter == squeezeCounter){
                            stepCounter++
                        }
                        counter++
                    } else {
                        stepCounter++
                    }

                } },
        ) {
            Image(painter = currentImage, contentDescription = stringResource(
                id = R.string.lemon_tree
            ))
        }

        Spacer(Modifier.padding(16.dp))
        Text(text = currentText)
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadePreview() {
    LemonadeTheme {
        LemonadeApp(Modifier.fillMaxSize())
    }
}