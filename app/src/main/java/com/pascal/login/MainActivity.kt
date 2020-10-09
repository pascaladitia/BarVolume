package com.pascal.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        // set on-click listener
        btn_login.setOnClickListener {
            val email = edit_email.text.toString()
            val password = edit_password.text.toString()

            if (email.isEmpty()) {
                edit_email.error = "Email tidak boleh kosong"
            } else if (password.isEmpty()) {
                edit_password.error = "Password tidak boleh kosong"
            } else {
                actionLogin(email, password)
            }
        }
    }

    private fun actionLogin(email: String, password: String) {
        //email = admin,  pass = 12345678
        if (email.equals("admin@gmail.com") && password.equals("12345678")) {
            val intent = Intent(this@MainActivity, Dashboard::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Email atau password salah", Toast.LENGTH_SHORT).show()
        }
    }
}
