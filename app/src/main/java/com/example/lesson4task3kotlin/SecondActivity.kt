package com.example.lesson4task3kotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.lesson4task3kotlin.Model.Member
import com.example.lesson4task3kotlin.Model.User

class SecondActivity: AppCompatActivity() {
    val TAG = SecondActivity::class.java.toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_act)
        initView()
    }

    private fun initView() {
        val tv_detail: TextView = findViewById<TextView>(R.id.tv_detail)
        val b_exit: Button = findViewById<Button>(R.id.b_exit)
        b_exit.setOnClickListener {
            val member = Member("Temur", 18)
            closeDetail(member)
        }
        val user: User = getIntent().getSerializableExtra("user") as User
        Log.d(TAG, user.toString())
        tv_detail.text = user.toString()
    }

    private fun closeDetail(member: Member?) {
        val intent = Intent(this, MainAct::class.java)
        intent.putExtra("member", member)
        setResult(RESULT_OK, intent)
        finish()
    }
}