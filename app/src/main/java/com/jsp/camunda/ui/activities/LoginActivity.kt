package com.jsp.camunda.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.jsp.camunda.R
import com.jsp.camunda.repository.dao.rest.dto.Login
import com.jsp.camunda.ui.activities.base.BaseActivity
import com.jsp.camunda.ui.viewmodels.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject

class LoginActivity: BaseActivity() {
    val viewModel by inject<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        lifecycle.addObserver(viewModel)
        init()
    }

    private fun init(){
        observeData()
        initView()
    }

    private fun observeData(){
        viewModel.isUserLogin.observe(this, Observer {
            if (it){
                userLogin()
            }
        })
    }

    private fun initView(){
        loginButton.setOnClickListener {
            viewModel.login(Login(userEditText.text?.toString()?:"",passwordEditText.text?.toString()?:""))
        }
    }

    private fun userLogin(){
        val intent = Intent(this, TasksActivity::class.java)
        startActivity(intent)
    }
}