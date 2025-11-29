package org.dataprime.emdr.platform

interface ScreenCategory {
    val platformCategory: PlatformCategory
}

expect fun getCategory(): PlatformCategory