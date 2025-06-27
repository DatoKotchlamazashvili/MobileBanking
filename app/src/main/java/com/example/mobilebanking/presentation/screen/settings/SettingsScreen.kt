package com.example.mobilebanking.presentation.screen.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mobilebanking.presentation.design_system.field.CwNavigateWithText
import com.example.mobilebanking.presentation.design_system.image.CwImage
import com.example.mobilebanking.presentation.screen.LanguageRoute
import com.example.mobilebanking.presentation.screen.MyProfile
import com.example.mobilebanking.presentation.screen.Route
import com.example.mobilebanking.ui.theme.lightGray100


@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    tabs: List<SettingsTab>,
    hasAccessToBiometricData: Boolean = false,
    onBiometricChanged: (Boolean) -> Unit,
    onClick: (Route) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CwImage(imageVector = Icons.AutoMirrored.Filled.ArrowBack)

            Text("My Card", fontWeight = FontWeight.Bold, color = Color.Black)

            CwImage(imageVector = Icons.Default.Add)

        }
        Spacer(modifier = Modifier.height(32.dp))

        tabs.forEach { tab ->
            Text(tab.tabName, color = lightGray100)
            Spacer(modifier = Modifier.height(31.dp))
            tab.child.forEachIndexed { idx, settingsRoute ->
                CwNavigateWithText(
                    modifier = Modifier
                        .clickable { onClick(settingsRoute.route) }
                        .fillMaxWidth()
                        .padding(
                            top = if (idx == 0) 0.dp else 22.dp
                        ),
                    mainText = settingsRoute.mainText,
                    subText = settingsRoute.subText
                )
            }
            Spacer(modifier = Modifier.height(32.dp))

        }

        Row(modifier = Modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween ) {
            Text("Choose what data you share with us", color = lightGray100)
            Switch(hasAccessToBiometricData, onCheckedChange = {onBiometricChanged(it)})

        }
    }
}

data class SettingsRoute(val mainText: String, val subText: String, val route: Route)
data class SettingsTab(val tabName: String, val child: List<SettingsRoute>)


@Preview
@Composable
private fun SettingsScreenPreview() {
    Surface {
        SettingsScreen(
            modifier = Modifier.fillMaxSize(),
            tabs = listOf(
                SettingsTab(
                    tabName = "General",
                    child = listOf(
                        SettingsRoute(
                            mainText = "Language",
                            subText = "English",
                            route = LanguageRoute
                        ),
                        SettingsRoute(
                            mainText = "Language",
                            subText = "Georgia",
                            route = MyProfile
                        )
                    )
                ), SettingsTab(
                    tabName = "General",
                    child = listOf(
                        SettingsRoute(
                            mainText = "Language",
                            subText = "English",
                            route = LanguageRoute
                        ),
                        SettingsRoute(
                            mainText = "Language",
                            subText = "Georgia",
                            route = MyProfile
                        )
                    )
                )
            ),
            onClick = { },
            hasAccessToBiometricData = true,
            onBiometricChanged = {true}
        )
    }
}