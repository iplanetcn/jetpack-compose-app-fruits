package io.github.iplanetcn.app.fruits.ui.components

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.iplanetcn.app.fruits.ui.theme.JetpackComposeAppFruitsTheme
import io.github.iplanetcn.app.fruits.ui.theme.Typography


@Composable
fun SourceLinkView(modifier: Modifier = Modifier, keyword: String = String()) {
    val context = LocalContext.current
    val annotatedText = with(AnnotatedString.Builder()) {
        pushStyle(
            style = SpanStyle(
                color = Color.Blue,
                textDecoration = TextDecoration.Underline
            )
        )
        append("Wikipedia")
        // attach a string annotation that stores a URL to the text "Jetpack Compose".
        addStringAnnotation(
            tag = "URL",
            annotation = "https://en.wikipedia.org/wiki/$keyword",
            start = 0,
            end = 8
        )
        toAnnotatedString()
    }

    Row(
        modifier = modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .background(color = Color(0x10000000))
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .animateContentSize()
    ) {
        Text(
            text = "Content source",
            modifier = Modifier.weight(1f),
            style = Typography.body1,
        )

        ClickableText(
            text = annotatedText,
            onClick = { offset ->
                annotatedText.getStringAnnotations(tag = "URL", start = offset, end = offset)
                    .firstOrNull()?.let { annotation ->
                        Log.d("ClickableText", "$annotation is clicked.")
                        // open wikipedia link
                        context.startActivity(
                            Intent(Intent.ACTION_VIEW).setData(
                                Uri.parse(
                                    annotation.item
                                )
                            )
                        )
                    }
            }
        )

        Spacer(modifier = Modifier.width(4.dp))

        Icon(
            imageVector = Icons.Filled.Send,
            contentDescription = "jump icon",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview
@Composable
fun SourceLinkViewPreview() {
    JetpackComposeAppFruitsTheme {
        SourceLinkView()
    }
}