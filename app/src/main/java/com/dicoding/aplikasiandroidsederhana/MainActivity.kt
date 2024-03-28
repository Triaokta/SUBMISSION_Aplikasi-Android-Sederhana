package com.dicoding.aplikasiandroidsederhana

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvComponent: RecyclerView
    private val list = ArrayList<Component>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvComponent = findViewById(R.id.rv_component)
        rvComponent.setHasFixedSize(true)
        list.addAll(getListComponent())
        showRecyclerList()
    }
    @SuppressLint("Recycle")
    private fun getListComponent(): ArrayList<Component> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listComponent = ArrayList<Component>()
        for (i in dataName.indices) {
            val Component =Component(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listComponent.add(Component)
        }
        return listComponent
    }

    private fun showRecyclerList() {
        rvComponent.layoutManager = LinearLayoutManager(this)
        val listComponentAdapter = ListComponentAdapter(list)
        rvComponent.adapter = listComponentAdapter
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.tv_about -> {
                val aboutIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(aboutIntent)
            }
        }
        return true
    }
}