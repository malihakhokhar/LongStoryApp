package com.example.longstoryapp.activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.longstoryapp.R
import com.example.longstoryapp.adapter.ListViewAdapter
import com.example.longstoryapp.databinding.LongStoryAppBinding
import com.example.longstoryapp.model.Story

class MainActivity : AppCompatActivity() {
    lateinit var binding: LongStoryAppBinding
    private lateinit var headerView: View

    private var titles = arrayOf(
        "Unique Culture",
        "Every Culture is Different",
        "Beauty of Nature"
    )
    private var profiles = intArrayOf(
        R.drawable.a,
        R.drawable.b,
        R.drawable.c
    )
    private var time = arrayOf(
        "25 min ago",
        "1 hour ago",
        "Yesterday"
    )
    private var comments = arrayOf(
        "Sample description text",
        "Beautiful scene description",
        "Amazing moment captured",
        "Great story writeup"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = LongStoryAppBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Inflate header
        headerView = layoutInflater.inflate(R.layout.header, null)

        // Add header to ListView
        binding.list.addHeaderView(headerView, null, false)

        // Prepare arraylist
        val storyArrayList = ArrayList<Story>()

        for (i in titles.indices) {
            val story = Story(
                titles[i],
                profiles[i],
                time[i],
                comments[i]
            )
            storyArrayList.add(story)
        }

        val adapter = ListViewAdapter(this, storyArrayList)
        binding.list.adapter = adapter

    }
}