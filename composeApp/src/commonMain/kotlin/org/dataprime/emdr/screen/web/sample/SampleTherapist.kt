package org.dataprime.emdr.screen.web.sample

import org.dataprime.emdr.screen.web.web_model.Plan
import org.dataprime.emdr.screen.web.web_model.TherapistModel

val sampleTherapistLists = listOf(
    TherapistModel(firstName = "Alissa", lastName = "Miles", subscriptionPlan = Plan.Basic, subscriptionStartDate = "Feb 11, 2025", nextRenewalDate = "Mar 11, 2025"),
    TherapistModel(firstName = "Arden", lastName = "Mane", subscriptionPlan = Plan.Basic, subscriptionStartDate = "Mar 04, 2025", nextRenewalDate = "Apr 04, 2025"),
    TherapistModel(firstName = "Ashton", lastName = "Queen", subscriptionPlan = Plan.Basic, subscriptionStartDate = "Apr 27, 2025", nextRenewalDate = "May 27, 2025"),
    TherapistModel(firstName = "Ben", lastName = "Gold", subscriptionPlan = Plan.Basic, subscriptionStartDate = "May 16, 2025", nextRenewalDate = "Jun 16, 2025"),
    TherapistModel(firstName = "Bruce", lastName = "Wills", subscriptionPlan = Plan.Premium, subscriptionStartDate = "June 24, 2025", nextRenewalDate = "Jul 24, 2025"),
)