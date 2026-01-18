package org.dataprime.emdr.data.model

import org.dataprime.emdr.screen.web.web_model.Plan

data class TherapistModel(
    val firstName: String,
    val lastName: String,
    val subscriptionPlan: Plan,
    val subscriptionStartDate: String,
    val nextRenewalDate: String,
    val address: String,
    val businessName: String,
    val signupDate: String
): User