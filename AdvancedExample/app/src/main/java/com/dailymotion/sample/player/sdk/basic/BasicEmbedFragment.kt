package com.dailymotion.sample.player.sdk.basic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dailymotion.sample.player.sdk.R
import com.dailymotion.sample.player.sdk.VideoAdapter

class BasicEmbedFragment : Fragment() {


    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_video_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val videoList = listOf(
            VideoItem("x8nlohg"),
            VideoItem("x8nlop2"),
            VideoItem("x8nlohg"),
            VideoItem("x8nlop2")
        )

        recyclerView.adapter = VideoAdapter(videoList)
    }
}