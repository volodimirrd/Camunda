package com.jsp.camunda.repository.dao.rest.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("authenticatedUser") val authenticatedUser: String,
    @SerializedName("groups") val groups: String?,
    @SerializedName("tenants") val tenants: String?,
    @SerializedName("authenticated") val authenticated: Boolean
)
