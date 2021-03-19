package jetpack.compose.app.fruits.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jetpack.compose.app.fruits.data.Fruit
import jetpack.compose.app.fruits.data.fruitData
import jetpack.compose.app.fruits.ui.theme.JetpackComposeAppFruitsTheme
import java.util.*

@Composable
fun FruitDetailView(fruit: Fruit) {
    val nutrient = arrayOf("Energy", "Sugar", "Fat", "Protein", "Vitamins", "Minerals")
    var expandedNutrient by remember { mutableStateOf<Array<String>>(emptyArray()) }
    
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        // icon
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(0.8f)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            fruit.gradientColors.first(),
                            fruit.gradientColors.last()
                        )
                    )
                )
        ) {
            Image(
                painter = painterResource(id = fruit.image),
                contentDescription = "fruit icon",
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        //FRUIT TITLE
        Text(
            text = fruit.title,
            color = fruit.gradientColors.last(),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                letterSpacing = 0.15.sp
            ),
        )

        //FRUIT HEADLINE
        Text(
            text = fruit.headline,
            color = Color.Black,
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 24.sp,
                letterSpacing = 0.sp
            ),
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        //NUTRIENT
        FruitNutrientView(modifier = Modifier.padding(horizontal = 8.dp),fruit = fruit, nutrient = nutrient, expended = expandedNutrient.contentEquals(nutrient),onClick = {
            expandedNutrient = if (expandedNutrient.contentEquals(nutrient)) emptyArray() else nutrient
        })
        //SUBHEADING
        Text(
            text = "Learn more about ${fruit.title}".toUpperCase(Locale.ENGLISH),
            color = fruit.gradientColors.last(),
            style =  TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                letterSpacing = 0.sp
            ),
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        //description
        Text(
            text = fruit.description,
            color = Color.Black,
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                letterSpacing = 0.sp
            ),
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        // link
//        SourceLinkView()
    }
}

@Preview
@Composable
fun FruitDetailViewPreview() {
    JetpackComposeAppFruitsTheme {
        FruitDetailView(fruitData.first())
    }
}