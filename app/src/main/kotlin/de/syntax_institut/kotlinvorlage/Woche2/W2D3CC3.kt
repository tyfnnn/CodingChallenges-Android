package de.syntax_institut.kotlinvorlage.Woche2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val movies = listOf(
    Movie("The Shawshank Redemption", 9.2),
    Movie("The Godfather", 9.2),
    Movie("The Dark Knight", 9.0),
    Movie("Pulp Fiction", 8.9),
    Movie("The Lord of the Rings: The Return of the King", 8.9),
    Movie("Inception", 8.8),
    Movie("Fight Club", 8.8),
    Movie("The Matrix", 8.7),
    Movie("Forrest Gump", 8.7),
    Movie("The Silence of the Lambs", 8.6),
    Movie("Pulp Fiction", 8.6)
)

data class Movie(val title: String, val rating: Double)

@Composable
fun MoviesList() {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(movies) { movie ->
            MovieItem(movie = movie)
        }
    }
}

@Composable
fun MovieItem(movie: Movie) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Text(
                text = movie.rating.toString(),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MoviesListPreview() {
    MoviesList()
}