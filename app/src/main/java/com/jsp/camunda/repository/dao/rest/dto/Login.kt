package com.jsp.camunda.repository.dao.rest.dto

import com.google.gson.annotations.SerializedName

data class Login(
    @SerializedName("username") val password: String,
    @SerializedName("password") val email: String
)
