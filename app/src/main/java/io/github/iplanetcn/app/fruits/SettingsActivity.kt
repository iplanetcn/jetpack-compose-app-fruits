package io.github.iplanetcn.app.fruits

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
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.Brush
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.PhoneAndroid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import io.github.iplanetcn.app.fruits.ui.components.SettingsLabelView
import io.github.iplanetcn.app.fruits.ui.components.SettingsRowView
import io.github.iplanetcn.app.fruits.ui.theme.ColorLimeLight
import io.github.iplanetcn.app.fruits.ui.theme.JetpackComposeAppFruitsTheme
import io.github.iplanetcn.app.fruits.ui.theme.Typography

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
fun SettingsAppBar() {
    val context = LocalContext.current

    TopAppBar(
        modifier = Modifier.padding(top = 32.dp),
        backgroundColor = Color.White,
        elevation = 0.dp,
    ) {
        Text(
            text = "Settings",
            textAlign = TextAlign.Center,
            style = Typography.h4,
            modifier = Modifier
                .padding(8.dp)
                .wrapContentSize(Alignment.Center)
        )

        Spacer(modifier = Modifier.weight(1f))

        IconButton(onClick = {
            if (context is SettingsActivity) {
                context.finish()
            }
        }) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "", tint = Color.Black)
        }
    }
}


@Composable
fun SettingsView() {
    Scaffold(
        topBar = { SettingsAppBar() },
        content = {
            SettingsContentView()
        }
    )
}

@Composable
fun SettingsContentView() {
    val checkedState = remember{ mutableStateOf(true) }

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
            // Section One
            Box(
                modifier = Modifier.background(Color(0, 0, 0, 8), shape = RoundedCornerShape(16.dp))
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
            Box(
                modifier = Modifier.background(Color(0, 0, 0, 8), shape = RoundedCornerShape(16.dp))
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
                        Text(
                            color = if (checkedState.value) ColorLimeLight else Color.DarkGray,
                            text = if (checkedState.value)  "RESTARTED" else "RESTART",
                            style = Typography.button
                        )
                        Spacer(Modifier.weight(1f, true))
                        Switch(
                            checked = checkedState.value,
                            onCheckedChange = {
                                checkedState.value = it
                            },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = ColorLimeLight
                            )
                        )
                        Spacer(modifier = Modifier.padding(16.dp))
                    }
                }
            }

            Spacer(modifier = Modifier.padding(16.dp))

            // Section Three
            Box(
                modifier = Modifier.background(Color(0, 0, 0, 8), shape = RoundedCornerShape(16.dp))
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