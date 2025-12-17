package com.websarva.wings.androidctfseminar

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.websarva.wings.androidctfseminar.ui.theme.AndroidCTFSeminarTheme

class MainActivity : ComponentActivity() {
    val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidCTFSeminarTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val text = if (viewModel.rotateCount >= 6) {
                        getFlagFromJNI()
                    } else {
                        "Welcome to the Main Screen!\nBut you can't see the flag yet."
                    }
                    MainScreen(
                        modifier = Modifier.padding(innerPadding),
                        text = text,
                        isShowFlag = viewModel.rotateCount >= 6
                    )
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()
        viewModel.incrementRotateCount()
    }

    external fun getFlagFromJNI(): String

    companion object {
        init {
            System.loadLibrary("androidctfseminar")
        }
    }
}
