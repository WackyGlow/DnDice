package com.TyreSoft.dndice

import android.content.Intent
import android.graphics.Color.*
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.util.*
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    private val TAG: String = "xyz"
    private var dieType: String = ""
    val resultList: MutableList<Int> = mutableListOf()

    private val mRandomGenerator = Random()
    private val historyList: ArrayList<String> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        skbDiceAmount.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(skbDiceAmount: SeekBar, p1: Int, p2: Boolean) {
                /**
                 * not used
                 */
            }

            override fun onStartTrackingTouch(skbDiceAmount: SeekBar) {
                /**
                 * not used
                 */
            }

            override fun onStopTrackingTouch(skbDiceAmount: SeekBar) {
                twDiceAmount.text = "Dice Amount: " + skbDiceAmount.progress
            }
        })
        btnHistory.setOnClickListener{val intet = Intent(this@MainActivity, RollHistory::class.java)
            val b = Bundle()
            b.putStringArrayList("history",historyList)
            intet.putExtras(b)
            startActivity(intent)}
        btnRoll.setOnClickListener{v -> onClickRoll(skbDiceAmount.progress)}
        iwTetra.setOnClickListener { v -> selectDiceType("d4") }
        iwCube.setOnClickListener { v -> selectDiceType("d6") }
        iwOcta.setOnClickListener { v -> selectDiceType("d8") }
        Log.d(TAG, "onCreate")
    }

    private fun selectDiceType(dicetype : String){
        when (dicetype){
            "d4" -> {
                dieType = "d4"
                iwTetra.setBackgroundColor(GREEN)
                iwCube.setBackgroundColor(WHITE)
                iwOcta.setBackgroundColor(WHITE)
            }
            "d6" -> {
                dieType = "d6"
                iwCube.setBackgroundColor(GREEN)
                iwTetra.setBackgroundColor(WHITE)
                iwOcta.setBackgroundColor(WHITE)
            }
            "d8" -> {
                dieType = "d8"
                iwOcta.setBackgroundColor(GREEN)
                iwCube.setBackgroundColor(WHITE)
                iwTetra.setBackgroundColor(WHITE)
            }
        }
    }

    private fun rollDice(){

        when (dieType){
            "d4" -> {
                val result = mRandomGenerator.nextInt(4) + 1
                resultList.add(result)
                println()
                twRolledDice.text = resultList.toString()

            }
            "d6" -> {
                val result = mRandomGenerator.nextInt(6) + 1
                resultList.add(result)
                twRolledDice.text = resultList.toString()
            }
            "d8" -> {
                val result = mRandomGenerator.nextInt(8) + 1
                resultList.add(result)
                twRolledDice.text = resultList.toString()
            }
            else -> {
                Toast.makeText(this@MainActivity, "Please choose a dice type",
                    Toast.LENGTH_SHORT).show()

            }
        }
    }

    private fun onClickRoll(howMany: Int){
        if ( howMany > 0 || howMany <= 6) {
            println("throwing the " + dieType)
            for (i in 1..howMany){
                println("dice number: $i")
                rollDice()
            }
            historyList.add(resultList.toString())
            resultList.clear()
        }
    }
}