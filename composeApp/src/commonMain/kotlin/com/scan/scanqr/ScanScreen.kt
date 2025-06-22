package com.scan.scanqr

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import qrscanner.CameraLens
import qrscanner.QrScanner
@Composable
fun ScanScreen(onScanCompleted: (String) -> Unit) {
    QrScanner(
        modifier = Modifier.fillMaxSize(),
        flashlightOn = false,
        cameraLens = CameraLens.Back,
        openImagePicker = false,
        onCompletion = { result -> onScanCompleted(result) },
        imagePickerHandler = {},
        onFailure = { error -> onScanCompleted("Scan failed: $error") }
    )
}