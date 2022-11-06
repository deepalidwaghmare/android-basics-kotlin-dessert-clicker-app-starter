package com.example.android.dessertclicker

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HappyBirthdayMessage : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.happy_birthday_message)

        val imageView:ImageView = findViewById(R.id.imageViewCake)
        imageView.setOnClickListener{
            val toast = Toast.makeText(this, "Cupcake Clicked", Toast.LENGTH_SHORT)
            toast.show()
        }
    }
}