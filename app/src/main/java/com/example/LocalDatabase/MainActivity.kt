package com.example.LocalDatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.learnvoley.R

class MainActivity : AppCompatActivity() {
    lateinit var btnAfficher: Button
    lateinit var btnCreate: Button
    lateinit  var nameMedicament:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
               btnAfficher = findViewById(R.id.afficher)
                btnAfficher.setOnClickListener{
                   nameMedicament = findViewById(R.id.medicament)
                    var valueNameMedicament = nameMedicament.text.toString()
                    var nextActivity = Intent(this@MainActivity, EntreeActivity::class.java)
                    nextActivity.putExtra("nametxt", valueNameMedicament)
                    startActivity(nextActivity)
                }
        btnCreate.setOnClickListener {
            var nameText:EditText = findViewById(R.id.fournirNom)
            var qtiteText:EditText = findViewById(R.id.quantite)
            val nomMedicament = nameText.text.toString()
            val qteStock = qtiteText.text.toString().toInt()

            if (nomMedicament.isNotEmpty() && qteStock > 0) {
                val newMedicament = Medicament(nomMedicament, qteStock)
                var database = MyDatabase.getInstance(applicationContext)
                var dao: Dao? = database?.getDao()
                dao?.addMedecament(newMedicament)
                Toast.makeText(applicationContext, "object was added successfully", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Please fill the box", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
