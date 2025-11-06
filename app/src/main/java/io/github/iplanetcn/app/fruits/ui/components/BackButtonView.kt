package io.github.iplanetcn.app.fruits.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.iplanetcn.app.fruits.ui.theme.JetpackComposeAppFruitsTheme

/**
 * BackButtonView
 *
 * @author john
 * @since 2021-08-03
 */
@Composable
fun BackButtonView(modifier: Modifier = Modifier, onClick: () -> Unit) {
    TextButton(
        onClick,
        modifier
            .background(color = MaterialTheme.colors.background.copy(alpha = 0.5f), shape = CircleShape)
            .width(48.dp)
            .height(48.dp)
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "icon arrow back",
            tint = MaterialTheme.colors.onBackground,
            modifier = Modifier.size(32.dp)
        )
    }
}

@Preview(name = "Light theme", uiMode = UI_MODE_NIGHT_NO, showSystemUi = false)
@Preview(name = "Dark theme", uiMode = UI_MODE_NIGHT_YES, showSystemUi = false)
@Composable
fun BackButtonViewPreview() {
    JetpackComposeAppFruitsTheme {
        BackButtonView {}
    }
}