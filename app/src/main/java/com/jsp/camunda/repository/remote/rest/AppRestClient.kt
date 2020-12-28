package com.jsp.camunda.repository.remote.rest

import com.jsp.camunda.repository.dao.rest.dto.Login
import com.jsp.camunda.repository.dao.rest.response.LoginResponse
import retrofit2.Response

interface AppRestClient {
    suspend fun login(login: Login): Response<LoginResponse>
}