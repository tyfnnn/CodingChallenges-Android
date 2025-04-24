package de.syntax_institut.kotlinvorlage.woche5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

data class Contact(
    val name: String,
    val phone: String
)

val contacts = listOf(
    Contact("John Doe", "123-456-7890"),
    Contact("Jane Smith", "987-654-3210"),
    Contact("Bob Johnson", "555-555-5555"),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppStart()
        }
    }
}


@Composable
fun AppStart1() {
    val navController = rememberNavController()
    Scaffold { innerPadding ->

        // NavHost

        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun DetailScreen(modifier: Modifier = Modifier, viewModel: DetailScreenViewModel = viewModel()) {


    Column(modifier = modifier.padding(24.dp)) {
        Text("Name: ", fontSize = 36.sp)
        Text("Nummer: ", fontSize = 24.sp)
    }
}

class DetailScreenViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    // Coding Challenge 2
}


@Composable
fun HomeScreen(modifier: Modifier = Modifier, onNavigateToDetail: (Contact) -> Unit) {
    LazyColumn(modifier = modifier) {
        // items( items: List<T>, ...) auswählen
        items(contacts) { contact ->
            Row(
                Modifier
                    .padding(16.dp)
                    .clickable { onNavigateToDetail(contact) }) {
                Text(contact.name, fontWeight = FontWeight.ExtraBold)
                Spacer(Modifier.weight(1f))
                Text(contact.phone)
            }
        }
    }
}