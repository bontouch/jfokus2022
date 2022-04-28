package com.bontouch.example.compose.ui.util

import kotlinx.coroutines.flow.MutableStateFlow

fun <T> MutableStateFlow<T>.update(onUpdate: (T) -> T): T {
    while (true) {
        val expected = value
        val new = onUpdate(expected)
        if (compareAndSet(expected, new)) {
            return new
        }
    }
}
