package com.example.myapp

import ai.codia.x.kotlin.demo.BaseMainActivity
import ai.codia.x.kotlin.demo.R
import android.os.Bundle
import android.widget.Toast

class MainActivity : BaseMainActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Toast.makeText(this, "Welcome to the Main Activity!", Toast.LENGTH_SHORT).show()
        // Aquí puedes agregar la lógica de la pantalla principal

        setContentView(R.layout.menu)
    }
}
