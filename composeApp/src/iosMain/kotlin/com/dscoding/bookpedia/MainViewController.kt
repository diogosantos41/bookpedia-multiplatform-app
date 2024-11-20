package com.dscoding.bookpedia

import androidx.compose.ui.window.ComposeUIViewController
import com.dscoding.bookpedia.app.App
import com.dscoding.bookpedia.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }
