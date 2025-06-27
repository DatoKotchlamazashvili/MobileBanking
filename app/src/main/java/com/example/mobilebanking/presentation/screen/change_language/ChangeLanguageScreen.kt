package com.example.mobilebanking.presentation.screen.change_language

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Language
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilebanking.presentation.design_system.search.CwSimpleSearchBar


data class Language(
    val imageRes: ImageVector,
    val name: String,
    val isSelected: Boolean,
)

@Composable
fun ChangeLanguageScreen(
    modifier: Modifier = Modifier,
    searchText: String,
    onSearchChanged: (String) -> Unit,
    languages: List<Language>,
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

        Spacer(modifier = Modifier.height(31.dp))

        CwSimpleSearchBar(
            text = searchText,
            onChangedText = onSearchChanged
        )

        Spacer(modifier = Modifier.height(31.dp))

        LazyColumn {
            items(languages) { language ->

                LanguageItem(
                    imageRes = language.imageRes,
                    name = language.name,
                    isSelected = language.isSelected,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 22.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun ChangeLanguageScreenPreview() {
    Surface {
        ChangeLanguageScreen(
            searchText = "",
            onSearchChanged = { },
            languages = listOf(
                Language(
                    imageRes = Icons.Default.Language,
                    name = "England",
                    isSelected = true
                ),
                Language(
                    imageRes = Icons.Default.Language,
                    name = "Portugal",
                    isSelected = false
                ),
                Language(
                    imageRes = Icons.Default.Language,
                    name = "Portugal",
                    isSelected = false
                ),             Language(
                    imageRes = Icons.Default.Language,
                    name = "Portugal",
                    isSelected = false
                ),
                )

        )
    }
}