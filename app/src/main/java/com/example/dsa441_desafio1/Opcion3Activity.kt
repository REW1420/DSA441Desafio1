package com.example.dsa441_desafio1

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.dsa441_desafio1.controller.CalculatorController
import com.example.dsa441_desafio1.controller.ICalculatorController
import com.example.dsa441_desafio1.view.ICalculatorView

class Opcion3Activity : AppCompatActivity(), ICalculatorView {

    var num1: EditText? = null
    var num2: EditText? = null
    var txtResponse: TextView? = null
    var trigger: Button? = null
    var actionPresenter: ICalculatorController? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opcion3)

        num1 = findViewById(R.id.etxtNum1)
        num2 = findViewById(R.id.etxtNum2)
        txtResponse = findViewById(R.id.txtRespuesta)
        trigger = findViewById(R.id.btnCalcular)
        val spinner = findViewById<Spinner>(R.id.spinner)

        actionPresenter = CalculatorController(this)


        val lista = arrayOf("sumar", "restar", "multiplicar", "dividir")
        val adaptador1 = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista)
        spinner.adapter = adaptador1

        trigger?.setOnClickListener {
            (actionPresenter as CalculatorController).OnAction(
                spinner.selectedItem.toString(),
                num1?.text.toString().toDouble(),
                num2?.text.toString().toDouble()
            )
        }
    }


    override fun OnActionSuccess(message: String?) {
        txtResponse?.text=message
    }

    override fun OnExcepcion(message: String?) {
        txtResponse?.text=message
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menuopciones, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.opcion1) {
            Toast.makeText(this, "Se seleccionó la primer opción", Toast.LENGTH_LONG).show()
            val intent = Intent(this, Opcion1Activity::class.java)
            startActivity(intent)
        }
        if (id == R.id.opcion2) {
            Toast.makeText(this, "Se seleccionó la segunda opción", Toast.LENGTH_LONG).show()
            val intent = Intent(this, Opcion2Activity::class.java)
            startActivity(intent)
        }
        if (id == R.id.opcion3) {
            Toast.makeText(this, "Se seleccionó la tercer opción", Toast.LENGTH_LONG).show()
            val intent = Intent(this, Opcion3Activity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }


}