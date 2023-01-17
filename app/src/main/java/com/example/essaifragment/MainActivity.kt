package com.example.essaifragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    // Je récupère le package fragmentManager
    private val fragmentManager = supportFragmentManager

    private val TAG = "FirstFragment"
    private val secondTAG = "SecondFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Au clique j'affiche le BlankFragment
    fun onClickFirst(view: View) {
        Log.i(TAG, "J'ai cliqué sur le bouton First !")
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.frameLayout, BlankFragment())
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    // Au clique j'affiche le SecondFragment
    fun onClickSecond(view: View) {
        Log.i(secondTAG, "J'ai cliqué sur le bouton Second !")
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.frameLayout, SecondFragment())
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

}