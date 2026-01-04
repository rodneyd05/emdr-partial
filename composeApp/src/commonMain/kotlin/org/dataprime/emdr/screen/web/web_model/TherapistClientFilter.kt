package org.dataprime.emdr.screen.web.web_model

enum class TherapistClientFilter(val label: String) {
    ALL("All"),
    ACTIVE("Active"),
    EXPIRED("Expired (Inactive)"),
    GRACE_PERIOD("Grace Period")
}