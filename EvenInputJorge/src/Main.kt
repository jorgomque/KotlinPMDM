/**
 *  Programa que pide al usuario un número hata que introduzca un numero par
 *  @author Jorge Gómez
 * @version 1.0
 *
 */

fun main() {
    var userInput = 0
    var quantityEvenNumbers = 0
    do {
        try {
            println("Introduce un número par")
            userInput = readln().toInt()
            if (userInput % 2 == 0) quantityEvenNumbers++
            else throw Exception("Se introdujo un número impar")

        } catch (e: NumberFormatException){
            println("Se ha introducido algo distinto a un número")
        }
        catch (e: Exception){
            println(e.message)
        }
    }while (quantityEvenNumbers<1)
    println("El numero introducido ($userInput) es par")
}