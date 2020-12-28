package com.jsp.camunda.repository.remote.rest

import com.jsp.camunda.BuildConfig
import com.jsp.camunda.repository.dao.rest.dto.Login
import com.jsp.camunda.repository.dao.rest.response.LoginResponse
import com.jsp.camunda.repository.remote.rest.retrofit.RetrofitBuilder
import retrofit2.Response

class RetrofitRestClient: AppRestClient {
    private val camundaService: CamundaApi =
        RetrofitBuilder.createRetrofit(BuildConfig.BASE_API_URL, RetrofitBuilder.getClient()).create(CamundaApi::class.java)

    override suspend fun login(login: Login): Response<LoginResponse> {
        val loginResponse = camundaService.login(login)
        return loginResponse
    }
}