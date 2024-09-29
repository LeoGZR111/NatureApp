package com.example.natureapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.natureapp.ui.theme.NatureAppTheme

data class NaturalPlace(
    val name: String,
    val description: String,
    val imageUrl: String
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val places = listOf(
            NaturalPlace(
                name = "Parque Nacional Yosemite",
                description = "Famoso por sus impresionantes acantilados de granito y cascadas. Ubicada en el estado de California.",
                imageUrl = "https://www.visittheusa.co/sites/default/files/styles/hero_l/public/images/hero_media_image/2016-10/Yosemite_CROPPED_Web72DPI.jpg?itok=yh64rimD"
            ),
            NaturalPlace(
                name = "Gran Barrera de Coral",
                description = "El sistema de arrecifes de coral más grande del mundo. extendiéndose por más de 2,300 kilómetros a lo largo de la costa noreste de Australia, en el Mar de Coral.",
                imageUrl = "https://geoinnova.org/wp-content/uploads/2021/08/Gran-Barrera-de-Coral.jpeg"
            ),
            NaturalPlace(
                name = "Monte Everest",
                description = "La montaña más alta del mundo, ubicada en el Himalaya. con una altura de 8,848 metros sobre el nivel del mar. Se encuentra en la frontera entre Nepal y la Región Autónoma del Tíbet en China. ",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e7/Everest_North_Face_toward_Base_Camp_Tibet_Luca_Galuzzi_2006.jpg/450px-Everest_North_Face_toward_Base_Camp_Tibet_Luca_Galuzzi_2006.jpg"
            ),
            NaturalPlace(
                name = "Selva Amazónica",
                description = "La selva tropical más grande del mundo, rica en biodiversidad, cubriendo aproximadamente 5.5 millones de kilómetros cuadrados en Sudamérica, abarcando nueve países, siendo Brasil el de mayor extensión.",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/5/56/Amazon17_%285641020319%29.jpg/273px-Amazon17_%285641020319%29.jpg"
            )
        )
        setContent {
            NatureAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PlaceList(places = places)
                }
            }
        }
    }
}

@Composable
fun PlaceList(places: List<NaturalPlace>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        items(places) { place ->
            PlaceCard(place = place)
        }
    }
}

@Composable
fun PlaceCard(place: NaturalPlace, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            AsyncImage(
                model = place.imageUrl,
                contentDescription = place.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = place.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = place.description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}