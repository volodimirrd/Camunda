package com.jsp.camunda.ui.adapters.holders

import androidx.recyclerview.widget.RecyclerView
import com.jsp.camunda.databinding.ListItemTaskBinding
import com.jsp.camunda.repository.dao.rest.response.Task
import com.jsp.camunda.ui.adapters.TasksAdapter

class TaskHolder(
        private var binding: ListItemTaskBinding,
        private var listener: TasksAdapter.TasksAdapterListener): RecyclerView.ViewHolder(binding.root) {

    private lateinit var task: Task

    init {
        binding.root.setOnClickListener { onClickTask(task) }
    }

    fun bind(task: Task){
        this.task = task
        binding.data = task
    }

    private fun onClickTask(task: Task){
        listener.onTaskClick(task)
    }
}