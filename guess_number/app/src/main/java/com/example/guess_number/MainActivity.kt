package com.example.guess_number

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private lateinit var  handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        handler = Handler(Looper.getMainLooper())
        val mainView = findViewById<TextView>(R.id.mainView)
        val ANS = findViewById<TextView>(R.id.ANS)
        val inView = findViewById<EditText>(R.id.inView)
        val guess = findViewById<Button>(R.id.guess)
        val reset = findViewById<Button>(R.id.reset)
        var Vnumber:Int
        var secr : Int = Random.nextInt(100) + 1
        var max:Int = 100
        var min:Int = 1
        guess.setOnClickListener {
            if (inView.text.toString().toInt() > secr) {
                max = inView.text.toString().toInt()
            } else if (inView.text.toString().toInt() < secr) {
                min = inView.text.toString().toInt()
            }
            mainView.text = min.toString() + "-" + max.toString()

            if (inView.text.toString().toInt() == secr) {
                ANS.text = "nice"
                handler.postDelayed({
                    Toast.makeText(this, "6s is done", Toast.LENGTH_SHORT).show()
                    secr = Random.nextInt(100) + 1
                    mainView.text ="Please enter a number"
                    max = 100
                    min = 1
                    ANS.text=""
                    inView.text=null
                }, 6000)

            }

        }
        /*ANS.text = secr.toString()*/
        reset.setOnClickListener{
            secr = Random.nextInt(100) + 1
            mainView.text ="Please enter a number"
            max = 100
            min = 1
            ANS.text=""
        }

    }
    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}