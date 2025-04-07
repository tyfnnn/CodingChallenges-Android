package de.syntax_institut.kotlinvorlage.Woche3

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppStart1() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Meine App") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue,
                    titleContentColor = Color.White
                )
            )
        },
        bottomBar = {
            BottomAppBar {
                listOf(Icons.Default.Home, Icons.Default.Search, Icons.Default.Person)
                    .forEach {icon ->
                        NavigationBarItem(
                            icon = { Icon(icon, contentDescription = null) },
                            label = null,
                            selected = false,
                            onClick = {  }
                        )
                    }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}, containerColor = Color.Red) {
                Icon(Icons.Default.Add, contentDescription = "Hinzufügen", tint = Color.White)
            }
        }
    ) { padding ->
        Box(Modifier.padding(padding).fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "🏠 Home", style = MaterialTheme.typography.headlineMedium)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview1() {
    AppStart1()
}