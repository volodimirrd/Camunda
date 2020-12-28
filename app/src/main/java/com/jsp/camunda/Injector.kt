package com.jsp.camunda

import com.jsp.camunda.repository.CamundaRepository
import com.jsp.camunda.repository.remote.rest.AppRestClient
import com.jsp.camunda.repository.remote.rest.RetrofitRestClient
import com.jsp.camunda.ui.viewmodels.LoginViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module{
    viewModel { LoginViewModel() }
}

val repositoryModule = module{
    single { RetrofitRestClient() }
    single { CamundaRepository(get<RetrofitRestClient>()) }
}