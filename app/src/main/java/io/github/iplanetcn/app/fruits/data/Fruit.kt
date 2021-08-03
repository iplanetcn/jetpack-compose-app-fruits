package io.github.iplanetcn.app.fruits.data

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
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Fruit

        if (id != other.id) return false
        if (title != other.title) return false
        if (headline != other.headline) return false
        if (image != other.image) return false
        if (!gradientColors.contentEquals(other.gradientColors)) return false
        if (description != other.description) return false
        if (!nutrition.contentEquals(other.nutrition)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + headline.hashCode()
        result = 31 * result + image
        result = 31 * result + gradientColors.contentHashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + nutrition.contentHashCode()
        return result
    }

}