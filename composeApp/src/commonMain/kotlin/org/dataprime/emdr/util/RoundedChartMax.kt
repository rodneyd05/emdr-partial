package org.dataprime.emdr.util

fun roundedChartMax(
    values: List<Float>,
    step: Float = 1000f
): Float {
    val max = values.maxOrNull() ?: 0f
    return kotlin.math.ceil(max / step) * step
}
