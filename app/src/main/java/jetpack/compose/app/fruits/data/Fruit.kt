package jetpack.compose.app.fruits.data

import androidx.compose.ui.graphics.Color
import java.util.*

data class Fruit(
    var id: UUID = UUID.randomUUID(),
    var title: String,
    var headline: String,
    var image: Int,
    var gradientColors: Array<Color>,
    var description: String,
    var nutrition: Array<String>,
)