package jetpack.compose.app.fruits.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jetpack.compose.app.fruits.ui.theme.JetpackComposeAppFruitsTheme

/**
 * BackButtonView
 *
 * @author john
 * @since 2021-08-03
 */
@Composable
fun BackButtonView(onClick: () -> Unit) {
    TextButton(
        onClick,
        Modifier
//            .border(width = 1.25.dp, color = Color.White, shape = CircleShape)
//            .background(color = Color(0, 0, 0, 88), shape = CircleShape)
            .width(48.dp)
            .height(48.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "icon arrow forward",
            tint = Color.White,
            modifier = Modifier.size(32.dp)
        )
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun BackButtonViewPreview() {
    JetpackComposeAppFruitsTheme {
        BackButtonView {}
    }
}