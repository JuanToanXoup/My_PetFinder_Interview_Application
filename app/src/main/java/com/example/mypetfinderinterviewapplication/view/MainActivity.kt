package com.example.mypetfinderinterviewapplication.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mypetfinderinterviewapplication.R
import com.example.mypetfinderinterviewapplication.c11.view.C11Activity
import com.example.mypetfinderinterviewapplication.c12.view.C12Activity
import com.example.mypetfinderinterviewapplication.c13.view.C13Activity
import com.example.mypetfinderinterviewapplication.viewModel.MainViewModel
import com.example.mypetfinderinterviewapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var mainActivityBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initBinding()
        initViewModel()
        initObservers()
    }

    private fun initBinding() {
        mainActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainActivityBinding.lifecycleOwner = this
    }

    private fun initViewModel() {
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainActivityBinding.mainViewModel = mainViewModel
    }

    private fun initObservers() {
        mainViewModel.observeClickedButton().observe(this) { it?.let { onButtonClicked(it) } }
    }

    private fun onButtonClicked(button: String) {
        when (button) {
            "C11" -> startActivity(Intent(this, C11Activity::class.java))
            "C12" -> startActivity(Intent(this, C12Activity::class.java))
            "C13" -> startActivity(Intent(this, C13Activity::class.java))
            else -> "throw error"
        }
    }


}