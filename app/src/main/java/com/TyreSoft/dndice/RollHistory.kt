package com.TyreSoft.dndice
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class RollHistory : AppCompatActivity() {
    private val historyList: ArrayList<String> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val historyBundle = intent.extras
        if (historyBundle != null) {
            historyList.addAll(historyBundle.getStringArrayList("history")!!)
        }
    }
}