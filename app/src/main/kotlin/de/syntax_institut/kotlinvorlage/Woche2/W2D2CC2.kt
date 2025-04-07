import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GreetingPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)) // Light gray background like in the image
            .padding(16.dp)
    ) {
        // Hallo mit smiley
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Hallo ",
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal
            )
            Text(
                text = "☺",
                fontSize = 20.sp
            )
        }

        // Links - Rechts row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Links",
                fontSize = 18.sp,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "Rechts",
                fontSize = 18.sp
            )
        }

        // Mittendrin in blue box
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue)
                .padding(vertical = 32.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Mittendrin",
                fontSize = 22.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Yellow
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GreetingPreview()
}