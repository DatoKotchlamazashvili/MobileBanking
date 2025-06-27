package com.example.mobilebanking.presentation.design_system.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CwSearchBar(
    modifier: Modifier = Modifier,
    text: String,
    expanded: Boolean,
    onExpandedChanged: (Boolean) -> Unit,
    onSearchTextChanged: (String) -> Unit,
    onCancelClick: () -> Unit,
    recommendationContent: (@Composable ColumnScope.() -> Unit)?,
    dataContent: @Composable () -> Unit,
) {

    Box(
        modifier
            .fillMaxSize()
            .semantics { isTraversalGroup = true }
    ) {
        SearchBar(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .semantics { traversalIndex = 0f },
            inputField = {
                SearchBarDefaults.InputField(
                    query = text,
                    onQueryChange = onSearchTextChanged,
                    onSearch = { onExpandedChanged(false) },
                    expanded = expanded,
                    onExpandedChange = { onExpandedChanged(it) },
                    placeholder = { Text("Hinted search text") },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                    trailingIcon = if (text.isNotEmpty()) {
                        {
                            Icon(
                                imageVector = Icons.Default.Cancel,
                                contentDescription = null,
                                tint = Color.Gray,
                                modifier = Modifier.clickable {
                                    onCancelClick()
                                }
                            )
                        }
                    } else null,
                )
            },
            expanded = expanded,
            onExpandedChange = { onExpandedChanged(it) }
        ) {
            recommendationContent?.invoke(this)
        }

        dataContent()
    }
}

@Preview(showBackground = true)
@Composable
fun CwSearchBarPreview() {
    MaterialTheme {
        CwSearchBar(
            text = "te",
            onSearchTextChanged = { },
            expanded = true,
            onExpandedChanged = {},
            recommendationContent = {
                Text(
                    text = "Search content goes here",
                    modifier = Modifier.padding(16.dp)
                )
            },
            onCancelClick = {},
            dataContent = {
                LazyColumn(
                    contentPadding = PaddingValues(
                        start = 16.dp,
                        top = 72.dp,
                        end = 16.dp,
                        bottom = 16.dp
                    ),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.semantics { traversalIndex = 1f }
                ) {
                    val list = List(100) { "Text $it" }
                    items(count = list.size) {
                        Text(
                            text = list[it],
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                        )
                    }
                }
            }
        )
    }
}