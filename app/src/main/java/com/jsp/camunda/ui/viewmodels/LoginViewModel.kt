package com.jsp.camunda.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import com.jsp.camunda.repository.CamundaRepository
import com.jsp.camunda.repository.dao.rest.dto.Login
import com.jsp.camunda.ui.viewmodels.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.inject

class LoginViewModel: BaseViewModel() {
    private val appRepository by inject<CamundaRepository>()

    var isUserLogin: MutableLiveData<Boolean> = MutableLiveData()

    fun login(login: Login){
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = appRepository.login(login)
                withContext(Dispatchers.Main) {
                    try {
                        if (response.isSuccessful) {
                            isUserLogin.value = true
                        } else {
                            isUserLogin.value = false
                          //  getError(response.errorBody())
                        }
                    } catch (e: Throwable) {
                        errorMessage.value = e.message
                    } finally {
                        isLoading.value = false
                    }
                }
            } catch (t: Throwable) {
                t.printStackTrace()
                isLoading.postValue(false)
            }
        }
    }
}