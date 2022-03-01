package com.TyreSoft.dndice
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_history.*

class RollHistory : AppCompatActivity() {
    private val historyList: ArrayList<String> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val historyBundle = intent.extras
        if (historyBundle != null) {
            historyList.addAll(historyBundle.getStringArrayList("history")!!)
        }
        setContentView(R.layout.activity_history)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        btnBack.setOnClickListener{
            finish()
        }
        val arrayAdapter: ListAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            historyList.reversed()
        )
        lwHistory.adapter = arrayAdapter
    }
}