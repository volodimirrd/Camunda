package com.jsp.camunda.repository

import com.jsp.camunda.repository.dao.rest.dto.Login
import com.jsp.camunda.repository.dao.rest.response.LoginResponse
import com.jsp.camunda.repository.dao.rest.response.Task
import com.jsp.camunda.repository.remote.rest.AppRestClient
import retrofit2.Response

class CamundaRepository(private val restClient: AppRestClient) {

    suspend fun login(login: Login): Response<LoginResponse>{
        val response = restClient.login(login)
        return response
    }

    suspend fun getTasks(): Response<List<Task>>{
        return restClient.getTasks()
    }
}