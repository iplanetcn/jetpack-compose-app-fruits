package jetpack.compose.app.fruits.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
                    fontWeight = FontWeight.Bold,
                    text = with(AnnotatedString.Builder()) {
                        append(linkLabel)
                        addStringAnnotation(
                            tag = "URL",
                            annotation = "https://$linkDestination",
                            start = 0, end = length
                        )
                        toAnnotatedString()
                    })
                Icon(
                    imageVector = Icons.Outlined.Share,
                    contentDescription = "",
                    tint = Color.Red
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
    SettingsRowView(name = "Website", linkLabel = "Facebook", linkDestination = "facebook.com")
}