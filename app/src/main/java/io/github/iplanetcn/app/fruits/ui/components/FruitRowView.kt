package io.github.iplanetcn.app.fruits.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.iplanetcn.app.fruits.FruitDetailActivity
import io.github.iplanetcn.app.fruits.data.Fruit
import io.github.iplanetcn.app.fruits.data.fruitData
import io.github.iplanetcn.app.fruits.ui.theme.JetpackComposeAppFruitsTheme

@Composable
fun FruitRowView(fruit: Fruit) {
    val context = LocalContext.current

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.background(Color.White)
            .padding(8.dp)
            .clickable(role = Role.Button) {
                FruitDetailActivity.start(context, fruit.id)
            }
    ) {
        // icon
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(80.dp)
                .clip(shape = RoundedCornerShape(8.dp))
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

        Column {
            //FRUIT TITLE
            Text(
                text = fruit.title,
                color = Color.Black,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    letterSpacing = 0.15.sp
                ),
            )

            //FRUIT HEADLINE
            Text(
                text = fruit.headline,
                color = Color.Gray,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    letterSpacing = 0.sp
                )
            )
        }
    }
}


@Preview(
    name = "Light Mode",
    showBackground = true)
@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun FruitRowViewPreview() {
    JetpackComposeAppFruitsTheme {
        FruitRowView(fruitData[0])
    }
}