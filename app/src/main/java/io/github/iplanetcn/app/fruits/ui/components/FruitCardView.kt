package io.github.iplanetcn.app.fruits.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.iplanetcn.app.fruits.MainActivity
import io.github.iplanetcn.app.fruits.data.Fruit
import io.github.iplanetcn.app.fruits.data.fruitData
import io.github.iplanetcn.app.fruits.ui.theme.JetpackComposeAppFruitsTheme

@Composable
fun FruitCardView(fruit: Fruit) {
    val context = LocalContext.current

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .padding(start = 8.dp, top = 16.dp, end = 8.dp, bottom = 16.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        fruit.gradientColors.first(),
                        fruit.gradientColors.last()
                    )
                )
            )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(20.dp))
            //FRUIT IMAGE
            Image(
                painter = painterResource(fruit.image),
                contentDescription = "fruit ${fruit.title} image",
                contentScale = ContentScale.Fit
            )

            //FRUIT TITLE
            Text(
                text = fruit.title,
                color = Color.White,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                    letterSpacing = 0.15.sp,
                    shadow = Shadow(
                        color = Color(0x26000000),
                        offset = Offset(4f, 4f),
                        blurRadius = 4f
                    )
                ),
            )

            //FRUIT HEADLINE
            Text(
                text = fruit.headline,
                color = Color.White,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    letterSpacing = 0.15.sp
                ),
                modifier = Modifier.padding(horizontal = 16.dp),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(20.dp))

            StartButtonView {
                MainActivity.start(context)
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FruitCardViewPreview() {
    JetpackComposeAppFruitsTheme {
        FruitCardView(fruitData.first())
    }
}
