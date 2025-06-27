package com.example.mobilebanking.presentation.screen.my_profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilebanking.presentation.design_system.image.CwImage
import com.example.mobilebanking.presentation.screen.ChangePassword
import com.example.mobilebanking.presentation.screen.LanguageRoute
import com.example.mobilebanking.ui.theme.Gray100

@Composable
fun MyProfileScreen(
    modifier: Modifier = Modifier, fullName: String,
    role: String,
    profileTabs: List<ProfileTab>,
) {
    Column(modifier = modifier.fillMaxSize().padding(20.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CwImage(imageVector = Icons.AutoMirrored.Filled.ArrowBack)

            Text("Profile", fontWeight = FontWeight.Bold, color = Color.Black)

            CwImage(imageVector = Icons.Default.Edit)

        }
        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                modifier = Modifier.size(70.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f)
            ) {
                Text(
                    fullName,
                    color = Color.Black,
                    fontWeight = FontWeight.Medium,
                    fontSize = 17.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(role, color = Gray100)
            }
        }

        LazyColumn {
            items(profileTabs) { tab ->
                CwProfileTab(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 22.dp),
                    imageResStart = tab.imageRes,
                    name = tab.name,
                )
            }
        }
    }
}


@Preview
@Composable
private fun MyProfileScreenPreview() {
    Surface {
        MyProfileScreen(
            fullName = "davit kotchla",
            role = "Android developer",
            profileTabs = listOf(
                ProfileTab(
                    imageRes = Icons.Default.Language,
                    name = "Language",
                    route = LanguageRoute
                ),
                ProfileTab(
                    imageRes = Icons.Default.Language,
                    name = "Change Password",
                    route = ChangePassword
                )
            )
        )
    }
}