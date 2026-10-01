/**
 *  Programa que muestra al usuario un saludo y procede a mostrar un menun
 *  con opciones de una calculadora que pedira datos para operar o parara si el usuario introduce 0
 *  @author Jorge Gómez
 * @version 1.0
 *
 */
fun main() {
    greeting()

    var menuOption : Int
    var firstUserNumber  = 0
    var secondtUserNumber = 0
    do {
        menuOption = menu()
        try {
            //Si el usuario a introducido 0 no hace falta datos para operar
            if (menuOption != 0) {
                println("Introduce el primer número entero")
                 firstUserNumber = readln().toInt()
                println("Introduce el segundo número entero")
                secondtUserNumber = readln().toInt()
            }
            when (menuOption) {
                0 -> println("Gracias por usar la calculadora :)")
                1 -> add(firstUserNumber, secondtUserNumber)
                2 -> subtract(secondtUserNumber, firstUserNumber)
                3 -> multiply(firstUserNumber, secondtUserNumber)
                4 -> if (secondtUserNumber != 0) {
                    divide(firstUserNumber, secondtUserNumber)
                } else {
                    println("No se puede dividir entre 0!!!!")
                }
            }
        } catch (e: NumberFormatException) {
            println("Introduce un númeor entero!!!")
        }
    }while (menuOption != 0)


}

fun greeting(){
    println("Buenos dias usuario (:")

}

fun menu(): Int{
    var userNumber = 0
    do {
        var numberIsValid = true
        println(
            """
            Elige una opción:
            0. Salir
            1. Suma
            2. Resta
            3. Multiplicación
            4. División
        """.trimIndent()
        )
        try {
            userNumber = readln().toInt()
            if (userNumber !in 0..4) {
                throw Exception("Opcion fuera del rango del menu")
            }
        }
        catch (e: NumberFormatException) {
            numberIsValid = false
            println("Introduce un número entero ")
        }
        catch (e: Exception){
            numberIsValid = false
            println(e.message)
        }
    }while (!numberIsValid)
    return userNumber
}

fun add(num1: Int, num2: Int){
    println(num1 + num2)

}

fun subtract(num1: Int, num2: Int){
    println(num1 - num2)

}

fun multiply(num1: Int, num2: Int){
    println(num1 * num2)

}
fun divide(num1: Int, num2: Int) {
    println(num1 / num2)

}


