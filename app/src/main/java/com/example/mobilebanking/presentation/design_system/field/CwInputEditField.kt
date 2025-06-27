package com.example.mobilebanking.presentation.design_system.field

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilebanking.ui.theme.MobileBankingTheme
import com.example.mobilebanking.ui.theme.lightGray100


@Composable
fun CwInputEditField(
    modifier: Modifier = Modifier,
    value: String = "",
    onValueChange: (String) -> Unit,
    leadingIconRes: ImageVector? = null,
    hint: String,
    title: String,
    isSecret: Boolean = false,
) {
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }
    Column(modifier = modifier) {

        Text(
            text = title,
            fontSize = 14.sp,
            color = lightGray100,
            modifier = Modifier.padding(start = 9.dp)
        )



        OutlinedTextField(
            value = value,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
            ),
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = if (isPasswordVisible) {
                PasswordVisualTransformation(mask = '*')
            } else VisualTransformation.None,
            placeholder = { Text(text = hint, color = lightGray100) },
            leadingIcon = if (leadingIconRes != null) {
                {
                    Icon(
                        imageVector = leadingIconRes,
                        contentDescription = null,
                        tint = Color.Gray
                    )
                }
            } else null,
            trailingIcon = {
                if (isSecret) {
                    IconButton(
                        onClick = {
                            isPasswordVisible = !isPasswordVisible
                        }
                    ) {
                        when {
                            isPasswordVisible -> {
                                Icon(
                                    imageVector = Icons.Filled.VisibilityOff,
                                    contentDescription = "Hide password"
                                )
                            }

                            !isPasswordVisible -> {
                                Icon(
                                    imageVector = Icons.Default.Visibility,
                                    contentDescription = "Show password"
                                )
                            }
                        }
                    }
                }

            }
        )
        HorizontalDivider(color = Color(0xFFF4F4F4))

    }
}


@Preview
@Composable
private fun CwInputEditFieldPreview() {
    MobileBankingTheme {
        Surface {
            Column {
                (0..2).map {
                    CwInputEditField(
                        hint = "$it value",
                        value = "gfdgfd",
                        isSecret = it == 2,
                        leadingIconRes = null,
                        onValueChange = {},
                        title = "asds",

                        )
                }


            }
        }
    }
}