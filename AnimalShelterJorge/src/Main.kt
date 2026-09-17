
/**
 *  Programa que pide el total de perros y gatos de un refugio
 *  y calcula el porcentaje que asume cada animal
 * @author Jorge Gómez
 * @version 1.0
 */

fun main() {

    println("Refugio de animales C-137")
    println("Introduce la cantidad de perros del refugio")
    val dogsQuantity = readln().toDouble()
    println("Introduce la cantidad de gatos del refugio")
    val catsQuantity = readln().toDouble()

    val totalAnimals = dogsQuantity + catsQuantity

    println("Porcentaje de perros: ${(dogsQuantity/totalAnimals )*100}%")
    println("Porcentaje de gatos: ${(catsQuantity/totalAnimals )*100}%")

}