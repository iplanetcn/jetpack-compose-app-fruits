package jetpack.compose.app.fruits

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Brush
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.PhoneAndroid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import jetpack.compose.app.fruits.ui.components.SettingsLabelView
import jetpack.compose.app.fruits.ui.components.SettingsRowView
import jetpack.compose.app.fruits.ui.theme.JetpackComposeAppFruitsTheme
import jetpack.compose.app.fruits.ui.theme.Typography

class SettingsActivity : ComponentActivity() {
    companion object {
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, SettingsActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupStatusBarColor(color = Color.Transparent)
        window?.run {
            WindowCompat.setDecorFitsSystemWindows(this, false)
        }
        setContent {
            JetpackComposeAppFruitsTheme {
                Surface(color = MaterialTheme.colors.background) {
                    SettingsView()
                }
            }
        }
    }
}

@Composable
fun SettingsView() {
    val context = LocalContext.current

    Box(
        Modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
        ) {
            // Top
            Spacer(modifier = Modifier.padding(24.dp))

            // Close Button
            Row {
                Spacer(modifier = Modifier.weight(1f, true))
                IconButton(
                    onClick = {
                        if (context is SettingsActivity) {
                            context.finish()
                        }
                    },
                ) {
                    Icon(imageVector = Icons.Outlined.Close, contentDescription = "")
                }
            }

            // Title
            Text(
                text = "Settings",
                style = Typography.h4
            )

            Spacer(modifier = Modifier.padding(16.dp))

            // Section One
            Box (
                modifier = Modifier.background(Color(0,0,0,8), shape = RoundedCornerShape(16.dp))
            ) {
                Column {
                    SettingsLabelView(labelText = "fructus", labelImage = Icons.Outlined.Info)
                    Divider(
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier.size(120.dp),
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo),
                                contentDescription = "icon"
                            )
                        }

                        Spacer(modifier = Modifier.padding(8.dp))
                        Text(text = "Most fruit are naturallt low in fat, sodium, and calories. None have cholesterol. Fruits are sources of many essential nutrients, including potassium, dietary fiber, vitamins, and much more")
                    }
                }
            }

            Spacer(modifier = Modifier.padding(16.dp))

            // Section Two
            Box (
                modifier = Modifier.background(Color(0,0,0,8), shape = RoundedCornerShape(16.dp))
            ) {
                Column {
                    SettingsLabelView(
                        labelText = "Customization",
                        labelImage = Icons.Outlined.Brush
                    )
                    Divider(
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Text(
                        modifier = Modifier.padding(16.dp),
                        text = "If you wish, you can restart the application by toggle the switch in this box. that way it start the onoarding process and you will see the welcome screen again. "
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(16.dp)
                            .height(60.dp)
                            .background(Color.White, shape = RoundedCornerShape(16.dp))
                    ) {
                        Spacer(modifier = Modifier.padding(16.dp))
                        Text(text = "RESTART")
                        Spacer(Modifier.weight(1f, true))
                        Switch(checked = false, onCheckedChange = {
                            // TODO
                        })
                        Spacer(modifier = Modifier.padding(16.dp))
                    }
                }
            }

            Spacer(modifier = Modifier.padding(16.dp))

            // Section Three
            Box (
                modifier = Modifier.background(Color(0,0,0,8), shape = RoundedCornerShape(16.dp))
            ) {
                Column {
                    SettingsLabelView(
                        labelText = "Application",
                        labelImage = Icons.Outlined.PhoneAndroid
                    )
                    SettingsRowView(name = "Developer", content = "John")
                    SettingsRowView(name = "Designer", content = "Robert petras")
                    SettingsRowView(name = "Compatibility", content = "Android Lollipop")
                    SettingsRowView(
                        name = "Website",
                        linkLabel = "Bethel",
                        linkDestination = "Bethel.edu"
                    )
                    SettingsRowView(
                        name = "Website",
                        linkLabel = "Facebook",
                        linkDestination = "facebook.com.edu"
                    )
                    SettingsRowView(name = "Jetpack Compose", content = "1.0.0")
                    SettingsRowView(name = "Version", content = "1.0.0")
                }
            }

            Spacer(modifier = Modifier.padding(16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsActivityPreview() {
    JetpackComposeAppFruitsTheme {
        SettingsView()
    }
}