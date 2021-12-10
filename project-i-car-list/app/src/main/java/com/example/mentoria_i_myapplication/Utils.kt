package com.example.mentoria_i_myapplication

import android.os.Handler


class Utils {
    fun delayFunction(function: () -> Unit, delay: Long) {
        Handler().postDelayed(function, delay)
    }
}