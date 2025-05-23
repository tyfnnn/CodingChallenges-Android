package de.syntax_institut.kotlinvorlage.woche3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CounterTextComposable(count: Int, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Wassertracker",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "$count Gläser",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}

@Composable
fun CounterButtonComposable(
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    count: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = onDecrement,
            enabled = count > 0
        ) {
            Text("Weniger")
        }

        Button(
            onClick = onIncrement
        ) {
            Text("Mehr")
        }
    }
}

@Composable
fun WaterGlassCounter(
    count: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CounterTextComposable(count = count)

            Spacer(modifier = Modifier.height(16.dp))

            CounterButtonComposable(
                onIncrement = onIncrement,
                onDecrement = onDecrement,
                count = count
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WaterCounterPreview() {
    var count by remember { mutableIntStateOf(0) }

    WaterGlassCounter(
        count = count,
        onIncrement = { count++ },
        onDecrement = { if (count > 0) count-- }
    )
}

@Preview(showBackground = true)
@Composable
fun WaterCounterWithDataPreview() {
    var count by remember { mutableIntStateOf(5) }

    WaterGlassCounter(
        count = count,
        onIncrement = { count++ },
        onDecrement = { if (count > 0) count-- }
    )
}