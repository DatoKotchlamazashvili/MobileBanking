package com.example.mobilebanking.presentation.screen.my_profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilebanking.presentation.design_system.field.CwInputEditField

@Composable
fun EditProfileScreen(
    modifier: Modifier = Modifier,
    fullName: String,
    email: String,
    phoneNumber: String,
    joinedAt: String,
    onEmailChanged: (String) -> Unit,
    onPhoneNumberChanged: (String) -> Unit,
    onFullNameChanged: (String) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterStart)
            )

            Text(
                text = "Edit Profile",
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                modifier = Modifier
                    .size(90.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = fullName, fontWeight = FontWeight.Medium, fontSize = 17.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Senior Designer", fontSize = 13.sp, color = Color.Gray)
        }

        Spacer(modifier = Modifier.height(32.dp))

        CwInputEditField(
            value = fullName,
            onValueChange = onFullNameChanged,
            title = "Full Name",
            hint = "Tanya Myroniuk",
            leadingIconRes = Icons.Default.Person
        )

        Spacer(modifier = Modifier.height(24.dp))

        CwInputEditField(
            value = email,
            onValueChange = onEmailChanged,
            title = "Email Address",
            hint = "tanya.myroniuk@gmail.com",
            leadingIconRes = Icons.Default.Email
        )

        Spacer(modifier = Modifier.height(24.dp))

        CwInputEditField(
            value = phoneNumber,
            onValueChange = onPhoneNumberChanged,
            title = "Phone Number",
            hint = "+8801712663389",
            leadingIconRes = Icons.Default.Call
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "Birth Date", color = Color.Gray)
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "28")
            Text(text = "September")
            Text(text = "2000")
        }

        Spacer(modifier = Modifier.height(48.dp))

        Text(
            text = "Joined $joinedAt",
            color = Color.Gray,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}


@Preview
@Composable
private fun EditProfileScreenPreview() {
    Surface {
        EditProfileScreen(
            fullName = "DAto kotchla",
            email = "dato@gmial.com",
            phoneNumber = "+995576435345",
            joinedAt = "21 sep 2024",
            onEmailChanged = {},
            onPhoneNumberChanged = { }
        ) { }
    }
}