package com.jsp.camunda.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.jsp.camunda.R
import com.jsp.camunda.repository.dao.rest.response.Task
import com.jsp.camunda.ui.activities.base.BaseActivity
import com.jsp.camunda.ui.adapters.TasksAdapter
import com.jsp.camunda.ui.viewmodels.TasksViewModel
import kotlinx.android.synthetic.main.activity_tasks.*
import kotlinx.android.synthetic.main.loading_layout.loadingContainer
import org.koin.android.ext.android.inject

class TasksActivity: BaseActivity(), TasksAdapter.TasksAdapterListener {
    val viewModel by inject<TasksViewModel>()

    lateinit var adapter: TasksAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks)
        lifecycle.addObserver(viewModel)
        viewModel.reloadTasks()
        init()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_logout, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menuLogout){
            openLogin()
        }
        return false
    }

    private fun openLogin(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    private fun init(){
        observeData()
        initView()
    }

    private fun observeData(){
        viewModel.isLoading.observe(this, Observer {
            loadingContainer.visibility = if(it) View.VISIBLE else View.GONE
        })
        viewModel.isTasksLoaded.observe(this, Observer {
            tasksLoaded()
        })
    }

    private fun initView(){
        tasksSwipeRefreshLayout.setOnRefreshListener { refresh() }
        adapter = TasksAdapter(this)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        tasksRecyclerView.layoutManager = layoutManager
        adapter.setHasStableIds(true)
        tasksRecyclerView.adapter = adapter
    }

    private fun tasksLoaded(){
        viewModel.tasks.get()?.let { adapter.replaceAll(it) }
    }

    override fun onTaskClick(task: Task) {
        //todo "Not yet implemented"
    }

    private fun refresh(){
        tasksSwipeRefreshLayout.isRefreshing = false
        viewModel.reloadTasks()
    }
}