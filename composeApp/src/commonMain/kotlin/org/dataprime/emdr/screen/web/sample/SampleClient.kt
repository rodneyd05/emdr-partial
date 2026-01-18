package org.dataprime.emdr.screen.web.sample

import org.dataprime.emdr.data.model.ClientModel
import org.dataprime.emdr.screen.web.web_model.Plan

val sampleClientList = listOf(
    ClientModel(userId = "0001", userName = "cbcmiguel", subscriptionPlan = Plan.Basic, linkedTherapist = "Alissa Miles", logShared = true, subscriptionStartDate = "Feb 11, 2025", nextRenewalDate = "Mar 11, 2025", signupDate = "Feb 11, 2025"),
    ClientModel(userId = "0002", userName = "dvariano", subscriptionPlan = Plan.Basic, linkedTherapist = "Alissa Miles", logShared = true, subscriptionStartDate = "Mar 04, 2025", nextRenewalDate = "Apr 04, 2025", signupDate = "Mar 04, 2025"),
    ClientModel(userId = "0003", userName = "chputh", subscriptionPlan = Plan.Basic, linkedTherapist = "Alissa Miles", logShared = true, subscriptionStartDate = "Apr 27, 2025", nextRenewalDate = "May 27, 2025", signupDate = "Apr 27, 2025"),
    ClientModel(userId = "0004", userName = "etal", subscriptionPlan = Plan.Basic, linkedTherapist = "Alissa Miles", logShared = true, subscriptionStartDate = "May 16, 2025", nextRenewalDate = "Jun 16, 2025", signupDate = "May 16, 2025"),
    ClientModel(userId = "0005", userName = "mnl_02", subscriptionPlan = Plan.Premium, linkedTherapist = "Ben Gold", logShared = true, subscriptionStartDate = "Jun 24, 2025", nextRenewalDate = "Jul 24, 2025", signupDate = "Jun 24, 2025"),
    ClientModel(userId = "0006", userName = "alison32", subscriptionPlan = Plan.Premium, linkedTherapist = "Ben Gold", logShared = true, subscriptionStartDate = "Jul 17, 2025", nextRenewalDate = "Aug 17, 2025", signupDate = "Jul 17, 2025"),
    ClientModel(userId = "0007", userName = "benjamin_p890", subscriptionPlan = Plan.Premium, linkedTherapist = "Ben Gold", logShared = true, subscriptionStartDate = "Aug 14, 2025", nextRenewalDate = "Sep 14, 2025", signupDate = "Aug 14, 2025"),
    ClientModel(userId = "0008", userName = "thursday_87912", subscriptionPlan = Plan.Premium, linkedTherapist = "Ben Gold", logShared = false, subscriptionStartDate = "Sep 28, 2025", nextRenewalDate = "Oct 28, 2025", signupDate = "Sep 28, 2025"),
    ClientModel(userId = "0009", userName = "indiv_123243", subscriptionPlan = Plan.Basic, linkedTherapist = "Arden Mane", logShared = false, subscriptionStartDate = "Oct 11, 2025", nextRenewalDate = "Nov 11, 2025", signupDate = "Oct 11, 2025")
)