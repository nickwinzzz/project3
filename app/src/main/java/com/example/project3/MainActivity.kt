package com.example.project3

import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView: ImageView = findViewById(R.id.imageView)
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)

        button1.setOnClickListener {
            setImageWithFade(imageView, R.drawable.image1)
        }
        button2.setOnClickListener {
            setImageWithFade(imageView, R.drawable.image2)
        }
        button3.setOnClickListener {
            setImageWithFade(imageView, R.drawable.image3)
        }
    }

    private fun setImageWithFade(imageView: ImageView, resourceId: Int) {

        val fadeOut = AlphaAnimation(1.0f, 0.0f).apply {
            duration = 300
            setAnimationListener(object : android.view.animation.Animation.AnimationListener {
                override fun onAnimationStart(animation: android.view.animation.Animation?) {}

                override fun onAnimationEnd(animation: android.view.animation.Animation?) {

                    imageView.setImageResource(resourceId)


                    val fadeIn = AlphaAnimation(0.0f, 1.0f).apply {
                        duration = 300
                    }
                    imageView.startAnimation(fadeIn)
                }

                override fun onAnimationRepeat(animation: android.view.animation.Animation?) {}
            })
        }

        imageView.startAnimation(fadeOut)
    }
}
