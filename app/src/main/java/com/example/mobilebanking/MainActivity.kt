package com.example.mobilebanking


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mobilebanking.presentation.design_system.date.CwDatePicker
import com.example.mobilebanking.presentation.design_system.date.MonthText
import com.example.mobilebanking.ui.theme.MobileBankingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileBankingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var isOpened by remember { mutableStateOf(false) }

                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Button(onClick = { isOpened = true }) {
                            Text("Pick a Date")
                        }


                        CwDatePicker(
                            onDateSelected = {
                            }, monthFormat = MonthText.Text
                        )
                    }
                }
            }
        }
    }
}
