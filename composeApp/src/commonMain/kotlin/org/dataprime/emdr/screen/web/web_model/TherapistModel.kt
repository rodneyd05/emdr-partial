package org.dataprime.emdr.screen.web.web_model

data class TherapistModel(
    val firstName: String,
    val lastName: String,
    val subscriptionPlan: Plan,
    val subscriptionStartDate: String,
    val nextRenewalDate: String
)
