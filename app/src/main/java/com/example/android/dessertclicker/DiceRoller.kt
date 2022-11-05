package com.example.android.dessertclicker

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DiceRoller: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice_roller)

        val rollButton: Button = findViewById(R.id.button1)
        rollButton.setOnClickListener {
            rollDice()

            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()
        }
    }
    class Dice(val numSides:Int){
        fun roll():Int{
            return (1..numSides).random()
        }
    }

    private fun rollDice() {
        val dice = Dice(12)
        val diceRoll = dice.roll()
        val resultTextView:TextView = findViewById(R.id.textView2)
        resultTextView.text=diceRoll.toString()
    }
}