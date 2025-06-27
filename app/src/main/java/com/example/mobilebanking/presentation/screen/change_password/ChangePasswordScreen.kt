package com.example.mobilebanking.presentation.screen.change_password

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilebanking.presentation.design_system.button.CwButton
import com.example.mobilebanking.presentation.design_system.field.CwInputEditField
import com.example.mobilebanking.ui.theme.Gray100

@Composable
fun ChangePasswordScreen(
    modifier: Modifier = Modifier, currentPassword: String,
    newPassword: String, confirmPassword: String,
    onNewPassword: (String) -> Unit,
    onConfirmPassword: (String) -> Unit,
    onClick: () -> Unit,
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier.align(Alignment.CenterStart)
            )
            Text(
                text = "My Cards",
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        CwInputEditField(
            value = currentPassword,
            onValueChange = { },
            leadingIconRes = Icons.Default.Lock,
            hint = "",
            title = "Current Password",
            isSecret = true
        )

        Spacer(modifier = Modifier.height(21.dp))

        CwInputEditField(
            value = newPassword,
            onValueChange = onNewPassword,
            leadingIconRes = Icons.Default.Lock,
            hint = "",
            title = "Current Password",
            isSecret = true
        )

        Spacer(modifier = Modifier.height(21.dp))
        CwInputEditField(
            value = confirmPassword,
            onValueChange = onConfirmPassword,
            leadingIconRes = Icons.Default.Lock,
            hint = "",
            title = "Current Password",
            isSecret = true
        )

        Spacer(modifier = Modifier.height(9.dp))

        Text("Both Passwords Should Match", fontSize = 12.sp, color = Gray100)

        Spacer(modifier = Modifier.height(40.dp))

        CwButton(text = "ChangPassword", onClick =onClick)

    }

}

@Preview
@Composable
private fun ChangePasswordScreenPreview() {
    Surface {
        ChangePasswordScreen(
            currentPassword = "dsatogf",
            newPassword = "dasdjlks",
            confirmPassword = "dkslfjdsf",
            onNewPassword = {  },
            onConfirmPassword = {  }
        ) { }
    }
}