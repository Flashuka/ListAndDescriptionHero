package com.listanddescriptionhero

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Description() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)
        supportActionBar?.title = "Description"

        val positionPhoto = intent.getIntExtra("photoHero", 0)
        val positionName = intent.getStringExtra("nameHero")
        val positionDesc = intent.getStringExtra("descHero")

        val tvName: TextView = findViewById(R.id.desc_Name)
        val tvDetail: TextView = findViewById(R.id.desc_Detail)
        val imgPhoto: ImageView = findViewById(R.id.desc_Photo)
        
        tvName.text = positionName
        tvDetail.text = positionDesc
        imgPhoto.setImageResource(positionPhoto)
    }
}