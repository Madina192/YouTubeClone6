package com.example.youtubeclone.ui.playlist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.youtubeclone.data.model.PlaylistsModel
import com.example.youtubeclone.databinding.ItemPlaylistBinding

class PlaylistsAdapter(private val onClick: (PlaylistsModel.Item) -> Unit) :
    Adapter<PlaylistsAdapter.PlaylistViewHolder>() {

    private var list = mutableListOf<PlaylistsModel.Item>()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(model: List<PlaylistsModel.Item>?) {
        list = model as MutableList<PlaylistsModel.Item>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder =
        PlaylistViewHolder(
            ItemPlaylistBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    inner class PlaylistViewHolder(private val binding: ItemPlaylistBinding) :
        ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(playlistsModelItem: PlaylistsModel.Item) {
            with(binding) {
                Glide.with(ivPlaylist).load(playlistsModelItem.snippet.thumbnails.default.url)
                    .into(ivPlaylist)
                tvTitle.text = playlistsModelItem.snippet.title
                tvNumber.text = "${playlistsModelItem.contentDetails.itemCount} video series"
                itemView.setOnClickListener {
                    onClick.invoke(playlistsModelItem)
                }
            }
        }
    }
}