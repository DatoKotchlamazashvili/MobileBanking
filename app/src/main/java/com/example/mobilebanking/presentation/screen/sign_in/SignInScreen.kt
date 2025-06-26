package com.example.mobilebanking.presentation.screen.sign_in

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilebanking.presentation.design_system.button.CwButton
import com.example.mobilebanking.presentation.design_system.field.CwInputEditField
import com.example.mobilebanking.ui.theme.Blue100
import com.example.mobilebanking.ui.theme.Gray100
import com.example.mobilebanking.ui.theme.MobileBankingTheme

@Composable
fun SignInScreenContent(
    modifier: Modifier = Modifier,
    email: String,
    password: String,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onSignUpClicked: () -> Unit,
    onClick: () -> Unit,
) {
    Column(modifier = modifier) {
        Spacer(Modifier
            .fillMaxHeight(0.1f)
            .fillMaxWidth())

        Column(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(20.dp)) {
            Text("Sign In", fontSize = 32.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier.height(38.dp))

            CwInputEditField(
                value = email,
                onValueChange = onEmailChanged,
                title = "Email",
                hint = "johnDoe@example.com",
                leadingIconRes = Icons.Default.Email
            )
            Spacer(modifier.height(21.dp))

            CwInputEditField(
                value = password,
                onValueChange = onPasswordChanged,
                title = "Password",
                hint = "Enter String Password",
                leadingIconRes = Icons.Default.Lock,
                isSecret = true,

                )
            Spacer(modifier.height(40.dp))

            CwButton(text = "Sign In", onClick = onClick)
            Spacer(modifier.height(29.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onSignUpClicked() },
                text = buildAnnotatedString {
                    append("I’m a new user ")
                    withStyle(style = SpanStyle(color = Blue100)) {
                        append("Sign In")
                    }
                },
                textAlign = TextAlign.Center,
                color = Gray100
            )
        }
    }
}

@Preview
@Composable
private fun SignScreenContentPreview() {
    MobileBankingTheme {
        Surface {
            SignInScreenContent(
                email = "",
                onClick = {},
                onSignUpClicked = {},
                onPasswordChanged = {},
                onEmailChanged = {},
                password = "sadasd"
            )
        }
    }

}