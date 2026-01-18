package org.dataprime.emdr.data.model

import org.dataprime.emdr.screen.web.web_model.Plan

data class ClientModel(
    val userId: String,
    val userName: String,
    override val subscriptionPlan: Plan,
    val linkedTherapist: String,
    val logShared: Boolean,
    override val subscriptionStartDate: String,
    override val nextRenewalDate: String,
    override val signupDate: String
): User