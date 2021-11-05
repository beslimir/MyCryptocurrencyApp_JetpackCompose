package com.example.mycryptocurrencyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.example.mycryptocurrencyapp.ui.theme.MyCryptocurrencyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCryptocurrencyAppTheme {
                Surface(color = MaterialTheme.colors.background) {

                }
            }
        }
    }
}