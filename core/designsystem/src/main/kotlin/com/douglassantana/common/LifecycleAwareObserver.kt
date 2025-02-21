package com.douglassantana.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.compose.LocalLifecycleOwner

@Composable
fun LifecycleAwareObserver(
    observer: LifecycleObserver
) {
    val lifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(observer, lifecycleOwner) {
        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
}