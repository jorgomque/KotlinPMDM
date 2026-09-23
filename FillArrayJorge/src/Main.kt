/**
 * Programa que pide números al usuario hasta que rellene un array con números positivos
 * @author Jorge
 * @version 1.0
 */

fun main() {
    val positiveNumbersArray = IntArray(10)
    var positiveNumbersCounter = 0
    while (positiveNumbersCounter<positiveNumbersArray.size ) {
        println("Introduce un número par")
    val num = readln().toInt()
        if ( num > 0){
            positiveNumbersArray[positiveNumbersCounter] = num
            positiveNumbersCounter++
        }
        else{
            println("El número $num no es positivo!!!!")
        }
    }
    for (i in positiveNumbersArray){
        println(positiveNumbersArray[i])
    }
}