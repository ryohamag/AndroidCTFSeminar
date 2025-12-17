package com.websarva.wings.androidctfseminar

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var rotateCount by mutableIntStateOf(0)

    fun incrementRotateCount() {
        rotateCount++
    }
}