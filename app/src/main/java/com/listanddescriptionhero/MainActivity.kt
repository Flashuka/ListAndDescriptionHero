package com.listanddescriptionhero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(),ListHeroAdapter.OnItemClickCallback {
    private lateinit var rvHeroes: RecyclerView
    private var list: ArrayList<Hero> = arrayListOf()
    private var title: String = "Mode List"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHeroes = findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)

        list.addAll(HeroesData.listData)

        title = "List Hero"
        supportActionBar?.title = title
        showRecycleList()
    }

    private fun showRecycleList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list, this)
        rvHeroes.adapter = listHeroAdapter
    }

    override fun onItemClicked(data: Int) {
        Toast.makeText(this, "Kamu memilih no " + (data+1), Toast.LENGTH_SHORT).show()

        val moving = Intent(this, Description::class.java)
        moving.putExtra("nameHero", list[data].name)
        moving.putExtra("descHero", list[data].desc)
        moving.putExtra("photoHero", list[data].photo)

        startActivity(moving)
    }

}