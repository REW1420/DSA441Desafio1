package com.example.dsa441_desafio1

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dsa441_desafio1.controller.AverageController
import com.example.dsa441_desafio1.controller.IAverageController
import com.example.dsa441_desafio1.view.IAvarageView

class Opcion1Activity : AppCompatActivity(), IAvarageView {

    var StudentName: EditText? = null
    var num1: EditText? = null
    var num2: EditText? = null
    var num3: EditText? = null
    var num4: EditText? = null
    var trigger: Button? = null
    var ActionPresenter: IAverageController? = null
    var txtResults: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opcion1)

        StudentName = findViewById(R.id.etxtName)
        num1 = findViewById(R.id.etxtNumber1)
        num2 = findViewById(R.id.etxtNumber2)
        num3 = findViewById(R.id.etxtSalary)
        num4 = findViewById(R.id.etxtNumber4)
        trigger = findViewById(R.id.btnAction)
        txtResults = findViewById(R.id.txtResults)


        ActionPresenter = AverageController(this)

        trigger?.setOnClickListener {
            (ActionPresenter as AverageController).OnAction(

                StudentName?.text.toString(),
                num1?.text.toString().toDouble(),
                num2?.text.toString().toDouble(),
                num3?.text.toString().toDouble(),
                num4?.text.toString().toDouble(),
            )
        }
    }


    override fun OnActionSuccess(message: String?) {
        txtResults?.text = message
    }

    override fun OnExcepcion(message: String?) {
        Toast.makeText(this,message, Toast.LENGTH_LONG).show()
    }


    //NAVIGATION

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