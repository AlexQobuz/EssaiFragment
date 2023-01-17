package com.example.essaifragment

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(R.layout.activity_main), View.OnClickListener {

    // Je récupère le package fragmentManager
    // private val fragmentManager = supportFragmentManager

    lateinit var bottomNav : BottomNavigationView

    // création de la liste d'albums
    lateinit var albums: MutableList<Album>
    lateinit var adapter: AlbumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(HomeFragment())
        bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.album -> {
                    loadFragment(AlbumFragment())
                    true
                }
                else -> {
                    loadFragment(HomeFragment())
                    false
                }
            }
        }

        albums = mutableListOf<Album>()
        albums.add(Album("Back in Black", "Nouvelle Album du groupe ACDC"))
        albums.add(Album("Back in Black", "Nouvelle Album du groupe ACDC"))
        albums.add(Album("Back in Black", "Nouvelle Album du groupe ACDC"))
        albums.add(Album("Back in Black", "Nouvelle Album du groupe ACDC"))
        albums.add(Album("Back in Black", "Nouvelle Album du groupe ACDC"))
        albums.add(Album("Back in Black", "Nouvelle Album du groupe ACDC"))


        adapter = AlbumAdapter(albums, this)

        val recyclerView = findViewById<RecyclerView>(R.id.list_album_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }

    override fun onClick(view: View) {
        if (view.tag != null) {
            Log.i("AlbumListActivity", "click sur un album de la liste !")
        }
    }

}


// Au clique j'affiche le BlankFragment
    /**fun onClickFirst(view: View) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.frameLayout, BlankFragment())
        //fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    // Au clique j'affiche le SecondFragment
    fun onClickSecond(view: View) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.frameLayout, SecondFragment())
        //fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }*/
