package com.jsp.camunda.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.jsp.camunda.R
import com.jsp.camunda.databinding.ListItemTaskBinding
import com.jsp.camunda.repository.dao.rest.response.Task
import com.jsp.camunda.ui.adapters.base.BaseRecyclerAdapter
import com.jsp.camunda.ui.adapters.holders.TaskHolder

class TasksAdapter(var listener: TasksAdapterListener) : BaseRecyclerAdapter<Task, TaskHolder>() {
    interface TasksAdapterListener{
        fun onTaskClick(task: Task)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate(inflater, R.layout.list_item_task, parent, false) as ListItemTaskBinding
        return TaskHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: TaskHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
}