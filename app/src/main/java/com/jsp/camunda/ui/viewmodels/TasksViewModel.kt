package com.jsp.camunda.ui.viewmodels

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.jsp.camunda.repository.CamundaRepository
import com.jsp.camunda.repository.dao.rest.response.Task
import com.jsp.camunda.ui.viewmodels.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.inject

class TasksViewModel: BaseViewModel() {
    private val appRepository by inject<CamundaRepository>()

    var tasks: ObservableField<List<Task>> = ObservableField()
    var isTasksLoaded: MutableLiveData<Boolean> = MutableLiveData()

    fun reloadTasks() {
        isLoading.postValue(true)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = appRepository.getTasks()
                withContext(Dispatchers.Main) {
                    try {
                        if (response.isSuccessful) {
                            tasks.set(response.body())
                            isTasksLoaded.postValue(true)
                        } else {
                            isTasksLoaded.postValue(false)
                            Log.d("TasksViewModel", "${response.errorBody()}")
                        }
                    } catch (e: Throwable) {
                        errorMessage.value = e.message
                    } finally {
                        isLoading.postValue(false)
                    }
                }
            } catch (t: Throwable) {
                t.printStackTrace()
                isLoading.postValue(false)
            }
        }
    }
}