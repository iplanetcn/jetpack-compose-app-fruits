package io.github.iplanetcn.app.fruits.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.iplanetcn.app.fruits.data.Fruit
import io.github.iplanetcn.app.fruits.data.fruitData
import io.github.iplanetcn.app.fruits.ui.theme.JetpackComposeAppFruitsTheme
import io.github.iplanetcn.app.fruits.ui.theme.Typography

@Composable
fun FruitNutrientView(
    modifier: Modifier = Modifier,
    fruit: Fruit
) {
    val nutrient = arrayOf("Energy", "Sugar", "Fat", "Protein", "Vitamins", "Minerals")
    var expandedNutrient by remember { mutableStateOf<Array<String>>(emptyArray()) }

    Column(
        modifier = modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .background(color = Color(0x10000000))
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .animateContentSize(),
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
                modifier = Modifier.weight(1f)
            )

            IconButton(
                onClick = {
                    expandedNutrient =
                        if (expandedNutrient.contentEquals(nutrient)) emptyArray() else nutrient
                },
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowRight,
                    contentDescription = "icon arrow forward",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(24.dp)
                        .rotate(if (expandedNutrient.isNotEmpty()) 90f else 0f)
                )
            }

        }

        if (expandedNutrient.isNotEmpty()) {
            nutrient.forEachIndexed { index, item ->
                Divider(color = Color.DarkGray, thickness = 0.5.dp)

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.defaultMinSize(minHeight = 48.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Info,
                        contentDescription = "icon info",
                        tint = fruit.gradientColors.last(),
                        modifier = Modifier.size(24.dp)
                    )

                    Spacer(modifier = Modifier.width(4.dp))

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
}

@Preview
@Composable
fun FruitNutrientViewPreview() {
    JetpackComposeAppFruitsTheme {
        FruitNutrientView(fruit = fruitData.first())
    }
}