package com.capstone.peopleconnect.SPrvoider

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.capstone.peopleconnect.Client.C3Getstarted2Client
import com.capstone.peopleconnect.Client.C5LoginClient
import com.capstone.peopleconnect.R

class SP2Getstarted1SProvider : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sp2_getstarted1_sprovider)

        val next = findViewById<Button>(R.id.getstarted1_button_sprovider)
        next.setOnClickListener {

            val intent = Intent(this, SP3Getstarted2SProvider::class.java)
            startActivity(intent)
        }

        val skip = findViewById<TextView>(R.id.skip)
        skip.setOnClickListener {

            val intent = Intent(this, SP5LoginSProvider::class.java)
            startActivity(intent)
        }
    }
}