package com.example.irpanuts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.irpanuts.fragment.LainyaFragment
import com.example.irpanuts.fragment.UntukmuFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lainnyaFragment = LainyaFragment()
        val untukmuFragment = UntukmuFragment()

        makeCurrentFragment (untukmuFragment)

        val bottomnavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomnavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_home -> makeCurrentFragment(untukmuFragment)
                R.id.menu_profile -> makeCurrentFragment(lainnyaFragment)
            }
            true
        }
//
//        var pengaturan = PengaturanFragment()
//        pengaturan.onCreateView().switchBtn
    }

    fun makeCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fram_nav, fragment)
            commit()
        }

    }

}