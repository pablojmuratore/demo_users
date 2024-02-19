package com.pablojmuratore.demousers.webcontainer.ui.screens

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun WebContainerScreen(
    modifier: Modifier = Modifier,
    url: String = ""
) {
    Surface(
        modifier = modifier
            .fillMaxSize()
    ) {
        AndroidView(
            factory = { context ->
                WebView(context).apply {
                    settings.javaScriptEnabled = false
                    webViewClient = WebViewClient()
                }
            },
            update = { webView ->
                webView.loadUrl(url)
            }
        )
    }
}