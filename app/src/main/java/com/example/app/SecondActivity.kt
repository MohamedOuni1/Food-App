package com.example.app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.app.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        val binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val nb = intent.getIntExtra("nbr", 0)
        binding.t2.text = nb.toString()
        val pri = intent.getStringExtra("pr")
        binding.t7.text = pri.toString()

     /*   val s = intent.getStringExtra("select")
        binding.t5.text = s.toString()

      */


        val ce = intent.getBooleanExtra("choix_extra", false)
        val cb = intent.getBooleanExtra("choix_boi", false)

        if (ce) {
            binding.t9.text = "Extra Frite"
        }
        if (cb) {
            binding.t9.text = "Boisson"
        }
        if ((cb) && (ce)) {
            binding.t9.text = "Extra Frite Et Boisson"
        }


        var lieu = findViewById<EditText>(R.id.lieu)
        var tel = findViewById<EditText>(R.id.tel)
        var mod = findViewById<Button>(R.id.mod)
        var q = findViewById<Button>(R.id.q)



        mod.setOnClickListener {
            val x = Intent(this, MainActivity::class.java)
            startActivity(x)
        }

        var code = findViewById<EditText>(R.id.code)
        var valide = findViewById<Button>(R.id.valide)

        valide.setOnClickListener {
            val a = tel.text.toString().toInt()
            val l = lieu.text.toString()

                var saisie=code.text.toString()
            var m="projet"
            if (m==code.text.toString()) {
                Toast.makeText(this,"Vous avez eu un remise de 10% ",
                    Toast.LENGTH_LONG).show()
                /*
                    var remise =0.9f
                var  s=pri.toString().toFloat() * remise
            binding.t7.text = "$s DT"
                 */
            }

            else {
                Toast.makeText(this,"Code invalide",
                    Toast.LENGTH_LONG).show()  }


            if ((9999999 < a) && (a < 100000000)&&(l.isNotEmpty()))
                Toast.makeText(this, "Votre commande a été effectuée ", Toast.LENGTH_LONG)
                    .show()
            else if (l.isEmpty())
                Toast.makeText(this, "Verifier votre adresse domicile", Toast.LENGTH_LONG)
                    .show()

            if ((9999999 > a) || (a > 100000000))
                Toast.makeText(this, "Verifier votre numero telephone", Toast.LENGTH_LONG)
                    .show()
        }

     /*   binding.valide.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
        */
        binding.q.setOnClickListener {
            val intent = Intent(this, FirstActivity::class.java)
            startActivity(intent)

        }



        }
    }

