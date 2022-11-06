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

//            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
//            toast.show()
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
        val luckyNumber = 6
        if(luckyNumber == diceRoll){
            val toast = Toast.makeText(this, "You Win!", Toast.LENGTH_SHORT)
            toast.show()
        }else{
            println("Try Again")
        }
        val diceImage:ImageView = findViewById(R.id.imageView)
        diceImage.setImageResource(R.drawable.dice_1)
        when(diceRoll){
            1->diceImage.setImageResource(R.drawable.dice_1)
            2->diceImage.setImageResource(R.drawable.dice_2)
            3->diceImage.setImageResource(R.drawable.dice_3)
            4->diceImage.setImageResource(R.drawable.dice_4)
            5->diceImage.setImageResource(R.drawable.dice_5)
            6->diceImage.setImageResource(R.drawable.dice_6)
        }
        //resultTextView.text=diceRoll.toString()
    }
}