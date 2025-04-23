package de.syntax_institut.kotlinvorlage.woche5

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

@Serializable
object StartRoute

@Serializable
object PredictionRoute


@Composable
fun AppStart() {
    val navController = rememberNavController()
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = StartRoute,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable<StartRoute> {
                StartScreen(
                    onNavigateToPrediction = { navController.navigate(PredictionRoute) }
                )
            }

            composable<PredictionRoute> {
                PredictionScreen()
            }
        }

    }
}

@Composable
fun StartScreen(onNavigateToPrediction: () -> Unit, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = { onNavigateToPrediction() }) {
            Text("Vohersage")
        }
    }
}

@Composable
fun PredictionScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Yellow, Color.Red, Color.White)
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Ein Abenteuer erwartet dich!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

@Preview
@Composable
fun AppStartPreview() {
    AppStart()
}