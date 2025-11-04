package io.github.iplanetcn.app.fruits.ui.components

import android.content.Intent
import android.content.res.Configuration
import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import io.github.iplanetcn.app.fruits.ui.theme.DarkCardColor
import io.github.iplanetcn.app.fruits.ui.theme.JetpackComposeAppFruitsTheme
import io.github.iplanetcn.app.fruits.ui.theme.LightCardColor
import io.github.iplanetcn.app.fruits.ui.theme.Typography


@Composable
fun SourceLinkView(modifier: Modifier = Modifier, keyword: String = String()) {
    val cardColor: Color =  if (isSystemInDarkTheme()) DarkCardColor else LightCardColor
    val context = LocalContext.current

    Row(
        modifier = modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .background(color = cardColor)
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .animateContentSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Content source",
            modifier = Modifier.weight(1f),
            style = Typography.body1,
        )

        Text(
            text = "Wikipedia",
            color = MaterialTheme.colors.secondaryVariant,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.clickable {
                val linkDestination = "https://en.wikipedia.org/wiki/$keyword"
                Log.d("SettingsRowView", "Link clicked: $linkDestination")
                // open link
                context.startActivity(
                    Intent(Intent.ACTION_VIEW).setData(
                        linkDestination.toUri()
                    )
                )
            }
        )

        Spacer(modifier = Modifier.width(4.dp))

        Icon(
            imageVector = Icons.AutoMirrored.Filled.Send,
            contentDescription = "jump icon",
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview(name = "Light theme", uiMode = Configuration.UI_MODE_NIGHT_NO, showSystemUi = true)
@Preview(name = "Dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true)
@Composable
fun SourceLinkViewPreview() {
    JetpackComposeAppFruitsTheme {
        SourceLinkView()
    }
}