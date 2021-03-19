package jetpack.compose.app.fruits.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jetpack.compose.app.fruits.data.Fruit
import jetpack.compose.app.fruits.data.fruitData
import jetpack.compose.app.fruits.ui.theme.JetpackComposeAppFruitsTheme
import jetpack.compose.app.fruits.ui.theme.Typography

@Composable
fun FruitNutrientView(fruit: Fruit, modifier:Modifier = Modifier) {
    val nutrient = arrayOf("Energy", "Sugar", "Fat", "Protein", "Vitamins", "Minerals")

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(20.dp))
            .background(color = Color(0x10000000))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Nutritional value per 100g",
                color = Color.Black,
                style = Typography.body1,
            )

            Icon(
                imageVector = Icons.Outlined.KeyboardArrowRight,
                contentDescription = "icon arrow forward",
                tint = Color.Black,
                modifier = Modifier.size(24.dp).fillMaxWidth(1f)
            )

        }

        nutrient.forEachIndexed { index, item ->
            Divider(color = Color.DarkGray, thickness = 0.5.dp)

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.defaultMinSize(40.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = "icon info",
                    tint = fruit.gradientColors.last(),
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = item,
                    color = fruit.gradientColors.last(),
                    style = Typography.body1,
                    modifier = Modifier.width(100.dp)
                )

                Text(
                    text = fruit.nutrition[index],
                    color = Color.Black,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        letterSpacing = 0.5.sp
                    ),
                    textAlign = TextAlign.End,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Preview
@Composable
fun FruitNutrientViewPreview() {
    JetpackComposeAppFruitsTheme {
        FruitNutrientView(fruitData.first())
    }
}