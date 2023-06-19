package com.example.watermate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.os.Bundle
import android.os.Handler
import android.view.MotionEvent
import android.view.Window
import android.widget.ListView
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import com.example.watermate.custom_utils.CustomArrayAdapter

@Suppress("DEPRECATION")
class WelcomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(0, 0)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(R.layout.activity_welcome_screen)

        val abilitiesArray = resources.getStringArray(R.array.possibilities_list)

        val listView = findViewById<ListView>(R.id.possibilities)

        val adapter = CustomArrayAdapter(this, android.R.layout.simple_list_item_1, abilitiesArray)
        listView.adapter = adapter

        val button = findViewById<Button>(R.id.start)
        button.setOnClickListener {
            val intent = Intent(this, FunctionalActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
    }
}
