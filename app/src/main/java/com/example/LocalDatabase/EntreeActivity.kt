package com.example.LocalDatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.learnvoley.R

class EntreeActivity : AppCompatActivity() {
    lateinit var medicamentView:EditText
    lateinit var qtiteView:EditText
    lateinit var btnUpdate: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entree)
        var Data = intent
        var nameVallue:String = Data.getStringExtra("nametxt").toString()
       medicamentView = findViewById(R.id.medicament)
        medicamentView.setText(nameVallue)
         qtiteView = findViewById(R.id.quantite)
        btnUpdate.setOnClickListener {
            val nomValue = medicamentView.text.toString()
            val qtiteValue = qtiteView.text.toString().toInt()
            if (nomValue.isNotEmpty() && qtiteValue > 0) {
                Toast.makeText(applicationContext, "update was success", Toast.LENGTH_SHORT).show()
                var database = MyDatabase.getInstance(applicationContext)
                var dao: Dao? = database?.getDao()
                var medicament:Medicament = Medicament(nomValue, qtiteValue)
                dao?.addMedecament(medicament)
                var nextActivity = Intent(this@EntreeActivity, MainActivity::class.java)
                startActivity(nextActivity)
            } else {
                Toast.makeText(applicationContext, "Please fill the box", Toast.LENGTH_SHORT).show()
            }
        }

    }
}