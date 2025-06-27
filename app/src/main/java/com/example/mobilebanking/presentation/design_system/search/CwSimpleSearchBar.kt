package com.example.mobilebanking.presentation.design_system.search

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mobilebanking.ui.theme.lightGray100


@Composable
fun CwSimpleSearchBar(
    modifier: Modifier = Modifier,
    text: String,
    onChangedText: (String) -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .border(0.5.dp, Color(0xFF707070), RoundedCornerShape(12.dp))
            .background(Color(0xFFF4F4F4), RoundedCornerShape(12.dp))
            .padding(0.1.dp)
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = onChangedText,
            modifier = Modifier
                .fillMaxWidth(),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = null)
            },
            shape = RoundedCornerShape(12.dp),
            placeholder = { Text("Search Language", color = lightGray100) },

            )
    }
}

@Preview
@Composable
private fun CwSimpleSearchBarPreview() {
    Surface {
        CwSimpleSearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .size(200.dp)
                .padding(top = 20.dp),
            text = "dato",
            onChangedText = { }
        )
    }
}