package com.android.roundup.dashboard.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.roundup.R
import com.android.roundup.utils.RoundUpHelper
import kotlinx.android.synthetic.main.item_dashboard_video.view.*

class VideoThumbsAdapter(
    private val onAdapterClicked:(videoUrl: String) -> Unit,
    private val context: Context,
    private val listOfResults: List<String>
): RecyclerView.Adapter<VideoThumbsAdapter.VideoThumbsHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoThumbsHolder {
        return VideoThumbsHolder(LayoutInflater.from(context).inflate(R.layout.item_dashboard_video,parent,false))
    }

    override fun getItemCount(): Int {
        return listOfResults.size
    }

    override fun onBindViewHolder(holder: VideoThumbsHolder, position: Int) {
        holder.bind(position,listOfResults[position])
    }

    inner class VideoThumbsHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int, searchRes: String){
            itemView.apply {
                setOnClickListener { onAdapterClicked(searchRes) }
                RoundUpHelper.setImageUsingPicasso(context, img_video_thumbnail, searchRes)
            }
        }
    }
}
