package com.yusril.codelabrc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yusril.codelabrc.adapter.GridHeroAdapter
import com.yusril.codelabrc.adapter.ListHeroAdapter
import com.yusril.codelabrc.data.HeroesData
import com.yusril.codelabrc.model.Hero

class MainActivity : AppCompatActivity() {
    // Langkah 1 Buat Variabel
    private lateinit var rvHeroes:RecyclerView
    private var list: ArrayList<Hero> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Langkah 2 inisiasi
        rvHeroes = findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)
        // Langkah 3 Masukan data
        list.addAll(HeroesData.listData)// masukan data dari collection kedalam list
        // Langkah 4 tampilan Rv
        showRecyclerList()
    }
    //
    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)// set Layut rv secara vertical
        val listHeroAdapter = ListHeroAdapter(list)// inisisasi adapter
        rvHeroes.adapter = listHeroAdapter// set rvHeroes dgn adapter
    }
    //Langkah 8
    private  fun showRecyclerGrid(){
        rvHeroes.layoutManager = GridLayoutManager(this, 2) // set Layut rv secara grid kolom 2
        val gridHeroAdapter = GridHeroAdapter(list)// inisisasi adapter grid
        rvHeroes.adapter = gridHeroAdapter// set rvHeroes dgn adapter
    }
    //Langkah 5 inisisasi menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
    //Langkah 7
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)// ambil item id
        return super.onOptionsItemSelected(item)
    }
    //Langkah 6
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                showRecyclerList()
            }
            R.id.action_grid -> {
                showRecyclerGrid()
            }
            R.id.action_cardview -> {
            }
        }
    }
}