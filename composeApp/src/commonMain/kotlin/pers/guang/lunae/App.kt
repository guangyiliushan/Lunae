package pers.guang.lunae


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
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
    object Home : Screen("home", "Home", Icons.Default.Home)
    object Settings : Screen("settings", "Settings", Icons.Default.Settings)
}


@Composable
@Preview
fun App() {
    MaterialTheme {
        var selectedScreen by remember { mutableStateOf<Screen>(Screen.Home) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            when (selectedScreen) {
                is Screen.Home -> HomeScreen()
                is Screen.Settings -> SettingsScreen()
            }
            BottomNavigation {
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
    }
}


@Composable
fun SettingsScreen() {
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Welcome to the Settings Screen!")
    }
}
