package com.dailymotion.sample.player.sdk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.dailymotion.player.android.sdk.Dailymotion
import com.dailymotion.player.android.sdk.PlayerParameters
import com.dailymotion.player.android.sdk.PlayerView
import com.dailymotion.player.android.sdk.listeners.PlayerListener
import com.dailymotion.player.android.sdk.webview.error.PlayerError
import com.dailymotion.sample.player.sdk.basic.VideoItem

class VideoAdapter(private val videoList: List<VideoItem>) :
    RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_video, parent, false)
        return VideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bind(videoList[position].videoId)
    }

    override fun getItemCount(): Int = videoList.size

    class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val videoContainer: FrameLayout = itemView.findViewById(R.id.videoContainer)

        fun bind(videoId: String) {
            Dailymotion.createPlayer(
                context = itemView.context,
                playerId = "xix5w",
                videoId = videoId,
                playerParameters = PlayerParameters(
                    mute = false
                ),
                playerSetupListener = object : Dailymotion.PlayerSetupListener {
                    override fun onPlayerSetupSuccess(player: PlayerView) {
                        videoContainer.removeAllViews()
                        videoContainer.addView(player)
                    }

                    override fun onPlayerSetupFailed(error: PlayerError) {
                        // Handle error
                    }
                },
                playerListener = object : PlayerListener {}
            )
        }
    }
}
