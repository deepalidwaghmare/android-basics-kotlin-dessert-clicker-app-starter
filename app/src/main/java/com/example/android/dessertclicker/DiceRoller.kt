package com.example.android.dessertclicker

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DiceRoller: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logging()
        division()
        setContentView(R.layout.activity_dice_roller)
        rollDice()
        val rollButton: Button = findViewById(R.id.button1)
        rollButton.setOnClickListener {
            rollDice()
            Toast.makeText(applicationContext,"lets Roll",Toast.LENGTH_SHORT).show()
        }
    }
    class Dice(private val numSides:Int){
        fun roll():Int{
            return (1..numSides).random()
        }
    }

    fun logging() {
        Log.v(TAG, "Hello, world!")
    }

    fun division() {
        val numerator = 60
        var denominator = 4
        repeat(4) {
            Log.v(TAG, "${numerator / denominator}")
            denominator--
        }
    }


    private fun rollDice() {
        //Create Dice Object with 6 sided
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceRoll2 = dice.roll()

        //Find Dice1 ImageView in Layout
        val diceImage = findViewById<ImageView>(R.id.imageView)
        diceImage.setImageResource(R.drawable.dice_2)

        //Find Dice2 ImageView in Layout
        val diceImageSecond: ImageView = findViewById(R.id.imageView2)
        diceImageSecond.setImageResource(R.drawable.dice_2)

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
        diceImage.setImageResource(drawableResource)

        //Determine which Drawable resource id is used based on diceRoll()
        val drawableResource2 = when(diceRoll2){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            6->R.drawable.dice_6
            else ->R.drawable.dice_6
        }

        //Updating the Dice1 ImageView with correct Drawable
        diceImage.setImageResource(drawableResource)

        //Updating the Dice 2 ImageView with correct Drawable
        diceImageSecond.setImageResource(drawableResource2)

        // Update the content description for Dice1
        diceImage.contentDescription = diceRoll.toString()

        //Update Content description for Dice2
        diceImageSecond.contentDescription = diceRoll.toString()
    }
}