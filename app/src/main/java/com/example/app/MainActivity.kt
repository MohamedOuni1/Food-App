package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.example.app.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val n = findViewById<EditText>(R.id.nbr_tacos)
        val choix_may = findViewById<CheckBox>(R.id.choix_may)
        choix_may.isChecked = true
        val choix_har = findViewById<CheckBox>(R.id.choix_har)
        choix_har.isChecked = true



        binding.rg.setOnCheckedChangeListener { group, checkedId ->

        binding.btnPrix.setOnClickListener {

                if (n.text.toString().toInt() <= 0)
                    Toast.makeText(this, "Saisir le nombre de tacos", Toast.LENGTH_LONG).show()
                else {
                    val t = binding.nbrTacos.text.toString().toFloat()
                    var prixt = 0.0f


                    when (checkedId) {
                        R.id.m -> {
                            prixt = prixt + 6.0f

                        }

                        R.id.l -> {
                            prixt = prixt + 7.0f

                        }

                        R.id.xl -> {
                            prixt = prixt + 9.0f

                        }

                        R.id.xxl -> {
                            prixt = prixt + 12.0f

                        }
                    }

                    var prixadd = 0.0f
                    if (binding.choixExtra.isChecked) {
                        prixadd = 1.5f
                    } else if (binding.choixBoi.isChecked) {
                        prixadd = 2.0f
                    } else {
                        prixadd = 0f
                    }

                    if ((binding.choixBoi.isChecked) && (binding.choixExtra.isChecked)) {
                        prixadd = 3.5f
                    }



                    var liv = 4.0f
                    binding.prixliv.text = "$liv DT"
                    var prixta = t * (prixt + prixadd)
                    binding.prixta.text = "$prixta DT"
                    var prix = (prixta + 4.0 )
                    binding.prix.text = "$prix DT"

                    binding.achat.setOnClickListener {
                        if (n.text.toString().toInt() <= 0) {
                            Toast.makeText(this, "Saisir le nombre de tacos", Toast.LENGTH_LONG).show()
                        } else {
                            val intent = Intent(this, SecondActivity::class.java)
                            intent.putExtra("nbr",binding.nbrTacos.text.toString().toInt())
                            intent.putExtra("pr",binding.prix.text)
                            /*  intent.putExtra("nvv",binding.prix.text) */

                            intent.putExtra("choix_extra", binding.choixExtra.isChecked)
                            intent.putExtra("choix_boi", binding.choixBoi.isChecked)



                            startActivity(intent)

                        }
                    }

                }

            }

        }



        binding.ret.setOnClickListener {

            val intent = Intent(this, FirstActivity::class.java)
             startActivity(intent)


        }

        }

}