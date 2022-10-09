package com.example.fish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fish.adapter.Myadapter
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList : ArrayList<products>
    private lateinit var tempArrayList : ArrayList<products>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId = arrayOf(
            R.drawable.pic1,
            R.drawable.pic10,
            R.drawable.pic12,
            R.drawable.pic13,
            R.drawable.pic14,
            R.drawable.pic15,
            R.drawable.pic2,
            R.drawable.pic21,
            R.drawable.pic22,
            R.drawable.pic23,
            R.drawable.pic24,
            R.drawable.pic25,
            R.drawable.pic26,
            R.drawable.pic27,
            R.drawable.pic28,
            R.drawable.pic29,
            R.drawable.pic3,
            R.drawable.pic30,
            R.drawable.pic4,
            R.drawable.pic5,
            R.drawable.pic6,
            R.drawable.pic7,
            R.drawable.pic8,
            R.drawable.pic9)
        heading = arrayOf(
            "Betta Fish Food: Flake Medley $3",
            "Aquarium Salt $5",
            "Moss Ball $10",
            "Betta Fish Food: Blood Worms $8",
            "Fake plants $7",
            "Siphon $15",
            "Amazon Sword $10",
            "Fish Tank $50",
            "Betta Fish Food: Pellets $4",
            "Java Fern $10",
            "Water Conditioner $7",
            "Water Testing Kit $6",
            "Fish net $5",
            "Substrate $17",
            "SpiderWood $30",
            "Filter $20",
            "Anubius Nana $10",
            "Thermometer $4",
            "Java Fern $7",
            "Lucky Bamboo $10",
            "SpiderWood $25",
            "Rock $5",
            "Plant Substrate $20",
            "Fish tank light $20"
        )
        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<products>()
        tempArrayList = arrayListOf<products>()
        getUserdata()

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_item,menu)
        val item = menu?.findItem(R.id.search_action)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                tempArrayList.clear()
                val searchText = newText!!.toLowerCase(Locale.getDefault())
                if (searchText.isNotEmpty()) {
                    newArrayList.forEach {
                        if (it.heading.toLowerCase(Locale.getDefault()).contains(searchText)) {

                            tempArrayList.add(it)
                        }
                    }
                    newRecyclerView.adapter!!.notifyDataSetChanged()
                }
                else{
                    tempArrayList.clear()
                    tempArrayList.addAll(newArrayList)
                    newRecyclerView.adapter!!.notifyDataSetChanged()
                }
                return false
            }

        })

        return super.onCreateOptionsMenu(menu)

    }

    private fun getUserdata() {

        for (i in imageId.indices){

            val Products = products(imageId[i],heading[i])
            newArrayList.add(Products)
        }

        tempArrayList.addAll(newArrayList)

        newRecyclerView.adapter = Myadapter(tempArrayList)

        val adapter = Myadapter(tempArrayList)



    }
}