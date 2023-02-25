package com.example.dsa441_desafio1.controller

import com.example.dsa441_desafio1.view.ISalaryView

class SalaryController(
    private val SalaryView : ISalaryView
): ISalaryController {



    override fun OnAction(name: String?, salary: Double?) {

        val response : String

        if ((name != null) && (salary != null)){

           if (salary < 0){
               SalaryView.OnExcepcion("El salario no puede ser negativo")
           } else {
               val isss = salary * 0.03
               val afp = salary * 0.04
               val renta = salary * 0.05
               val deductions = isss + afp + renta
               val netSalary = salary - deductions

               response = netSalary.toString()

               SalaryView.OnActionSuccess("Su salario neto menos reduccion es $response")
           }



        } else {
            SalaryView.OnExcepcion("Los campos estan vacios")
        }
    }
}