package org.dataprime.emdr.screen.web

import kotlinx.serialization.Serializable

interface WebRoute

@Serializable
object Login: WebRoute

@Serializable
object ForgotPassword: WebRoute

@Serializable
object ForgotPasswordSuccessAlert: WebRoute

@Serializable
object ChangePassword: WebRoute

@Serializable
object ChangePasswordSuccessAlert: WebRoute

@Serializable
object SuperAdmin: WebRoute