import kotlin.math.sqrt

/**
 *  Programa que pide al usuario un número, muestra si es primo o no
 *  hata que introduzca 0
 *  @author Jorge Gómez
 * @version 1.0
 *
 */

fun main() {
    var userInput = 0
    do {
        try {
            println("Introduce un número")
            userInput = readln().toInt()
            //Usado como bloque if else para gestionar excepciones
            when{
                userInput == 0 -> println("Fin del programa")
               userInput <= 1 -> throw Exception("El número es menor o igual a 1")
                userInput == 2 -> throw Exception("El número 2 se considera primo")
                userInput % 2 == 0 -> throw Exception("El número introducido es par")
                else -> {

                    //Comrpueba cada numero impar hasta el punto en el que las operaciones se repiten inviertiendo factores, el limite
                    val limit = sqrt(userInput.toDouble()).toInt()
                    for (i in 3 .. limit step 2)
                        if (userInput %i == 0){
                            throw Exception("El número no es primo")
                        }
                    println("El número es primo")
                }
            }
        } catch (e: NumberFormatException) {
            println("Se ha introducido algo distinto a un número")
        }
        catch (e: Exception){
            println(e.message)
        }
    }while (userInput != 0)
}