package com.example.dsa441_desafio1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.dsa441_desafio1.controller.ISalaryController
import com.example.dsa441_desafio1.controller.SalaryController
import com.example.dsa441_desafio1.view.ISalaryView

class Opcion2Activity : AppCompatActivity(), ISalaryView {

    var workerName : EditText? = null
    var salary : EditText? = null
    var txtResult: TextView? = null
    var trigger : Button? = null
    var actionPresenter: ISalaryController? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opcion2)


        workerName = findViewById(R.id.etxtName)
        salary = findViewById(R.id.etxtSalary)
        txtResult =findViewById(R.id.txtResults)
        trigger = findViewById(R.id.btnAction)

        actionPresenter = SalaryController(this)

        trigger?.setOnClickListener {
            (actionPresenter as SalaryController).OnAction(
                workerName?.text.toString(),
                salary?.text.toString().toDouble()
            )
        }
    }




    //override Interface funtions

    override fun OnActionSuccess(message: String?) {
        txtResult?.text=message
    }

    override fun OnExcepcion(message: String?) {
        txtResult?.text=message
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