package com.example.module2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNextActivity: Button = findViewById(R.id.btnNextActivity)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        btnNextActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_main -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                R.id.nav_second -> {
                    val intent = Intent(this, SecondActivity::class.java)
                    startActivity(intent)
                }
                R.id.nav_easter_egg -> {
                    Toast.makeText(this, "Félicitations, Easter Egg trouvé !", Toast.LENGTH_LONG).show()
                }
            }
            drawerLayout.closeDrawers()
            true
        }
    }
}
