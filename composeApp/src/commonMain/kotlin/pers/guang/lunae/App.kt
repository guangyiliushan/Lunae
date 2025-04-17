package pers.guang.lunae


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview


import lunae.composeapp.generated.resources.Res
import lunae.composeapp.generated.resources.compose_multiplatform


sealed class Screen(val route: String, val label: String, val icon: ImageVector) {
    data object Home : Screen("home", "Home", Icons.Default.Home)
    data object Settings : Screen("settings", "Settings", Icons.Default.Settings)
}


@Composable
@Preview
fun App() {
    MaterialTheme {
        var selectedScreen by remember { mutableStateOf<Screen>(Screen.Home) }
        Column(Modifier.fillMaxWidth()) {
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                when (selectedScreen) {
                    is Screen.Home -> HomeScreen()
                    is Screen.Settings -> SettingsScreen()
                }
            }

            // 底部导航栏
            BottomNavigation(
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = MaterialTheme.colors.onPrimary,
                modifier = Modifier.fillMaxWidth()
            ) {
                BottomNavigationItem(
                    selected = selectedScreen is Screen.Home,
                    onClick = { selectedScreen = Screen.Home },
                    icon = { Icon(Screen.Home.icon, contentDescription = Screen.Home.label) },
                    label = { Text(Screen.Home.label) }
                )
                BottomNavigationItem(
                    selected = selectedScreen is Screen.Settings,
                    onClick = { selectedScreen = Screen.Settings },
                    icon = { Icon(Screen.Settings.icon, contentDescription = Screen.Settings.label) },
                    label = { Text(Screen.Settings.label) }
                )
            }
        }
    }
}


@Composable
fun HomeScreen() {
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Welcome to the Home Screen!")
        val greeting = remember { Greeting().greet() }
        var showContent by remember { mutableStateOf(false) }
        Button(onClick = { showContent = !showContent }) {
            Text("Toggle Content")
        }
        AnimatedVisibility(showContent) {
            Text("Compose: $greeting")
        }
        Image(painterResource(Res.drawable.compose_multiplatform), null)
    }
}



@Composable
fun SettingsScreen() {
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Welcome to the Settings Screen!")
    }
}


