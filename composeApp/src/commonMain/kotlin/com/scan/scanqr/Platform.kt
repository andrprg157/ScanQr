package com.scan.scanqr

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform