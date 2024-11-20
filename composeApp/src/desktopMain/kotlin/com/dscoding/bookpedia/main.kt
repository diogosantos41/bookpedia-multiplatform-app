package com.dscoding.bookpedia

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.dscoding.bookpedia.app.App
import com.dscoding.bookpedia.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Bookpedia",
        ) {
            App()
        }
    }
}