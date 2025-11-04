package io.github.iplanetcn.app.fruits.ui.components

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Link
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri

/**
 * SettingsRowView
 *
 * @author john
 * @since 2021-08-03
 */
@Composable
fun SettingsRowView(
    name: String,
    content: String? = null,
    linkLabel: String? = null,
    linkDestination: String? = null
) {
    val context = LocalContext.current

    Column(
        Modifier.padding(horizontal = 16.dp)
    ) {
        Divider(
            Modifier.padding(bottom = 16.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = name)

            Spacer(Modifier.weight(1f, true))

            if (content != null) {
                Text(
                    fontWeight = FontWeight.Bold,
                    text = content
                )
            } else if (linkLabel != null && linkDestination != null) {
                Text(
                    text = linkLabel,
                    color = MaterialTheme.colors.secondaryVariant,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.clickable {
                        Log.d("SettingsRowView", "Link clicked: $linkDestination")
                        // open link
                        context.startActivity(
                            Intent(Intent.ACTION_VIEW).setData(
                                linkDestination.toUri()
                            )
                        )
                    }
                )
                Icon(
                    imageVector = Icons.Filled.Link,
                    contentDescription = "",
                    tint = MaterialTheme.colors.secondaryVariant
                )
            }
        }

        Spacer(
            Modifier.padding(bottom = 16.dp)
        )
    }

}

@Preview
@Composable
fun SettingsRowViewPreviewFirst() {
    SettingsRowView(name = "Developer", content = "John")
}

@Preview
@Composable
fun SettingsRowViewPreviewSecond() {
    SettingsRowView(
        name = "Source Code",
        linkLabel = "github",
        linkDestination = "https://github.com"
    )
}