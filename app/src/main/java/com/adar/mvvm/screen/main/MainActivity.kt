package com.adar.mvvm.screen.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.adar.mvvm.R
import com.adar.mvvm.screen.employee.EmployeeActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activity_main_open_button.setOnClickListener {
            startActivity(EmployeeActivity.newIntent(this))
        }
    }
}
