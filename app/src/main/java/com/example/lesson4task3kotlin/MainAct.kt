package com.example.lesson4task3kotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.lesson4task3kotlin.Model.User
import java.lang.reflect.Member

class MainAct:  AppCompatActivity() {
    private val TAG: String = SecondActivity::class.java.toString()
    private var LAUNCHER_DETAIL = 112
    private var tv_home: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == LAUNCHER_DETAIL) {
            if (resultCode == RESULT_OK) {
                val member: Member? = data!!.getSerializableExtra("member") as Member?
                Log.d(TAG, member.toString())
                tv_home?.setText(member.toString())
            }
        }
    }

    private fun initView() {
        tv_home = findViewById(R.id.tv_home)
        val b_detail = findViewById<Button>(R.id.b_detail)
        b_detail.setOnClickListener {
            val user = User("Temur", 18)
            openDetail(user)
        }
    }

    var detailLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val result = data!!.getSerializableExtra("member")
            tv_home?.text = result.toString()
        }
    }

    private fun openDetail(user: User?) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("user", user)
        detailLauncher.launch(intent)
    }
}