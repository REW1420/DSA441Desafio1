package com.example.dsa441_desafio1.controller

import com.example.dsa441_desafio1.view.IAvarageView
import java.text.DecimalFormat

class AverageController(
    private val AvarageView: IAvarageView
) : IAverageController {

    override fun OnAction(
        name: String?,
        num1: Double?,
        num2: Double?,
        num3: Double?,
        num4: Double?
    ) {
        var request: Double = 0.0
        val df = DecimalFormat("#.#")


        //general validationsif
        if ((name != null)&& (num1 != null) && (num2 != null) && (num3 != null) && (num4 != null)) {

            if (num1 > 10.0){
                AvarageView.OnExcepcion("La primer nota no puede ser mayor de 10")
            } else {
                if ( num2 > 10.0){
                    AvarageView.OnExcepcion("La segunda nota no puede ser mayor de 10")

                } else {
                    if ( num3 > 10.0){
                        AvarageView.OnExcepcion("La tercera nota no puede ser mayor de 10")

                    } else {
                        if ( num4 > 10.0){
                            AvarageView.OnExcepcion("La cuarta nota no puede ser mayor de 10")

                        } else {

                            request = (num1 + num2 + num3 + num4) / 4
                            val oneDecimal = df.format(request).toDouble()

                            if (request >= 6.0) {
                                val response: String = oneDecimal.toString()
                                AvarageView.OnActionSuccess("$name tiene una nota de $response esta aprovado")
                            } else if (request < 6.0) {
                                val response: String = oneDecimal.toString()
                                AvarageView.OnActionSuccess("$name tiene una nota de $response esta reprovado")
                            }

                        }
                    }
                }
            }




        }


    }
}