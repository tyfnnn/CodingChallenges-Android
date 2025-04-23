package de.syntax_institut.kotlinvorlage.woche5

import android.R.attr.onClick
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

data class Todo(
    val name: String,
    val description: String,
    val done: Boolean
)

val TODOS = listOf(
    Todo("Einkauf erledigen", "Milch, Brot, und Eier im Supermarkt kaufen", false),
    Todo("Meeting vorbereiten", "Präsentation für das wöchentliche Team-Meeting erstellen", true),
    Todo("Fitnessstudio besuchen", "Trainingseinheit für Beine und Rücken absolvieren", false),
    Todo("Buch lesen", "Kapitel 5 des aktuellen Romans fertig lesen", false),
    Todo("Rechnung bezahlen", "Stromrechnung für diesen Monat begleichen", true),
    Todo("E-Mails beantworten", "Alle offenen E-Mails im Posteingang durchgehen und beantworten", false),
    Todo("Auto waschen", "Auto innen und außen reinigen", false),
    Todo("Arzttermin vereinbaren", "Jahres-Check-up beim Hausarzt vereinbaren", false),
    Todo("Projektstatus aktualisieren", "Projektfortschritt in der Team-Software dokumentieren", true),
    Todo("Pflanzen gießen", "Alle Zimmerpflanzen bewässern", false)
)

class TaskMasterViewModel : ViewModel() {
    private val _todos = MutableStateFlow(TODOS)
    val todos = _todos.asStateFlow()

    fun toggleTodoDone(index: Int) {
        val currentTodos = _todos.value.toMutableList()
        val todoToUpdate = currentTodos[index]
        currentTodos[index] = todoToUpdate.copy(done = !todoToUpdate.done)
        _todos.value = currentTodos
    }

    fun clearTodos() {
        _todos.value = emptyList()
    }
}

@Composable
fun TaskMasterApp() {
    val viewModel: TaskMasterViewModel = viewModel()
    val todos = viewModel.todos.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Meine Todo-Liste",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Clear button
        Button(
            onClick = { viewModel.clearTodos() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text("Liste leeren")
        }

        LazyColumn {
            items(todos.size) { index ->
                TodoItem(
                    todo = todos[index],
                    onToggleDone = { viewModel.toggleTodoDone(index) }
                )
            }
        }
    }
}

@Composable
fun TodoItem(
    todo: Todo,
    onToggleDone: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onToggleDone() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(
                        color = if (todo.done) Color.Green else Color.Red,
                        shape = CircleShape
                    )
            )

            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f)
            ) {
                Text(
                    text = todo.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = if (todo.done) FontWeight.Normal else FontWeight.Bold
                )
                Text(
                    text = todo.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TaskMasterAppPreview() {
    TaskMasterApp()
}