package io.github.iplanetcn.app.fruits.ui.components

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.iplanetcn.app.fruits.data.Fruit
import io.github.iplanetcn.app.fruits.data.fruitData
import io.github.iplanetcn.app.fruits.ui.theme.JetpackComposeAppFruitsTheme
import java.util.*

@Composable
fun FruitDetailView(fruit: Fruit) {
    val isDefault = remember { mutableStateOf(true) }
    val imageScale: Float by animateFloatAsState(
        if (isDefault.value) 0.5f else 1f,
        animationSpec = tween(
            durationMillis = 300,
            delayMillis = 50,
            easing = FastOutLinearInEasing
        )
    )

    LaunchedEffect(true) {
        isDefault.value = false
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        // Image
        Box(
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
                modifier = Modifier
                    .scale(imageScale)
                    .fillMaxSize(),
                painter = painterResource(id = fruit.image),
                contentDescription = "fruit ${fruit.title} icon",
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
        FruitNutrientView(modifier = Modifier.padding(horizontal = 8.dp), fruit = fruit)
        //SUBHEADING
        Text(
            text = "Learn more about ${fruit.title}".uppercase(Locale.ENGLISH),
            color = fruit.gradientColors.last(),
            style = TextStyle(
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
        SourceLinkView(modifier = Modifier.padding(horizontal = 8.dp), keyword = fruit.title)

        Spacer(modifier = Modifier.height(32.dp))

    }
}

@Preview
@Composable
fun FruitDetailViewPreview() {
    JetpackComposeAppFruitsTheme {
        FruitDetailView(fruitData.first())
    }
}