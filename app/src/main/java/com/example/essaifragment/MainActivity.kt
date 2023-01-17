package com.example.essaifragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    // Je récupère le package fragmentManager
    private val fragmentManager = supportFragmentManager

    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(HomeFragment())
        bottomNav = findViewById(R.id.bottomNav) as BottomNavigationView
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
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
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
