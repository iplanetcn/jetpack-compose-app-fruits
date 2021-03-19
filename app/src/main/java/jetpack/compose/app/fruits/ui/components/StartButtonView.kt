package jetpack.compose.app.fruits.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jetpack.compose.app.fruits.R
import jetpack.compose.app.fruits.ui.theme.JetpackComposeAppFruitsTheme

@Composable
fun StartButtonView(onClick: () -> Unit) {
    TextButton(
        onClick,
        Modifier
            .border(width = 1.25.dp, color = Color.White, shape = CircleShape)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            Text(
                text = stringResource(id = R.string.button_text_start),
                color = Color.White,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 20.sp,
                    letterSpacing = 1.25.sp
                )
            )

            Spacer(Modifier.width(8.dp))

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.border(width = 1.25.dp, Color.White, shape = CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = "icon arrow forward",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun StartButtonViewPreview() {
    JetpackComposeAppFruitsTheme {
        StartButtonView {}
    }
}