package io.github.iplanetcn.app.fruits.ui.components

import android.app.Activity
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.iplanetcn.app.fruits.data.Fruit
import io.github.iplanetcn.app.fruits.data.fruitData
import io.github.iplanetcn.app.fruits.ui.theme.DarkCardColor
import io.github.iplanetcn.app.fruits.ui.theme.JetpackComposeAppFruitsTheme
import io.github.iplanetcn.app.fruits.ui.theme.LightCardColor
import java.util.*

@Composable
fun FruitDetailView(fruit: Fruit) {
    val statusBarTop = WindowInsets.systemBars.asPaddingValues().calculateTopPadding()
    val activity = LocalContext.current as? Activity
    val isDefault = remember { mutableStateOf(true) }
    val imageScale: Float by animateFloatAsState(
        if (isDefault.value) 0.5f else 1f, animationSpec = tween(
            durationMillis = 300, delayMillis = 50, easing = FastOutLinearInEasing
        ), label = "ImageScale"
    )

    val cardColor: Color =  if (isSystemInDarkTheme()) DarkCardColor else LightCardColor


    LaunchedEffect(true) {
        isDefault.value = false
    }

    Scaffold {
        Box(modifier = Modifier.padding(it)) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                // Image
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(0.8f)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    fruit.gradientColors.first(), fruit.gradientColors.last()
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
                        fontWeight = FontWeight.Bold, fontSize = 32.sp, letterSpacing = 0.15.sp
                    ),
                )

                //FRUIT HEADLINE
                Text(
                    text = fruit.headline,
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 24.sp,
                        letterSpacing = 0.sp,
                    ),
                    modifier = Modifier.padding(horizontal = 8.dp),
                )

                //NUTRIENT
                FruitNutrientView(modifier = Modifier.padding(horizontal = 8.dp), fruit = fruit)
                //SUBHEADING
                Text(
                    text = "Learn more about ${fruit.title}".uppercase(Locale.ENGLISH),
                    color = fruit.gradientColors.last(),
                    style = TextStyle(
                        fontWeight = FontWeight.Normal, fontSize = 20.sp, letterSpacing = 0.sp
                    ),
                    modifier = Modifier.padding(horizontal = 8.dp)
                )

                //description
                Text(
                    text = fruit.description, style = TextStyle(
                        fontWeight = FontWeight.Normal, fontSize = 18.sp, letterSpacing = 0.sp
                    ), modifier = Modifier.padding(horizontal = 8.dp)
                )

                // link
                SourceLinkView(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    keyword = fruit.title
                )

                Spacer(modifier = Modifier.height(32.dp))

            }

            IconButton(modifier = Modifier
                .padding(horizontal = 16.dp, vertical = statusBarTop)
                .background(
                    color = cardColor, shape = RoundedCornerShape(48.dp)
                ), onClick = {
                activity?.finish()
            }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = "Back Icon",
                    tint = Color.White
                )
            }
        }
    }
}

@Preview(name = "Light theme", uiMode = UI_MODE_NIGHT_NO, showSystemUi = true)
@Preview(name = "Dark theme", uiMode = UI_MODE_NIGHT_YES, showSystemUi = true)
@Composable
fun FruitDetailViewPreview() {
    JetpackComposeAppFruitsTheme {
        FruitDetailView(fruitData.first())
    }
}

