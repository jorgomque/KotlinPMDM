import kotlin.math.pow
/**
 *  Programa que pide el radio de un círculo al usuario y calcula su perímetro,
 *  área, superficie de la esfera y volumen de la esfera.
 * @author Jorge Gómez
 * @version 1.0
 */
fun main() {


    println("Introduce el radio del un circulo")
    val radius = readln().toDouble()

    println("El perimetro es: ${2 * Math.PI * radius}")
    println("El área es: ${Math.PI* radius.pow(2)}")
    println("La superficie de una esfera con ese radio es: ${4* Math.PI * radius.pow(2)}")
    println("El volumen de una esfera con ese radio es: ${4.0/3.0 * Math.PI * radius.pow(3)}")
}