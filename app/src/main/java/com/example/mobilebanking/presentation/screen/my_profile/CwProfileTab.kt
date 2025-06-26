package com.example.mobilebanking.presentation.screen.my_profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mobilebanking.presentation.screen.Route

@Composable
fun CwProfileTab(
    modifier: Modifier = Modifier,
    imageResStart: ImageVector,
    name: String,
    imageResEnd: ImageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
) {

    Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

        Image(imageResStart, contentDescription = null)

        Text(
            text = name, modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
        )

        Image(
            imageVector = imageResEnd,
            contentDescription = null,
        )
    }

}


data class ProfileTab(
    val imageRes: ImageVector,
    val name: String,
    val route: Route,
)


@Preview
@Composable
private fun CwProfileTabPreview() {
    Surface {
        CwProfileTab(
            name = "Messages",
            imageResStart = Icons.AutoMirrored.Filled.Message,
        )
    }
}