package com.malinikali.calculator.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.malinikali.calculator.R
import kotlin.concurrent.thread

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val handler = Handler()
        val ivLogo = findViewById<ImageView>(R.id.ivLogo);

            val blinkAnim =
                AnimationUtils.loadAnimation(applicationContext, R.anim.blink)
            ivLogo.startAnimation(blinkAnim)


        thread {

                handler.postDelayed({

                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)


                },5000)





        }
    }
}