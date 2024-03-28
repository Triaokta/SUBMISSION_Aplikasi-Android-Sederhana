package com.dicoding.aplikasiandroidsederhana

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.aplikasiandroidsederhana.Component
import com.dicoding.aplikasiandroidsederhana.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        @Suppress("DEPRECATION")
        val dataComponent = intent.getParcelableExtra<Component>("key_component") as Component

        val tvDetailName:TextView = findViewById(R.id.tv_detail_name)
        val tvDetailDescription:TextView = findViewById(R.id.tv_detail_description)
        val ivDetailPhoto:ImageView = findViewById(R.id.iv_detail_photo)

        tvDetailName.text = dataComponent.name
        tvDetailDescription.text = dataComponent.description
        ivDetailPhoto.setImageResource(dataComponent.photo)
    }
}