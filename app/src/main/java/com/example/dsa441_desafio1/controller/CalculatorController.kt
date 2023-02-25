package com.example.dsa441_desafio1.controller

import com.example.dsa441_desafio1.view.ICalculatorView

class CalculatorController(
    private val CalculatorView: ICalculatorView
):ICalculatorController {


    override fun OnAction(selector: String?, num1: Double?, num2: Double?) {
        var request: Double = 0.0
        var response: String = ""

        try {
            when (selector) {
                "sumar" -> request = num1!! + num2!!
                "multiplicar" -> request = num1!! * num2!!
                "dividir" -> request = num1!! / num2!!
                "restar" -> request = num1!! - num2!!
            }
        } catch (e: java.lang.NumberFormatException) {
            CalculatorView.OnExcepcion("se produjo una exepcion")
        }

        response = request.toString()

        CalculatorView.OnActionSuccess("La repuesta de $selector es $response")
    }
}