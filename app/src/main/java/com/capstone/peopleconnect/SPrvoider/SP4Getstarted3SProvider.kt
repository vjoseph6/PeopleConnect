package com.capstone.peopleconnect.SPrvoider

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.capstone.peopleconnect.R

class SP4Getstarted3SProvider : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sp4_getstarted3_sprovider)

        val next = findViewById<Button>(R.id.getstarted3_button_sprovider)
        next.setOnClickListener {

            val intent = Intent(this, SP5LoginSProvider::class.java)
            startActivity(intent)
        }

        val skip = findViewById<TextView>(R.id.skip)
        skip.setOnClickListener {

            val intent = Intent(this, SP5LoginSProvider::class.java)
            startActivity(intent)
        }

    }
}