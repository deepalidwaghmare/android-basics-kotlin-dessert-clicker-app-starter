package com.example.android.dessertclicker

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DiceRoller: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice_roller)

        val rollButton: Button = findViewById(R.id.button1)
        rollButton.setOnClickListener {
            rollDice()
        }
    }
    class Dice(val numSides:Int){
        fun roll():Int{
            return (1..numSides).random()
        }
    }

    private fun rollDice() {
        //Create Dice Object with 6 sided
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val luckyNumber = 6
        if(luckyNumber == diceRoll){
            val toast = Toast.makeText(this, "You Win!", Toast.LENGTH_SHORT)
            toast.show()
        }else{
            val toast = Toast.makeText(this, "Nice Try!", Toast.LENGTH_SHORT)
            toast.show()
        }

        //Find ImageView in Layout
        val diceImage:ImageView = findViewById(R.id.imageView)
        diceImage.setImageResource(R.drawable.dice_1)
        //Determine which Drawable resource id is used based on diceRoll()
        val drawableResource = when(diceRoll){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            6->R.drawable.dice_6
            else ->R.drawable.dice_6
        }
        //Updating the ImageView with correct Drawable
        diceImage.setImageResource(drawableResource)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
    }
}