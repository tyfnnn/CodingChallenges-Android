package de.syntax_institut.kotlinvorlage.Woche3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyScreen(
    modifier: Modifier = Modifier,
) {
    var isOn by remember { mutableStateOf(true) }

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier.padding(12.dp)
    ) {
        if (isOn) {
            Card(
                modifier = Modifier.width(200.dp)
            ) {
                Text(
                    text = "Ich bin eine Karte.",
                    Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyScreenPreview() {
        MyScreen()
}