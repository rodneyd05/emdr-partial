package org.dataprime.emdr.data.model

import org.dataprime.emdr.screen.web.web_model.Plan

interface User {
    val subscriptionPlan: Plan
    val subscriptionStartDate: String
    val nextRenewalDate: String
    val signupDate: String
}