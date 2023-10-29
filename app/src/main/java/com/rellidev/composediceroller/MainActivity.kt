package com.rellidev.composediceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rellidev.composediceroller.ui.theme.ComposeDiceRollerTheme

class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDiceRollerTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    DiceAndButton()
                }
            }
        }
    }
}

fun roll(): Int {
    return (1..6).random()
}

fun findDice(dice: Int): Int
{
    var newDice =  R.drawable.dice_1
    when(dice) {
        1 -> newDice = R.drawable.dice_1
        2 -> newDice = R.drawable.dice_2
        3 -> newDice = R.drawable.dice_3
        4 -> newDice = R.drawable.dice_4
        5 -> newDice = R.drawable.dice_5
        6 -> newDice = R.drawable.dice_6
    }
    return  newDice
}

@Composable
fun DiceAndButton(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)
) {
    var image by remember { mutableStateOf(1) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = findDice(image)),
            contentDescription = "$image"
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { image = roll() },
        ) {
            Text(text = stringResource(R.string.roll))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiceRollerPreview()
{
    ComposeDiceRollerTheme {
        DiceAndButton()
    }
}