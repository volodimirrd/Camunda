package com.jsp.camunda.repository.remote.rest

import com.jsp.camunda.repository.dao.rest.dto.Login
import com.jsp.camunda.repository.dao.rest.response.LoginResponse
import com.jsp.camunda.repository.dao.rest.response.Task
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CamundaApi {
    @POST("identity/verify")
    suspend fun login(@Body login: Login) : Response<LoginResponse>

    @GET("task")
    suspend fun getTasks(): Response<List<Task>>
}