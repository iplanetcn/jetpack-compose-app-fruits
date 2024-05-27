package io.github.iplanetcn.app.fruits.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.iplanetcn.app.fruits.ui.theme.Typography

/**
 * SettingsLabelView
 *
 * @author john
 * @since 2021-08-03
 */
@Composable
fun SettingsLabelView(labelText: String, labelImage: ImageVector) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = labelText.uppercase(),
            style = Typography.h6
        )
        Spacer(Modifier.weight(1f, true))
        Icon(imageVector = labelImage, contentDescription = "information icon")

    }
}

@Composable
@Preview(name = "Light Mode", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
fun SettingsLabelViewPreview() {
    SettingsLabelView(
        labelText = "Fructus",
        labelImage = Icons.Outlined.Info
    )
}