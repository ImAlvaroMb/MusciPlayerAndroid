package com.example.musicplayer2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var songAdapter: SongAdapter
    private lateinit var songList: MutableList<Song>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.RecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        songList = mutableListOf()
        songList.add(Song("Early 90's Gabber Subculure", R.raw.earlyninety))
        songList.add(Song("Sistanem JID", R.raw.sisternemm))
        songList.add(Song("Malamente Rosalía", R.raw.malamente))
        songList.add(Song("Can you hear the music Ludwig Goransson", R.raw.canyouhearthemusic))
        songList.add(Song("Rather Be Clean Bandit & Jess Glynne", R.raw.ratherbe))

        songAdapter = SongAdapter(this, songList)
        recyclerView.adapter = songAdapter

        songAdapter.setOnVolumeChangeListener(object : SongAdapter.OnVolumeChangeListener {
            override fun onVolumeChanged(position: Int, volume: Int) {
                val mediaPlayer = songAdapter.getMediaPlayer(position)
                mediaPlayer?.setVolume(volume / 100f, volume / 100f)
            }
        })
    }
}