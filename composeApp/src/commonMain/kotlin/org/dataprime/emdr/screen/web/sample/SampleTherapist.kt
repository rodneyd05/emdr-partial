package org.dataprime.emdr.screen.web.sample

import org.dataprime.emdr.screen.web.web_model.Plan
import org.dataprime.emdr.data.model.TherapistModel

val sampleTherapistList = listOf(
    TherapistModel(firstName = "Alissa", lastName = "Miles", subscriptionPlan = Plan.Basic, subscriptionStartDate = "Feb 11, 2025", nextRenewalDate = "Mar 11, 2025", address = "12 Hill St, Boston, MA", businessName = "MediCore", signupDate = "Feb 11, 2025"),
    TherapistModel(firstName = "Arden", lastName = "Mane", subscriptionPlan = Plan.Basic, subscriptionStartDate = "Mar 04, 2025", nextRenewalDate = "Apr 04, 2025", address = "45 Pine Rd, Miami, FL", businessName = "HealthPoint", signupDate = "Mar 04, 2025"),
    TherapistModel(firstName = "Ashton", lastName = "Queen", subscriptionPlan = Plan.Basic, subscriptionStartDate = "Apr 27, 2025", nextRenewalDate = "May 27, 2025", address = "88 Lake St, Denver, CO", businessName = "QuickCare", signupDate = "Apr 27, 2025"),
    TherapistModel(firstName = "Ben", lastName = "Gold", subscriptionPlan = Plan.Basic, subscriptionStartDate = "May 16, 2025", nextRenewalDate = "Jun 16, 2025", address = "23 Elm Dr, Dallas, TX", businessName = "PureWell", signupDate = "May 16, 2025"),
    TherapistModel(firstName = "Bruce", lastName = "Wills", subscriptionPlan = Plan.Premium, subscriptionStartDate = "June 24, 2025", nextRenewalDate = "Jul 24, 2025", address = "57 Oak Ln, Seattle, WA", businessName = "LifeSpring", signupDate = "Jun 24, 2025"),
    TherapistModel(firstName = "Arden", lastName = "Mane", subscriptionPlan = Plan.Basic, subscriptionStartDate = "Mar 04, 2025", nextRenewalDate = "Apr 04, 2025", address = "45 Pine Rd, Miami, FL", businessName = "HealthPoint", signupDate = "Mar 04, 2025"),
    TherapistModel(firstName = "Ashton", lastName = "Queen", subscriptionPlan = Plan.Basic, subscriptionStartDate = "Apr 27, 2025", nextRenewalDate = "May 27, 2025", address = "88 Lake St, Denver, CO", businessName = "QuickCare", signupDate = "Apr 27, 2025"),
    TherapistModel(firstName = "Ben", lastName = "Gold", subscriptionPlan = Plan.Basic, subscriptionStartDate = "May 16, 2025", nextRenewalDate = "Jun 16, 2025", address = "23 Elm Dr, Dallas, TX", businessName = "PureWell", signupDate = "May 16, 2025"),
    TherapistModel(firstName = "Bruce", lastName = "Wills", subscriptionPlan = Plan.Premium, subscriptionStartDate = "June 24, 2025", nextRenewalDate = "Jul 24, 2025", address = "57 Oak Ln, Seattle, WA", businessName = "LifeSpring", signupDate = "Jun 24, 2025")
)