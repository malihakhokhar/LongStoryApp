package com.example.longstoryapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.longstoryapp.databinding.ListItemBinding
import com.example.longstoryapp.model.Story

class ListViewAdapter(
    private val context: Context,
    private val storyArrayList: ArrayList<Story>
) : BaseAdapter() {

    override fun getCount(): Int = storyArrayList.size

    override fun getItem(position: Int): Story = storyArrayList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        // Binding variable
        val binding: ListItemBinding

        val view: View

        if (convertView == null) {
            // Inflate binding
            val inflater = LayoutInflater.from(context)
            binding = ListItemBinding.inflate(inflater, parent, false)
            view = binding.root
            view.tag = binding
        } else {
            // Reuse old view binding
            binding = convertView.tag as ListItemBinding
            view = convertView
        }

        // Current item
        val story = getItem(position)

        // Bind data
        binding.title.text = story.title
        binding.time.text = story.time
        binding.comment.text = story.comment
        binding.banner.setImageResource(story.profile)

        return view
    }
}