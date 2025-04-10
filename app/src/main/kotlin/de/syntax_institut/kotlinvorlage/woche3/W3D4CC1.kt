package de.syntax_institut.kotlinvorlage.woche3


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DialogBottomSheetDemo() {
    // State für Dialog und BottomSheet
    var showDialog by remember { mutableStateOf(false) }
    var showBottomSheet by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        // Hauptcontent mit Buttons
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Techdemo: Dialog & BottomSheet",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            // Button für Dialog
            Button(
                onClick = { showDialog = true },
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text("Dialog anzeigen")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Button für BottomSheet
            Button(
                onClick = { showBottomSheet = true },
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text("Modal Bottom Sheet anzeigen")
            }
        }

        // Dialog anzeigen wenn showDialog true ist
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Dialog") },
                text = { Text("Hallo, ich bin ein Dialog!") },
                confirmButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("Schließen")
                    }
                }
            )
        }

        // BottomSheet anzeigen wenn showBottomSheet true ist
        if (showBottomSheet) {
            BottomSheetContent(
                onDismiss = { showBottomSheet = false }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetContent(onDismiss: () -> Unit) {
    val bottomSheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = bottomSheetState
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Hallo, ich bin ein Bottom Sheet!",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { onDismiss() },
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text("Schließen")
            }

            // Spacer am Ende für besseres Layout mit System-Navigation
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Preview
@Composable
fun DialogBottomSheetDemoPreview() {
    DialogBottomSheetDemo()
}