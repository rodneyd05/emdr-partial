package org.dataprime.emdr.screen.web.web_model

enum class Filter(val label: String) {
    ALL_TIME("All time"),
    TODAY("Today"),
    LAST_7_DAYS("Last 7 days"),
    LAST_14_DAYS("Last 14 days"),
    THIS_MONTH("This month"),
    LAST_MONTH("Last month"),
    THIS_YEAR("This year"),
    CUSTOM("Custom date range")
}