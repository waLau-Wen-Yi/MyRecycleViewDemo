package com.example.myrecycleviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecycleviewdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MyAdapter.OnItemClickListener {
    private lateinit var binding: ActivityMainBinding

    private val studentList = listOf(
        Student("W001", "John", "RST", "M"),
        Student("W002", "Alex", "RST", "M"),
        Student("W003", "Mark", "RST", "M"),
        Student("W004", "Alice", "RST", "F"),
        Student("W005", "Steven", "RST", "M"),
        Student("W006", "Ken", "RST", "M"),
        Student("W007", "Stella", "RST", "F")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = MyAdapter(studentList, this)

        binding.rvStudList.adapter = adapter
        binding.rvStudList.layoutManager = LinearLayoutManager(applicationContext)
        binding.rvStudList.setHasFixedSize(true)
    }

    override fun itemClick(position: Int) {
        val selectedStud = studentList[position]
        Toast.makeText(this, selectedStud.name, Toast.LENGTH_SHORT).show()
    }
}