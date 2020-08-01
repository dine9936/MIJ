package com.example.mijsmartmeter

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {


    lateinit var  progressBar:ProgressBar
    lateinit var countdownTimer:CountDownTimer

    var i:Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        countDown()



    }

    fun countDown(){
        progressBar = findViewById(R.id.splash_prgress_bar)
        progressBar.progress = i

        countdownTimer = object : CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                i++
                progressBar.setProgress(i * 100 / (5000 / 4000))
            }

            override fun onFinish() {
                i++
                progressBar.setProgress(100)

                val intent = Intent(this@SplashScreen, MainActivity::class.java)
                startActivity(intent)
                finish()

            }
        }
        countdownTimer.start()
    }


}


